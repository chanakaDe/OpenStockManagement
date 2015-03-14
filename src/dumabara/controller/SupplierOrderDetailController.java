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
import dumbara.model.SupplierOrderDetail;

/**
 *
 * @author chanu1993
 */
public class SupplierOrderDetailController {
    
    public static int addOrderDetail(SupplierOrderDetail supplierOrderDetail) throws ClassNotFoundException, SQLException{
        String sql="insert into supplierOrderDetail values (?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, supplierOrderDetail.getSupplierOrderID());
        pStatement.setString(2, supplierOrderDetail.getBottleID());
        pStatement.setString(3, supplierOrderDetail.getBottleVolume());
        pStatement.setString(4, supplierOrderDetail.getBottleQty());
        int res=pStatement.executeUpdate();
        return res;
    }
    public static SupplierOrderDetail[] viewAll(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from supplierOrderDetail where SupplierOrderID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, id);
        ResultSet rst=pStatement.executeQuery();
        int count=0;
        while(rst.next()){
            count++;
        }
        SupplierOrderDetail[] supplierOrderDetails=new SupplierOrderDetail[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String bID=rst.getString("BottleID");
            String bVol=rst.getString("BottleVolume");
            String bQty=rst.getString("BottleQty");
            
            SupplierOrderDetail supplierOrderDetail=new SupplierOrderDetail(id, bID, bVol, bQty);
            supplierOrderDetails[i]=supplierOrderDetail;
        }
        return supplierOrderDetails;
    }
    
}
