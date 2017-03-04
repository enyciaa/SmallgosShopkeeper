package smallgos.intuithack.com.smallgos.model;

public class InventoryItem {

    public String name;
    public String title;
    public int price;
    public int stock;

    public InventoryItem(String name, String title, int price, int stock) {
        this.name = name;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
