package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Revision;
import appelhorne.fogbugz.impl.RevisionImpl;
import appelhorne.fogbugz.util.Util;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ListRevisionsCommand extends Command {
    private List<Revision> revisions = new ArrayList<Revision>();
    private int articleNr;

    public ListRevisionsCommand(FogBugz fogbugz, int articleNr) {
        super(fogbugz);
        this.articleNr = articleNr;
        setCommand("listRevisions");
        addParam("ixWikiPage", articleNr + "");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        NodeList ndRevisions = xpathListOld("//revision");
        for (int i = 0; i < ndRevisions.getLength(); i++) {
            Node node = ndRevisions.item(i);
            RevisionImpl revision = new RevisionImpl();
            revision.setArticleNr(articleNr);
            revision.setRevision(Integer.parseInt(xpath(node, "nRevision/text()")));
            revision.setPerson(Integer.parseInt(xpath(node, "ixPerson/text()")));
            revision.setRemoteIP(xpath(node, "sRemoteIP/text()"));
            revision.setHeadline(xpath(node, "sTitle/text()"));
            revision.setComment(xpath(node, "sComment/text()"));
            revision.setDifference(xpath(node, "fDiff/text()").equals("true"));
            revision.setDate(Util.parseDate(xpath(node, "dt/text()")));

            revisions.add(revision);
        }
    }

    public List<Revision> getRevisions() {
        return revisions;
    }
}
