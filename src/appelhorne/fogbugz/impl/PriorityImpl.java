package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Priority;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class PriorityImpl extends Priority {
    private int priorityNr;
    private String name;
    private boolean defaultPriority;

    public int getPriorityNr() {
        return priorityNr;
    }

    public void setPriorityNr(int priorityNr) {
        this.priorityNr = priorityNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDefaultPriority() {
        return defaultPriority;
    }

    public void setDefaultPriority(boolean defaultPriority) {
        this.defaultPriority = defaultPriority;
    }
}
