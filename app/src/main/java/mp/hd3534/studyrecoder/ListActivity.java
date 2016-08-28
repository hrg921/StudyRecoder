package mp.hd3534.studyrecoder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.List;

import mp.hd3534.studyrecoder.Data.StudyData;
import mp.hd3534.studyrecoder.Database.DbController;
import mp.hd3534.studyrecoder.List.ListViewAdapter;

public class ListActivity extends Activity {

    private DbController dbController;
    private List<StudyData> studyDatas;

    private ListView listView;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initData();
        initView();
        initList();
    }

    private void initView() {
        listView = (ListView)findViewById(R.id.list_listview);
    }

    private void initData() {
        dbController = new DbController(getApplicationContext());
        studyDatas = dbController.selectAll();
    }

    private void initList() {
        listViewAdapter = new ListViewAdapter(getApplicationContext(), R.layout.listview_item, studyDatas.toArray(new StudyData[studyDatas.size()]), dbController);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_NONE);
        listView.setAdapter(listViewAdapter);
    }
//    image_urls.toArray(new String[image_urls.size()]);
}
