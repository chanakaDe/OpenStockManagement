/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class User {
    private String userNAme;
    private String password;
    private int privileges;
    private String email;

    public User() {
    }

    public User(String userNAme, String password, int privileges, String email) {
        this.userNAme = userNAme;
        this.password = password;
        this.privileges = privileges;
        this.email = email;
    }
    
    public User(String userNAme, String password, int privileges) {
        this.userNAme = userNAme;
        this.password = password;
        this.privileges = privileges;
    }
    
    public User(String userNAme) {
        this.userNAme = userNAme;
    }

    /**
     * @return the userNAme
     */
    public String getUserNAme() {
        return userNAme;
    }

    /**
     * @param userNAme the userNAme to set
     */
    public void setUserNAme(String userNAme) {
        this.userNAme = userNAme;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the privileges
     */
    public int getPrivileges() {
        return privileges;
    }

    /**
     * @param privileges the privileges to set
     */
    public void setPrivileges(int privileges) {
        this.privileges = privileges;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

   
    
    
    
}
