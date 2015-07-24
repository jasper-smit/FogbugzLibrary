package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class SaveFilterCommand extends Command {
    public SaveFilterCommand(FogBugz fogbugz, String filter) {
        super(fogbugz);
        setCommand("saveFilter");
        addParam("sFilter", filter);
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
    }
}
