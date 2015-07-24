package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;


public class ApiCommand extends Command {
    private String version;
    private String minVersion;
    private String url;

    public ApiCommand(FogBugz fogbugz) {
        super(fogbugz);
    }

    public void execute() throws FogBugzException {
        doCommandGet(fogbugz.getServer() + "/api.xml");
        setVersion(xpath("//version/text()"));
        setMinVersion(xpath("//minversion/text()"));
        setUrl(xpath("//url/text()"));
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMinVersion() {
        return minVersion;
    }

    public void setMinVersion(String minVersion) {
        this.minVersion = minVersion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
