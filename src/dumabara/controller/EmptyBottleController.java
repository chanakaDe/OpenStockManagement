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
import dumbara.model.EmptyBottle;

/**
 *
 * @author chanu1993
 */
public class EmptyBottleController {
    public static int addBottles(EmptyBottle emptyBottle) throws ClassNotFoundException, SQLException{
        String sql="insert into emptyBottles values(?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, emptyBottle.getBottleID());
        preparedStatement.setString(2, emptyBottle.getBottleVolume());
        preparedStatement.setInt(3, emptyBottle.getQty());
        int res=preparedStatement.executeUpdate();
        return res;
    }
    public static String getLastID() throws ClassNotFoundException, SQLException{
        String sql="select BottleID from emptyBottles order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    public static EmptyBottle[] viewEmptyBottles() throws SQLException, ClassNotFoundException{
        String sql="select * from emptyBottles";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        EmptyBottle[] emptyBottles=new EmptyBottle[count];
        rst.beforeFirst();
        
        for (int i = 0; rst.next(); i++) {
            String id=rst.getString("BottleID");
            String volume=rst.getString("BottleVolume");
            int qty=Integer.parseInt(rst.getString("Qty"));
            
            EmptyBottle emptyBottle=new EmptyBottle(id, volume, qty);

            emptyBottles[i]=emptyBottle;
        }
        return emptyBottles;
    }
    public static int updateBottles(EmptyBottle emptyBottle) throws ClassNotFoundException, SQLException{
        String sql="update emptyBottles set Qty=Qty+'"+emptyBottle.getQty()+"' where BottleID='"+emptyBottle.getBottleID()+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
}
