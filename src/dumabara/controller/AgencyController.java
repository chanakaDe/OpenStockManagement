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
import dumbara.model.Agency;

/**
 *
 * @author chanu1993
 */
public class AgencyController {

    public static int addAgency(Agency agency) throws ClassNotFoundException, SQLException {
        String sql="insert into agency values(?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, agency.getAgencyID());
        preparedStatement.setString(2, agency.getAgencyName());
        preparedStatement.setString(3, agency.getAddress());
        preparedStatement.setString(4, agency.getContactNo());
        preparedStatement.setString(5, agency.getOwnerName());
        preparedStatement.setString(6, agency.getOwnerNo());
        int res=preparedStatement.executeUpdate();
        return res;
    }
    
    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql="select AgencyID from agency order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    
    public static Agency[] viewAllAgency() throws ClassNotFoundException, SQLException{
        String sql="select * from agency";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Agency[] agencys=new Agency[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String agencyID=rst.getString("AgencyID");
            String agencyName=rst.getString("AgencyName");
            String address=rst.getString("Address");
            String contactNo=rst.getString("ContactNo");
            String ownerName=rst.getString("OwnerName");
            String ownerNo=rst.getString("OwnerNo");
            
            Agency agency=new Agency(agencyID, agencyName, address, contactNo, ownerName, ownerNo);
            agencys[i]=agency;
        }
        return agencys;
    }
    
    public static Agency viewAllAgencybyID(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from agency where AgencyID='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);

        Agency agencys=new Agency();
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String agencyID=rst.getString("AgencyID");
            String agencyName=rst.getString("AgencyName");
            String address=rst.getString("Address");
            String contactNo=rst.getString("ContactNo");
            String ownerName=rst.getString("OwnerName");
            String ownerNo=rst.getString("OwnerNo");
            
             agencys=new Agency(agencyID, agencyName, address, contactNo, ownerName, ownerNo);
            
        }
        return agencys;
    }
    
   public static String[] getAgencyID() throws SQLException, ClassNotFoundException{
       String sql="select agencyid from sales group by agencyid";
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
           String id=rst.getString("AgencyID");
           strings[i]=id;
       }
       return strings;
   }
    
  
}
