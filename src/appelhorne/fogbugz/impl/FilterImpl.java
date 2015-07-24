package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Case;
import appelhorne.fogbugz.Filter;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.command.SaveFilterCommand;
import appelhorne.fogbugz.command.SearchCommand;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class FilterImpl extends Filter {
    private FogBugz fogbugz;
    private String type;
    private String id;
    private String name;
    private boolean current;

    public FilterImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurrent() {
        return current;
    }

    @Override
    public List<Case> execute() throws FogBugzException {
        return execute(0);
    }

    @Override
    public List<Case> execute(int limit) throws FogBugzException {
        return execute(limit, false);
    }

    @Override
    public List<Case> execute(int limit, boolean light) throws FogBugzException {
        SaveFilterCommand cmdSave = new SaveFilterCommand(fogbugz, getId());
        cmdSave.execute();
        SearchCommand cmdSearch = new SearchCommand(fogbugz, null, limit, light);
        cmdSearch.execute();
        return cmdSearch.getCases();
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }


}
