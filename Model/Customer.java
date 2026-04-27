package Model;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String membershipLevel;
    private int loyaltyPoints;

    public Customer(String customerId, String name) {
        setCustomerId(customerId);
        setName(name);
        setMembershipLevel("Bronze");
    }

    // Helper method for string validation
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        validateString(customerId, "Customer ID");
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateString(name, "Name");
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validateString(phone, "Phone");
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateString(email, "Email");
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateString(address, "Address");
        this.address = address;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    private void setMembershipLevel(String membershipLevel) {
        validateString(membershipLevel, "Membership Level");
        this.membershipLevel = membershipLevel;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Real-world: Add or deduct points, rather than directly setting them
    public void addLoyaltyPoints(int points) {
        if (points < 0) throw new IllegalArgumentException("Points cannot be negative");
        this.loyaltyPoints += points;
    }
}
