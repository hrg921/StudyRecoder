package mp.hd3534.studyrecoder.Database;

import android.provider.BaseColumns;

/**
 * Created by hangeonho on 16. 8. 22..
 */
public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String _TABLENAME = "STUDY_RECORD";

        public static final String YEAR = "year";
        public static final String MONTH = "month";
        public static final String DATE = "date";
        public static final String HOUR = "hour";
        public static final String MINUTE = "minute";
        public static final String SECOND = "second";

        public static final String _CREATE =
                "CREATE TABLE " + _TABLENAME + "(" +
                YEAR + " INTEGER NOT NULL, " +
                MONTH + " INTEGER NOT NULL, " +
                DATE + " INTEGER NOT NULL, " +
                HOUR + " INTEGER NOT NULL, " +
                MINUTE + " INTEGER NOT NULL, " +
                SECOND + " INTEGER NOT NULL )";
    }
}
