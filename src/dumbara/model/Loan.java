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
public class Loan {
    private String empID;
    private String loanID;
    private String longAmount;
    private String loanTerm;
    private String interestRate;
    private String monthlyPayment;
    private String dueAmount;

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public Loan() {
    }

    public Loan( String longAmount, String monthlyPayment , String loanID) {
        this.longAmount = longAmount;
        this.monthlyPayment = monthlyPayment; 
        this.loanID=loanID;
    }

    public Loan(String empID, String loanID, String longAmount, String loanTerm, String interestRate, String monthlyPayment, String dueAmount) {
        this.empID = empID;
        this.loanID = loanID;
        this.longAmount = longAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
        this.monthlyPayment = monthlyPayment;
        this.dueAmount = dueAmount;
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
     * @return the loanID
     */
    public String getLoanID() {
        return loanID;
    }

    /**
     * @param loanID the loanID to set
     */
    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    /**
     * @return the longAmount
     */
    public String getLongAmount() {
        return longAmount;
    }

    /**
     * @param longAmount the longAmount to set
     */
    public void setLongAmount(String longAmount) {
        this.longAmount = longAmount;
    }

    /**
     * @return the loanTerm
     */
    public String getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param loanTerm the loanTerm to set
     */
    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    /**
     * @return the interestRate
     */
    public String getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the monthlyPayment
     */
    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * @param monthlyPayment the monthlyPayment to set
     */
    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    
    
}
