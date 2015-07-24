package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Person;

/*
* Door Jasper Smit (j.b.smit <at> gmail.com)
*/
public class PersonImpl extends Person {
    private int personNr;
    private String fullName;
    private String email;
    private String phone;
    private boolean administrator;
    private boolean community;
    private boolean virtual;
    private boolean deleted;
    private boolean notify;
    private String homepage;
    private String locale;
    private String language;
    private String timeZoneKey;
    private boolean expert;

    public int getPersonNr() {
        return personNr;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public boolean isCommunity() {
        return community;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isNotify() {
        return notify;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getLocale() {
        return locale;
    }

    public String getLanguage() {
        return language;
    }

    public String getTimeZoneKey() {
        return timeZoneKey;
    }

    public boolean isExpert() {
        return expert;
    }

    public void setPersonNr(int personNr) {
        this.personNr = personNr;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public void setCommunity(boolean community) {
        this.community = community;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTimeZoneKey(String timeZoneKey) {
        this.timeZoneKey = timeZoneKey;
    }

    public void setExpert(boolean expert) {
        this.expert = expert;
    }
}
