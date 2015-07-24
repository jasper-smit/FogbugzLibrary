package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.*;

import java.util.Date;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class EventImpl extends Event {
    private FogBugz fogbugz;
    private int eventNr;
    private int type;
    private String verb;
    private int personNr;
    private String text;
    private Date date;
    private boolean external;
    private String changes;
    private String description;
    private Email email;

    public EventImpl(FogBugzImpl fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getEventNr() {
        return eventNr;
    }

    public void setEventNr(int eventNr) {
        this.eventNr = eventNr;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public int getPersonNr() {
        return personNr;
    }

    public void setPersonNr(int personNr) {
        this.personNr = personNr;
    }

    public Person getPerson() throws FogBugzException {
        return Person.get(fogbugz, getPersonNr());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
