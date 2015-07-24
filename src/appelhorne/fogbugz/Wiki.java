package appelhorne.fogbugz;

import appelhorne.fogbugz.command.ListArticlesCommand;
import appelhorne.fogbugz.impl.WikiImpl;

import java.io.File;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Wiki {
    public abstract List<ArticleHeadline> getArticleHeadlines() throws FogBugzException;

    public abstract int getWikiNr();

    public abstract Article createArticle(String headline, String body) throws FogBugzException;

    public abstract Attachment uploadAttachment(File attachment) throws FogBugzException;

    public static Wiki get(FogBugz fogbugz, int wikiNr) throws FogBugzException {
        return new WikiImpl(fogbugz, wikiNr);
    }
}
