package appelhorne.fogbugz.docaswiki;

import appelhorne.fogbugz.*;
import org.apache.commons.io.IOUtils;
import org.htmlcleaner.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class UploadHTMLAsWiki {
    public int uploadHTMLToWiki(String username, String password, int wikiNr, String title, String file) throws FogBugzException, IOException {

        FogBugz fb = null;
        try {
            fb = FogBugz.login("http://uocg04.housing.rug.nl", username, password);

            return new UploadHTMLAsWiki().uploadHTMLToWiki(fb, wikiNr, new File(file), title);

        } finally {
            if (fb != null) {
                fb.logoff();
            }
        }
    }

    public static void main(String[] args) {
        HtmlCleaner cleaner = new HtmlCleaner();

        TagTransformation tt = new TagTransformation("font");

        CleanerTransformations transformations =
                new CleanerTransformations();

        transformations.addTransformation(tt);
        cleaner.setTransformations(transformations);


        try {
            TagNode root = new UploadHTMLAsWiki().parseHtmlFile(new File("D:\\tmp5555\\out.html"), cleaner);

            root.traverse(new TagNodeVisitor() {
                public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
                    if (htmlNode instanceof TagNode) {
                        TagNode tag = (TagNode) htmlNode;
                        if (tag.hasAttribute("style")) {
                            tag.removeAttribute("style");
                        }
                        if (tag.getName().equals("div") && tag.hasAttribute("name") && tag.getAttributeByName("name").startsWith("Kop ")) {
                            String tagName = "h" + tag.getAttributeByName("name").substring(4);
                            tag.setName(tagName);
                        }
                    }
                    return true;
                }
            });

            String html = new PrettyHtmlSerializer(cleaner.getProperties()).getAsString(root);
            FileOutputStream fos = new FileOutputStream(new File("D:\\tmp5555\\clean.html"));
            fos.write(html.getBytes());
            fos.close();


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


    public int uploadHTMLToWiki(FogBugz fb, int wikiNr, File f, String title) throws FogBugzException, IOException {
            HtmlCleaner cleaner = new HtmlCleaner();

            CleanerTransformations transformations = new CleanerTransformations();
            TagTransformation tt = new TagTransformation("font");
            transformations.addTransformation(tt);
            cleaner.setTransformations(transformations);

            TagNode root = parseHtmlFile(f, cleaner);
            removeStyle(root);
            uploadImages(f.getParent(), fb, Wiki.get(fb, wikiNr), root);

            String html = new PrettyHtmlSerializer(cleaner.getProperties()).getAsString(root);
            html = html.replaceAll("<wiki-page>", "").replaceAll("</wiki-page>", "");

			Article article = Wiki.get(fb, wikiNr).createArticle(title, html);
			return article.getArticleNr();


    }

    private void removeStyle(TagNode root) {
        root.traverse(new TagNodeVisitor() {
            public boolean visit(TagNode tagNode, HtmlNode htmlNode) {
                if (htmlNode instanceof TagNode) {
                    TagNode tag = (TagNode) htmlNode;
                    if (tag.hasAttribute("style")) {
                        tag.removeAttribute("style");
                    }
                    if (tag.getName().equals("div") && tag.hasAttribute("name") && tag.getAttributeByName("name").startsWith("Kop ")) {
                        String tagName = "h" + tag.getAttributeByName("name").substring(4);
                        tag.setName(tagName);
                    }
                }
                return true;
            }
        });
    }


    private void uploadImages(String parent, FogBugz fb, Wiki wiki, TagNode root) throws FogBugzException {
        for (TagNode img : root.getElementsByName("img", true)) {
            try {
                String src = img.getAttributeByName("src");
                Attachment attachment = wiki.uploadAttachment(new File(parent + "/" + src));

                img.setAttribute("src", attachment.getUrl(src));
                System.out.println(attachment.getAttachmentNr() + src);
            } catch (FogBugzException ex) {
                //Just ignore 
            }
        }
    }


    private TagNode parseHtmlFile(File f, HtmlCleaner cleaner) throws IOException {
        CleanerProperties props = cleaner.getProperties();
        props.setOmitHtmlEnvelope(true);
        props.setOmitXmlDeclaration(true);
        //System.out.println(IOUtils.toString(new FileInputStream(f)));
        TagNode root = cleaner.clean("<wiki-page>" + IOUtils.toString(new FileInputStream(f)) + "</wiki-page>");
        return root;
    }
}
