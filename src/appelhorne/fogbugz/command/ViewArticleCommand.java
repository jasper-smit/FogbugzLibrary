package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Article;
import appelhorne.fogbugz.impl.ArticleImpl;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ViewArticleCommand extends Command {
    private int articleNr;
    private int revision;
    private ArticleImpl article;

    public ViewArticleCommand(FogBugz fogbugz, int articleNr, int revision) {
        super(fogbugz);
        this.articleNr = articleNr;
        this.revision = revision;
        setCommand("viewArticle");
        addParam("ixWikiPage", articleNr + "");
        if(revision > 0) addParam("nRevision", revision + "");
    }

    public void execute() throws FogBugzException {
        doCommand();
        article = new ArticleImpl(fogbugz);
        article.setBody(xpath("//sBody"));
        article.setHeadline(xpath("//sHeadline"));
        article.setRevision(Integer.parseInt(xpath("//nRevision")));
        article.setArticleNr(articleNr);
    }

    public Article getArticle() {
        return article;
    }
}
