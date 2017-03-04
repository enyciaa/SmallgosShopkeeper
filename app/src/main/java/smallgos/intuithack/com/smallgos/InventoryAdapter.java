package smallgos.intuithack.com.smallgos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private String[] dataSet;

    public InventoryAdapter(String[] dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemInventoryTitle.setText(dataSet[position]);

    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemInventoryTitle)
        TextView itemInventoryTitle;


        public ViewHolder(LinearLayout view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}