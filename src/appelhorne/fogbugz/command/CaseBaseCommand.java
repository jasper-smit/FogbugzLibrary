package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Case;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.CaseImpl;
import appelhorne.fogbugz.util.ExtNode;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class CaseBaseCommand extends Command {
    public CaseBaseCommand(FogBugz fogbugz) {
        super(fogbugz);
    }

    protected String getCols() {
        return "ixBug,fOpen,sTitle,sLatestTextSummary,ixBugEventLatestText,ixProject,sProject,ixArea,sArea,ixGroup,ixPersonAssignedTo,"+
        "sPersonAssignedTo,sEmailAssignedTo,ixPersonOpenedBy,ixPersonResolvedBy,ixPersonClosedBy,ixPersonLastEditedBy,ixStatus," +
        "sStatus,ixPriority,sPriority,ixFixFor,sFixFor,dtFixFor,sVersion,sComputer,hrsOrigEst,hrsCurrEst,hrsElapsed,c,sCustomerEmail," +
        "ixMailbox,ixCategory,sCategory,dtOpened,dtResolved,dtClosed,ixBugEventLatest,dtLastUpdated,fForwarded," +
        "sTicket,ixDiscussTopic,dtDue,sReleaseNotes,ixBugEventLastView,dtLastView,ixRelatedBugs,sScoutDescription,sScoutMessage,fScoutStopReporting,fSubscribed,events";
    }

        protected String getLightCols() {
        return "ixBug,fOpen,sTitle";
    }

    protected void parseCaseData(CaseImpl caze, ExtNode nd) throws FogBugzException {
                    caze.setCaseNr(nd.getInt("ixBug"));
            caze.setOpen(nd.getBool("fOpen"));
            caze.setTitle(nd.getString("sTitle"));
            caze.setLatestTextSummary(nd.getString("sLatestTextSummary"));
            caze.setProjectNr(nd.getInt("ixProject"));
            caze.setAreaNr(nd.getInt("ixArea"));
            caze.setAssignedToNr(nd.getInt("ixPersonAssignedTo"));
            caze.setStatusNr(nd.getInt("ixStatus"));
            caze.setPriorityNr(nd.getInt("ixPriority"));
            caze.setCustomerEmail(nd.getString("sCustomerEmail"));
            caze.setCategoryNr(nd.getInt("ixCategory"));
            caze.setDateOpened(nd.getDate("dtOpened"));
            caze.setDateResolved(nd.getDate("dtResolved"));
            caze.setDateClosed(nd.getDate("dtClosed"));
            caze.setDateLastUpdated(nd.getDate("dtLastUpdated"));
            caze.setForwarded(nd.getBool("fForwarded"));
            caze.setReplied(nd.getBool("fReplied"));
            caze.setEventLastViewed(nd.getInt("ixBugEventLastView"));
            caze.setDateLastViewed(nd.getDate("dtLastView"));
            caze.setRelatedCases(nd.getString("sRelatedBugs"));
            caze.setSubscribed(nd.getBool("fSubscribed"));
    }
}
