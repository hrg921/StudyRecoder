package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectTimeActivity extends Activity {

    private static final String YEARLY = "Y";
    private static final String MONTHLY = "M";
    private static final String DAYLY = "D";

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

            }
        });
        monthly_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        daily_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
