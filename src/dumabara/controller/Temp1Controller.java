/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDe
 */
public class Temp1Controller {
    public static int addTempData(String userName) throws ClassNotFoundException, SQLException{
        String sql="insert into temp1 values '"+userName+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm =conn.createStatement();
        int executeUpdate = stm.executeUpdate(sql);
        return executeUpdate;
    }
   
    public static int updateTempData(String userName) throws ClassNotFoundException, SQLException{
        String sql="update temp1 set username='"+userName+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm =conn.createStatement();
        int executeUpdate = stm.executeUpdate(sql);
        return executeUpdate;
    }
    
    public static String getTempData() throws ClassNotFoundException, SQLException{
        String sql="select username from temp1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm =conn.createStatement();
        String  name=stm.executeQuery(sql).toString();      
        System.out.println(name);
        return name;
    }
}
