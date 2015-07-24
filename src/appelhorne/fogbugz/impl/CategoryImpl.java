package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Category;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Status;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class CategoryImpl extends Category {
    private FogBugz fogbugz;
    private int categoryNr;
    private String name;
    private String plural;
    private int defaultStatusNr;
    private boolean scheduleItem;

    public CategoryImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
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

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public int getDefaultStatusNr() {
        return defaultStatusNr;
    }

    public void setDefaultStatusNr(int defaultStatusNr) {
        this.defaultStatusNr = defaultStatusNr;
    }

    public Status getDefaultStatus() throws FogBugzException {
        return Status.get(fogbugz, getDefaultStatusNr());
    }

    public boolean isScheduleItem() {
        return scheduleItem;
    }

    public void setScheduleItem(boolean scheduleItem) {
        this.scheduleItem = scheduleItem;
    }
}
