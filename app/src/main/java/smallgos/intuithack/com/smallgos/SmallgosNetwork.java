package smallgos.intuithack.com.smallgos;

import com.squareup.moshi.Moshi;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.Observable;
import smallgos.intuithack.com.smallgos.model.CatalogResponse;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public enum SmallgosNetwork {
    INSTANCE;

    private SmallgosApi smallgosApi;

    public void init() {
        Moshi moshi = new Moshi.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SmallgosApi.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

        smallgosApi = retrofit.create(SmallgosApi.class);
    }

    public Observable<CatalogResponse> addItem(List<InventoryItem> items) {
        CatalogResponse catalogResponse = new CatalogResponse(items);
        return smallgosApi.addItem(catalogResponse);
    }

    public Observable<CatalogResponse> getInventory() {
        return smallgosApi.getInventory();
    }


}
