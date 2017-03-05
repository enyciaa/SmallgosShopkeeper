package smallgos.intuithack.com.smallgos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import smallgos.intuithack.com.smallgos.model.InventoryItem;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    private Context context;
    private List<InventoryItem> items;

    public InventoryAdapter(Context context, List<InventoryItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout view = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventory, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final InventoryItem item = items.get(position);
        if (items.get(position).getImage() != null) {
            holder.itemInventoryItemPicture.setImageDrawable(Utils.convertBase64ToDrawable(context, item.getImage()));
        }
        holder.itemInventoryItemCode.setText(item.getProductId());
        holder.itemInventoryItemName.setText(item.getTitle());
        holder.itemInventoryItemPrice.setText("£" + item.getPrice());
        holder.itemInventoryItemQuantity.setText(context.getString(R.string.inventory_item_quantity, items.get(position).getStock()));
        holder.itemInventoryItem.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onClick(item);
            }
        });
    }

    public void addItems(List<InventoryItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.itemInventoryItem)
        LinearLayout itemInventoryItem;
        @BindView(R.id.itemInventoryItemPicture)
        ImageView itemInventoryItemPicture;
        @BindView(R.id.itemInventoryItemName)
        TextView itemInventoryItemName;
        @BindView(R.id.itemInventoryItemCode)
        TextView itemInventoryItemCode;
        @BindView(R.id.itemInventoryItemPrice)
        TextView itemInventoryItemPrice;
        @BindView(R.id.itemInventoryItemQuantity)
        TextView itemInventoryItemQuantity;


        public ViewHolder(LinearLayout view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnItemClickListener {

        void onClick(InventoryItem item);

    }
}