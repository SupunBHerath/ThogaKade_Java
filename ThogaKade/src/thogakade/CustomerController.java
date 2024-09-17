/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nirot
 */
public class CustomerController {

    public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into Customer Values(?,?,?,?)");
        stm.setObject(1, customer.getId());
        stm.setObject(2, customer.getName());
        stm.setObject(3, customer.getAddress());
        stm.setObject(4, customer.getSalary());
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<String> getCustomerId() throws ClassNotFoundException, SQLException {
        ArrayList<String> custId = new ArrayList<>();
        ResultSet resultSet = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM customer");
        while (resultSet.next()) {
            custId.add(resultSet.getString("id"));
        }
        return custId;
    }

    public static Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Customer where id='" + id + "'");
        return rst.next() ? new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary")) : null;
    }

    public static boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete  From Customer where id='" + id + "'") > 0;
    }

}
