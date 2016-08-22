package mp.hd3534.studyrecoder.Database;

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

    // initialize Database, called once to make DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE
        db.execSQL(DataBases.CreateDB._CREATE);
    }

    // version update -> remake DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBases.CreateDB._TABLENAME);
        onCreate(db);
    }
}
