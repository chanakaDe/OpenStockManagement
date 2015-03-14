/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.Loan;
import dumbara.model.Chart1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author chanu1993
 */
public class LoanController {
    public static int addLoan(Loan loan) throws ClassNotFoundException, SQLException{
        String sql="insert into loan values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement =conn.prepareStatement(sql);
        pStatement.setString(2,loan.getEmpID());
        pStatement.setString(1,loan.getLoanID());
        pStatement.setString(3,loan.getLongAmount());
        pStatement.setString(4,loan.getLoanTerm());
        pStatement.setString(5,loan.getInterestRate());
        pStatement.setString(6,loan.getMonthlyPayment());
        pStatement.setString(7,"Full Amount");
        int res=pStatement.executeUpdate();
        return res;
    }
    public static String getLastID() throws ClassNotFoundException, SQLException{
        String sql="select LoanID from loan order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString("LoanID");
        }
        return null;
    }
    public static Loan[] viewLoan() throws ClassNotFoundException, SQLException{
        String sql="select * from loan";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Loan [] loanList=new Loan[count];
        rst.beforeFirst();
        for(int i=0;rst.next();i++){
            String empID=rst.getString("empID");
            String loanID=rst.getString("loanID");
            String longAmount=rst.getString("loanAmount");
            String loanTerm=rst.getString("loanTerm");
            String interestRate=rst.getString("interestRate");
            String monthlyPayment=rst.getString("monthlyPayment");
            String duePayment=rst.getString("duePayment");
            
            Loan loan=new Loan(empID, loanID, longAmount, loanTerm, interestRate, monthlyPayment,duePayment);
            loanList[i]=loan;
        }
        return loanList;
    }
    public static String getLoanAmount(String loanId) throws ClassNotFoundException, SQLException{
        String sql = "select LoanAmount from loan where loanId = '"+loanId+"' ";
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery(sql); 
        rst.next();
        return rst.getString(1);
        
    }
    public static int deleteLoan(String id) throws ClassNotFoundException, SQLException{
        String sql="delete from loan where LoanID='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
    public  static Chart1[] getLoanAmounts() throws ClassNotFoundException, SQLException{
        String sql="select EmpID , sum(LoanAmount) from loan group by empID";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Chart1[] charts=new Chart1[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String empID=rst.getString("EmpID");
            double loanamount=rst.getDouble("sum(LoanAmount)");
            
            Chart1 chart1 = new Chart1(empID, loanamount);
            charts[i]=chart1;
        }
        return charts;
    }
    
    public static Loan[] viewLoanbyID(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from loan where empid='"+id+"' ";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Loan [] loanList=new Loan[count];
        rst.beforeFirst();
        for(int i=0;rst.next();i++){
            String empID=rst.getString("empID");
            String loanID=rst.getString("loanID");
            String longAmount=rst.getString("loanAmount");
            String loanTerm=rst.getString("loanTerm");
            String interestRate=rst.getString("interestRate");
            String monthlyPayment=rst.getString("monthlyPayment");
            String duePayment=rst.getString("duePayment");
            
            Loan loan=new Loan(empID, loanID, longAmount, loanTerm, interestRate, monthlyPayment,duePayment);
            loanList[i]=loan;
        }
        return loanList;
    }
}
