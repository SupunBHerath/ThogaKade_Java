/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade;

/**
 *
 * @author supun
 */
public class Order {
    String oId;
    String date;
    String custId;

    public Order(String oId, String date, String custId) {
        this.oId = oId;
        this.date = date;
        this.custId = custId;
    }

    public String getoId() {
        return oId;
    }

    public String getDate() {
        return date;
    }

    public String getCustId() {
        return custId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    
}
