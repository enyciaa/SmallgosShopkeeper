package smallgos.intuithack.com.smallgos;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class TopSpaceDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public TopSpaceDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(parent.getChildAdapterPosition(view) == state.getItemCount()-1){
            outRect.bottom = space;
            outRect.top = 0; //don't forget about recycling...
        }
        if(parent.getChildAdapterPosition(view) == 0){
            outRect.top = space;
            outRect.bottom = 0;
        }
    }
}
