package smallgos.intuithack.com.smallgos;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import smallgos.intuithack.com.smallgos.model.CatalogResponse;

public interface SmallgosApi {

    String BASE_URL = "http://176.31.124.179:8080/";

    @POST("catalog")
    Observable<CatalogResponse> addItem(@Body CatalogResponse items);

    @GET("catalog")
    Observable<CatalogResponse> getInventory();

}
