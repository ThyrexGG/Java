package Model;

import Interface.Displayable;
import Interface.Calculatable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order implements Displayable, Calculatable {

    // ── Fields ───────────────────────────────────────────────
    private String              orderId;
    private Customer            customer;
    private Staff               staff;          // assigned only after confirmOrder()
    private ArrayList<OrderItem> orderItems;
    private String              orderDate;
    private String              orderStatus;    // "Pending" → "Confirmed" | "Cancelled"
    private String              paymentStatus;  // "Unpaid"  → "Paid"      | "Failed"

    // ── Static counter ───────────────────────────────────────
    private static int orderCount = 0;

    // ── Constructor ──────────────────────────────────────────
    // Staff is NOT passed here — assigned when confirmOrder(staff) is called
    public Order(String orderId, Customer customer, String orderDate) {
        this.orderId       = cleanText(orderId,    "NO_ORDER_ID");
        this.customer      = customer;
        this.staff         = null;
        this.orderDate     = cleanText(orderDate,  "No Date");
        this.orderItems    = new ArrayList<>();
        this.orderStatus   = "Pending";
        this.paymentStatus = "Unpaid";
        orderCount++;
    }

    // ── Validation helper ────────────────────────────────────
    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) return defaultValue;
        return value.trim();
    }

    // ── Static method ────────────────────────────────────────
    public static int getOrderCount() { return orderCount; }

    // ── Getters ──────────────────────────────────────────────
    public String              getOrderId()       { return orderId; }
    public Customer            getCustomer()      { return customer; }
    public Staff               getStaff()         { return staff; }
    public String              getOrderDate()     { return orderDate; }
    public String              getOrderStatus()   { return orderStatus; }
    public String              getPaymentStatus() { return paymentStatus; }

    public ArrayList<OrderItem> getOrderItemsCopy() {
        return new ArrayList<>(orderItems); // defensive copy
    }

    // ── Status checks ────────────────────────────────────────
    public boolean hasItems()    { return !orderItems.isEmpty(); }
    public boolean isConfirmed() { return "Confirmed".equalsIgnoreCase(orderStatus); }
    public boolean isPaid()      { return "Paid".equalsIgnoreCase(paymentStatus); }

    // ── Add order item (only while Pending) ──────────────────
    public boolean addOrderItem(OrderItem orderItem) {
        if (!"Pending".equalsIgnoreCase(orderStatus)) {
            System.out.println("Cannot add items. Order is already " + orderStatus + ".");
            return false;
        }
        if (orderItem == null || orderItem.getItem() == null) {
            System.out.println("Cannot add invalid order item.");
            return false;
        }

        orderItems.add(orderItem);
        return true;
    }

    // ── Stock check — ALL items must have enough before ANY stock is reduced ──
    private boolean checkAllStockAvailable() {
        if (orderItems.isEmpty()) {
            System.out.println("Order cannot be confirmed without items.");
            return false;
        }

        // Aggregate quantities required for each item across multiple order lines
        Map<String, Integer> requiredQuantities = new HashMap<>();
        for (OrderItem oi : orderItems) {
            String itemId = oi.getItem().getItemId();
            requiredQuantities.put(itemId, requiredQuantities.getOrDefault(itemId, 0) + oi.getQuantity());
        }

        // Check if stock is sufficient for the total aggregated quantities
        for (OrderItem oi : orderItems) {
            String itemId = oi.getItem().getItemId();
            int totalRequired = requiredQuantities.get(itemId);
            if (oi.getItem().getStock() < totalRequired) {
                System.out.println("Order cannot be confirmed: insufficient stock for item " + oi.getItem().getItemName() + " (Required: " + totalRequired + ", Available: " + oi.getItem().getStock() + ").");
                return false;
            }
        }
        return true;
    }

    private boolean reduceAllStock() {
        for (OrderItem oi : orderItems) {
            if (!oi.reduceItemStock()) {
                System.out.println("Stock reduction failed.");
                return false;
            }
        }
        return true;
    }

    // ── Confirm order (called by Staff.processOrder) ─────────
    public boolean confirmOrder(Staff staff) {
        if (!"Pending".equalsIgnoreCase(orderStatus)) {
            System.out.println("Order " + orderId + " is already " + orderStatus + ".");
            return false;
        }
        if (customer == null) {
            System.out.println("Order cannot be confirmed without a customer.");
            return false;
        }
        if (staff == null) {
            System.out.println("Order cannot be confirmed without staff.");
            return false;
        }
        if (!checkAllStockAvailable()) return false;
        if (!reduceAllStock())         return false;

        this.staff       = staff;
        this.orderStatus = "Confirmed";
        return true;
    }

    // ── Mark as paid (order must be confirmed first) ─────────
    public boolean markAsPaid() {
        if (!isConfirmed()) {
            System.out.println("Payment failed. Order must be confirmed first.");
            paymentStatus = "Failed";
            return false;
        }
        if (calculate() <= 0) {
            System.out.println("Payment failed. Order total must be greater than 0.");
            paymentStatus = "Failed";
            return false;
        }
        paymentStatus = "Paid";
        return true;
    }

    // ── Cancel order ─────────────────────────────────────────
    public void cancelOrder() {
        if (isPaid()) {
            System.out.println("Paid order cannot be cancelled.");
            return;
        }
        if ("Cancelled".equalsIgnoreCase(orderStatus)) {
            System.out.println("Order " + orderId + " is already cancelled.");
            return;
        }
        
        // If the order was confirmed, we must restore the inventory stock
        if (isConfirmed()) {
            for (OrderItem oi : orderItems) {
                if (oi.getItem() != null) {
                    oi.getItem().increaseStock(oi.getQuantity());
                }
            }
            System.out.println("Order " + orderId + " cancelled. Stock has been restored.");
        } else {
            System.out.println("Order " + orderId + " has been cancelled.");
        }
        orderStatus = "Cancelled";
    }

    // ── Calculatable interface ────────────────────────────────
    // Sums calculate() from every OrderItem
    @Override
    public double calculate() {
        double total = 0;
        for (OrderItem oi : orderItems) {
            total += oi.calculate();
        }
        return total;
    }

    // ── Displayable ──────────────────────────────────────────
    @Override
    public void displayInfo() {
        System.out.println("====================================================================================================");
        System.out.println("                                            ORDER DETAIL                                            ");
        System.out.println("====================================================================================================");
        System.out.printf( "  Order ID       : %s%n", orderId);
        System.out.printf( "  Date           : %s%n", orderDate);
        System.out.printf( "  Order Status   : %s%n", orderStatus);
        System.out.printf( "  Payment Status : %s%n", paymentStatus);
        System.out.printf( "  Customer       : %s%n", (customer != null ? customer.getName() : "None"));
        System.out.printf( "  Processed By   : %s%n", (staff    != null ? staff.getName()    : "Not assigned yet"));
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("  Items Purchased:");
        if (orderItems.isEmpty()) {
            System.out.println("    No items in this order.");
        } else {
            for (OrderItem oi : orderItems) {
                oi.displayInfo();
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf( "  Total Amount   : $%.2f%n", calculate());
        System.out.println("====================================================================================================");
    }

    //order item overloads, take item just for clothingitem nad assume customer wants 1 of it
    public boolean addOrderItem(ClothingItem item) {
        return addOrderItem(new OrderItem(orderItems.size() + 1, item, 1));
    }

    //same as the above but need to specify what the customer wants
    public boolean addOrderItem(ClothingItem item, int quantity) {
        return addOrderItem(new OrderItem(orderItems.size() + 1, item, quantity));
    }

    //complete shortcut, if jeans are 10% off, pass 10.0 as thrid argument and handles eveything
     public boolean addOrderItem(ClothingItem item, int quantity, double discountPercent) {
        OrderItem oi = new OrderItem(orderItems.size() + 1, item, quantity);
        oi.setDiscountPercent(discountPercent);
        return addOrderItem(oi);
    }

    // calculating the overloads(adds up all items in subtotals, applies to whole order even discounts)
    public double calculate(double orderDiscount) {
        double total = calculate();
        return total - (total * orderDiscount / 100);
    }

    public double calculate(double orderDiscount, double taxRate) {
        double discounted = calculate(orderDiscount);
        return discounted + (discounted * taxRate / 100);
    }
}
