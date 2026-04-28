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

    public ClothingItem(String itemCode, String itemName, String catogory, String size, String color, String gender) {
        setitemCode(itemCode);
        setitemName(itemName);
        setcatogory(catogory);
        setsize(size);
        setcolor(color);
        setgender(gender);
    }

    private void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            System.out.println(fieldName + " cannot be null or empty");
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        validateString(itemName, "Item Name");
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    private void setitemCode(String itemCode) {
        validateString(itemCode, "Item Code");
        this.itemCode = itemCode;
    }

    public String getCategory() {
        return catogory;
    }

    private void setcatogory(String catogory) {
        validateString(catogory, "Category");
        this.catogory = catogory;
    }

    public String getSize() {
        return size;
    }

    private void setsize(String size) {
        validateString(size, "Size");
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    private void setcolor(String color) {
        validateString(color, "Color");
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setprice(double price) {
        if (price < 0)
            System.out.println("Price cannot be negative");
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setstock(int stock) {
        if (stock < 0)
            System.out.println("Stock cannot be negative");
        this.stock = stock;
    }

    public String getGender() {
        return gender;
    }

    private void setgender(String gender) {
        validateString(gender, "Gender");
        this.gender = gender;
    }
}