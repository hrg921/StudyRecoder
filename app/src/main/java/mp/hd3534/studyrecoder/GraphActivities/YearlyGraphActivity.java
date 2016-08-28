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
import java.util.Comparator;
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

    //        Log.d("yearList", "year[" + yearList.get(i) + "] : " + yearDataMap.get(yearList.get(i)));
    // 1. 모든 스터디 데이터를 년도별로 분류한다
    // 2. 스터디 데이터 리스트를 년도별로 이용하여 년도별 총합을 구한다
    private void makeYearlyGraph() {
//        yearDataMap = new HashMap<>();
//        yearListMap = new HashMap<>();
//
//        List<StudyData> studyDataList = dbController.selectAll();
//        List<Integer> yearList = new ArrayList<>();
//
//        for (StudyData studyData : studyDataList) {
//            if (yearListMap.containsKey(studyData.getYear())) {
//                yearListMap.get(studyData.getYear()).add(studyData);
//            } else {
//                List<StudyData> datas = new ArrayList<>();
//                datas.add(studyData);
//                yearList.add(studyData.getYear());
//                yearListMap.put(studyData.getYear(), datas);
//            }
//        }
//
//        Collections.sort(yearList, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer lhs, Integer rhs) {
//                return lhs.compareTo(rhs);
//            }
//        });
//
//        for (int i = 0; i < yearList.size(); i++) {
//            yearDataMap.put(yearList.get(i), DataProcessHelper.getHourSumByList(yearListMap.get(yearList.get(i))));
//        }

        List<Entry> entries = new ArrayList<>();

//        for (int i = 0; i < yearList.size(); i++) {
//            int year = yearList.get(i);
//            int hour = yearDataMap.get(yearList.get(i));
//            entries.add(new Entry(year, hour));
//        }

        List<StudyData> studyDataList = dbController.selectAll();

        for (int i = 0; i < studyDataList.size(); i++) {
            entries.add(new Entry(i, DataProcessHelper.getMinuteSumByDay(studyDataList.get(i))));
        }

        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.YELLOW);
        dataSet.setValueTextSize(0);

        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }
}
