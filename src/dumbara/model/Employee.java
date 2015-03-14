/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumbara.model;

import javax.swing.ImageIcon;

/**
 *
 * @author chanu1993
 */
public class Employee {
    private String empID;
    private String name;
    private String address;
    private String contactNo;
    private String dob;
    private String age;
    private String nic;
    private String assignDate;
    private String gender;
    private String civilStatus;
    private String nationality;
    private String bloodGroup;
    private double salary;
    private String emergencyCall;
    private ImageIcon empImage;
    

    public Employee() {
    }

    public Employee(String empID, String name, String address, String contactNo, String dob, String age, String nic, String assignDate, String gender, String civilStatus, String nationality, String bloodGroup,double salary, String emergencyCall) {
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.age = age;
        this.nic = nic;
        this.assignDate = assignDate;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.salary = salary;
        this.emergencyCall = emergencyCall;
    }

    public Employee(String empID, String name, String address, String contactNo, String dob, String age, String nic, String assignDate, String gender, String civilStatus, String nationality, String bloodGroup,double salary, String emergencyCall, ImageIcon empImage) {
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.dob = dob;
        this.age = age;
        this.nic = nic;
        this.assignDate = assignDate;
        this.gender = gender;
        this.civilStatus = civilStatus;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.salary = salary;
        this.emergencyCall = emergencyCall;
        this.empImage = empImage;
    }
    
    public Employee(String empID, String name, String address, String contactNo,String civilStatus,String emergencyCall){
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.civilStatus = civilStatus;
        this.emergencyCall = emergencyCall;
    }
    
    
    public Employee(String empID, String name, String address, String contactNo,String civilStatus,String emergencyCall,String nic,double salary){
        this.empID = empID;
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.civilStatus = civilStatus;
        this.emergencyCall = emergencyCall;
        this.nic=nic;
        this.salary=salary;
    }
    
    public Employee(ImageIcon empImage){
        this.empImage = empImage;
    }

    public ImageIcon getEmpImage() {
        return empImage;
    }

    public void setEmpImage(ImageIcon empImage) {
        this.empImage = empImage;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the contactNo
     */
    public String getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the assignDate
     */
    public String getAssignDate() {
        return assignDate;
    }

    /**
     * @param assignDate the assignDate to set
     */
    public void setAssignDate(String assignDate) {
        this.assignDate = assignDate;
    }

    /**
     * @return the resignDate
     */
    public String getResignDate() {
        return gender;
    }

    /**
     * @param resignDate the resignDate to set
     */
    public void setResignDate(String resignDate) {
        this.gender = gender;
    }

    /**
     * @return the civilStatus
     */
    public String getCivilStatus() {
        return civilStatus;
    }

    /**
     * @param civilStatus the civilStatus to set
     */
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the emergencyCall
     */
    public String getEmergencyCall() {
        return emergencyCall;
    }
    
    public double getSalary() {
        return salary;
    }

    /**
     * @param emergencyCall the emergencyCall to set
     */
    public void setEmergencyCall(String emergencyCall) {
        this.emergencyCall = emergencyCall;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String toString(){
        return empID+"-"+name;
    }
    
    
}
