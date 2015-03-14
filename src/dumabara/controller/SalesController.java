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
import dumbara.model.Chart;
import dumbara.model.Chart3;
import dumbara.model.Chart4;
import dumbara.model.Sale;
import java.util.ArrayList;

/**
 *
 * @author chanu1993
 */
public class SalesController {

    public static int addSales(Sale sale) throws ClassNotFoundException, SQLException {
        String sql = "insert into sales values(?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getInstance().getConnection();
        PreparedStatement pStatement = conn.prepareStatement(sql);
        pStatement.setString(1, sale.getSalesID());
        pStatement.setString(2, sale.getSalesDate());
        pStatement.setString(3, sale.getAgencyID());
        pStatement.setString(4, sale.getBottleID());
        pStatement.setString(5, sale.getBottleVolume());
        pStatement.setInt(6, sale.getSaledQty());
        pStatement.setDouble(7, sale.getIncome());
        int res = pStatement.executeUpdate();
        return res;
    }

    public static String getLastID() throws ClassNotFoundException, SQLException {
        String sql = "select salesID from sales order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }else{
            return null;
        }
    }
    public static Sale[] viewAllSales() throws ClassNotFoundException, SQLException{
        String sql="select * from sales order by 1 desc limit 13";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Sale[] sales=new Sale[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String salesID=rst.getString("SalesID");
            String salesDate=rst.getString("SalesDate");
            String agencyID=rst.getString("AgencyID");
            String bottleID=rst.getString("BottleID");
            String bottleVolume=rst.getString("BottleVolume");
            int qty=rst.getInt("SaledQty");
            double income=rst.getDouble("Income");
            
            Sale sale=new Sale(salesID, salesDate, agencyID, bottleID, bottleVolume, qty, income);
            sales[i]=sale;
        }
        return sales;
    }
    public static int deleteSales(String id) throws ClassNotFoundException, SQLException{
        String sql="delete from sales where SalesID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int res=preparedStatement.executeUpdate();
        return res;
    }
    public static Chart[] getAgencyAmounts() throws ClassNotFoundException, SQLException{
        String sql="select AgencyID,sum(Income) from sales group by AgencyID";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Chart[] charts=new Chart[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String agencyID=rst.getString("AgencyID");
            double incomeSum=rst.getDouble("sum(Income)");
            
            Chart chart=new Chart(agencyID, incomeSum);
            charts[i]=chart;
        }
        return charts;
    }
    
    public static Chart3[] getBottleIncome() throws ClassNotFoundException, SQLException{
        String sql="select BottleID,sum(Income) from sales group by BottleID";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Chart3[] charts=new Chart3[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String bottleID=rst.getString("BottleID");
            double incomeSum=rst.getDouble("sum(Income)");
            
            Chart3 chart3=new Chart3(bottleID, incomeSum);
            charts[i]=chart3;
        }
        return charts;
    }
    
    public static Chart4[] getIncomeByDate() throws ClassNotFoundException, SQLException{
        String sql="select salesdate,sum(income) from sales group by salesdate limit 10";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Chart4[] charts=new Chart4[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String salesDate=rst.getString("salesDate");
            double incomeSum=rst.getDouble("sum(Income)");
            
            Chart4 chart4=new Chart4(salesDate, incomeSum);
            charts[i]=chart4;
        }
        return charts;
    }
    
    public static String[] getSalesDate(String id) throws SQLException, ClassNotFoundException{
       String sql="select salesDate from sales where agencyid='"+id+"' ";
       Connection conn=DBConnection.getInstance().getConnection();
       Statement stm=conn.createStatement();
       ResultSet rst=stm.executeQuery(sql);
       int count=0;
       while(rst.next()){
           count++;
       }
       String[] strings=new String[count];
       rst.beforeFirst();
       for (int i = 0; rst.next(); i++) {
           String salesDate=rst.getString("salesDate");
           strings[i]=salesDate;
       }
       return strings;
   }
    
    public static String[] getIncome(String id) throws SQLException, ClassNotFoundException{
       String sql="select income from sales where agencyid='"+id+"'";
       Connection conn=DBConnection.getInstance().getConnection();
       Statement stm=conn.createStatement();
       ResultSet rst=stm.executeQuery(sql);
       int count=0;
       while(rst.next()){
           count++;
       }
       String[] strings=new String[count];
       rst.beforeFirst();
       
       for (int i = 0; rst.next(); i++) {
           String income=rst.getString("income");
           strings[i]=income;
       }
       return strings;
   }
}
