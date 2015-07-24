package appelhorne.fogbugz.command;

import appelhorne.fogbugz.Case;
import appelhorne.fogbugz.Email;
import appelhorne.fogbugz.FogBugz;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class  EmailCommand extends EditCommand {
    public EmailCommand(FogBugz fogbugz, String action, Case caze, Email email) {
        super(fogbugz, action, caze, "test 1 2 3");
        //setCommand("edit");
        addParam("sSubject", email.getSubject());
        addParam("sTo", email.getTo());
        addParam("sFrom", email.getFrom());
        addParam("sCC", email.getCC());
        addParam("sBCC", email.getBCC());

    }
}
