package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;
import appelhorne.fogbugz.command.*;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class FogBugzImpl extends FogBugz {
    /* Connection settings */
    private String server;
    private HttpClient client;
    private String url;
    private String token;

    /* Cached objects */
    private List<Person> people;
    private List<Project> projects;
    private List<Area> areas;
    private List<Status> statuses;
    private List<Category> categories;
    private List<Mailbox> mailboxes;
    private List<Priority> priorities;
    private List<Filter> filters;


    /* Commands */
    public void logoff() throws FogBugzException {
        new LogoffCommand(this).execute();
    }

    @Override
    public void clearCache() {
        people = null;
        projects = null;
        areas = null;
        statuses = null;
        categories = null;
        mailboxes = null;
        filters = null;
    }

    /* Connection settings, getters */
    public HttpClient getClient() {
        return client;
    }

    public String getServer() {
        return server;
    }

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }

    /* Cached objects getters */
    public List<Person> getPeople() throws FogBugzException {
        if (people == null) {
            ListPeopleCommand cmd = new ListPeopleCommand(this);
            cmd.execute();
            people = cmd.getPeople();
        }
        return people;
    }

    public List<Project> getProjects() throws FogBugzException {
        if (projects == null) {
            ListProjectsCommand cmd = new ListProjectsCommand(this);
            cmd.execute();
            projects = cmd.getProjects();
        }
        return projects;
    }

    public List<Area> getAreas() throws FogBugzException {
        if (areas == null) {
            ListAreasCommand cmd = new ListAreasCommand(this);
            cmd.execute();
            areas = cmd.getAreas();
        }
        return areas;
    }

    public List<Status> getStatuses() throws FogBugzException {
        if (statuses == null) {
            ListStatusesCommand cmd = new ListStatusesCommand(this);
            cmd.execute();
            statuses = cmd.getStatuses();
        }
        return statuses;
    }

    public List<Category> getCategories() throws FogBugzException {
        if (categories == null) {
            ListCategoriesCommand cmd = new ListCategoriesCommand(this);
            cmd.execute();
            categories = cmd.getCategories();
        }
        return categories;
    }

    public List<Mailbox> getMailboxes() throws FogBugzException {
        if(mailboxes == null) {
            ListMailboxesCommand cmd = new ListMailboxesCommand(this);
            cmd.execute();
            mailboxes = cmd.getMailboxes();
        }
        return mailboxes;
    }

    public List<Priority> getPriorities() throws FogBugzException {
        if(priorities == null) {
            ListPrioritiesCommand cmd = new ListPrioritiesCommand(this);
            cmd.execute();
            priorities = cmd.getPriorities();
        }
        return priorities;
    }

    public List<Filter> getFilters() throws FogBugzException {
        if(filters == null) {
            ListFiltersCommand cmd = new ListFiltersCommand(this);
            cmd.execute();
            filters = cmd.getFilters();
        }
        return filters;
    }

    /* Object creation */
    protected FogBugzImpl(String server) {
        this.server = server;
        client = new DefaultHttpClient();
    }

    public static FogBugzImpl login(String server, String username, String password) throws FogBugzException {
        FogBugzImpl fogbugz = new FogBugzImpl(server);

        /* Get URL */
        ApiCommand apiCommand = new ApiCommand(fogbugz);
        apiCommand.execute();
        fogbugz.url = server + "/" + apiCommand.getUrl();

        /* Get token */
        LogonCommand logonCmd = new LogonCommand(fogbugz, username, password);
        logonCmd.execute();
        fogbugz.token = logonCmd.getToken();

        return fogbugz;
    }
}
