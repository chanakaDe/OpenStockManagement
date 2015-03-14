/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.LoanOptionsM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ChanakaDe
 */
public class LoanOptionController {
    public static int addLoanOption(ArrayList<LoanOptionsM> arrayList) throws ClassNotFoundException, SQLException{
        int executeUpdate=0;
        for (LoanOptionsM loanOptionsM : arrayList) {
        String sql="insert into interestrate values(?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setDouble(1, loanOptionsM.getLowest());
        pStatement.setDouble(2, loanOptionsM.getHighest());
        pStatement.setDouble(3, loanOptionsM.getRate());
        pStatement.setString(4, loanOptionsM.getRateID());
        executeUpdate = pStatement.executeUpdate();
        }
        return executeUpdate;
    }
    
    public static LoanOptionsM[] viewLoanOption() throws ClassNotFoundException, SQLException{
        String sql="select * from interestrate";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        LoanOptionsM loanOptionsM[] =new LoanOptionsM[count];
        rst.beforeFirst();
         for (int i = 0;rst.next(); i++) {
            String id=rst.getString("RateID");
            double lowest=rst.getDouble("Lowest");
            double highest=rst.getDouble("Highest");
            double rate=rst.getDouble("Rate");
            
            LoanOptionsM loanOptionsM1=new LoanOptionsM(id, lowest, highest, rate);
            loanOptionsM[i]=loanOptionsM1;
        }
         return loanOptionsM;
    }
    public static int updateLoanOption(ArrayList<LoanOptionsM> arrayList) throws ClassNotFoundException, SQLException{
        int res=0;
        for (LoanOptionsM loanOptionsM : arrayList) {
            String sql="update interestrate set Lowest='"+loanOptionsM.getLowest()+"', Highest='"+loanOptionsM.getHighest()+"',Rate='"+loanOptionsM.getRate()+"' where RateID='"+loanOptionsM.getRateID()+"' ";
            Connection conn=DBConnection.getInstance().getConnection();
            Statement stm=conn.createStatement();
            res=stm.executeUpdate(sql);     
        }
        return res;
    }
}
