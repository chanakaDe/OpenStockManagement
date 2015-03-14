/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class Chart1 {
    private String empID;
    private double loanamount;

    public Chart1() {
    }

    public Chart1(String empID, double loanamount) {
        this.empID = empID;
        this.loanamount = loanamount;
    }

    /**
     * @return the empID
     */
    public String getEmpID() {
        return empID;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(String empID) {
        this.empID = empID;
    }

    /**
     * @return the loanamount
     */
    public double getLoanamount() {
        return loanamount;
    }

    /**
     * @param loanamount the loanamount to set
     */
    public void setLoanamount(double loanamount) {
        this.loanamount = loanamount;
    }
    
    
}
