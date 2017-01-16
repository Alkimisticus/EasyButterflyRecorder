package si.alkimisticus.easybutterflyrecorder.db;

import android.provider.BaseColumns;

/**
 * Created by jernej on 12.1.2017.
 */
public final class InsectRecorderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private InsectRecorderContract() {}

    /* Inner class that defines the table contents */
    static class SpeciesEntry implements BaseColumns {
        public static final String TABLE_NAME = "species";
        public static final String COLUMN_NAME_COMMON_NAME = "common_name";
        public static final String COLUMN_NAME_LATIN_NAME = "latin_name";
        public static final String COLUMN_NAME_COMMON_FAMILY_NAME = "common_family_name";
        public static final String COLUMN_NAME_LATIN_FAMILY_NAME = "latin_family_name";
    }

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SpeciesEntry.TABLE_NAME + " (" +
                    SpeciesEntry._ID + " INTEGER PRIMARY KEY," +
                    SpeciesEntry.COLUMN_NAME_COMMON_NAME + " TEXT," +
                    SpeciesEntry.COLUMN_NAME_LATIN_NAME + " TEXT," +
                    SpeciesEntry.COLUMN_NAME_COMMON_FAMILY_NAME + " TEXT," +
                    SpeciesEntry.COLUMN_NAME_LATIN_FAMILY_NAME + " TEXT)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SpeciesEntry.TABLE_NAME;


    public static final String[] PROJECTION = new String[]{
            SpeciesEntry.TABLE_NAME+"."+SpeciesEntry.COLUMN_NAME_COMMON_NAME,
            SpeciesEntry.TABLE_NAME+"."+SpeciesEntry.COLUMN_NAME_LATIN_NAME,
            SpeciesEntry.TABLE_NAME+"."+SpeciesEntry.COLUMN_NAME_COMMON_FAMILY_NAME,
            SpeciesEntry.TABLE_NAME+"."+SpeciesEntry.COLUMN_NAME_LATIN_FAMILY_NAME
    };




}
