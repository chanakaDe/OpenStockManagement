/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import dumbara.model.Employee;

/**
 *
 * @author chanu1993
 *///
public class EmployeeController {

    public static int addEmployee(Employee emp) throws ClassNotFoundException, SQLException {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("./A.JPG"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, emp.getEmpID());
        prepareStatement.setString(2, emp.getName());
        prepareStatement.setString(3, emp.getAddress());
        prepareStatement.setString(4, emp.getContactNo());
        prepareStatement.setString(5, emp.getDob());
        prepareStatement.setString(6, emp.getAge());
        prepareStatement.setString(7, emp.getNic());
        prepareStatement.setString(8, emp.getAssignDate());
        prepareStatement.setString(9, emp.getResignDate());
        prepareStatement.setString(10, emp.getCivilStatus());
        prepareStatement.setString(11, emp.getNationality());
        prepareStatement.setString(12, emp.getBloodGroup());
        prepareStatement.setString(13, emp.getEmergencyCall());
        prepareStatement.setBinaryStream(14, fis, new File("./A.JPG").length());
        prepareStatement.setDouble(15, emp.getSalary());
        int res = prepareStatement.executeUpdate();
        return res;
    }

    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql = "select EmpID from employee order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

    public static Employee[] viewAllEmployee() throws SQLException, ClassNotFoundException, IOException {
        String sql = "select * from employee";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Employee[] empList = new Employee[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String empid = rst.getString("EmpID");
            String name = rst.getString("EmpName");
            String address = rst.getString("Address");
            String contactNo = rst.getString("contactNo");
            String dob = rst.getString("DOB");
            String age = rst.getString("Age");
            String nic = rst.getString("NIC");
            String assignDate = rst.getString("AssignedDate");
           
            String civilStatus = rst.getString("CivilStatus");
            String nationality = rst.getString("Nationality");
            String bloodGroup = rst.getString("BloodGroup");
            String emergencyCall = rst.getString("EmergencyCall");
            InputStream binaryStream;
            ImageIcon imageIcon = null;
            if((binaryStream= rst.getBinaryStream("EmpImage")) != null){
         
                imageIcon = new ImageIcon(ImageIO.read(binaryStream));
            }
            double salary=rst.getDouble("salary");
               
            Employee employee = new Employee(empid, name, address, contactNo, dob, age, nic, assignDate, null, civilStatus, nationality, bloodGroup, salary,emergencyCall,imageIcon);
            empList[i] = employee;
        }
        return empList;

    }
    public static int deleteEmployee(String empID) throws ClassNotFoundException, SQLException{
        String sql="delete from employee where empID='"+empID+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
    
    public static int updateEmployee(Employee emp) throws ClassNotFoundException, SQLException{
        String sql="update employee set EmpName='"+emp.getName()+"', address='"+emp.getAddress()+"', ContactNo='"+emp.getContactNo()+"', CivilStatus='"+emp.getCivilStatus()+"' ,EmergencyCall='"+emp.getEmergencyCall()+"' where EmpID='"+emp.getEmpID()+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
    public static ImageIcon viewEmployeeImg(String id) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select EmpImage from employee where EmpID='"+id+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ImageIcon imageIcon = null;
        InputStream binaryStream;
        if (rst.next()) {
            if((binaryStream= rst.getBinaryStream("EmpImage")) != null){
                imageIcon = new ImageIcon(ImageIO.read(binaryStream));
                return imageIcon;
            }
        }
        return null;
    }
    
    public static Employee[] viewAllEmployeebyID(String id) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select * from employee where EmpId='"+id+"'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Employee[] empList = new Employee[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String id1=rst.getString("EmpID");
            String name = rst.getString("EmpName");
            String address = rst.getString("Address");
            String contactNo = rst.getString("contactNo");   
            String nic = rst.getString("NIC");
            String civilStatus = rst.getString("CivilStatus"); 
            String emergencyCall = rst.getString("EmergencyCall");    
            double salary=rst.getDouble("Salary"); 
            Employee employee=new Employee(id1, name, address, contactNo, civilStatus, emergencyCall, nic, salary);
            empList[i]=employee;
        }
        return empList;

    }
}

