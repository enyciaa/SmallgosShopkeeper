package smallgos.intuithack.com.smallgos;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import smallgos.intuithack.com.smallgos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    InventoryView inventoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("   " + getSupportActionBar().getTitle());
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setIcon(R.drawable.ic_logo_white);
        }

        LayoutInflater inflater = getLayoutInflater();
        inventoryView = (InventoryView) inflater.inflate(R.layout.view_inventory, binding.mainContainer, false);
        binding.mainContainer.addView(inventoryView);
    }

}
