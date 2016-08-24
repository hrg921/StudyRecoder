package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mp.hd3534.studyrecoder.GraphActivities.DailyGraphActivity;
import mp.hd3534.studyrecoder.GraphActivities.MonthlyGraphActivity;
import mp.hd3534.studyrecoder.GraphActivities.YearlyGraphActivity;

public class SelectTimeActivity extends Activity {

    private Button yearly_button;
    private Button monthly_button;
    private Button daily_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        initView();
    }

    private void initView() {
        yearly_button = (Button)findViewById(R.id.select_time_yearly_button);
        monthly_button = (Button)findViewById(R.id.select_time_monthly_button);
        daily_button = (Button)findViewById(R.id.select_time_daily_button);
        initListeners();
    }

    private void initListeners() {
        yearly_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YearlyGraphActivity.class);
                startActivity(intent);
            }
        });
        monthly_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MonthlyGraphActivity.class);
                startActivity(intent);
            }
        });
        daily_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DailyGraphActivity.class);
                startActivity(intent);
            }
        });
    }
}
