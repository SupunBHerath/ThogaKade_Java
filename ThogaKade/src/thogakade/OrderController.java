/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author nirot
 */
public class OrderController {

 
 public static boolean addOrder(Order order) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into orders Values(?,?,?)");
        stm.setObject(1, order.oId);
        stm.setObject(2, order.date);
        stm.setObject(3, order.custId);
        return stm.executeUpdate() > 0;
    }
    static String getOrderLastId() throws ClassNotFoundException, SQLException {
        ResultSet resultSet = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT id FROM `orders` ORDER BY id DESC LIMIT 1;");

        if (resultSet.next()) {
            return getNextId(resultSet.getString("id"));
        } else {
            return "D01";
        }
    }

    private static String getNextId(String lastId) {
        if (lastId == null || lastId.isEmpty()) {
            return "D01";
        }

        String numPart = lastId.substring(1);
        int number = Integer.parseInt(numPart);
        System.out.println(number);
        number++;
        return "D" + String.format("%03d", number);
    }

}
