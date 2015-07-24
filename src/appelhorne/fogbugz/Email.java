package appelhorne.fogbugz;

/**
 * Door Jasper Smit (jbsmit <at> gmail.com)
 */
public class Email {
    private String to;
    private String from;
    private String cc;
    private String bcc;
    private String subject;
    private String message;
    private String replyTo;
    private String text;
    private String html;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getCC() {
        return cc;
    }

    public void setCC(String cc) {
        this.cc = cc;
    }

    public String getBCC() {
        return bcc;
    }

    public void setBCC(String bcc) {
        this.bcc = bcc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getHTML() {
        return html;
    }

    public void setHTML(String html) {
        this.html = html;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
