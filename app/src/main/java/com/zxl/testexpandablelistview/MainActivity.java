package com.zxl.testexpandablelistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.lv)
    ListView lv;

    List<String> items;
    List<Class<?>> activitys;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initActivity();
        initItems();
        initView();
    }

    public void initActivity() {
        activitys = new ArrayList<>();
        activitys.add(SimpleExpandActivity.class);
    }

    public void initItems() {
        items = new ArrayList<>();
        items.add("简单的ExpandListView");
    }

    public void initView() {
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, items);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                jump(activitys.get(i));
            }
        });
    }

    public void jump(Class<?> T) {
        startActivity(new Intent(this, T));
    }
}
