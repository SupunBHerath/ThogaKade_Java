/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author nirot
 */
public class ItemController {

//public static boolean addItem(Customer customer) throws ClassNotFoundException, SQLException {
//        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into Customer Values(?,?,?,?)");
//        stm.setObject(1, customer.getId());
//        stm.setObject(2, customer.getName());
//        stm.setObject(3, customer.getAddress());
//        stm.setObject(4, customer.getSalary());
//        return stm.executeUpdate() > 0;
//    }

    public static ArrayList<String> getItemId() throws ClassNotFoundException, SQLException {
        ArrayList<String> custId = new ArrayList<>();
        ResultSet resultSet = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT code FROM item");
        while (resultSet.next()) {
            custId.add(resultSet.getString("code"));
        }
        return custId;
    }

    public static Item searchitem(String code) throws ClassNotFoundException, SQLException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From item where code='" + code + "'");
        return rst.next() ? new Item(rst.getString("code"), rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand")) : null;
    }

    public static boolean deleteCustomer(String code) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete  From item where code='" + code + "'") > 0;
    }
}
