package mp.hd3534.studyrecoder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hangeonho on 16. 8. 17..
 */
public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE
        db.execSQL("CREATE TABLE STUDY_RECORD(" +
                "year INTEGER" +
                "month INTEGER" +
                "date INTEGER" +
                "hour INTEGER" +
                "minute INTEGER" +
                "second INTEGER");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
