package mp.hd3534.studyrecoder.GraphActivities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mp.hd3534.studyrecoder.Data.DataProcessHelper;
import mp.hd3534.studyrecoder.Data.StudyData;
import mp.hd3534.studyrecoder.Database.DbController;
import mp.hd3534.studyrecoder.R;

public class YearlyGraphActivity extends Activity {

    private LineChart lineChart;

    private Button button;

    private DbController dbController;

    private Map<Integer, Integer> yearDataMap;
    private Map<Integer, List> yearListMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_graph);
        initView();
        initDatabase();
        makeYearlyGraph();
    }

    /******************** initializer *******************/

    // view
    private void initView() {
        lineChart = (LineChart)findViewById(R.id.yearly_graph_chart);
        button = (Button)findViewById(R.id.yearly_graph_button);
        initListeners();
    }

    private void initListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeYearlyGraph();
            }
        });
    }

    private void initDatabase() {
        dbController = new DbController(getApplicationContext());
    }

    /******************** graph *******************/

    private void makeYearlyGraph() {
//        yearDataMap = new HashMap<>();
//        yearListMap = new HashMap<>();
//
//        List<StudyData> studyDataList = dbController.selectAll();
//        List<Integer> studiedYearList = new ArrayList<>();
//
//        for (StudyData studyData : studyDataList) {
//            if (yearDataMap.containsKey(studyData.getYear())) {
//                yearListMap.get(studyData.getYear()).add(studyData);
//                studiedYearList.add(studyData.getYear());
//            } else {
//                List<StudyData> dataList = new ArrayList<>();
//                dataList.add(studyData);
//                yearListMap.put(studyData.getYear(), dataList);
//            }
//        }
//
//        for (int i = 0; i < studiedYearList.size(); i++) {
//            yearDataMap.put(studiedYearList.get(i), DataProcessHelper.getHourSumByList(yearListMap.get(studiedYearList.get(i))));
//        }
//
        List<Entry> entries = new ArrayList<>();

//        for (int i = 0; i < studiedYearList.size(); i++) {
//            int year = studiedYearList.get(i);
//            int hour = yearDataMap.get(year);
//            Log.d("Yearly_Entry", "year:" + year + " hour:" + hour);
//            entries.add(new Entry(year, hour));
//        }


        for (int i = 0; i < 100; i++) {
            entries.add(new Entry(i, i));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(Color.BLACK);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
//        lineChart.setBackgroundColor(Color.parseColor("#ffffff"));
        lineChart.invalidate();
    }
}
