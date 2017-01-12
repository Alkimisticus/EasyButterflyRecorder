package si.alkimisticus.easybutterflyrecorder.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jernej on 12.1.2017.
 */

public class InsectRecorderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "InsectRecorder.db";

    public InsectRecorderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InsectRecorderContract.SQL_CREATE_ENTRIES);
        // only for development & testing
        fillWithTemporaryData(db);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(InsectRecorderContract.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    /**
     * Fill with temporary data for initial testing end development
     * Ment to be called from onCreate()
     */
    private void fillWithTemporaryData(SQLiteDatabase db) {

        ArrayList<SpeciesDbTable> temporayData = new ArrayList<SpeciesDbTable>();
        temporayData.add(new SpeciesDbTable("hromi volnoritec","Eriogaster catax","kokljice","Lasiocampidae"));
        temporayData.add(new SpeciesDbTable("navadni mlečkar","Hyles euphorbiae","veščeci","Sphingidae"));
        temporayData.add(new SpeciesDbTable("mlečkova sovka","Acronicta euphorbiae","sovke","Noctuidae"));
        temporayData.add(new SpeciesDbTable("sfingina sovka","Asteroscopus sphinx","sovke","Noctuidae"));
        temporayData.add(new SpeciesDbTable("veliki lišajar","Lithosia quadra","neprave sovke","Erebidae"));
        temporayData.add(new SpeciesDbTable("hrastova čopasta sovka","Meganola strigula","čopaste sovke","Nolidae"));
        temporayData.add(new SpeciesDbTable("brestova hrbtorožka","Dicranura ulmi","hrbtorožke","Notodontidae"));
        temporayData.add(new SpeciesDbTable("veliki slezovček","Pyrgus carthami","debeloglavčki","Hesperiidae"));
        temporayData.add(new SpeciesDbTable("rdeči ali gorski apolon","Parnassius apollo","lastovičarji","Papilionidae"));
        temporayData.add(new SpeciesDbTable("glogova belinka","Aporia crataegi","belini","Pieridae"));

        for(SpeciesDbTable species : temporayData) {

            // Create a new map of values, where column names are the keys
            ContentValues values = new ContentValues();
            values.put(InsectRecorderContract.SpeciesEntry.COLUMN_NAME_COMMON_NAME, species.getCommonName());
            values.put(InsectRecorderContract.SpeciesEntry.COLUMN_NAME_LATIN_NAME, species.getLatinName());
            values.put(InsectRecorderContract.SpeciesEntry.COLUMN_NAME_COMMON_FAMILY_NAME, species.getCommonFamilyName());
            values.put(InsectRecorderContract.SpeciesEntry.COLUMN_NAME_LATIN_FAMILY_NAME, species.getLatinFamilyName());

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(InsectRecorderContract.SpeciesEntry.TABLE_NAME, null, values);

        }
    }


}
