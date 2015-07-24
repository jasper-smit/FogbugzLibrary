package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Area {

    public abstract int getAreaNr();

    public abstract String getName();

    public abstract Project getProject() throws FogBugzException;

    public abstract Person getOwner() throws FogBugzException;

    public abstract int getType();

    public abstract int getDoc();

    public static List<Area> listAreas(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getAreas();
    }

    public static Area get(FogBugz fogbugz, int areaNr) throws FogBugzException {
        for (Area area : listAreas(fogbugz)) {
            if (area.getAreaNr() == areaNr) return area;
        }
        return null;
    }

    public static List<Area> listAreasByProject(FogBugz fogbugz, Project project) throws FogBugzException {
        List<Area> areas = new ArrayList<Area>();
        for (Area area : listAreas(fogbugz)) {
            if (area.getProject().getProjectNr() == project.getProjectNr()) areas.add(area);
        }
        return areas;
    }
}
