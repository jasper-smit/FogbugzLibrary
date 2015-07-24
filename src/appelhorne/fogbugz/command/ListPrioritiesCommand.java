package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Priority;
import appelhorne.fogbugz.impl.PriorityImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class ListPrioritiesCommand extends Command {
    private List<Priority> priorities = new ArrayList<Priority>();

    public ListPrioritiesCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listPriorities");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//priority")) {
            PriorityImpl priority = new PriorityImpl();
            priority.setPriorityNr(nd.getInt("ixPriority"));
            priority.setName(nd.getString("sPriority"));
            priority.setDefaultPriority(nd.getBool("fDefault"));
            priorities.add(priority);
        }
    }

    public List<Priority> getPriorities() {
        return priorities;
    }
}
