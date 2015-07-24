package appelhorne.fogbugz;

import appelhorne.fogbugz.impl.FogBugzImpl;

import java.util.List;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public abstract class Person {
    public abstract int getPersonNr();

    public abstract String getFullName();

    public abstract String getEmail();

    public abstract String getPhone();

    public abstract boolean isAdministrator();

    public abstract boolean isCommunity();

    public abstract boolean isVirtual();

    public abstract boolean isDeleted();

    public abstract boolean isNotify();

    public abstract String getHomepage();

    public abstract String getLocale() ;

    public abstract String getLanguage();

    public abstract String getTimeZoneKey();

    public  abstract boolean isExpert();

    public static List<Person> listPeople(FogBugz fogbugz) throws FogBugzException {
        return ((FogBugzImpl)fogbugz).getPeople();
    }

    public static Person get(FogBugz fogbugz, int personNr) throws FogBugzException {
        for(Person p : listPeople(fogbugz)) {
            if(p.getPersonNr() == personNr) return p;
        }
        return null;
    }
    public static Person getByFullName(FogBugz fogbugz, String name) throws FogBugzException {
            for(Person p : listPeople(fogbugz)) {
            if(p.getFullName().equals(name)) return p;
        }
        return null;
    }
    public static Person getByEmail(FogBugz fogbugz, String email) throws FogBugzException {
            for(Person p : listPeople(fogbugz)) {
            if(p.getEmail().equals(email)) return p;
        }
        return null;
    }
}
