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

    public void addItem(List<InventoryItem> items) {
//        Observable<List<InventoryItem>> call = smallgosApi.addItem(items);
//        call.enqueue(new Callback<List<InventoryItem>>() {
//            @Override
//            public void onResponse(Call<List<InventoryItem>> call, Response<List<InventoryItem>> response) {
//                Log.i("Test", "call success");
//            }
//
//            @Override
//            public void onFailure(Call<List<InventoryItem>> call, Throwable t) {
//                Log.i("Test", "call failure");
//            }
//        });
    }

    public Observable<CatalogResponse> getInventory() {
        return smallgosApi.getInventory();
    }


}
