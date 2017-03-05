package smallgos.intuithack.com.smallgos.model;

public class InventoryItem {

    public String image;
    public String productId;
    public String name;
    public String description;
    public String title;
    public String price;
    public String stock;

    public InventoryItem() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "item:" + name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price.replaceAll("\\s+","").replace(",", ".");
    }

    public void setPrice(String price) {
        this.price = price.replaceAll("\\s+","").replace(",", ".");
    }

    public String getStock() {
        return stock.replaceAll("\\s+","");
    }

    public void setStock(String stock) {
        this.stock = stock.replaceAll("\\s+","");
    }
}
