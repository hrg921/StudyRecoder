package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mp.hd3534.studyrecoder.Data.StudyData;
import mp.hd3534.studyrecoder.Database.DbController;
import mp.hd3534.studyrecoder.Database.DbOpenHelper;

public class RecordActivity extends Activity {

    private EditText editText_date;
    private EditText editText_hour;
    private EditText editText_minute;
    private EditText editText_second;

    private Button button_record;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");

    private DbController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initView();
        initDatabase();
    }

    /******************** initializer *******************/

    // view
    private void initView() {
        editText_date = (EditText)findViewById(R.id.record_editText_date);
        editText_hour = (EditText)findViewById(R.id.record_editText_hour);
        editText_minute = (EditText)findViewById(R.id.record_editText_minute);
        editText_second = (EditText)findViewById(R.id.record_editText_second);
        button_record = (Button)findViewById(R.id.record_button_record);
        initListeners();
    }

    private void initListeners() {
        button_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnyEmpty()) {
                    Toast.makeText(getApplicationContext(), "빈 칸을 모두 채워주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                Date date = parseDate();
                Date time = parseTime();
                dbController.insert(new StudyData(date.getYear()+1900, date.getMonth(), date.getDate(), time.getHours(), time.getMinutes(), time.getSeconds()), getApplicationContext());
                editText_date.setText(null);
                editText_hour.setText(null);
                editText_minute.setText(null);
                editText_second.setText(null);
            }
        });
    }

    // data
    private void initDatabase() {
        dbController = new DbController(getApplicationContext());
    }

    /******************** validator *******************/

    private Date parseDate () {
        Date date = null;
        try {
            date = dateFormat.parse(editText_date.getText().toString());
        } catch (ParseException e) {
            Toast.makeText(getApplicationContext(), "YYYY-MM-DD 형식을 지켜주세요", Toast.LENGTH_SHORT).show();
        }
        return date;
    }

    private Date parseTime () {
        Date time = null;
        try {
            time = timeFormat.parse(editText_hour.getText().toString() + editText_minute.getText().toString() + editText_second.getText().toString());
        } catch (ParseException e) {
            Toast.makeText(getApplicationContext(), "시간 형식을 지켜주세요 HH MM SS", Toast.LENGTH_SHORT).show();
        }
        return time;
    }

    private boolean isAnyEmpty() {
        if (isEmpty(editText_date) || isEmpty(editText_hour) || isEmpty(editText_minute) || isEmpty(editText_second)) {
            return true;
        }
        return false;
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0) return false;
        return true;
    }
}
