package mp.hd3534.studyrecoder.GraphActivities;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;

import mp.hd3534.studyrecoder.R;

public class YearlyGraphActivity extends Activity {

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_graph);
    }

    /******************** initializer *******************/

    // view
    private void initView() {
        lineChart = (LineChart)findViewById(R.id.chart);
    }
}
