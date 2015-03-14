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
public class SupplierOrderDetail {
    
    private String supplierOrderID;
    private String bottleID;
    private String bottleVolume;
    private String bottleQty;

    public SupplierOrderDetail() {
    }

    public SupplierOrderDetail( String supplierOrderID, String bottleID, String bottleVolume, String bottleQty) {
        
        this.supplierOrderID = supplierOrderID;
        this.bottleID = bottleID;
        this.bottleVolume = bottleVolume;
        this.bottleQty = bottleQty;
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
     * @return the bottleQty
     */
    public String getBottleQty() {
        return bottleQty;
    }

    /**
     * @param bottleQty the bottleQty to set
     */
    public void setBottleQty(String bottleQty) {
        this.bottleQty = bottleQty;
    }
     
    
}
