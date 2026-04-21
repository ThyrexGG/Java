package Model;

import java.util.List;

public class Order {
    private String orderID;
    private String orderDate;
    private Customer customer;
    private List<OrderItem> items;
    private double totalPrice;
    private String status;
    private String paymentStatus;
    private String shippingAddress;

    // Constructor
    public Order(String orderID, Customer customer, String orderDate) {
        setOrderID(orderID);
        setCustomer(customer);
        setOrderDate(orderDate);
    }

    public String getOrderID() {
        return orderID;
    }

    private void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    private void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
