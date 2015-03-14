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
public class EmptyBottle {
    private String bottleID;
    private String bottleVolume;
    private int qty;

    public EmptyBottle() {
    }

    public EmptyBottle(String bottleID, String bottleVolume, int qty) {
        this.bottleID = bottleID;
        this.bottleVolume = bottleVolume;
        this.qty = qty;
    }
        public EmptyBottle(String bottleID,  int qty) {
        this.bottleID = bottleID;
        this.qty = qty;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public String toString(){
        return bottleID+"-"+bottleVolume;
    }

    
}

    