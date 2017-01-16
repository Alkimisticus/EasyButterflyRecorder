package si.alkimisticus.easybutterflyrecorder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import si.alkimisticus.easybutterflyrecorder.db.SpeciesDbTable;

/**
 * Created by jernej on 13.1.2017.
 */

public class RecordingAdapter extends RecyclerView.Adapter<RecordingAdapter.ViewHolder> {

    private ArrayList<SpeciesDbTable> listData;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout chatRow;
        //public ChatRowData.HolderTypes holderType;

        public ViewHolder(LinearLayout v) {
            super(v);
            //holderType = type;
            chatRow = v;

        }

    }

    public RecordingAdapter(ArrayList<SpeciesDbTable> data) {
        listData = data;
    }

    public void setData(ArrayList<SpeciesDbTable> data) {
        listData = data;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the view for this view holder
        LinearLayout thisItemsView = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_recording_row,
                parent, false);
// Call the view holder's constructor, and pass the view to it;
// return that new view holder
        return new ViewHolder(thisItemsView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Find out the data, based on this view holder's position
        SpeciesDbTable thisItemsName = listData.get(position);
        ((TextView)holder.chatRow.findViewById(R.id.prvi)).setText(thisItemsName.getCommonName());
        ((TextView)holder.chatRow.findViewById(R.id.drugi)).setText(thisItemsName.getLatinName());
        ((TextView)holder.chatRow.findViewById(R.id.tretji)).setText(thisItemsName.getCommonFamilyName());
        ((TextView)holder.chatRow.findViewById(R.id.cetrti)).setText(thisItemsName.getLatinFamilyName());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }




}
