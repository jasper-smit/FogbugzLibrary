package appelhorne.fogbugz;

import appelhorne.fogbugz.command.ApiCommand;
import appelhorne.fogbugz.command.LogoffCommand;
import appelhorne.fogbugz.command.LogonCommand;
import appelhorne.fogbugz.command.ViewArticleCommand;
import appelhorne.fogbugz.impl.FogBugzImpl;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class FogBugz {
    /* Commands */
    public abstract void logoff() throws FogBugzException;

    /* Clear cache */
    public abstract void clearCache();


    public static FogBugz login(String server, String username, String password) throws FogBugzException {
        return FogBugzImpl.login(server, username, password);
    }
}
