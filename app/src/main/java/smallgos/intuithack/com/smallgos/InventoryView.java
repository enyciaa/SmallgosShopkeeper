package smallgos.intuithack.com.smallgos;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InventoryView extends LinearLayout {

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

    public InventoryView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
        String[] data = new String[3];
        data[0] = "Inventory item 1";
        data[1] = "Inventory item 2";
        data[2] = "Inventory item 3";
        InventoryAdapter inventoryAdapter = new InventoryAdapter(data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        inventoryList.setLayoutManager(linearLayoutManager);
        inventoryList.setAdapter(inventoryAdapter);
    }

    @OnClick
    void addItem() {
        Toast.makeText(getContext(), "GO TO MANAGE ITEM SCREEN", Toast.LENGTH_SHORT).show();
    }
}
