package smallgos.intuithack.com.smallgos;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import smallgos.intuithack.com.smallgos.databinding.ActivityAddItemBinding;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public class AddItemActivity extends AppCompatActivity {

    private ActivityAddItemBinding binding;
    private InventoryItem item = new InventoryItem();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_item);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.itemAddButton)
    void addItem() {
        item.setProductId("XCY34X9");
        item.setName("Chocolate");
        item.setTitle("Chocolate");
        item.setDescription("Chocolate melt in your mouth goodness");
        item.setPrice(2.00);
        item.setStock(20);

        List<InventoryItem> items = new ArrayList<>();
        items.add(item);

        SmallgosNetwork.INSTANCE.addItem(items)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(catalogResponse -> {
                    Log.i("Test", "respnse");
                });
    }
}
