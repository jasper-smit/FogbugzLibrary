package appelhorne.fogbugz;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Attachment {
	public abstract int getAttachmentNr();

	public abstract String getUrl(String filename);
}
