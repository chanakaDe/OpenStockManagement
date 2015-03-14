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
public class AgencyOrder {
    private String agencyID;
    private String agencyOrderID;
    private String date;

    public AgencyOrder() {
    }

    public AgencyOrder(String agencyID, String agencyOrderID, String date) {
        this.agencyID = agencyID;
        this.agencyOrderID = agencyOrderID;
        this.date = date;
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
     * @return the agencyOrderID
     */
    public String getAgencyOrderID() {
        return agencyOrderID;
    }

    /**
     * @param agencyOrderID the agencyOrderID to set
     */
    public void setAgencyOrderID(String agencyOrderID) {
        this.agencyOrderID = agencyOrderID;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
}
