package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;

/*
 * Door Jasper Smit (j.b.smit <at> gmail.com)
 */

public class LogoffCommand extends Command {
    public LogoffCommand(FogBugz fogbugz) {
        super(fogbugz);
    }

    public void execute() throws FogBugzException {
        setCommand("logoff");
        doCommand();
    }
}
