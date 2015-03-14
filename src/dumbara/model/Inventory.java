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
public class Inventory {
    private String itemCode;
    private String itemName;
    private String desc;
    private String brandName;
    private String price;
    private String supplierName;
    private String supplierAddress;
    private String supplierContactNo;
    private String pucharsedDate;
    private String warrantyPeriod;
    private String warrantyEndDate;

    public Inventory() {
    }

    public Inventory(String itemCode, String itemName, String desc, String brandName, String price, String supplierName, String supplierAddress, String supplierContactNo, String pucharsedDate, String warrantyPeriod, String warrantyEndDate) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.desc = desc;
        this.brandName = brandName;
        this.price = price;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierContactNo = supplierContactNo;
        this.pucharsedDate = pucharsedDate;
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyEndDate = warrantyEndDate;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return the supplierAddress
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * @param supplierAddress the supplierAddress to set
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    /**
     * @return the supplierContactNo
     */
    public String getSupplierContactNo() {
        return supplierContactNo;
    }

    /**
     * @param supplierContactNo the supplierContactNo to set
     */
    public void setSupplierContactNo(String supplierContactNo) {
        this.supplierContactNo = supplierContactNo;
    }

    /**
     * @return the pucharsedDate
     */
    public String getPucharsedDate() {
        return pucharsedDate;
    }

    /**
     * @param pucharsedDate the pucharsedDate to set
     */
    public void setPucharsedDate(String pucharsedDate) {
        this.pucharsedDate = pucharsedDate;
    }

    /**
     * @return the warrantyPeriod
     */
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    /**
     * @param warrantyPeriod the warrantyPeriod to set
     */
    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    /**
     * @return the warrantyEndDate
     */
    public String getWarrantyEndDate() {
        return warrantyEndDate;
    }

    /**
     * @param warrantyEndDate the warrantyEndDate to set
     */
    public void setWarrantyEndDate(String warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }
    
    public String toString(){
        return itemCode+"-"+itemName;
    }
    
}
