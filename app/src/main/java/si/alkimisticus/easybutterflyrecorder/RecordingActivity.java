package si.alkimisticus.easybutterflyrecorder;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;

import java.util.TreeMap;

/**
 * Created by jernej on 9.6.2016.
 */
public class RecordingActivity extends Activity implements LoaderManager.LoaderCallbacks<Cursor> {

    private RecordingAdapter recordingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);



        // Prepare the loader.  Either re-connect with an existing one,
        // or start a new one.
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        return new CursorLoader(
                this,   // Parent activity context
                "species",  // Table to query
                FavoriteApplicationsSelectAll.PROJECTION,         // Projection to return0
                null,                                           // No selection clause
                null,                                           // No selection arguments
                null)          // Default sort order


    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        recordingAdapter.setData(new TreeMap<LayerKey, ChatRowData>());
    }
}
