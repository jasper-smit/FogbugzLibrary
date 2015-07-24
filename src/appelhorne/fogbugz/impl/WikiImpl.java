package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;
import appelhorne.fogbugz.command.ListArticlesCommand;
import appelhorne.fogbugz.command.NewArticleCommand;
import appelhorne.fogbugz.command.WikiFileUploadCommand;

import java.io.File;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class WikiImpl extends Wiki {
    private FogBugz fogbugz;
    private List<ArticleHeadline> headlines;
    private int wikiNr;

    public List<ArticleHeadline> getArticleHeadlines() throws FogBugzException {
        if(headlines == null) {
            ListArticlesCommand cmd = new ListArticlesCommand(fogbugz, wikiNr);
            cmd.execute();
            headlines = cmd.getHeadlines();
        }
        return headlines;
    }

    public int getWikiNr() {
        return wikiNr;
    }

    @Override
    public Article createArticle(String headline, String body) throws FogBugzException {
        NewArticleCommand cmd = new NewArticleCommand(fogbugz, getWikiNr(), headline, body);
        cmd.execute();
        ArticleImpl article = new ArticleImpl(fogbugz);
        article.setArticleNr(cmd.getArticleNr());
        article.setHeadline(headline);
        article.setBody(body);
        article.setRevision(1);
        return article;
    }

    @Override
    public Attachment uploadAttachment(File attachment) throws FogBugzException {
        WikiFileUploadCommand cmd = new WikiFileUploadCommand(fogbugz, wikiNr, attachment);
        cmd.execute();
        return new AttachmentImpl(fogbugz, cmd.getAttachmentNr()); 
    }

    public WikiImpl(FogBugz fogbugz, int wikiNr) {
        this.fogbugz = fogbugz;
        this.wikiNr = wikiNr;
    }
}
