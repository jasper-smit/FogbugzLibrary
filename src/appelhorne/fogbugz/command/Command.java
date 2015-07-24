package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.FogBugzImpl;
import appelhorne.fogbugz.util.ExtNode;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public abstract class Command {
    protected FogBugzImpl fogbugz;
    private Document document;
    private List<NameValuePair> params = new ArrayList<NameValuePair>();

    public Command(FogBugz fogbugz) {
        this.fogbugz = (FogBugzImpl)fogbugz;
    }

    public abstract void execute() throws FogBugzException;

    protected void doCommand(String uri) throws FogBugzException {
        try {
            HttpPost post = new HttpPost(uri);
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            InputStream content = fogbugz.getClient().execute(post).getEntity().getContent();
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(content);
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute command " + getClass().getName(), ex);
        }
        if (getError() != null) {
            throw new FogBugzException(getErrorMessage());
        }
    }

        protected void doCommandGet(String uri) throws FogBugzException {
        try {
            HttpGet get = new HttpGet(uri);
            InputStream content = fogbugz.getClient().execute(get).getEntity().getContent();
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(content);

        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute command " + getClass().getName(), ex);
        }
        if (getError() != null) {
            throw new FogBugzException(getErrorMessage());
        }
    }

    protected void doCommand() throws FogBugzException {
        addParam("token", fogbugz.getToken());
        doCommand(fogbugz.getUrl());
    }

    protected String doCommandNoParsing() throws FogBugzException {
        addParam("token", fogbugz.getToken());
        String uri = fogbugz.getUrl();
        try {
            String query = URLEncodedUtils.format(params, "UTF-8");
            HttpGet get = new HttpGet(uri + query);
            InputStream content = fogbugz.getClient().execute(get).getEntity().getContent();
            return IOUtils.toString(content);
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute command " + getClass().getName(), ex);
        }
    }


        protected void doMultipart(File file) throws FogBugzException {
        addParam("token", fogbugz.getToken());
        String uri = fogbugz.getUrl();
        try {
            String query = URLEncodedUtils.format(params, "UTF-8");
            HttpPost post = new HttpPost(uri + query);
            MultipartEntity entity = new MultipartEntity();
            entity.addPart("File1", new FileBody(file));
            post.setEntity(entity);
            InputStream content = fogbugz.getClient().execute(post).getEntity().getContent();
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(content);

        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute command " + getClass().getName(), ex);
        }
    }


    public String getError() throws FogBugzException {
        return xpath("//error", "code");
    }

    public String getErrorMessage() throws FogBugzException {
        return xpath("//error");
    }

    protected String xpath(Object obj, String xpath) throws FogBugzException {
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(xpath);
            return expr.evaluate(obj);
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute xpatch " + xpath, ex);
        }
    }

    protected String xpath(String xpath) throws FogBugzException {
        return xpath(document, xpath);
    }

    protected NodeList xpathListOld(String xpath) throws FogBugzException {
            try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(xpath);
            return (NodeList)expr.evaluate(document, XPathConstants.NODESET);
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute xpath " + xpath, ex);
        }
    }

    protected List<ExtNode> xpathList(String xpath) throws FogBugzException {
            try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(xpath);
            NodeList results = (NodeList)expr.evaluate(document, XPathConstants.NODESET);
            List<ExtNode> extNodes = new ArrayList<ExtNode>();
            for(int i = 0; i < results.getLength(); i++) {
                extNodes.add(new ExtNode(results.item(i)));
            }
            return extNodes;    
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute xpath " + xpath, ex);
        }
    }

    protected String xpath(String xpath, String attribute) throws FogBugzException {
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(xpath);
            Node node = ((Node) expr.evaluate(document, XPathConstants.NODE));
            if (node == null) return null;
            Node attrNode = node.getAttributes().getNamedItem(attribute);
            if (attrNode == null) return null;
            return attrNode.getTextContent();
        } catch (Exception ex) {
            throw new FogBugzException("Failed to execute xpath " + xpath, ex);
        }
    }

    protected void addParam(String key, String value) {
        params.add(new BasicNameValuePair(key, value));
    }

    protected void setCommand(String cmd) {
        addParam("cmd", cmd);
    }
}
