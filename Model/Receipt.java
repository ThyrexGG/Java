package Model;

public class Receipt {

    // ── Fields ───────────────────────────────────────────────
    private String receiptId;
    private Order order; // Composition: Receipt connects to the full Order
    private String paymentMethod;
    private double finalAmount; // calculated from order at receipt creation time

    // ── Static counter ───────────────────────────────────────
    // Counts every receipt ever created during the program run
    private static int receiptCount = 0;

    // ── Constructor ──────────────────────────────────────────
    // Receipt is created FROM a completed Order
    public Receipt(String receiptId, Order order, String paymentMethod) {
        setReceiptId(receiptId);
        setOrder(order);
        setPaymentMethod(paymentMethod);
        // Calculate final amount from order at the moment receipt is created
        this.finalAmount = order.calculateTotal();
        receiptCount++;
    }

    // ── Static method ────────────────────────────────────────
    // receiptCount = total receipts ever created in this program run
    // This is different from a list size — even if removed from list, count stays
    public static int getReceiptCount() {
        return receiptCount;
    }

    // ── Getters ──────────────────────────────────────────────
    public String getReceiptId() {
        return receiptId;
    }

    public Order getOrder() {
        return order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    // Convenience getters — read directly from the connected Order
    public String getCustomerName() {
        return order.getCustomer().getName();
    }

    public String getStaffName() {
        return order.getStaff().getName();
    }

    public String getOrderID() {
        return order.getOrderID();
    }

    // ── Setters ──────────────────────────────────────────────
    public void setReceiptId(String receiptId) {
        if (receiptId != null && !receiptId.trim().isEmpty()) {
            this.receiptId = receiptId;
        } else {
            System.out.println("Receipt ID cannot be empty");
        }
    }

    private void setOrder(Order order) {
        if (order == null) {
            System.out.println("Order cannot be null");
        } else {
            this.order = order;
        }
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod != null && !paymentMethod.trim().isEmpty()) {
            this.paymentMethod = paymentMethod;
        } else {
            System.out.println("Payment method cannot be empty");
        }
    }
}
