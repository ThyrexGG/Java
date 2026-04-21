package Model;

public class Receipt {
    private String receiptId;
    private String customerName;
    private String date;
    private double totalAmount;
    private String paymentMethod;

    // Constructor
    public Receipt(String receiptId, String customerName, String date, double totalAmount, String paymentMethod) {
        setReceiptId(receiptId);
        setCustomerName(customerName);
        setDate(date);
        setTotalAmount(totalAmount);
        setPaymentMethod(paymentMethod);
    }

    // Helper method for string validation
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    // Getters
    public String getReceiptId() {
        return receiptId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setters with validation
    public void setReceiptId(String receiptId) {
        validateString(receiptId, "Receipt ID");
        this.receiptId = receiptId;
    }

    public void setCustomerName(String customerName) {
        validateString(customerName, "Customer name");
        this.customerName = customerName;
    }

    public void setDate(String date) {
        validateString(date, "Date");
        this.date = date;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount < 0) {
            throw new IllegalArgumentException("Total amount cannot be negative");
        }
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        validateString(paymentMethod, "Payment method");
        this.paymentMethod = paymentMethod;
    }
}
