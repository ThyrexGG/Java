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
        setItemCode(itemCode);
        setItemName(itemName);
        setCategory(catogory);
        setSize(size);
        setColor(color);
        setGender(gender);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    private void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getCategory() {
        return catogory;
    }

    private void setCategory(String catogory) {
        this.catogory = catogory;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }
}
