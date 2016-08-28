package mp.hd3534.studyrecoder.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

import mp.hd3534.studyrecoder.Data.StudyData;
import mp.hd3534.studyrecoder.Database.DbController;
import mp.hd3534.studyrecoder.ListActivity;
import mp.hd3534.studyrecoder.R;

/**
 * Created by hangeonho on 16. 8. 28..
 */
public class ListViewAdapter extends ArrayAdapter {

    private Context context;
    private int resourceId;
    private List<StudyData> studyDatas = null;
    private DbController dbController;

    public ListViewAdapter(Context context, int resourceId, List<StudyData> studyDatas, DbController dbController) {
        super(context, resourceId, studyDatas);
        this.context = context;
        this.resourceId = resourceId;
        this.studyDatas = studyDatas;
        this.dbController = dbController;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row;
        StudyDataHolder studyDataHolder = new StudyDataHolder();
        final StudyData studyData = studyDatas.get(position);

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        row = layoutInflater.inflate(resourceId, parent, false);

        studyDataHolder.textView_date = (TextView)row.findViewById(R.id.listview_item_date);
        studyDataHolder.textView_hour = (TextView)row.findViewById(R.id.listview_item_hour);
        studyDataHolder.button_delete = (Button)row.findViewById(R.id.listview_item_button);

        studyDataHolder.textView_date.setText(studyData.toStringDate());
        studyDataHolder.textView_hour.setText(studyData.toStringHour());
        studyDataHolder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbController.delete(studyData.get_id());
                studyDatas.remove(position);
                ((ListActivity)context).listViewAdapter.notifyDataSetChanged();
            }
        });

        return row;
    }

    private class StudyDataHolder {
        TextView textView_date;
        TextView textView_hour;
        Button button_delete;
    }
}
