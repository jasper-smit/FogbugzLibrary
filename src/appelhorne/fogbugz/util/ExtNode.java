package appelhorne.fogbugz.util;

import appelhorne.fogbugz.FogBugzException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/


/*
 * Extended DOM, more convenient to use
 */
public class ExtNode {
    private Node node;

    public ExtNode(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public String xpath(String xpath) throws FogBugzException {
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(xpath);
            return expr.evaluate(getNode());
        } catch (XPathExpressionException e) {
            throw new FogBugzException("Failed executing xpath expression '" + xpath + "'");
        }
    }

    public String getString(String member) throws FogBugzException {
        return xpath(member + "/text()");
    }

    public int getInt(String member) throws FogBugzException {
        String val = getString(member);
        if (val.equals("")) return 0;
        return Integer.parseInt(val);
    }

    public boolean getBool(String member) throws FogBugzException {
        return "true".equals(getString(member));
    }

    public Date getDate(String member) throws FogBugzException {
        return Util.parseDate(getString(member));
    }


    public List<ExtNode> getChildren(String name) throws FogBugzException {
        try {
            XPathFactory factory = XPathFactory.newInstance();
            XPathExpression expr = factory.newXPath().compile(name);
            NodeList nodeList =(NodeList)expr.evaluate(getNode(), XPathConstants.NODESET);
            List<ExtNode> children = new ArrayList<ExtNode>();
            for(int i = 0; i < nodeList.getLength(); i++) {
                children.add(new ExtNode(nodeList.item(i)));
            }
            return children;
        } catch (XPathExpressionException e) {
            throw new FogBugzException("Failed executing xpath expression for getting member " + name);
        }
    }

    public String getAttribute(String attribute) throws FogBugzException {
        return xpath("@" + attribute);

    }

    public String getText() {
        return getNode().getTextContent();
    }
}
