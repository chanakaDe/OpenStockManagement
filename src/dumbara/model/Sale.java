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
public class Sale {
  private String salesID;
  private String salesDate;
  private String agencyID;
  private String bottleID;
  private String bottleVolume;
  private int saledQty;
  private double income;

    public Sale() {
    }

    public Sale(String salesID, String salesDate, String agencyID, String bottleID, String bottleVolume, int saledQty, double income) {
        this.salesID = salesID;
        this.salesDate = salesDate;
        this.agencyID = agencyID;
        this.bottleID = bottleID;
        this.bottleVolume = bottleVolume;
        this.saledQty = saledQty;
        this.income = income;
    }

    /**
     * @return the salesID
     */
    public String getSalesID() {
        return salesID;
    }

    /**
     * @param salesID the salesID to set
     */
    public void setSalesID(String salesID) {
        this.salesID = salesID;
    }

    /**
     * @return the salesDate
     */
    public String getSalesDate() {
        return salesDate;
    }

    /**
     * @param salesDate the salesDate to set
     */
    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
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
     * @return the saledQty
     */
    public int getSaledQty() {
        return saledQty;
    }

    /**
     * @param saledQty the saledQty to set
     */
    public void setSaledQty(int saledQty) {
        this.saledQty = saledQty;
    }

    /**
     * @return the income
     */
    public double getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(double income) {
        this.income = income;
    }

    
  
  
}
