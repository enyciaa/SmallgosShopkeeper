package smallgos.intuithack.com.smallgos;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import smallgos.intuithack.com.smallgos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    InventoryView inventoryView;
    OrderView orderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        LayoutInflater inflater = getLayoutInflater();
        inventoryView = (InventoryView) inflater.inflate(R.layout.view_inventory, binding.mainContainer, false);
        orderView = (OrderView) inflater.inflate(R.layout.view_orders, binding.mainContainer, false);

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tabInventory:
                                binding.mainContainer.removeAllViews();
                                binding.mainContainer.addView(inventoryView);
                                break;

                            case R.id.tabOrders:
                                binding.mainContainer.removeAllViews();
                                binding.mainContainer.addView(orderView);
                                break;

                        }
                        return true;
                    }
                });

        Menu bottomNavigationMenu = binding.bottomNavigation.getMenu();
        bottomNavigationMenu.performIdentifierAction(R.id.tabInventory, 0);
    }

}
