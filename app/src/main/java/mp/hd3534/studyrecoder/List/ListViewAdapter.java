package mp.hd3534.studyrecoder.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mp.hd3534.studyrecoder.Data.StudyData;
import mp.hd3534.studyrecoder.R;

/**
 * Created by hangeonho on 16. 8. 28..
 */
public class ListViewAdapter extends ArrayAdapter {

    private Context context;
    private int resourceId;
    private StudyData[] studyDatas = null;

    public ListViewAdapter(Context context, int resourceId, StudyData[] studyDatas) {
        super(context, resourceId, studyDatas);
        this.context = context;
        this.resourceId = resourceId;
        this.studyDatas = studyDatas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        StudyDataHolder studyDataHolder = new StudyDataHolder();
        StudyData studyData = studyDatas[position];

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        row = layoutInflater.inflate(resourceId, parent, false);

        studyDataHolder.textView_date = (TextView)row.findViewById(R.id.listview_item_date);
        studyDataHolder.textView_hour = (TextView)row.findViewById(R.id.listview_item_hour);

        studyDataHolder.textView_date.setText(studyData.toStringDate());
        studyDataHolder.textView_hour.setText(studyData.toStringHour());

        return row;
    }

    private class StudyDataHolder {
        TextView textView_date;
        TextView textView_hour;
    }
}
