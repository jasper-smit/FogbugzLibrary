package appelhorne.fogbugz;

import java.util.Date;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Event {
    public abstract int getEventNr();

    public abstract int getType();

    public abstract String getVerb();

    public abstract Person getPerson() throws FogBugzException;

    public abstract String getText();

    public abstract Date getDate();

    public abstract boolean isExternal();

    public abstract String getChanges();

    public abstract String getDescription();

    public abstract Email getEmail();
}
