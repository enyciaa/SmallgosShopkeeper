package smallgos.intuithack.com.smallgos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import smallgos.intuithack.com.smallgos.model.CatalogResponse;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public interface SmallgosApi {

    String BASE_URL = "http://176.31.124.179:8080/";

    @POST("catalog")
    Call<List<InventoryItem>> addItem(@Body List<InventoryItem> items);

    @GET("catalog")
    Call<CatalogResponse> getInventory();

}
