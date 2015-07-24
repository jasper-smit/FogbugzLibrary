package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Revision;

import java.util.Date;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class RevisionImpl extends Revision {
    private int articleNr;
    private int revision;
    private int person;
    private String remoteIP;
    private String headline;
    private String comment;
    private boolean difference;
    private Date date;

    public int getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(int articleNr) {
        this.articleNr = articleNr;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isDifference() {
        return difference;
    }

    public void setDifference(boolean difference) {
        this.difference = difference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
