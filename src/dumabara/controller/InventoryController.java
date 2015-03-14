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
import dumbara.model.Inventory;

/**
 *
 * @author chanu1993
 */
public class InventoryController {
    public static int addInventory(Inventory inventory) throws ClassNotFoundException, SQLException{
        String sql="insert into inventory values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement pStatement=conn.prepareStatement(sql);
        pStatement.setString(1,inventory.getItemCode());
        pStatement.setString(2, inventory.getItemName());
        pStatement.setString(3,inventory.getDesc() );
        pStatement.setString(4, inventory.getBrandName());
        pStatement.setString(5, inventory.getPrice());
        pStatement.setString(6, inventory.getSupplierName());
        pStatement.setString(7, inventory.getSupplierAddress());
        pStatement.setString(8, inventory.getSupplierContactNo());
        pStatement.setString(9, inventory.getPucharsedDate());
        pStatement.setString(10,inventory.getWarrantyPeriod() );
        pStatement.setString(11, inventory.getWarrantyEndDate());
        int res=pStatement.executeUpdate();
        return res;
        
    }
    public static String getLastID() throws ClassNotFoundException, SQLException{
        String sql="select ItemCode from inventory order by 1 desc limit 1";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
    public static Inventory searchInventory(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from inventory where ItemCode='"+id+"'";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        Inventory inventory=null;
        if (rst.next()) {
            String itemCode=id;
            String itemName=rst.getString("ItemName");
            String itemDesc=rst.getString("ItemDesc");
            String brandName=rst.getString("BrandName");
            String price=rst.getString("Price");
            String supplierName=rst.getString("SupplierName");
            String supplierAddress=rst.getString("SupplierAddress");
            String supplierContactNo=rst.getString("SupplierContactNo");
            String purchasedDate=rst.getString("PurchasedDate");
            String warrantyPeriod=rst.getString("WarrantyPeriod");
            String warrantyEndDate=rst.getString("WarrantyEndDate");
            
             inventory=new Inventory(itemCode, itemName,itemDesc, brandName, price, supplierName, supplierAddress, supplierContactNo, purchasedDate, warrantyPeriod, warrantyEndDate);
        }
        return inventory;
    }
    public static Inventory[] viewInventory() throws ClassNotFoundException, SQLException{
        String sql="select * from inventory";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Inventory[] inventorys=new Inventory[count];
        rst.beforeFirst();
        for (int i = 0;  rst.next(); i++) {
            String itemCode=rst.getString("ItemCode");
            String itemName=rst.getString("ItemName");
            String itemDesc=rst.getString("ItemDesc");
            String brandName=rst.getString("BrandName");
            String price=rst.getString("Price");
            String supplierName=rst.getString("SupplierName");
            String supplierAddress=rst.getString("SupplierAddress");
            String supplierContactNo=rst.getString("SupplierContactNo");
            String purchasedDate=rst.getString("PurchasedDate");
            String warrantyPeriod=rst.getString("WarrantyPeriod");
            String warrantyEndDate=rst.getString("WarrantyEndDate");
            
            Inventory inventory=new Inventory(itemCode, itemName,itemDesc, brandName, price, supplierName, supplierAddress, supplierContactNo, purchasedDate, warrantyPeriod, warrantyEndDate);
            inventorys[i]=inventory;
            System.out.println(itemCode+" "+itemName);
        }
           return inventorys;
    }
    
    public static Inventory[] viewInventorybyID(String id) throws ClassNotFoundException, SQLException{
        String sql="select * from inventory where ItemCode='"+id+"' ";
        Connection conn=DBConnection.getInstance().getConnection();
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        int count=0;
        while(rst.next()){
            count++;
        }
        Inventory[] inventorys=new Inventory[count];
        rst.beforeFirst();
        for (int i = 0;  rst.next(); i++) {
            String itemCode=rst.getString("ItemCode");
            String itemName=rst.getString("ItemName");
            String itemDesc=rst.getString("ItemDesc");
            String brandName=rst.getString("BrandName");
            String price=rst.getString("Price");
            String supplierName=rst.getString("SupplierName");
            String supplierAddress=rst.getString("SupplierAddress");
            String supplierContactNo=rst.getString("SupplierContactNo");
            String purchasedDate=rst.getString("PurchasedDate");
            String warrantyPeriod=rst.getString("WarrantyPeriod");
            String warrantyEndDate=rst.getString("WarrantyEndDate");
            
            Inventory inventory=new Inventory(itemCode, itemName,itemDesc, brandName, price, supplierName, supplierAddress, supplierContactNo, purchasedDate, warrantyPeriod, warrantyEndDate);
            inventorys[i]=inventory;
            System.out.println(itemCode+" "+itemName);
        }
           return inventorys;
    }
    public static int deleteInventory(String id) throws ClassNotFoundException, SQLException{
        String sql="delete from inventory where ItemCode=?";
        Connection conn=DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=conn.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int res=preparedStatement.executeUpdate();
        return res;
    }
}
