package si.alkimisticus.easybutterflyrecorder;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by jernej on 13.1.2017.
 */

public class RecordingAdapter extends RecyclerView.Adapter<RecordingAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout chatRow;
        //public ChatRowData.HolderTypes holderType;

        public ViewHolder(LinearLayout v) {
            super(v);
            //holderType = type;
            chatRow = v;

        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the view for this view holder
        View thisItemsView = myInflater.inflate(R.layout.list_item_layout,
                parent, false);
// Call the view holder's constructor, and pass the view to it;
// return that new view holder
        return new ViewHolder(thisItemsView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Find out the data, based on this view holder's position
        String thisItemsName = myNameList.get(position);
        holder.nameTextView.setText(thisItemsName);

    }

    @Override
    public int getItemCount() {
        return 0;
    }




}
