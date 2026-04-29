package Model;

public class Customer {

    // ── Fields ───────────────────────────────────────────────
    private String customerId;
    private String name;
    private String phone;
    private String membershipLevel;
    private int loyaltyPoints;

    // ── Static counter ───────────────────────────────────────
    private static int customerCount = 0;

    // ── Constructor ──────────────────────────────────────────
    public Customer(String customerId, String name) {
        setCustomerId(customerId);
        setName(name);
        setMembershipLevel("Bronze");
        customerCount++;
    }

    // ── Validation helper ────────────────────────────────────
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be null or empty");
        }
    }

    // ── Static method ────────────────────────────────────────
    public static int getCustomerCount() {
        return customerCount;
    }

    // ── Getters ──────────────────────────────────────────────
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // ── Setters ──────────────────────────────────────────────
    private void setCustomerId(String customerId) {
        validateString(customerId, "Customer ID");
        this.customerId = customerId;
    }

    public void setName(String name) {
        validateString(name, "Name");
        this.name = name;
    }

    public void setPhone(String phone) {
        validateString(phone, "Phone");
        this.phone = phone;
    }

    private void setMembershipLevel(String membershipLevel) {
        validateString(membershipLevel, "Membership Level");
        this.membershipLevel = membershipLevel;
    }

    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            System.out.println("Points cannot be negative");
        } else {
            this.loyaltyPoints += points;
        }
    }
}
