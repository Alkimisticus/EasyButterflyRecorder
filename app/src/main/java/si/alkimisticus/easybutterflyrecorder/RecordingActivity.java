package si.alkimisticus.easybutterflyrecorder;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.TreeMap;

import si.alkimisticus.easybutterflyrecorder.db.DataProvider;
import si.alkimisticus.easybutterflyrecorder.db.InsectRecorderContract;
import si.alkimisticus.easybutterflyrecorder.db.SpeciesDbTable;

/**
 * Created by jernej on 9.6.2016.
 */
public class RecordingActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView mRecyclerView;
    private RecordingAdapter recordingAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        recordingAdapter = new RecordingAdapter(new ArrayList<SpeciesDbTable>());
        mRecyclerView.setAdapter(recordingAdapter);

        // Prepare the loader.  Either re-connect with an existing one,
        // or start a new one.
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(
                this,   // Parent activity context
                DataProvider.BASE_CONTENT_URI.buildUpon().appendPath("species").build() ,  // Table to query
                InsectRecorderContract.PROJECTION,         // Projection to return0
                null,                                           // No selection clause
                null,                                           // No selection arguments
                null);          // Default sort order


    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        ArrayList<SpeciesDbTable> tableData = new ArrayList<>();

        data.moveToFirst();
        while (data.isAfterLast() == false) {

            tableData.add(new SpeciesDbTable(data.getString(0),data.getString(1),data.getString(2),data.getString(3)));
            data.moveToNext();
        }
        data.close();

        recordingAdapter.setData(tableData);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        recordingAdapter.setData(new ArrayList<SpeciesDbTable>());
    }
}
