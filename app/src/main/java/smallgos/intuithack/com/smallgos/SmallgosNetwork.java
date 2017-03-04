package smallgos.intuithack.com.smallgos;

import android.util.Log;

import com.squareup.moshi.Moshi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public enum SmallgosNetwork {
    INSTANCE;

    private SmallgosApi smallgosApi;

    public void init() {
        Moshi moshi = new Moshi.Builder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SmallgosApi.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build();

        smallgosApi = retrofit.create(SmallgosApi.class);
    }

    public void addItem() {
        List<InventoryItem> items = new ArrayList<>();
        InventoryItem item = new InventoryItem("Tomatoes");
        items.add(item);
        Call<List<InventoryItem>> call = smallgosApi.addItem(items);
        call.enqueue(new Callback<List<InventoryItem>>() {
            @Override
            public void onResponse(Call<List<InventoryItem>> call, Response<List<InventoryItem>> response) {
                Log.i("Test", "call success");
            }

            @Override
            public void onFailure(Call<List<InventoryItem>> call, Throwable t) {
                Log.i("Test", "call failure");
            }
        });
    }


}
