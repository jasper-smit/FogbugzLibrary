package appelhorne.fogbugz;

import java.util.Date;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Revision {
    public abstract int getArticleNr();

    public abstract int getRevision();

    public abstract int getPerson();

    public abstract String getRemoteIP();

    public abstract String getHeadline();

    public abstract String getComment();

    public abstract boolean isDifference();

    public abstract Date getDate();
}
