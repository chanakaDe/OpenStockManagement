/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.EmailForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ChanakaDe
 */
public class EmailFormController {
    public static int addDraft(EmailForm emailForm) throws ClassNotFoundException, SQLException {
        String sql="insert into emailDraft values(?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, emailForm.getToMail());
        preparedStatement.setString(2, emailForm.getSubject());
        preparedStatement.setString(3, emailForm.getMsg());
        preparedStatement.setInt(4, 1);
        int res=preparedStatement.executeUpdate();
        return res;
    }
    public static int updateDraft(EmailForm emailForm) throws ClassNotFoundException, SQLException {
        String sql="update emailDraft set toMail = ? , subject = ? , msg = ? ";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, emailForm.getToMail());
        preparedStatement.setString(2, emailForm.getSubject());
        preparedStatement.setString(3, emailForm.getMsg());
        int res=preparedStatement.executeUpdate();
        return res;
    }
    public static EmailForm getDraft() throws ClassNotFoundException, SQLException{
        EmailForm emailForm=null;
        String sql="select * from emailDraft";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        for (int i = 0; rst.next(); i++) {
            String tomail=rst.getString("toMail");
            String subject=rst.getString("subject");
            String msg=rst.getString("msg");
            emailForm=new EmailForm(tomail, subject, msg);
        }
        return emailForm;
    }
    public static int deleteDarft() throws ClassNotFoundException, SQLException {
        String sql="delete from emaildraft";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int executeUpdate = stm.executeUpdate(sql);
        return executeUpdate;
    }
}
