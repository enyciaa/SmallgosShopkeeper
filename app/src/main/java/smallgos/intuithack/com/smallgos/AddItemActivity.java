package smallgos.intuithack.com.smallgos;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import smallgos.intuithack.com.smallgos.databinding.ActivityAddItemBinding;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public class AddItemActivity extends AppCompatActivity {

    public static final int PICTURE_REQUEST_CODE = 1787;

    private ActivityAddItemBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_item);
        ButterKnife.bind(this);

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("   " + getSupportActionBar().getTitle());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_logo_white);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == PICTURE_REQUEST_CODE && resultCode == RESULT_OK && null != data) {
                Picasso.with(AddItemActivity.this)
                        .load(data.getData())
                        .noPlaceholder()
                        .centerCrop()
                        .fit()
                        .into(binding.itemPicture);
            }
        }
    }

    @OnClick(R.id.itemPicture)
    void addPicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICTURE_REQUEST_CODE);
    }

    @OnClick(R.id.itemAddButton)
    void addItem() {
        InventoryItem item = new InventoryItem();
        String image = Utils.convertDrawableToBase64(this, binding.itemPicture.getDrawable());
        String name = binding.itemName.getText().toString();
        String productId = binding.itemProductId.getText().toString();
        String price = binding.itemPrice.getText().toString();
        String description = binding.itemDescription.getText().toString();
        String quantity = binding.itemQuantity.getText().toString();
        if (!TextUtils.isEmpty(image)
                && !TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(productId)
                && !TextUtils.isEmpty(price)
                && !TextUtils.isEmpty(description)
                && !TextUtils.isEmpty(quantity)) {
            item.setImage(image);
            item.setName(name);
            item.setProductId(productId);
            item.setPrice(price);
            item.setDescription(description);
            item.setStock(quantity);
        } else {
            Toast.makeText(this, getString(R.string.data_missing), Toast.LENGTH_SHORT).show();
            return;
        }

        List<InventoryItem> items = new ArrayList<>();
        items.add(item);

        SmallgosNetwork.INSTANCE.addItem(items)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(catalogResponse -> {
                    Log.i("Test", "response");
                });
    }
}
