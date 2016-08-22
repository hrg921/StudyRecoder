package mp.hd3534.studyrecoder.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hangeonho on 16. 8. 22..
 */
public class DbOpenHelper {

    private static final String DATABASE_NAME = "studyrecord.db";
    private static final int DATABASE_VERSION = 1;
    public static SQLiteDatabase database;
    private DBManager dbManager;
    private Context context;

    public DbOpenHelper(Context context) {
        this.context = context;
    }

    public DbOpenHelper open() {
        dbManager = new DBManager(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = dbManager.getWritableDatabase();
        return this;
    }

    public void close() {
        database.close();
    }
}
