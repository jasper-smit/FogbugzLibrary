package appelhorne.fogbugz.command;

import appelhorne.fogbugz.ArticleHeadline;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.ArticleHeadlineImpl;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ListArticlesCommand extends Command {
    private List<ArticleHeadline> headlines = new ArrayList<ArticleHeadline>();

    public ListArticlesCommand(FogBugz fogbugz, int wikiNr) {
        super(fogbugz);
        setCommand("listArticles");
        addParam("ixWiki", wikiNr + "");
    }

    public void execute() throws FogBugzException {
        doCommand();
        NodeList articles = xpathListOld("//article");
        for(int i = 0; i < articles.getLength(); i++) {
            Node article = articles.item(i);
            headlines.add(new ArticleHeadlineImpl(
                    xpath(article, "sHeadline/text()"),
                    Integer.parseInt(xpath(article, "ixWikiPage/text()"))));
        }
    }

    public List<ArticleHeadline> getHeadlines() {
        return headlines;
    }
}
