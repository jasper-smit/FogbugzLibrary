package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Project {
    public abstract int getProjectNr();

    public abstract String getName();

    public abstract Person getOwner() throws FogBugzException;

    public abstract boolean isInbox();

    public abstract int getType();

    public abstract List<Area> listAreas() throws FogBugzException;
    

    public static List<Project> listProjects(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getProjects();
    }

    public static Project get(FogBugz fogbugz, int projectNr) throws FogBugzException {
        for(Project project : listProjects(fogbugz)) {
            if(project.getProjectNr() == projectNr) return project;
        }
        return null;
    }

    public static Project getByName(FogBugz fogbugz, String name) throws FogBugzException {
            for(Project project : listProjects(fogbugz)) {
            if(project.getName().equals(name)) return project;
        }
        return null;
    }

}
