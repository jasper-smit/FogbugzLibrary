package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Attachment;
import appelhorne.fogbugz.FogBugz;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/


public class AttachmentImpl extends Attachment {
	private int attachmentNr;
    private FogBugz fogbugz;


	public AttachmentImpl(FogBugz fogbugz, int attachmentNr) {
		this.attachmentNr = attachmentNr;
        this.fogbugz = fogbugz;
	}


	@Override
	public int getAttachmentNr() {
		return attachmentNr;
	}


	@Override
	public String getUrl(String filename) {
		return ((FogBugzImpl)fogbugz).getServer() + "/default.asp?pg=pgDownload&pgType=pgWikiAttachment&ixAttachment=" +
				getAttachmentNr() + "&sFileName=" + filename;
	}
}
