/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class LoanOptionSetCount {
    private String slaryId;
    private double lowest;
    private double highest;
    private double count;

    public LoanOptionSetCount() {
    }

    public LoanOptionSetCount(String slaryId, double lowest, double highest, double count) {
        this.slaryId = slaryId;
        this.lowest = lowest;
        this.highest = highest;
        this.count = count;
    }

    /**
     * @return the slaryId
     */
    public String getSlaryId() {
        return slaryId;
    }

    /**
     * @param slaryId the slaryId to set
     */
    public void setSlaryId(String slaryId) {
        this.slaryId = slaryId;
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
     * @return the count
     */
    public double getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(double count) {
        this.count = count;
    }
    
    public boolean isRelevantOption(double amount) {
        if (amount >= lowest && amount < highest) {
            return true;
        }
        return false;
    }
    
    
}
