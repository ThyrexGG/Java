package Model;

import java.util.ArrayList;

public class Order {

    // ── Fields ───────────────────────────────────────────────
    private String orderID;
    private String orderDate;
    private Customer customer; // Association: Order knows its Customer
    private Staff staff; // Association: Order knows which Staff processed it
    private ArrayList<OrderItem> items; // Composition: Order is made of OrderItems
    private String status;
    private String paymentStatus;

    // ── Static counter ───────────────────────────────────────
    private static int orderCount = 0;

    // ── Constructor ──────────────────────────────────────────
    // Order now requires both Customer and Staff — shows full association
    public Order(String orderID, Customer customer, Staff staff, String orderDate) {
        setOrderID(orderID);
        setCustomer(customer);
        setStaff(staff);
        setOrderDate(orderDate);
        this.items = new ArrayList<>();
        orderCount++;
    }

    // ── Validation helper ────────────────────────────────────
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println("Error: " + fieldName + " cannot be null or empty");
        }
    }

    // ── Static method ────────────────────────────────────────
    public static int getOrderCount() {
        return orderCount;
    }

    // ── Add item to order ────────────────────────────────────
    public void addItem(OrderItem item) {
        if (item != null) {
            items.add(item);
        } else {
            System.out.println("Cannot add null item to order");
        }
    }

    // ── Calculate total ──────────────────────────────────────
    // Always loops through items for accurate total
    // This is safer than storing totalPrice because discounts may change
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculateSubtotal();
        }
        return total;
    }

    // ── Confirm order and reduce stock ───────────────────────
    // Stock should only be reduced AFTER order is confirmed
    public void confirmOrder() {
        this.status = "Confirmed";
        for (OrderItem oi : items) {
            oi.getItem().reduceStock(oi.getQuantity());
        }
        System.out.println("Order " + orderID + " confirmed. Stock updated.");
    }

    // ── Getters ──────────────────────────────────────────────
    public String getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    // ── Setters ──────────────────────────────────────────────
    private void setOrderID(String orderID) {
        validateString(orderID, "Order ID");
        this.orderID = orderID;
    }

    private void setOrderDate(String orderDate) {
        validateString(orderDate, "Order Date");
        this.orderDate = orderDate;
    }

    private void setCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Error: Customer cannot be null");
        } else {
            this.customer = customer;
        }
    }

    private void setStaff(Staff staff) {
        if (staff == null) {
            System.out.println("Error: Staff cannot be null");
        } else {
            this.staff = staff;
        }
    }

    public void setStatus(String status) {
        validateString(status, "Status");
        this.status = status;
    }

    public void setPaymentStatus(String paymentStatus) {
        validateString(paymentStatus, "Payment Status");
        this.paymentStatus = paymentStatus;
    }
}
