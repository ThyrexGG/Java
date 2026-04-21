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

    public String getitemName() {
        return itemName;
    }

    public void setitemName(String itemName) {
        this.itemName = itemName;
    }

    public String getitemCode() {
        return itemCode;
    }

    private void setitemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getcatogory() {
        return catogory;
    }

    private void setcatogory(String catogory) {
        this.catogory = catogory;
    }

    public String getsize() {
        return size;
    }

    private void setsize(String size) {
        this.size = size;
    }

    public String getcolor() {
        return color;
    }

    private void setcolor(String color) {
        this.color = color;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public int getstock() {
        return stock;
    }

    public void setstock(int stock) {
        this.stock = stock;
    }

    public String getgender() {
        return gender;
    }

    private void setgender(String gender) {
        this.gender = gender;
    }
}
