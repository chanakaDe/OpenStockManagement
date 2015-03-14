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
public class AgencyOrderDetail {
    private String agencyOrderID;
    private String bottleID;
    private String qty;
    private String unitPrice;
    private String totalPrice;

    public AgencyOrderDetail() {
    }

    public AgencyOrderDetail(String agencyOrderID, String bottleID, String qty, String unitPrice, String totalPrice) {
        this.agencyOrderID = agencyOrderID;
        this.bottleID = bottleID;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
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
     * @return the bottleID
     */
    public String getBottleID() {
        return bottleID;
    }

    /**
     * @param bottleID the bottleID to set
     */
    public void setBottleID(String bottleID) {
        this.bottleID = bottleID;
    }

    /**
     * @return the qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /**
     * @return the unitPrice
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the totalPrice
     */
    public String getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
