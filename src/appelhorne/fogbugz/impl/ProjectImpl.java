package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ProjectImpl extends Project {
    private FogBugz fogbugz;
    private int projectNr;
    private String name;
    private int ownerNr;
    private boolean inbox;
    private int type;

    public ProjectImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getProjectNr() {
        return projectNr;
    }

    public void setProjectNr(int projectNr) {
        this.projectNr = projectNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwnerNr() {
        return ownerNr;
    }

    public Person getOwner() throws FogBugzException {
        return Person.get(fogbugz, ownerNr);
    }

    public void setOwnerNr(int ownerNr) {
        this.ownerNr = ownerNr;
    }

    public boolean isInbox() {
        return inbox;
    }

    public void setInbox(boolean inbox) {
        this.inbox = inbox;
    }

    public int getType() {
        return type;
    }

    @Override
    public List<Area> listAreas() throws FogBugzException {
        return Area.listAreasByProject(fogbugz, this);
    }

    public void setType(int type) {
        this.type = type;
    }
}
