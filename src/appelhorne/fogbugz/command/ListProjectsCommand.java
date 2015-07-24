package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Project;
import appelhorne.fogbugz.impl.ProjectImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ListProjectsCommand extends Command {
    private List<Project> projects = new ArrayList<Project>();

    public ListProjectsCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listProjects");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//project")) {
            ProjectImpl project = new ProjectImpl(fogbugz);
            project.setProjectNr(nd.getInt("ixProject"));
            project.setName(nd.getString("sProject"));
            project.setOwnerNr(nd.getInt("ixPersonOwner"));
            project.setInbox(nd.getBool("fInbox"));
            project.setType(nd.getInt("iType"));
            projects.add(project);
        }
    }

    public List<Project> getProjects() {
        return projects;
    }
}
