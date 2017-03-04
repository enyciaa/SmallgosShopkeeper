package smallgos.intuithack.com.smallgos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private List<InventoryItem> items;

    public InventoryAdapter(List<InventoryItem> items) {
        this.items = items;
    }

    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemInventoryTitle.setText(items.get(position).getName());
    }

    public void addItems(List<InventoryItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
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