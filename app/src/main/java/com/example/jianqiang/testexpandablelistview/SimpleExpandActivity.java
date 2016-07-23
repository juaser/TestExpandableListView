package com.example.jianqiang.testexpandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by JianQiang on 2016/7/23.
 */
public class SimpleExpandActivity extends Activity {
    @Bind(R.id.expand_simple)
    ExpandableListView expandContacts;
    private List<String> group_list;
    private List<String> item_lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleexpand);
        ButterKnife.bind(this);
        setExpand();
    }

    public void setExpand() {
        // 随便一堆测试数据
        group_list = new ArrayList<String>();
        group_list.add("我的好友");
        group_list.add("我的家人");
        group_list.add("兄弟姐妹");
        group_list.add("我的同学");

        item_lt = new ArrayList<String>();
        item_lt.add("张三丰");
        item_lt.add("董存瑞");
        item_lt.add("李大钊");
        expandContacts.setGroupIndicator(null);
        expandContacts.setAdapter(new SimpleExpandAdapter(this, group_list, item_lt));
    }
}
