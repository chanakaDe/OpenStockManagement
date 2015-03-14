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
public class FilledBottle {
    private String bottleID;
    private String bottleVolume;
    private String producedDate;
    private String expireDate;
    private String inStockQty;
    private String unitPrice;

    public FilledBottle() {
    }

    public FilledBottle(String bottleID, String bottleVolume, String producedDate, String expireDate, String inStockQty, String unitPrice) {
        this.bottleID = bottleID;
        this.bottleVolume = bottleVolume;
        this.producedDate = producedDate;
        this.expireDate = expireDate;
        this.inStockQty = inStockQty;
        this.unitPrice = unitPrice;
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
     * @return the bottleVolume
     */
    public String getBottleVolume() {
        return bottleVolume;
    }

    /**
     * @param bottleVolume the bottleVolume to set
     */
    public void setBottleVolume(String bottleVolume) {
        this.bottleVolume = bottleVolume;
    }

    /**
     * @return the producedDate
     */
    public String getProducedDate() {
        return producedDate;
    }

    /**
     * @param producedDate the producedDate to set
     */
    public void setProducedDate(String producedDate) {
        this.producedDate = producedDate;
    }

    /**
     * @return the expireDate
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate the expireDate to set
     */
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * @return the inStockQty
     */
    public String getInStockQty() {
        return inStockQty;
    }

    /**
     * @param inStockQty the inStockQty to set
     */
    public void setInStockQty(String inStockQty) {
        this.inStockQty = inStockQty;
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

    
    
    
}
