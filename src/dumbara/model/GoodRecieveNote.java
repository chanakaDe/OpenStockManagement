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
public class GoodRecieveNote {
    private String grnID;
    private String bottleId;
    private String grnDate;
    private String supplierOrderID;
    private String volume;
    private String orderQty;
    private String recievedQty;
    private String varience; 

    public GoodRecieveNote() {
    }

    public GoodRecieveNote(String grnID, String bottleId, String grnDate, String supplierOrderID, String volume, String orderQty, String recievedQty, String varience) {
        this.grnID = grnID;
        this.bottleId = bottleId;
        this.grnDate = grnDate;
        this.supplierOrderID = supplierOrderID;
        this.volume = volume;
        this.orderQty = orderQty;
        this.recievedQty = recievedQty;
        this.varience = varience;
    }

    /**
     * @return the grnID
     */
    public String getGrnID() {
        return grnID;
    }

    /**
     * @param grnID the grnID to set
     */
    public void setGrnID(String grnID) {
        this.grnID = grnID;
    }

    /**
     * @return the bottleId
     */
    public String getBottleId() {
        return bottleId;
    }

    /**
     * @param bottleId the bottleId to set
     */
    public void setBottleId(String bottleId) {
        this.bottleId = bottleId;
    }

    /**
     * @return the grnDate
     */
    public String getGrnDate() {
        return grnDate;
    }

    /**
     * @param grnDate the grnDate to set
     */
    public void setGrnDate(String grnDate) {
        this.grnDate = grnDate;
    }

    /**
     * @return the supplierOrderID
     */
    public String getSupplierOrderID() {
        return supplierOrderID;
    }

    /**
     * @param supplierOrderID the supplierOrderID to set
     */
    public void setSupplierOrderID(String supplierOrderID) {
        this.supplierOrderID = supplierOrderID;
    }

    /**
     * @return the volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @return the orderQty
     */
    public String getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(String orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the recievedQty
     */
    public String getRecievedQty() {
        return recievedQty;
    }

    /**
     * @param recievedQty the recievedQty to set
     */
    public void setRecievedQty(String recievedQty) {
        this.recievedQty = recievedQty;
    }

    /**
     * @return the varience
     */
    public String getVarience() {
        return varience;
    }

    /**
     * @param varience the varience to set
     */
    public void setVarience(String varience) {
        this.varience = varience;
    }
    
    
}
