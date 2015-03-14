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
public class Chart {
    private String agencyID;
    private double incomeSum;

    public Chart() {
    }

    public Chart(String agencyID, double incomeSum) {
        this.agencyID = agencyID;
        this.incomeSum = incomeSum;
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
     * @return the incomeSum
     */
    public double getIncomeSum() {
        return incomeSum;
    }

    /**
     * @param incomeSum the incomeSum to set
     */
    public void setIncomeSum(double incomeSum) {
        this.incomeSum = incomeSum;
    }
    
    
}
