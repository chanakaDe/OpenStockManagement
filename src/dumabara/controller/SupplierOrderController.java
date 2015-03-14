/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumabara.controller;

import dumbara.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dumbara.model.SupplierOrder;
import dumbara.model.SupplierOrderDetail;

/**
 *
 * @author chanu1993
 */
public class SupplierOrderController {
    public static  int addSupplierOrder(SupplierOrder supplierOrder,SupplierOrderDetail[] supplierOrderDetails) throws ClassNotFoundException, SQLException{
        String sql="insert into supplierOrder values(?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setFetchSize(100);
        preparedStatement.setString(1, supplierOrder.getSupplierOrderID());
        preparedStatement.setString(2, supplierOrder.getSupplierID());
        preparedStatement.setString(3, supplierOrder.getDate());
        preparedStatement.setString(4, "Not_Recieved");
        
        int res1=preparedStatement.executeUpdate();
        int res2=-1;
        for (int i = 0; i < supplierOrderDetails.length; i++) {
            res2=SupplierOrderDetailController.addOrderDetail(supplierOrderDetails[i]);
        }
        return res1>0 && res2>0 ? 1 :-1;
    }
    
    public static String getLastID() throws ClassNotFoundException, SQLException{
        String sql="select SupplierOrderID from supplierOrder order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }else{
            return null;
        }
    }
    public static SupplierOrder[] getAllOrders(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from supplierOrder where SupplierID=? AND supplierOrderID not in (select supplierOrderID from goodrecievednote) ";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, id);
        ResultSet rst=pStatement.executeQuery();
        int count=0;
        while(rst.next()){
            count++;
        }
        SupplierOrder supplierOrder[]=new SupplierOrder[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String sOID=rst.getString("SupplierOrderID");
            String sID=rst.getString("SupplierID");
            String oDate=rst.getString("OrderDate");
            String status=rst.getString("Status");
            
            SupplierOrder sOrder=new SupplierOrder(sOID, sID, oDate,status);
            supplierOrder[i]=sOrder;
            
        }
        return supplierOrder;
    }
    public static String getOrderDate(String id) throws ClassNotFoundException, SQLException{
        String sql="select OrderDate from supplierOrder where SupplierOrderID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, id);
        ResultSet rst=pStatement.executeQuery();
        if(rst.next()){
            String date=rst.getString("OrderDate");
            return date;
        }
        return null;   
    }
    public static SupplierOrder[] getAllOrdersAll() throws ClassNotFoundException, SQLException{
        String sql="select * from supplierOrder";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        SupplierOrder supplierOrder[]=new SupplierOrder[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String sOID=rst.getString("SupplierOrderID");
            String sID=rst.getString("SupplierID");
            String oDate=rst.getString("OrderDate");
            String status=rst.getString("Status");
            
            SupplierOrder sOrder=new SupplierOrder(sOID, sID, oDate,status);
            supplierOrder[i]=sOrder;      
        }
        return supplierOrder;
    }
    public static int updateSupplierOrder(String id) throws ClassNotFoundException, SQLException{
        String sql="update supplierorder set Status='Recieved' where SupplierOrderID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, id);
        int res=pStatement.executeUpdate();
        return res;
    }
}
