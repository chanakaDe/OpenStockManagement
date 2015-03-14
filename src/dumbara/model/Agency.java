/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumbara.model;

/**
 *
 * @author chanu1993
 */
public class Agency {
    private String agencyID;
    private String agencyName;
    private String address;
    private String contactNo;
    private String ownerName;
    private String ownerNo;

    public Agency() {
    }

    public Agency(String agencyID, String agencyName, String address, String contactNo, String ownerName, String ownerNo) {
        this.agencyID = agencyID;
        this.agencyName = agencyName;
        this.address = address;
        this.contactNo = contactNo;
        this.ownerName = ownerName;
        this.ownerNo = ownerNo;
    }

    /**
     * @return the agencyID
     */
    public String getAgencyID() {
        return agencyID;
    }

    /**
     * @param agencyID the agencyID to set
     */
    public void setAgencyID(String agencyID) {
        this.agencyID = agencyID;
    }

    /**
     * @return the agencyName
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * @param agencyName the agencyName to set
     */
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * @return the ownerNo
     */
    public String getOwnerNo() {
        return ownerNo;
    }

    /**
     * @param ownerNo the ownerNo to set
     */
    public void setOwnerNo(String ownerNo) {
        this.ownerNo = ownerNo;
    }
    public String toString(){
        return agencyID+"-"+agencyName;
    }
    
}
