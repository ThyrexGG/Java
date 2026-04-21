package Model;

public class Receipt {
    private String receiptId;
    private String customerName;
    private double totalAmount;
    private String paymentMethod;

    // Constructor
    public Receipt(String receiptId, String customerName, double totalAmount, String paymentMethod) {
        setReceiptId(receiptId);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        setPaymentMethod(paymentMethod);
    }

    // Helper method for string validation
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be null or empty");
        }
    }

    // Getters
    public String getReceiptId() {
        return receiptId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    private void setReceiptId(String receiptId) {
        validateString(receiptId, "Receipt ID");
        this.receiptId = receiptId;
    }

    private void setCustomerName(String customerName) {
        validateString(customerName, "Customer name");
        this.customerName = customerName;
    }

    private void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            System.out.println("Total amount cannot be negative");
        }
        this.totalAmount = totalAmount;
    }

    private void setPaymentMethod(String paymentMethod) {
        validateString(paymentMethod, "Payment method");
        this.paymentMethod = paymentMethod;
    }
}