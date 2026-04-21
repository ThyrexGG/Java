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
    }

    public String getCustomerId() {
        return customerId;
    }

    private void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Real-world: Add or deduct points, rather than directly setting them
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }
}
