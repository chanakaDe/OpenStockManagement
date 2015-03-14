/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumabara.controller;

import dumbara.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dumbara.model.AgencyOrderDetail;
import dumbara.model.SupplierOrderDetail;
import java.sql.ResultSet;

/**
 *
 * @author chanu1993
 */
public class AgencyOrderDetailController {

    static int addAgencyOrderDetail(AgencyOrderDetail agencyOrderDetail) throws ClassNotFoundException, SQLException {
       String sql="insert into agencyOrderDetail values(?,?,?,?,?)";
       Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, agencyOrderDetail.getAgencyOrderID());
        pStatement.setString(2, agencyOrderDetail.getBottleID());
        pStatement.setString(3, agencyOrderDetail.getQty());
        pStatement.setString(4, agencyOrderDetail.getUnitPrice());
        pStatement.setString(5, agencyOrderDetail.getTotalPrice());
        int res=pStatement.executeUpdate();
        return res;
    }
    
    public static AgencyOrderDetail[] viewAll(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from agencyorderdetail where AgencyOrderID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, id);
        ResultSet rst=pStatement.executeQuery();
        int count=0;
        while(rst.next()){
            count++;
        }
        AgencyOrderDetail[] agencyOrderDetails=new AgencyOrderDetail[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String bID=rst.getString("BottleID");
            String qty=rst.getString("Qty");
            String unitPrice=rst.getString("UnitPrice");
            String totPrice=rst.getString("TotalPrice");
            
            AgencyOrderDetail agencyOrderDetail=new AgencyOrderDetail(id, bID, qty, unitPrice, totPrice);
            System.out.println(id + " " + bID+" "+qty+ " "+unitPrice);
            agencyOrderDetails[i]=agencyOrderDetail;
           
        }
        return agencyOrderDetails;
    }
    
}
