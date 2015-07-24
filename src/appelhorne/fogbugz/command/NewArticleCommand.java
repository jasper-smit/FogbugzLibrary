package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class NewArticleCommand extends Command {
    private int articleNr;

    public NewArticleCommand(FogBugz fogbugz, int wikiNr, String headline, String body) {
        super(fogbugz);
        setCommand("newArticle");
        addParam("ixWiki", wikiNr + "");
        addParam("sHeadline", headline);
        addParam("sBody", body);
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        articleNr = Integer.parseInt(xpath("//ixWikiPage/text()"));
    }

    public int getArticleNr() {
        return articleNr;
    }
}
