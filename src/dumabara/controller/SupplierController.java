/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.Agency;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dumbara.model.Supplier;

/**
 *
 * @author chanu1993
 */
public class SupplierController {
    public static int addSupplier(Supplier supplier) throws ClassNotFoundException, SQLException{
        String sql="insert into supplier values(?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, supplier.getSupplierID());
        preparedStatement.setString(2, supplier.getSupplierName());
        preparedStatement.setString(3, supplier.getSupplierAddress());
        preparedStatement.setString(4, supplier.getSupplierContactNo());
        int res=preparedStatement.executeUpdate();
        return res;
    }
    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql="select SupplierID from supplier order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    public static Supplier[] viewSupplier() throws ClassNotFoundException, SQLException{
        String sql="select * from supplier";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Supplier supplier[]= new Supplier[count];
        rst.beforeFirst();
        for(int i=0;rst.next();i++){
            String id=rst.getString("SupplierID");
            String name=rst.getString("SupplierName");
            String address=rst.getString("SupplierAddress");
            String contactNo=rst.getString("SupplierContactNo");
 
            Supplier supplier1=new Supplier(id, name, address, contactNo);
            supplier[i]=supplier1;
            
        }
        return supplier;
    }
    public static Supplier viewAgencyByID(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from supplier where SupplierID='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);

        Supplier supplier=new Supplier();
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String supplierID=rst.getString("SupplierID");
            String supplierName=rst.getString("SupplierName");
            String address=rst.getString("SupplierAddress");
            String contactNo=rst.getString("SupplierContactNo");
  
             supplier=new Supplier(supplierID, supplierName, address, contactNo);
        }
        return supplier;
    }
}
