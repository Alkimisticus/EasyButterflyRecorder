package si.alkimisticus.easybutterflyrecorder.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by jernej on 12.1.2017.
 */

public class DataProvider extends ContentProvider {

    // Creates a UriMatcher object.
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    public static final String AUTHORITY = "si.alkimisticus.easybutterflyrecorder.provider";
    private InsectRecorderDbHelper dbHelper;
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    static {
        /*
         * The calls to addURI() go here, for all of the content URI patterns that the provider
         * should recognize. For this snippet, only the calls for table 3 are shown.
         */

        /*
         * Sets the integer value for multiple rows in table 3 to 1. Notice that no wildcard is used
         * in the path
         */
        sUriMatcher.addURI(AUTHORITY, "species", 1);

        /*
         * Sets the code for a single row to 2. In this case, the "#" wildcard is
         * used. "content://com.example.app.provider/table3/3" matches, but
         * "content://com.example.app.provider/table3 doesn't.
         */
        sUriMatcher.addURI(AUTHORITY, "species/#", 2);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new InsectRecorderDbHelper(getContext());
        return true;
    }


    // Implements ContentProvider.query()
    public Cursor query(Uri uri,String[] projection,String selection,String[] selectionArgs,String sortOrder) {

        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = null;
        /*
         * Choose the table to query and a sort order based on the code returned for the incoming
         * URI. Here, too, only the statements for table 3 are shown.
         */
        switch (sUriMatcher.match(uri)) {



            // If the incoming URI was for all of table3
            case 1:

//                if (TextUtils.isEmpty(sortOrder)) sortOrder = "_ID ASC";
//                break;

                cursor = db.query(InsectRecorderContract.SpeciesEntry.TABLE_NAME, projection, selection, selectionArgs, null, null,sortOrder, null);
                cursor.setNotificationUri(getContext().getContentResolver(), uri);
                break;

            // If the incoming URI was for a single row
            case 2:

                /*
                 * Because this URI was for a single row, the _ID value part is
                 * present. Get the last path segment from the URI; this is the _ID value.
                 * Then, append the value to the WHERE clause for the query
                 */
                selection = selection + "_ID = " + uri.getLastPathSegment();
                break;

            default:
                // If the URI is not recognized, you should do some error handling here.
        }
        // call the code to actually do the query

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }
}
