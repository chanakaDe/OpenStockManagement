/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumbara.model;

/**
 *
 * @author ChanakaDe
 */
public class Chart4 {
    private String salesDate;
    private double sumIncme;

    public Chart4() {
    }

    public Chart4(String salesDate, double sumIncme) {
        this.salesDate = salesDate;
        this.sumIncme = sumIncme;
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
     * @return the sumIncme
     */
    public double getSumIncme() {
        return sumIncme;
    }

    /**
     * @param sumIncme the sumIncme to set
     */
    public void setSumIncme(double sumIncme) {
        this.sumIncme = sumIncme;
    }
    
    
}
