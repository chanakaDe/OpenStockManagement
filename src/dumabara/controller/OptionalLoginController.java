/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.OptionalLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDe
 */
public class OptionalLoginController {

    public static OptionalLogin getLoginDetails(String name) throws ClassNotFoundException, SQLException {
        String sql = "select * from forgetpwd where username='" + name + "'";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        dumbara.model.OptionalLogin login = null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String username = rst.getString("username");
            String ques1 = rst.getString("ques1");
            String ques2 = rst.getString("ques2");
            String ques3 = rst.getString("ques3");
            
            System.out.println(ques1);

            login = new dumbara.model.OptionalLogin(username, ques1, ques2, ques3);
        }
        return login;
    }
    
    public static int addDetails(OptionalLogin optionalLogin) throws  ClassNotFoundException, SQLException{
        String sql="insert into forgetpwd values (?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, optionalLogin.getUserName());
        preparedStatement.setString(2, optionalLogin.getQues1());
        preparedStatement.setString(3, optionalLogin.getQues2());
        preparedStatement.setString(4, optionalLogin.getQues3());
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
    
    public static int updateDetails(OptionalLogin optionalLogin) throws ClassNotFoundException, SQLException{
        String sql="update forgetpwd set ques1 = ? , ques2 = ? , ques3 = ? where username = ? ";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, optionalLogin.getQues1());
        preparedStatement.setString(2, optionalLogin.getQues2());
        preparedStatement.setString(3, optionalLogin.getQues3());
        preparedStatement.setString(4, optionalLogin.getUserName());
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
}
