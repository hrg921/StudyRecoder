package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;

public class GraphActivity extends Activity {

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
    }

    /******************** initializer *******************/

    // view
    private void initView() {
        lineChart = (LineChart)findViewById(R.id.chart);
    }
}
