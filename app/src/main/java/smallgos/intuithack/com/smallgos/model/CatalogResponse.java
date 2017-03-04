package smallgos.intuithack.com.smallgos.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogResponse {

    public List<InventoryItem> items = new ArrayList<>();

    public CatalogResponse(List<InventoryItem> items) {
        this.items = items;
    }

    public List<InventoryItem> getItems() {
        return items;
    }

    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}
