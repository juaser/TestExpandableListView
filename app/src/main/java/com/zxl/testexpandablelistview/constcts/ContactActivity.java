package com.zxl.testexpandablelistview.constcts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zxl.testexpandablelistview.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @类说明：
 * @author：zxl
 * @CreateTime 2016/7/23.
 */
public class ContactActivity extends Activity {
    @Bind(R.id.expand_contacts)
    ExpandableListView expandContacts;
    private PingyinAdapter<ContactsInfoBean> adapter;
    private List<ContactsInfoBean> mList;

    private static String[] nicks = {"阿雅", "北风", "张山", "李四", "欧阳锋", "郭靖",
            "黄蓉", "杨过", "凤姐", "芙蓉姐姐", "移联网", "樱木花道", "风清扬", "张三丰", "梅超风"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        initData();
        setAdapter();
    }

    public void initData() {
        mList = new ArrayList<>();
        for (String name : nicks) {
            ContactsInfoBean bean = new ContactsInfoBean();
            bean.setName(name);
            mList.add(bean);
        }
    }

    public void setAdapter() {
        expandContacts.setGroupIndicator(null);
        adapter = new PingyinAdapter<ContactsInfoBean>(expandContacts, mList,
                R.layout.item_contactexpand_title, R.id.tv_contacts_title, R.layout.item_contactexpand_content) {
            @Override
            public String getItemName(ContactsInfoBean contactsInfoBean) {
                return contactsInfoBean.name;
            }

            @Override
            public ViewHolder getViewHolder(final ContactsInfoBean contactsInfoBean) {
                class DataViewHolder extends ViewHolder implements View.OnClickListener {
                    public TextView tv_name;

                    public DataViewHolder(ContactsInfoBean contactsInfoBean) {
                        super(contactsInfoBean);
                    }

                    @Override
                    public ViewHolder getHolder(View view) {
                        tv_name = (TextView) view.findViewById(R.id.tv_contacts_name);
                        view.setOnClickListener(this);
                        return null;
                    }

                    @Override
                    public void show() {
                        tv_name.setText(getItem().name);
                    }

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ContactActivity.this, contactsInfoBean.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
                return new DataViewHolder(contactsInfoBean);
            }

            @Override
            public void onItemClick(ContactsInfoBean contactsInfoBean, View view, int position) {

            }
        };
        adapter.expandGroup();
    }
}
