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
import dumbara.model.FilledBottle;

/**
 *
 * @author chanu1993
 */
public class FilledBottleController {
    public static int addToStock(FilledBottle filledBottle) throws ClassNotFoundException, SQLException{
        String sql="insert into filledBottles values (?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, filledBottle.getBottleID());
        pStatement.setString(2, filledBottle.getBottleVolume());
        pStatement.setString(3, filledBottle.getProducedDate());
        pStatement.setString(4, filledBottle.getExpireDate());
        pStatement.setString(5, filledBottle.getInStockQty());
        pStatement.setString(6, filledBottle.getUnitPrice());
        int res=pStatement.executeUpdate();
        return res;
    }
    public static FilledBottle[] viewFilledBottles() throws ClassNotFoundException, SQLException{
        String sql="select * from filledBottles";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        FilledBottle[] filledBottles=new FilledBottle[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String bottleID=rst.getString("BottleID");
            String bottleVolume=rst.getString("BottleVolume");
            String productionDate=rst.getString("ProducedDate");
            String expireDate=rst.getString("ExpireDate");
            String qty=rst.getString("InStockQty");
            String unitPrice=rst.getString("UnitPrice");
            
            FilledBottle filledBottle=new FilledBottle(bottleID, bottleVolume, productionDate, expireDate, qty, unitPrice);
            filledBottles[i]=filledBottle;
        }
        return filledBottles;
    }
    public static String getUnitPrice(String id) throws ClassNotFoundException, SQLException{
        String sql="select UnitPrice from filledBottles where BottleID='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("UnitPrice");
        }else{
            return null;
        }
    }
}
