/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class LoanOptionsM {
    private String rateID;
    private double lowest;
    private double highest;
    private double rate;

    public LoanOptionsM() {
    }

    public LoanOptionsM(String rateID, double lowest, double highest, double rate) {
        this.rateID = rateID;
        this.lowest = lowest;
        this.highest = highest;
        this.rate = rate;
    }

    /**
     * @return the rateID
     */
    public String getRateID() {
        return rateID;
    }

    /**
     * @param rateID the rateID to set
     */
    public void setRateID(String rateID) {
        this.rateID = rateID;
    }

    /**
     * @return the lowest
     */
    public double getLowest() {
        return lowest;
    }

    /**
     * @param lowest the lowest to set
     */
    public void setLowest(double lowest) {
        this.lowest = lowest;
    }

    /**
     * @return the highest
     */
    public double getHighest() {
        return highest;
    }

    /**
     * @param highest the highest to set
     */
    public void setHighest(double highest) {
        this.highest = highest;
    }

    /**
     * @return the rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
    
    public boolean isRelevantOption(double amount){
        if (amount >= lowest && amount < highest) {
            return true;
        }
        return false;
    }
    
}
