/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class OptionalLogin {
    private String userName;
    private String ques1;
    private String ques2;
    private String ques3;

    public OptionalLogin() {
    }

    public OptionalLogin(String userName, String ques1, String ques2, String ques3) {
        this.userName = userName;
        this.ques1 = ques1;
        this.ques2 = ques2;
        this.ques3 = ques3;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the ques1
     */
    public String getQues1() {
        return ques1;
    }

    /**
     * @param ques1 the ques1 to set
     */
    public void setQues1(String ques1) {
        this.ques1 = ques1;
    }

    /**
     * @return the ques2
     */
    public String getQues2() {
        return ques2;
    }

    /**
     * @param ques2 the ques2 to set
     */
    public void setQues2(String ques2) {
        this.ques2 = ques2;
    }

    /**
     * @return the ques3
     */
    public String getQues3() {
        return ques3;
    }

    /**
     * @param ques3 the ques3 to set
     */
    public void setQues3(String ques3) {
        this.ques3 = ques3;
    }
    
    
}
