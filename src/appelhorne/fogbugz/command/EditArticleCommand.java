package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Article;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class EditArticleCommand extends Command {
    public EditArticleCommand(FogBugz fogbugz, Article page) {
        super(fogbugz);
        setCommand("editArticle");
        addParam("ixWikiPage", page.getArticleNr() + "");
        addParam("sHeadline", page.getHeadline());
        addParam("sBody", page.getBody());
        addParam("sComment", "Editted by FogBugzLib");
    }

    public void execute() throws FogBugzException {
        doCommand();
    }
}
