package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Status {
    public abstract int getStatusNr();

    public abstract Category getCategory() throws FogBugzException;

    public abstract String getName();

    public static List<Status> listStatuses(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getStatuses();
    }

    public static Status get(FogBugz fogbugz, int statusNr) throws FogBugzException {
        for (Status status : listStatuses(fogbugz)) {
            if (status.getStatusNr() == statusNr) return status;
        }
        return null;
    }

    public static Status getByName(FogBugz fogbugz, String name) throws FogBugzException {
        for (Status status : listStatuses(fogbugz)) {
            if (status.getName().equals(name)) return status;
        }
        return null;
    }
}
