package com.zxl.testexpandablelistview.simple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.zxl.testexpandablelistview.R;

import java.util.List;

/**
 * @类说明：
 * @author：zxl
 * @CreateTime 2016/7/23.
 */
public class SimpleExpandAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> group_list;
    private List<String> item_lt;

    public SimpleExpandAdapter(Context context, List<String> group_list, List<String> item_lt) {
        this.context = context;
        this.group_list = group_list;
        this.item_lt = item_lt;
    }

    /**
     * 获取组的个数
     *
     * @return
     * @see android.widget.ExpandableListAdapter#getGroupCount()
     */
    @Override
    public int getGroupCount() {
        return group_list.size();
    }

    /**
     * 获取指定组中的子元素个数
     *
     * @param i
     * @return
     * @see android.widget.ExpandableListAdapter#getChildrenCount(int)
     */
    @Override
    public int getChildrenCount(int i) {
        return item_lt.size();
    }

    /**
     * 获取指定组中的数据
     *
     * @param i
     * @return
     * @see android.widget.ExpandableListAdapter#getGroup(int)
     */
    @Override
    public Object getGroup(int i) {
        return group_list.get(i);
    }

    /**
     * 获取指定组中的指定子元素数据。
     *
     * @param i
     * @param i1
     * @return
     * @see android.widget.ExpandableListAdapter#getChild(int, int)
     */
    @Override
    public Object getChild(int i, int i1) {
        return item_lt.size();
    }

    /**
     * 获取指定组的ID，这个组ID必须是唯一的
     *
     * @param i
     * @return
     * @see android.widget.ExpandableListAdapter#getGroupId(int)
     */
    @Override
    public long getGroupId(int i) {
        return i;
    }

    /**
     * 获取指定组中的指定子元素ID
     *
     * @param i
     * @param i1
     * @return
     * @see android.widget.ExpandableListAdapter#getChildId(int, int)
     */
    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    /**
     * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
     *
     * @return
     * @see android.widget.ExpandableListAdapter#hasStableIds()
     */
    @Override
    public boolean hasStableIds() {
        return true;
    }

    /**
     * 获取显示指定组的视图对象
     *
     * @param i         组位置
     * @param b         该组是展开状态还是伸缩状态
     * @param view      重用已有的视图对象
     * @param viewGroup 返回的视图对象始终依附于的视图组
     * @return
     * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, android.view.View,
     * android.view.ViewGroup)
     */
    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        GroupHolder groupHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_simpleexpand_title, null);
            groupHolder = new GroupHolder();
            groupHolder.txt = (TextView) view.findViewById(R.id.tv_expandable_title);
            view.setTag(groupHolder);
        } else {
            groupHolder = (GroupHolder) view.getTag();
        }
        groupHolder.txt.setText(group_list.get(i));
        return view;
    }

    /**
     * 获取一个视图对象，显示指定组中的指定子元素数据。
     *
     * @param i         组位置
     * @param i1        子元素位置
     * @param b         子元素是否处于组中的最后一个
     * @param view      重用已有的视图(View)对象
     * @param viewGroup 返回的视图(View)对象始终依附于的视图组
     * @return
     * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
     * android.view.ViewGroup)
     */
    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ItemHolder itemHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_simpleexpand_content, null);
            itemHolder = new ItemHolder();
            itemHolder.txt = (TextView) view.findViewById(R.id.tv_expandable_content);
            view.setTag(itemHolder);
        } else {
            itemHolder = (ItemHolder) view.getTag();
        }
        itemHolder.txt.setText(item_lt.get(i1));
        return view;
    }

    /**
     * 是否选中指定位置上的子元素。
     *
     * @param i
     * @param i1
     * @return
     * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
     */
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    class GroupHolder {
        public TextView txt;
    }

    class ItemHolder {
        public TextView txt;
    }
}
