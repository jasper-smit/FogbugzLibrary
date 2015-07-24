package appelhorne.fogbugz;

import appelhorne.fogbugz.command.ViewArticleCommand;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Article {
    private String headline;
    private String body;


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public abstract int getArticleNr();

    public abstract int getRevision();

    public abstract void save() throws FogBugzException;

    public abstract List<Revision> listRevisions() throws FogBugzException;

    public static Article get(FogBugz fogbugz, int articleNr, int revision) throws FogBugzException {
        ViewArticleCommand cmd = new ViewArticleCommand(fogbugz, articleNr, revision);
        cmd.execute();
        return cmd.getArticle();
    }

    public static Article get(FogBugz fogbugz, int articleNr) throws FogBugzException {
        return get(fogbugz, articleNr, 0);
    }
}
