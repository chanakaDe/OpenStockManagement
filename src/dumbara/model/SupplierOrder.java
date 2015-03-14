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
public class SupplierOrder {
    private String SupplierOrderID;
    private String SupplierID;
    private String date;
    private String status;

    public SupplierOrder() {
    }

    public SupplierOrder(String SupplierOrderID, String SupplierID, String date) {
        this.SupplierOrderID = SupplierOrderID;
        this.SupplierID = SupplierID;
        this.date = date;
    }
    
    public SupplierOrder(String SupplierOrderID, String SupplierID, String date,String status) {
        this.SupplierOrderID = SupplierOrderID;
        this.SupplierID = SupplierID;
        this.date = date;
        this.status=status;
    }

    /**
     * @return the SupplierOrderID
     */
    public String getSupplierOrderID() {
        return SupplierOrderID;
    }

    /**
     * @param SupplierOrderID the SupplierOrderID to set
     */
    public void setSupplierOrderID(String SupplierOrderID) {
        this.SupplierOrderID = SupplierOrderID;
    }

    /**
     * @return the SupplierID
     */
    public String getSupplierID() {
        return SupplierID;
    }

    /**
     * @param SupplierID the SupplierID to set
     */
    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
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
    
        public String getStatus() {
        return status;
    }
        
    public void setStatus(String status) {
        this.status = status;
    }
    public String toString(){
        return SupplierOrderID;
    }
}
