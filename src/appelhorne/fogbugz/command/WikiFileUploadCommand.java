package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;

import java.io.File;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class WikiFileUploadCommand extends Command {
    private int wikiNr;
    private int attachmentNr;
    private File attachment;

    public WikiFileUploadCommand(FogBugz fogbugz, int wikiNr, File attachment) {
        super(fogbugz);
        this.wikiNr = wikiNr;
        this.attachment = attachment;
        setCommand("wikiFileUpload");
        addParam("ixWiki", wikiNr + "");
    }

    @Override
    public void execute() throws FogBugzException {
        doMultipart(attachment);
        attachmentNr = Integer.parseInt(xpath("//ixAttachment/text()"));
    }


    public int getAttachmentNr() {
        return attachmentNr;
    }
}
