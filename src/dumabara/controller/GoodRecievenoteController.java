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
import java.util.ArrayList;
import dumbara.model.GoodRecieveNote;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chanu1993
 */
public class GoodRecievenoteController {
    public static int addGRN(ArrayList<GoodRecieveNote> arrayList) throws ClassNotFoundException, SQLException{
        String sql="insert into goodRecievedNote values(?,?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement praparedStatement=conn.prepareStatement(sql);
        for (GoodRecieveNote goodRecieveNote : arrayList) {
            System.out.println("BT ID:"+goodRecieveNote.getBottleId());
            System.out.println("GRN ID:"+goodRecieveNote.getGrnID());
            praparedStatement.setString(1, goodRecieveNote.getGrnID());
            praparedStatement.setString(2, goodRecieveNote.getBottleId());
            praparedStatement.setString(3, goodRecieveNote.getGrnDate());
            praparedStatement.setString(4, goodRecieveNote.getSupplierOrderID());
            praparedStatement.setString(5, goodRecieveNote.getVolume());
            praparedStatement.setString(6, goodRecieveNote.getOrderQty());
            praparedStatement.setString(7, goodRecieveNote.getRecievedQty());
            praparedStatement.setString(8, goodRecieveNote.getVarience());
            praparedStatement.addBatch();
            
        }

        int[] executeBatch = praparedStatement.executeBatch();
        for (int i : executeBatch) {
            return i;
        }
        return 0;
    }
    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql="select GRN_ID from goodrecievednote order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
