package dumabara.controller;

import dumbara.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import dumbara.model.Customer;


public class CustomerController {
    
    public static int addCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        String sql="insert into customer values(?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement prepareStatement = conn.prepareStatement(sql);
        prepareStatement.setString(1, customer.getCustID());
        prepareStatement.setString(2, customer.getName());
        prepareStatement.setString(3, customer.getAddress());
        prepareStatement.setString(4, customer.getContactNo());
        prepareStatement.setString(5, customer.getNic());
        int res=prepareStatement.executeUpdate();
        return res;
    }

    public static String getLastId() throws ClassNotFoundException, SQLException {
        String sql="select custID from customer order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    public static Customer[] viewCustomer() throws ClassNotFoundException, SQLException{
        String sql="select * from customer";;
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count = 0;
        while(rst.next()){
            count++;
        }
        Customer[] customerList=new Customer[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            String custID=rst.getString("CustID");
            String name=rst.getString("Name");
            String address=rst.getString("Address");
            String telNo=rst.getString("Telno");
            String nic=rst.getString("NIC");
            
            Customer customer=new Customer(custID, name, address, telNo, nic);
            
            customerList[i]=customer;
        }
        return customerList;
    }
    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from customer where custid='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        Customer customer=null;
        if(rst.next()){
            String custID=rst.getString("CustID");
            String name=rst.getString("Name");
            String address=rst.getString("Address");
            String telNo=rst.getString("Telno");
            String nic=rst.getString("NIC");
            
            customer=new Customer(custID, name, address, telNo, nic);
        }
        return customer;
    }
    public static int updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        String sql="update customer set Name='"+customer.getName()+"',Address='"+customer.getAddress()+"',Telno='"+customer.getContactNo()+"',NIC='"+customer.getNic()+"'where CustID='"+customer.getCustID()+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        int res=stm.executeUpdate(sql);
        return res;
    }
    public static int deleteCustomer(String id) throws ClassNotFoundException, SQLException{
        String sql="delete from customer where CustID=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int res=preparedStatement.executeUpdate();
        return res;
    }
}
