package Model;

public class Receipt {
    private String receiptId;
    private Order order;
    private Customer customer;
    private Staff cashier;
    private String date;
    private double totalAmount;
    private double taxAmount;
    private double discountAmount;
    private String paymentMethod;

    // Getter
    public String getReceiptId() {
        return receiptId;
    }

    public Order getOrder() {
        return order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Staff getCashier() {
        return cashier;
    }

    public String getDate() {
        return date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setter
    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCashier(Staff cashier) {
        this.cashier = cashier;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
