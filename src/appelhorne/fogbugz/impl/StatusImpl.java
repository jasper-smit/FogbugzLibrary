package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Category;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Status;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class StatusImpl extends Status {
    private FogBugz fogbugz;
    private int statusNr;
    private int categoryNr;
    private String name;

    public StatusImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getStatusNr() {
        return statusNr;
    }

    @Override
    public Category getCategory() throws FogBugzException {
        return Category.get(fogbugz, getCategoryNr());
    }

    public void setStatusNr(int statusNr) {
        this.statusNr = statusNr;
    }

    public int getCategoryNr() {
        return categoryNr;
    }

    public void setCategoryNr(int categoryNr) {
        this.categoryNr = categoryNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
