package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class AreaImpl extends Area {
    private FogBugz fogbugz;
    private int areaNr;
    private String name;
    private int projectNr;
    private int personOwnerNr;
    private int type;
    private int doc;

    public AreaImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getAreaNr() {
        return areaNr;
    }

    public void setAreaNr(int areaNr) {
        this.areaNr = areaNr;
    }

    public String getName() {
        return name;
    }

    @Override
    public Project getProject() throws FogBugzException {
        return Project.get(fogbugz, projectNr);
    }

    @Override
    public Person getOwner() throws FogBugzException {
        return Person.get(fogbugz, personOwnerNr);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectNr() {
        return projectNr;
    }

    public void setProjectNr(int projectNr) {
        this.projectNr = projectNr;
    }

    public int getPersonOwnerNr() {
        return personOwnerNr;
    }

    public void setPersonOwnerNr(int personOwnerNr) {
        this.personOwnerNr = personOwnerNr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }
}
