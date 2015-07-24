package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;


public class LogonCommand extends Command {
    private String username;
    private String password;
    private String token;

    public LogonCommand(FogBugz fogbugz, String username, String password) {
        super(fogbugz);
        this.username = username;
        this.password = password;
    }

    public void execute() throws FogBugzException {
        setCommand("logon");
        addParam("email", username);
        addParam("password", password);
        doCommand();
        token = xpath("//token");
    }

    public String getToken() {
        return token;
    }
}
