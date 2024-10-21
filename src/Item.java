public class Item {
    private double itemPrice;
    private String itemName;
    private String itemCode;
    private int itemStock;

    public Item(String code, String name, double price, int stock) {
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemStock = stock;
    }

    public double getPrice() {
        return itemPrice;
    }

    public String getCode() {
        return itemCode;
    }

    public String getName() {
        return itemName;
    }

    public int getStock() {
        return itemStock;
    }
}
