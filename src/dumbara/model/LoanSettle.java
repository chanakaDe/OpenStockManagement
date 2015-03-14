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
public class LoanSettle {
    private String loanSettleID;

    public void setLoanSettleID(String loanSettleID) {
        this.loanSettleID = loanSettleID;
    }

    public String getLoanSettleID() {
        return loanSettleID;
    }
    private String loanID;
    private String loanAmount;
    private String payment;
    private String duePayment;
    private String paymentDate;

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LoanSettle() {
    }



    public LoanSettle(String loanSettleID, String loanID, String loanAmount, String payment, String duePayment) {
        this.loanSettleID = loanSettleID;
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.payment = payment;
        this.duePayment = duePayment;
    }

    public LoanSettle(String loanSettleID, String loanID, String loanAmount, String payment, String duePayment, String paymentDate) {
        this.loanSettleID = loanSettleID;
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.payment = payment;
        this.duePayment = duePayment;
        this.paymentDate = paymentDate;
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
     * @return the loanAmount
     */
    public String getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @return the payment
     */
    public String getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * @return the duePayment
     */
    public String getDuePayment() {
        return duePayment;
    }

    /**
     * @param duePayment the duePayment to set
     */
    public void setDuePayment(String duePayment) {
        this.duePayment = duePayment;
    }
    
    
}
