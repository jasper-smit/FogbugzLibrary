package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Mailbox;
import appelhorne.fogbugz.impl.MailboxImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class ListMailboxesCommand extends Command {
    private List<Mailbox> mailboxes = new ArrayList<Mailbox>();

    public ListMailboxesCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listMailboxes");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//mailbox")) {
            MailboxImpl mailbox = new MailboxImpl();
            mailbox.setMailboxNr(nd.getInt("ixMailbox"));
            mailbox.setEmail(nd.getString("sEmail"));
            mailbox.setEmailUser(nd.getString("sEmailUser"));
            mailbox.setTemplate(nd.getString("sTemplate"));
            mailboxes.add(mailbox);
        }
    }

    public List<Mailbox> getMailboxes() {
        return mailboxes;
    }
}
