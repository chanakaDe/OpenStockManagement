/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dumabara.controller;

import dumbara.db.DBConnection;
import dumbara.model.LoanOptionSetCount;
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
public class LoanOptionSetcountController {

    public static int addLoanOptionSetCount(ArrayList<LoanOptionSetCount> arrayList) throws ClassNotFoundException, SQLException {
        int executeUpdate = 0;
        for (LoanOptionSetCount loanOptionsM : arrayList) {
            String sql = "insert into loanCount values(?,?,?,?)";
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setString(1, loanOptionsM.getSlaryId());
            pStatement.setDouble(2, loanOptionsM.getLowest());
            pStatement.setDouble(3, loanOptionsM.getHighest());
            pStatement.setDouble(4, loanOptionsM.getCount());
            executeUpdate = pStatement.executeUpdate();
        }
        return executeUpdate;
    }

    public static int updateLoanOption(ArrayList<LoanOptionSetCount> arrayList) throws ClassNotFoundException, SQLException {
        int res = 0;
        for (LoanOptionSetCount loanOptionsM : arrayList) {
            String sql = "update loanCount set lowest=? , highest = ? , count = ? where slaryId = ? ";
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement pStatement = conn.prepareStatement(sql);
            pStatement.setDouble(1, loanOptionsM.getLowest());
            pStatement.setDouble(2, loanOptionsM.getHighest());
            pStatement.setDouble(3, loanOptionsM.getCount());
            pStatement.setString(4, loanOptionsM.getSlaryId());
            res = pStatement.executeUpdate();
        }
        return res;
    }
    public static LoanOptionSetCount[] viewLoanOptionSetCounts() throws ClassNotFoundException, SQLException{
        String sql="select * from loanCount";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        LoanOptionSetCount loanOptionsM[] =new LoanOptionSetCount[count];
        rst.beforeFirst();
         for (int i = 0;rst.next(); i++) {
            String id=rst.getString("slaryId");
            double lowest=rst.getDouble("Lowest");
            double highest=rst.getDouble("Highest");
            double rate=rst.getDouble("Count");
            
            LoanOptionSetCount loanOptionsM1=new LoanOptionSetCount(id, lowest, highest, rate);
            loanOptionsM[i]=loanOptionsM1;
        }
         return loanOptionsM;
    }
}
