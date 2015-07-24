package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;
import appelhorne.fogbugz.command.EditCommand;
import appelhorne.fogbugz.command.EmailCommand;

import java.util.Date;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class CaseImpl extends Case {
    private FogBugz fogbugz;
    private int caseNr;
    private boolean open;
    private String title;
    private String latestTextSummary;
    private int assignedTo;
    private int statusNr;
    private int priorityNr;
    private int mailboxNr;
    private int areaNr;
    private int projectNr;
    private String customerEmail;
    private int categoryNr;
    private Date dateOpened;
    private Date dateResolved;
    private Date dateClosed;
    private Date dateLastUpdated;
    private boolean replied;
    private boolean forwarded;
    private int eventLastViewed;
    private Date dateLastViewed;
    private String relatedCases;
    private boolean subscribed;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    private List<Event> events;


    public CaseImpl(FogBugz fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getCaseNr() {
        return caseNr;
    }

    public void setCaseNr(int caseNr) {
        this.caseNr = caseNr;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatestTextSummary() {
        return latestTextSummary;
    }

    public void setLatestTextSummary(String latestTextSummary) {
        this.latestTextSummary = latestTextSummary;
    }

    public Person getAssignedTo() throws FogBugzException {
        return Person.get(fogbugz, assignedTo);
    }

    public void setAssignedTo(Person person) {
        assignedTo = person.getPersonNr();
    }

    public int getAreaNr() {
        return areaNr;
    }

    public void setAreaNr(int areaNr) {
        this.areaNr = areaNr;
    }

    public int getProjectNr() {
        return projectNr;
    }

    public void setProjectNr(int projectNr) {
        this.projectNr = projectNr;
    }

    @Override
    public Area getArea() throws FogBugzException {
        return Area.get(fogbugz, getAreaNr());
    }

    @Override
    public void setArea(Area area) {
        setAreaNr(area.getAreaNr());
    }

    @Override
    public Project getProject() throws FogBugzException {
        return Project.get(fogbugz, getProjectNr());
    }

    @Override
    public void setProject(Project project) {
        setProjectNr(project.getProjectNr());
    }

    @Override
    public Priority getPriority() throws FogBugzException {
        return Priority.get(fogbugz, getPriorityNr());
    }

    @Override
    public void setPriority(Priority priority) {
        setPriorityNr(priority.getPriorityNr());
    }

    @Override
    public Mailbox getMailbox() throws FogBugzException {
        return Mailbox.get(fogbugz, getMailboxNr());
    }

    @Override
    public void setMailbox(Mailbox mailbox) {
        setMailboxNr(mailbox.getMailboxNr());
    }

    @Override
    public Category getCategory() throws FogBugzException {
        return Category.get(fogbugz, getCategoryNr());
    }

    @Override
    public void setCategory(Category category) {
        setCategoryNr(category.getCategoryNr());
    }

    @Override
    public Status getStatus() throws FogBugzException {
        return Status.get(fogbugz, getStatusNr());
    }

    @Override
    public void setStatus(Status status) {
        setStatusNr(status.getStatusNr());
    }

    public int getAssignedToNr() {
        return assignedTo;
    }

    public void setAssignedToNr(int personNr) {
        assignedTo = personNr;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }


    public Date getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

    public Date getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }

    public Date getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = dateClosed;
    }

    public Date getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(Date dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public boolean isReplied() {
        return replied;
    }

    public void setReplied(boolean replied) {
        this.replied = replied;
    }

    public boolean isForwarded() {
        return forwarded;
    }

    public void setForwarded(boolean forwarded) {
        this.forwarded = forwarded;
    }

    public int getEventLastViewed() {
        return eventLastViewed;
    }

    public void setEventLastViewed(int eventLastViewed) {
        this.eventLastViewed = eventLastViewed;
    }

    public Date getDateLastViewed() {
        return dateLastViewed;
    }

    public void setDateLastViewed(Date dateLastViewed) {
        this.dateLastViewed = dateLastViewed;
    }

    public String getRelatedCases() {
        return relatedCases;
    }

    public void setRelatedCases(String relatedCases) {
        this.relatedCases = relatedCases;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public int getStatusNr() {
        return statusNr;
    }


    public void setStatusNr(int statusNr) {
        this.statusNr = statusNr;
    }


    public int getPriorityNr() {
        return priorityNr;
    }

    public void setPriorityNr(int priorityNr) {
        this.priorityNr = priorityNr;
    }

    public int getMailboxNr() {
        return mailboxNr;
    }

    public void setMailboxNr(int mailboxNr) {
        this.mailboxNr = mailboxNr;
    }

    public int getCategoryNr() {
        return categoryNr;
    }

    public void setCategoryNr(int categoryNr) {
        this.categoryNr = categoryNr;
    }

    public void edit(String message) throws FogBugzException {
        new EditCommand(fogbugz, "edit", this, message).execute();
    }

    public void assign(String message) throws FogBugzException {
        new EditCommand(fogbugz, "assign", this, message).execute();
    }

    @Override
    public void reactivate(String message) throws FogBugzException {
        new EditCommand(fogbugz, "reactivate", this, message).execute();
    }

    @Override
    public void reopen(String message) throws FogBugzException {
        new EditCommand(fogbugz, "reopen", this, message).execute();
    }

    @Override
    public void resolve(String message) throws FogBugzException {
        new EditCommand(fogbugz, "resolve", this, message).execute();
    }

    @Override
    public void close(String message) throws FogBugzException {
        new EditCommand(fogbugz, "close", this, message).execute();
    }

    @Override
    public void newCase(String message) throws FogBugzException {
        new EditCommand(fogbugz, "new", this, message).execute();
    }

    @Override
    public void email(Email email) throws FogBugzException {
        new EmailCommand(fogbugz, "email", this, email).execute();
    }

    @Override
    public void forward(Email email) throws FogBugzException {
        new EmailCommand(fogbugz, "forward", this, email).execute();
    }

    @Override
    public void reply(Email email) throws FogBugzException {
        new EmailCommand(fogbugz, "reply", this, email).execute();
    }

}
