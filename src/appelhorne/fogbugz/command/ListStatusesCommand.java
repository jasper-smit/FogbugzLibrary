package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Status;
import appelhorne.fogbugz.impl.StatusImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;


public class ListStatusesCommand extends Command {
    private List<Status> statuses = new ArrayList<Status>();

    public ListStatusesCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listStatuses");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//status")) {
            StatusImpl status = new StatusImpl(fogbugz);
            status.setStatusNr(nd.getInt("ixStatus"));
            status.setName(nd.getString("sStatus"));
            status.setCategoryNr(nd.getInt("ixCategory"));
            statuses.add(status);
        }
    }

    public List<Status> getStatuses() {
        return statuses;
    }
}
