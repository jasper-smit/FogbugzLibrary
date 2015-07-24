package appelhorne.fogbugz.impl;

import appelhorne.fogbugz.Mailbox;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class MailboxImpl extends Mailbox {
    private int mailboxNr;
    private String email;
    private String emailUser;
    private String template;

    public int getMailboxNr() {
        return mailboxNr;
    }

    public void setMailboxNr(int mailboxNr) {
        this.mailboxNr = mailboxNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
