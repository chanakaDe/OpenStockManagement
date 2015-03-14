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
import dumbara.model.AgencyOrder;
import dumbara.model.AgencyOrderDetail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chanu1993
 */
public class AgencyOrderController {

    public static String getLastID() throws ClassNotFoundException, SQLException {
        String sql = "select AgencyOrderID from agencyOrder order by 1 desc limit 1";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        } else {
            return null;
        }

    }

    public static int addOrder(AgencyOrder agencyOrder, AgencyOrderDetail[] agencyOrderDetails) throws ClassNotFoundException, SQLException {
        String sql = "insert into agencyOrder values(?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, agencyOrder.getAgencyOrderID());
        pStatement.setString(2, agencyOrder.getAgencyID());
        pStatement.setString(3, agencyOrder.getDate());
        int res1 = pStatement.executeUpdate();
        int res2 = -1;
        for (int i = 0; i < agencyOrderDetails.length; i++) {
            res2 = AgencyOrderDetailController.addAgencyOrderDetail(agencyOrderDetails[i]);

        }
        return res1 > 0 && res2 > 0 ? 1 : -1;
    }

    public static List<AgencyOrder> getPendingOrders() throws ClassNotFoundException, SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        List<AgencyOrder> agencyOrders = new ArrayList<>();
        String query = "SELECT * FROM agencyorder";
        Date today = new Date();
        Statement stm = DBConnection.getInstance().getConnection().createStatement();
        ResultSet rst = stm.executeQuery(query);
        while (rst.next()) {
            try {
                if (sdf.parse(rst.getString(3)).getTime() > today.getTime()) {
                    AgencyOrder ao = new AgencyOrder(rst.getString(1), rst.getString(2), rst.getString(3));
                    agencyOrders.add(ao);
                }
            } catch (ParseException ex) {
                Logger.getLogger(AgencyOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return agencyOrders;
    }
    public static AgencyOrder[] getAllOrders() throws ClassNotFoundException, SQLException{
        String sql="select * from agencyorder";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        AgencyOrder[] agencyOrders=new AgencyOrder[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String agencyOrderID=rst.getString("AgencyOrderID");
            String agencyId=rst.getString("AgencyID");
            String oDate=rst.getString("OrderDate");
            
            AgencyOrder agencyOrder=new AgencyOrder(agencyOrderID, agencyId, oDate);
            agencyOrders[i]=agencyOrder;
        }
        return agencyOrders;
    }
}
