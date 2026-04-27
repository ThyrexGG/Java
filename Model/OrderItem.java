package Model;

public class OrderItem {
    private String clothingItemId;
    private String itemName;
    private double price;
    private int quantity;
    private double discount;

    // Constructor
    public OrderItem(String clothingItemId, String itemName, double price, int quantity) {
        setClothingItemId(clothingItemId);
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
        this.discount = 0.0;
    }

    // Calculate for reciept
    public double calculateSubtotal() {
        double subtotal = price * quantity;
        return subtotal - discount;
    }

    // Getters
    public String getClothingItemId() {
        return clothingItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getDiscount() {
        return discount;
    }

    // Setters 
    public void setClothingItemId(String clothingItemId) {
        if (clothingItemId != null && !clothingItemId.trim().isEmpty()) {
            this.clothingItemId = clothingItemId;
        }
    }

    public void setItemName(String itemName) {
        if (itemName != null && !itemName.trim().isEmpty()) {
            this.itemName = itemName;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public void setDiscount(double discount) {
        if (discount >= 0) {
            this.discount = discount;
        }
    }
}