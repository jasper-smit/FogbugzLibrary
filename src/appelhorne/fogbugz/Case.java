package appelhorne.fogbugz;

import appelhorne.fogbugz.command.EditCommand;
import appelhorne.fogbugz.command.SearchCommand;
import appelhorne.fogbugz.impl.CaseImpl;

import java.util.Date;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Case {

    public abstract int getCaseNr() ;

    public abstract boolean isOpen();

    public abstract String getTitle();

    public abstract String getLatestTextSummary();

    public abstract Person getAssignedTo() throws FogBugzException;

    public abstract String getCustomerEmail();

    public abstract Date getDateOpened();

    public abstract Date getDateResolved();

    public abstract Date getDateClosed();

    public abstract Date getDateLastUpdated();

    public abstract boolean isReplied();

    public abstract boolean isForwarded();

    public abstract int getEventLastViewed();

    public abstract Date getDateLastViewed();

    public abstract String getRelatedCases();

    public abstract boolean isSubscribed();

    public abstract void setTitle(String title);

    public abstract void setAssignedTo(Person person);

    public abstract Area getArea() throws FogBugzException;

    public abstract void setArea(Area area);

    public abstract Project getProject() throws FogBugzException;

    public abstract void setProject(Project project);

    public abstract Priority getPriority() throws FogBugzException;

    public abstract void setPriority(Priority priority);

    public abstract Mailbox getMailbox() throws FogBugzException;

    public abstract void setMailbox(Mailbox mailbox);

    public abstract Category getCategory() throws FogBugzException;

    public abstract void setCategory(Category category);

    public abstract Status getStatus() throws FogBugzException;

    public abstract void setStatus(Status status);

    public abstract List<Event> getEvents();

    public abstract void edit(String message) throws FogBugzException;

    public abstract void assign(String message) throws FogBugzException;

    public abstract void reactivate(String message) throws FogBugzException;

    public abstract void reopen(String message) throws FogBugzException;

    public abstract void resolve(String message) throws FogBugzException;

    public abstract void close(String message) throws FogBugzException;

    public abstract void newCase(String message) throws FogBugzException;

    public abstract void email(Email email) throws FogBugzException;

    public abstract void forward(Email email) throws FogBugzException;

    public abstract void reply(Email email) throws FogBugzException;

    public static Case get(FogBugz fogbugz, int caseNr) throws FogBugzException {
        SearchCommand search = new SearchCommand(fogbugz, caseNr + "");
        search.execute();
        if(search.getCases().size() == 0) return null;
        return search.getCases().get(0);
    }

    public static Case newCase(FogBugz fogbugz) throws FogBugzException {
        return new CaseImpl(fogbugz);
    }
}
