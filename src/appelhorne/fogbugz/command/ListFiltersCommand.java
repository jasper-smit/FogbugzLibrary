package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Filter;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.FilterImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class ListFiltersCommand extends Command {
    private List<Filter> filters = new ArrayList<Filter>();

    public ListFiltersCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listFilters");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//filter")) {
            FilterImpl filter = new FilterImpl(fogbugz);
            filter.setId(nd.getAttribute("sFilter"));
            filter.setType(nd.getAttribute("type"));
            filter.setCurrent("current".equals(nd.getAttribute("status")));
            filter.setName(nd.getText());
            filters.add(filter);
        }
    }

    public List<Filter> getFilters() {
        return filters;
    }
}
