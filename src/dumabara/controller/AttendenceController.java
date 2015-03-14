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
import dumbara.model.Attendence;

/**
 *
 * @author chanu1993
 */
public class AttendenceController {
    public static int addInTime(Attendence attendence) throws SQLException, ClassNotFoundException{
        String sql="insert into attendence values(?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1, attendence.getEmpID());
        pStatement.setString(2, attendence.getDate());
        pStatement.setString(3, attendence.getInTime());
        pStatement.setString(4, attendence.getOutTime());
        
        int res=pStatement.executeUpdate();
        return res;
    }
    public static int updateOutTime(String outTime, String empId) throws ClassNotFoundException, SQLException{
        String sql="update attendence set OutTime='"+outTime+"' where EmpID = '"+empId+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
    public static Attendence[] viewAllAttendenceByDate() throws ClassNotFoundException, SQLException{
        String sql="select * from attendence where Date = curdate()";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Attendence[] attendence=new Attendence[count];
        rst.beforeFirst();
        
        for(int i=0;rst.next();i++){
            String empID=rst.getString("EmpID");
            String date=rst.getString("Date");
            String InTime=rst.getString("InTime");
            String OutTime=rst.getString("OutTime");
            Attendence attendence1=new Attendence(empID, date, InTime, OutTime);
            attendence[i]=attendence1;
        }
        return attendence;
    }
    public static Attendence[] viewAllAttendence() throws ClassNotFoundException, SQLException{
        String sql="select * from attendence";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Attendence[] attendence=new Attendence[count];
        rst.beforeFirst();
        
        for(int i=0;rst.next();i++){
            String empID=rst.getString("EmpID");
            String date=rst.getString("Date");
            String InTime=rst.getString("InTime");
            String OutTime=rst.getString("OutTime");
            Attendence attendence1=new Attendence(empID, date, InTime, OutTime);
            attendence[i]=attendence1;
        }
        return attendence;
    }
}
