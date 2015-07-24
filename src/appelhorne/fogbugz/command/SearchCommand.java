package appelhorne.fogbugz.command;

import appelhorne.fogbugz.*;
import appelhorne.fogbugz.impl.CaseImpl;
import appelhorne.fogbugz.impl.EventImpl;
import appelhorne.fogbugz.util.ExtNode;
import appelhorne.fogbugz.util.Util;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class SearchCommand extends CaseBaseCommand {
    private List<Case> cases = new ArrayList<Case>();

    public SearchCommand(FogBugz fogbugz, String query) {
        this(fogbugz, query, 0, false);
    }

    public SearchCommand(FogBugz fogbugz, String query, int limit, boolean light) {
        super(fogbugz);
        setCommand("search");
        if (query != null) {
            addParam("q", query);
        }
        if(limit > 0) {
            addParam("max", limit + "");
        }
        addParam("cols", light ? getLightCols() : getCols());
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();

        for (ExtNode nd : xpathList("//case")) {
            CaseImpl caze = new CaseImpl(fogbugz);
            parseCaseData(caze, nd);

            List<ExtNode> children = nd.getChildren("events/event");
            if (children.size() > 0) {
                List<Event> events = new ArrayList<Event>();
                for (ExtNode ndEvent : children) {
                    EventImpl event = new EventImpl(fogbugz);
                    event.setEventNr(ndEvent.getInt("ixBugEvent"));
                    event.setType(ndEvent.getInt("evt"));
                    event.setVerb(ndEvent.getString("sVerb"));
                    event.setDate(ndEvent.getDate("dt"));
                    event.setText(ndEvent.getString("s"));
                    event.setExternal(ndEvent.getBool("bExternal"));
                    event.setChanges(ndEvent.getString("sChanges"));
                    event.setPersonNr(ndEvent.getInt("ixPerson"));
                    event.setDescription(ndEvent.getString("evtDescription"));
                    if (ndEvent.getBool("bEmail")) {
                        Email email = new Email();
                        email.setFrom(ndEvent.getString("sFrom"));
                        email.setTo(ndEvent.getString("sTo"));
                        email.setCC(ndEvent.getString("sCC"));
                        email.setBCC(ndEvent.getString("sBCC"));
                        email.setReplyTo(ndEvent.getString("sReplyTo"));
                        email.setSubject(ndEvent.getString("sSubject"));
                        email.setText(ndEvent.getString("sBodyText"));
                        email.setHTML(ndEvent.getString("sBodyHTML"));
                        event.setEmail(email);
                    }
                    events.add(event);
                }
                caze.setEvents(events);
            }


            cases.add(caze);
        }
    }

    public List<Case> getCases() {
        return cases;
    }
}
