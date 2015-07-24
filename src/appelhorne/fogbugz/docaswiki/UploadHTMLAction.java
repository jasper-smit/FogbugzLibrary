package appelhorne.fogbugz.docaswiki;

import nl.truncus.Action;
import nl.truncus.JspResponse;
import nl.truncus.Response;
import nl.truncus.StringResponse;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class UploadHTMLAction extends Action {
    private final String TEMP = System.getProperty("java.io.tmpdir");


    @Override
    public Response doPost() throws Exception {
        File dir = new File(TEMP + "/tmp" + new Random().nextInt());
        dir.mkdir();
        System.out.println(dir.getPath());
         // dir = new File(TEMP + "\\tmp1507106418");

        String username = null;
        String password = null;
        String title = null;
        int wikiNr = 1;

        ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());

        List files = sfu.parseRequest(request);

        for (Object o : files) {
            DiskFileItem dfi = (DiskFileItem) o;
            if (!dfi.isFormField() && dfi.getSize() > 0) {
                InputStream in = dfi.getInputStream();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int s;

                byte[] buf = new byte[2048];
                while ((s = in.read(buf)) != -1) {
                    baos.write(buf, 0, s);
                }

                FileOutputStream fos = new FileOutputStream(dir.getPath() + "/in.doc");
                fos.write(baos.toByteArray());
                fos.close();

            }
            else if(dfi.getFieldName().equals("email")) {
               username = dfi.getString();
            }
             else if(dfi.getFieldName().equals("password")) {
               password = dfi.getString();
            }
             else if(dfi.getFieldName().equals("title")) {
               title = dfi.getString();
            }
                      else if(dfi.getFieldName().equals("wiki")) {
               wikiNr = Integer.parseInt(dfi.getString());
            }
        }

        //Do shell command
        String cmd = "/usr/bin/wvHtml " + dir.getPath() + "/in.doc " +  dir.getPath() + "/out.html ";
		Runtime run = Runtime.getRuntime();
		Process pr = run.exec(cmd);
		pr.waitFor();

        //Upload Page
        //request.setAttribute("link", "http://uocg04.housing.rug.nl/default.php?W" + new UploadHTMLAsWiki().uploadHTMLToWiki(username, password, wikiNr, title,  "D:\\FogBugzLib\\clean.html") );        
        request.setAttribute("link", "http://uocg04.housing.rug.nl/default.php?W" + new UploadHTMLAsWiki().uploadHTMLToWiki(username, password, wikiNr, title, dir.getPath() + "/out.html") );
       return new JspResponse("/web/success.jsp");
    }

    @Override
    public Response doGet() throws Exception {
        return new JspResponse("/web/uploadhtml.jsp");
    }


}
