package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Area;
import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.impl.AreaImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ListAreasCommand extends Command {
    private List<Area> areas = new ArrayList<Area>();

    public ListAreasCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listAreas");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//area")) {
            AreaImpl area = new AreaImpl(fogbugz);
            area.setAreaNr(nd.getInt("ixArea"));
            area.setName(nd.getString("sArea"));
            area.setProjectNr(nd.getInt("ixProject"));
            area.setPersonOwnerNr(nd.getInt("ixPersonOwner"));
            area.setType(nd.getInt("nType"));
            area.setDoc(nd.getInt("cDoc"));
            areas.add(area);
        }
    }

    public List<Area> getAreas() {
        return areas;
    }
}
