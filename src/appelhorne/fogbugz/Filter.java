package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Filter {

    public abstract String getType();

    public abstract String getId();

    public abstract String getName();

    public abstract boolean isCurrent();

    public abstract List<Case> execute() throws FogBugzException;

    public abstract List<Case> execute(int limit) throws FogBugzException;

    public abstract List<Case> execute(int limit, boolean light) throws FogBugzException;

    public static List<Filter> listFilters(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl)fogbugz).getFilters();
    }

    public static Filter getByName(FogBugz fogbugz, String name) throws FogBugzException {
        for(Filter filter : listFilters(fogbugz)) {
            if(filter.getName().equals(name)) return filter;
        }
        return null;
    }
}
