package mp.hd3534.studyrecoder.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mp.hd3534.studyrecoder.Data.StudyData;

/**
 * Created by hangeonho on 16. 8. 22..
 */
public class DbController {

    private static final String SELECT_ALL_SQL = "SELECT _id, year, month, date, hour, minute, second FROM " + DataBases.CreateDB._TABLENAME + " ORDER BY year ;";
    private static final String SELECT_BY_WHERE_SQL = "SELECT _id, year, month, date, hour, minute, second FROM " + DataBases.CreateDB._TABLENAME + " ORDER BY year ASC WHERE ";

    private DbOpenHelper dbOpenHelper;
    private SQLiteDatabase database;

    private Context context;

    public DbController(Context context) {
        this.context = context;
        dbOpenHelper = new DbOpenHelper(context).open();
        database = DbOpenHelper.database;
    }

    public void insert(StudyData data, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBases.CreateDB.YEAR, data.getYear());
        contentValues.put(DataBases.CreateDB.MONTH, data.getMonth());
        contentValues.put(DataBases.CreateDB.DATE, data.getDate());
        contentValues.put(DataBases.CreateDB.HOUR, data.getHour());
        contentValues.put(DataBases.CreateDB.MINUTE, data.getMinute());
        contentValues.put(DataBases.CreateDB.SECOND, data.getSecond());
        Log.d("StudyRecord_DB", Long.toString(database.insert(DataBases.CreateDB._TABLENAME, null, contentValues)));
        Toast.makeText(context, "데이터가 성공적으로 등록되었습니다", Toast.LENGTH_SHORT).show();
    }

    public boolean delete(int _id) {
        int result = database.delete(DataBases.CreateDB._TABLENAME, "_id=?", new String[] {String.valueOf(_id)});
        if (result!=0) {
            Toast.makeText(context, "데이터가 성공적으로 삭제되었습니다", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    public List<StudyData> selectAll() {
        List<StudyData> studyDataList = new ArrayList<>();
        Cursor results = database.rawQuery(SELECT_ALL_SQL, null);
        int count = 0;

        results.moveToFirst();

        // 0 : YEAR
        // 1 : MONTH
        // 2 : DATE
        // 3 : HOUR
        // 4 : MINUTE
        // 5 : SECOND

        while (!results.isAfterLast()) {
            int _id = results.getInt(0);
            int year = results.getInt(1);
            int month = results.getInt(2);
            int date = results.getInt(3);
            int hour = results.getInt(4);
            int minute = results.getInt(5);
            int second = results.getInt(6);

            StudyData data = new StudyData(_id, year, month, date, hour, minute, second);

            studyDataList.add(data);

            results.moveToNext();
        }

        return studyDataList;
    }

    public List<StudyData> selectByYear(int selectedYear) {
        List<StudyData> studyDataList = new ArrayList<>();
        Cursor results = database.rawQuery(SELECT_BY_WHERE_SQL + "year = " + selectedYear, null);

        int count = 0;

        while (!results.isAfterLast()) {
            int _id = results.getInt(0);
            int year = results.getInt(1);
            int month = results.getInt(2);
            int date = results.getInt(3);
            int hour = results.getInt(4);
            int minute = results.getInt(5);
            int second = results.getInt(6);

            StudyData data = new StudyData(_id, year, month, date, hour, minute, second);

            studyDataList.add(data);

            results.moveToNext();
        }
        
        return studyDataList;
    }

    public List<StudyData> selectByMonth(int selectedMonth) {
        List<StudyData> studyDataList = new ArrayList<>();
        Cursor results = database.rawQuery(SELECT_BY_WHERE_SQL + "month = " + selectedMonth, null);

        int count = 0;

        while (!results.isAfterLast()) {
            int _id = results.getInt(0);
            int year = results.getInt(1);
            int month = results.getInt(2);
            int date = results.getInt(3);
            int hour = results.getInt(4);
            int minute = results.getInt(5);
            int second = results.getInt(6);

            StudyData data = new StudyData(_id, year, month, date, hour, minute, second);

            studyDataList.add(data);

            results.moveToNext();
        }

        return studyDataList;
    }
}
// TODO: 16. 8. 24. Refactor repetition code