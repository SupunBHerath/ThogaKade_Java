/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thogakade;

/**
 *
 * @author supun
 */
public class OrderDetail {

    private String orderId;
    private double itemCode;
    private String qty;
    private String unitPrice;

    public OrderDetail(String orderId, double itemCode, String qty, String unitPrice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getItemCode() {
        return itemCode;
    }

    public String getQty() {
        return qty;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItemCode(double itemCode) {
        this.itemCode = itemCode;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

   
}
