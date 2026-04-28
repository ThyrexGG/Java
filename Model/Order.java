package Model;

import java.util.ArrayList;

public class Order {
    private String orderID;
    private String orderDate;
    private Customer customer;
    private ArrayList<OrderItem> items;
    private double totalPrice;
    private String status;
    private String paymentStatus;
    private String shippingAddress;

    public Order(String orderID, Customer customer, String orderDate) {
        setOrderID(orderID);
        setCustomer(customer);
        setOrderDate(orderDate);
        setItems(new ArrayList<>());
        setTotalPrice(0.0);
    }

    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be null or empty");
        }
    }

    public String getOrderID() {
        return orderID;
    }

    private void setOrderID(String orderID) {
        validateString(orderID, "Order ID");
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    private void setOrderDate(String orderDate) {
        validateString(orderDate, "Order Date");
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        if (customer == null)
            System.out.println("Customer cannot be null");
        this.customer = customer;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    private void setItems(ArrayList<OrderItem> items) {
        if (items == null)
            System.out.println("Items list cannot be null");
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        if (totalPrice < 0)
            System.out.println("Total price cannot be negative");
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        validateString(status, "Status");
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        validateString(paymentStatus, "Payment Status");
        this.paymentStatus = paymentStatus;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        validateString(shippingAddress, "Shipping Address");
        this.shippingAddress = shippingAddress;
    }
}