package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Case;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.CaseImpl;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class EditCommand extends Command {
    private String action;
    private CaseImpl caze;

    public EditCommand(FogBugz fogbugz, String action, Case caze, String event) {
        super(fogbugz);
        CaseImpl caseImpl = (CaseImpl)caze;
        this.action = action;
        this.caze = caseImpl;
        setCommand(action);
        addParam("ixBug", caseImpl.getCaseNr() + "");
        addParam("sTitle", caseImpl.getTitle());
        addParam("ixPersonAssignedTo", caseImpl.getAssignedToNr() + "");
        addParam("ixProject", caseImpl.getProjectNr() + "");
        addParam("ixArea", caseImpl.getAreaNr() + "");
        addParam("ixMailbox", caseImpl.getMailboxNr() + "");
        addParam("ixCategory", caseImpl.getCategoryNr() + "");
        addParam("ixStatus", caseImpl.getStatusNr() + "");
        addParam("sEvent", event);
        addParam("cols", "ixBug");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        caze.setCaseNr(Integer.parseInt(xpath("//case/ixBug/text()")));
    }
}
