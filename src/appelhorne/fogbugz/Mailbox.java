package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public abstract class Mailbox {
    public abstract int getMailboxNr();

    public abstract String getEmail();

    public abstract String getEmailUser();

    public abstract String getTemplate();

    public static Mailbox get(FogBugz fogbugz, int mailboxNr) throws FogBugzException {
        for(Mailbox mailbox : listMailboxes(fogbugz)) {
            if(mailbox.getMailboxNr() == mailboxNr) return mailbox;
        }
        return null;
    }

    public static List<Mailbox> listMailboxes(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl) fogbugz).getMailboxes();
    }
}
