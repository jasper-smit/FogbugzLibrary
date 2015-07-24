package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Priority {
    public abstract int getPriorityNr();

    public abstract String getName();

    public abstract boolean isDefaultPriority();

    public static Priority get(FogBugz fogbugz, int priorityNr) throws FogBugzException {
        for(Priority priority : listPriorities(fogbugz)) {
            if(priority.getPriorityNr() == priorityNr) return priority;
        }
        return null;
    }

    public static Priority getDefault(FogBugz fogbugz) throws FogBugzException {
        for(Priority priority : listPriorities(fogbugz)) {
            if(priority.isDefaultPriority()) return priority;
        }
        return null;
    }

    public static List<Priority> listPriorities(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getPriorities();
    }
}
