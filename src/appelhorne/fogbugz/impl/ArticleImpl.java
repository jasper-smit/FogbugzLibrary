package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;
import appelhorne.fogbugz.command.EditArticleCommand;
import appelhorne.fogbugz.command.ListRevisionsCommand;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ArticleImpl extends Article {
    private FogBugz fogbugz;
    private int revision;
    private int articleNr;

    public ArticleImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public int getArticleNr() {
        return articleNr;
    }

    public void setArticleNr(int articleNr) {
        this.articleNr = articleNr;
    }

    public void save() throws FogBugzException {
        new EditArticleCommand(fogbugz, this).execute();
        setRevision(getRevision() + 1);
    }

    @Override
    public List<Revision> listRevisions() throws FogBugzException {
        ListRevisionsCommand cmd = new ListRevisionsCommand(fogbugz, getArticleNr());
        cmd.execute();
        return cmd.getRevisions();
    }
}
