package Model;

public class ClothingItem {
    private String itemName;
    private String itemCode;
    private String catogory;
    private String size;
    private String color;
    private double price;
    private int stock;
    private String gender;

    // Constructor for immutable fields
    public ClothingItem(String itemCode, String itemName, String catogory, String size, String color, String gender) {
        setitemCode(itemCode);
        setitemName(itemName);
        setcatogory(catogory);
        setsize(size);
        setcolor(color);
        setgender(gender);
    }

    // Helper method for string validation
    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        validateString(itemName, "Item Name");
        this.itemName = itemName;
    }

    public String getitemCode() {
        return itemCode;
    }

    private void setitemCode(String itemCode) {
        validateString(itemCode, "Item Code");
        this.itemCode = itemCode;
    }

    public String getcatogory() {
        return catogory;
    }

    private void setcatogory(String catogory) {
        validateString(catogory, "Category");
        this.catogory = catogory;
    }

    public String getsize() {
        return size;
    }

    private void setsize(String size) {
        validateString(size, "Size");
        this.size = size;
    }

    public String getcolor() {
        return color;
    }

    private void setcolor(String color) {
        validateString(color, "Color");
        this.color = color;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public int getstock() {
        return stock;
    }

    public void setstock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }

    public String getgender() {
        return gender;
    }

    private void setgender(String gender) {
        validateString(gender, "Gender");
        this.gender = gender;
    }
}
