package com.huaijie.android_hacks.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.huaijie.android_hacks.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fenghb on 2014/4/30.
 */
public class HomeActivity extends Activity implements AdapterView.OnItemClickListener {

    List<ActivityInfo> list;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addActivity();
        initViews();
    }

    private void addActivity() {
        list = new ArrayList<ActivityInfo>();
        list.add(new ActivityInfo("centering view", CenteringView.class));
        list.add(new ActivityInfo("lazy loading", LazyLoading.class));
        list.add(new ActivityInfo("customViewGroup", CustomViewGroup.class));
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.list_view);
        listView.setOnItemClickListener(this);
        listView.setAdapter(new HacksAdapter(this, list));
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent();
        intent.setClass(this, list.get(position).getClazz());
        startActivity(intent);
    }


    private class HacksAdapter extends BaseAdapter {
        private List<ActivityInfo> activityInfos;
        private Context context;

        public HacksAdapter(Context context, List<ActivityInfo> activityInfos) {
            this.activityInfos = activityInfos;
            this.context = context;
        }

        @Override
        public int getCount() {
            return activityInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return activityInfos.get(position);
        }

        @Override
        public long getItemId(int id) {
            return id;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder holder;

            if (view == null) {
                holder = new ViewHolder();
                view = LayoutInflater.from(context).inflate(R.layout.item_hacks, null);
                holder.title = (TextView) view.findViewById(R.id.title);
                view.setTag(holder);

            } else {
                holder = (ViewHolder) view.getTag();
            }

            holder.title.setText(activityInfos.get(position).getTitle());
            return view;
        }

        private class ViewHolder {
            private TextView title;
        }
    }
}
