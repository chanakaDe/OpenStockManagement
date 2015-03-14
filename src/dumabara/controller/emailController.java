/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.Email;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDe
 */
public class emailController {
    public static int addEmail(Email email) throws ClassNotFoundException, SQLException{
        String sql="insert into email values (?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, email.getEmail());
        preparedStatement.setString(2, email.getPassword());
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
    
    public static int updateEmail(Email email) throws ClassNotFoundException, SQLException{
        String sql="update email set email= ? , pwd = ? ";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, email.getEmail());
        preparedStatement.setString(2, email.getPassword());
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
    
    public  static Email getEmailDetails() throws ClassNotFoundException, SQLException{
        String sql = "select * from email";
        Connection conn = DBConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String email = null;
        String pwd = null;
        for (int i = 0; rst.next(); i++) {
            email = rst.getString("email");
            pwd = rst.getString("pwd");
        }

        System.out.println(email + "----" + pwd);
        Email email1 = new Email(email, pwd);
        return email1;
    }
}
