package smallgos.intuithack.com.smallgos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public class InventoryView extends CoordinatorLayout {

    @BindView(R.id.inventoryList)
    RecyclerView inventoryList;

    public InventoryView(Context context) {
        super(context);
    }

    public InventoryView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InventoryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        List<InventoryItem> items = new ArrayList<>();
        InventoryAdapter inventoryAdapter = new InventoryAdapter(getContext(), items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        inventoryList.setLayoutManager(linearLayoutManager);
        inventoryList.setAdapter(inventoryAdapter);
        inventoryList.addItemDecoration(new TopSpaceDecoration(getContext().getResources().getDimensionPixelOffset(R.dimen.grid_16)));

        SmallgosNetwork.INSTANCE.getInventory()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(catalogResponse -> {
                    ((InventoryAdapter) inventoryList.getAdapter()).addItems(catalogResponse.getItems());
                });
    }

    @OnClick (R.id.addButton)
    void addItem() {
        Intent intent = new Intent(getContext(), AddItemActivity.class);
        getContext().startActivity(intent);
    }
}
