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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import dumbara.model.LoanSettle;

/**
 *
 * @author chanu1993
 */
public class LoanSettleController {
    public static int addLoanSettle(LoanSettle loanSettle) throws ClassNotFoundException, SQLException{
        
        String time=new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
        String sql="insert into loanSettle values(?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, loanSettle.getLoanSettleID());
        pStatement.setString(3, loanSettle.getLoanID());
        pStatement.setString(4, loanSettle.getLoanAmount());
        pStatement.setString(2, loanSettle.getPayment());
        pStatement.setString(5, loanSettle.getDuePayment());
        pStatement.setString(6, time);
        int res=pStatement.executeUpdate();
        return res;
    }
    public static String getLastID() throws SQLException, ClassNotFoundException{
        String sql="select LoanSettleID from loanSettle order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("LoanSettleID");
        }
        return null;
    }
    public static String getLastSettleAmount (String id) throws ClassNotFoundException, SQLException{
        String sql="select DuePayment from loanSettle where loanID='"+id+"' order by LoanSettleID desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("DuePayment");
        }
        return null;
    }
    public static LoanSettle[] viewLoanSettle() throws ClassNotFoundException, SQLException{
        String sql="select * from loanSettle";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        LoanSettle loanSettleList[]=new LoanSettle[count];
        rst.beforeFirst();
        for(int i=0;rst.next();i++){
            String loanSettleID=rst.getString("LoanSettleID");
            String loanID=rst.getString("LoanID");
            String payment=rst.getString("Payment");
            String loanAmount=rst.getString("LoanAmount");
            String duePayment=rst.getString("DuePayment");
            String paymentDate=rst.getString("PaymentDate");
            
            LoanSettle ls=new LoanSettle(loanSettleID, loanID, loanAmount, payment, duePayment,paymentDate);
            loanSettleList[i]=ls;
        }
        return loanSettleList;
    }
    
    public static LoanSettle[] viewLoanSettlebyEmp(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from loanSettle where LoanID='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        LoanSettle loanSettleList[]=new LoanSettle[count];
        rst.beforeFirst();
        for(int i=0;rst.next();i++){
            String loanSettleID=rst.getString("LoanSettleID");
            String loanID=rst.getString("LoanID");
            String payment=rst.getString("Payment");
            String loanAmount=rst.getString("LoanAmount");
            String duePayment=rst.getString("DuePayment");
            String paymentDate=rst.getString("PaymentDate");
            
            LoanSettle ls=new LoanSettle(loanSettleID, loanID, loanAmount, payment, duePayment,paymentDate);
            loanSettleList[i]=ls;
        }
        return loanSettleList;
    }
    
}
