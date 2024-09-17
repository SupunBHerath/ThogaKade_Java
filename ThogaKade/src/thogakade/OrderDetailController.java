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
public class OrderDetailController {

    public static boolean addOrderDetail(OrderDetail order) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into orderdetail Values(?,?,?,?)");
        stm.setObject(1, order.getOrderId());
        stm.setObject(2, order.getItemCode());
        stm.setObject(3, order.getQty());
        stm.setObject(4, order.getUnitPrice());
        return stm.executeUpdate() > 0;
    }
    public static OrderDetail searchOrder(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    public static String[] getOrderId() throws ClassNotFoundException, SQLException {
        ArrayList<String> orderIds = new ArrayList<>();
        ResultSet resultSet = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT orderId FROM Orderdetail");
        while (resultSet.next()) {
            orderIds.add(resultSet.getString("orderId"));
        }
        System.out.println(orderIds.toString());
        return orderIds.toArray(new String[0]);
    }

    public static boolean deleteOrder(String orderId) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete  From orderdetail where id='" + orderId + "'") > 0;
    }

}
