/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class EmailForm {
    private String toMail;
    private String subject;
    private String msg;

    public EmailForm() {
    }

    public EmailForm(String toMail, String subject, String msg) {
        this.toMail = toMail;
        this.subject = subject;
        this.msg = msg;
    }

    /**
     * @return the toMail
     */
    public String getToMail() {
        return toMail;
    }

    /**
     * @param toMail the toMail to set
     */
    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
