package Model;

public class OrderItem {
    private String clothingItemId;
    private String itemName;
    private String size;
    private String color;
    private double price;
    private int quantity;
    private double discount;
    private double subtotal;

    // Constructor
    public OrderItem(String clothingItemId, String itemName, double price, String size, String color) {
        setClothingItemId(clothingItemId);
        setItemName(itemName);
        setPrice(price);
        setSize(size);
        setColor(color);
        setSubtotal(0.0);
    }

    public String getClothingItemId() {
        return clothingItemId;
    }

    private void setClothingItemId(String clothingItemId) {
        this.clothingItemId = clothingItemId;
    }

    public String getItemName() {
        return itemName;
    }

    private void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSize() {
        return size;
    }

    private void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotal() {
        return subtotal;
    }

    private void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
