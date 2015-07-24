package appelhorne.fogbugz.command;

import appelhorne.fogbugz.FogBugz;
import appelhorne.fogbugz.FogBugzException;
import appelhorne.fogbugz.Person;
import appelhorne.fogbugz.impl.PersonImpl;
import appelhorne.fogbugz.util.ExtNode;

import java.util.ArrayList;
import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class ListPeopleCommand extends Command {
    private List<Person> people = new ArrayList<Person>();

    public ListPeopleCommand(FogBugz fogbugz) {
        super(fogbugz);
        setCommand("listPeople");
    }

    @Override
    public void execute() throws FogBugzException {
        doCommand();
        for(ExtNode nd : xpathList("//person")) {
            PersonImpl person = new PersonImpl();
            person.setPersonNr(nd.getInt("ixPerson"));
            person.setFullName(nd.getString("sFullName"));
            person.setEmail(nd.getString("sEmail"));
            person.setPhone(nd.getString("sPhone"));
            person.setAdministrator(nd.getBool("fAdministrator"));
            person.setCommunity(nd.getBool("fCommunity"));
            person.setVirtual(nd.getBool("fVirtual"));
            person.setDeleted(nd.getBool("fDeleted"));
            person.setNotify(nd.getBool("fNotify"));
            person.setHomepage(nd.getString("sHomepage"));
            person.setLocale(nd.getString("sLocale"));
            person.setLanguage(nd.getString("sLanguage"));
            person.setTimeZoneKey(nd.getString("sTimeZoneKey"));
            person.setExpert(nd.getBool("fExpert"));
            people.add(person);
        }
    }

    public List<Person> getPeople() {
        return people;
    }
}
