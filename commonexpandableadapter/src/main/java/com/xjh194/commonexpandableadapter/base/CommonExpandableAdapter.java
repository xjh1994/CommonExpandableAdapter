package com.xjh194.commonexpandableadapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import com.xjh194.commonexpandableadapter.inter.IChildViewHolder;
import com.xjh194.commonexpandableadapter.inter.IExpandableListItem;
import com.xjh194.commonexpandableadapter.inter.IGroupViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public abstract class CommonExpandableAdapter<T, E> extends BaseExpandableListAdapter implements IExpandableListItem<T, E>, IGroupViewHolder<T>, IChildViewHolder<T> {

    private Context context;
    List<T> groupList;
    List<List<E>> childList;

    public CommonExpandableAdapter(Context context, List<T> groupList, List<List<E>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        T holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getGroupLayoutResId(), null);
            holder = getGroupViewHolder();
            initGroupViewHolder(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (T) convertView.getTag();
        }

        handleGroupData(holder, context, groupList.get(groupPosition), 0);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        T holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getchildLayoutResId(), null);
            holder = getChildViewHolder();
            initChildViewHolder(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (T) convertView.getTag();
        }

        handleChildData(holder, context, childList.get(groupPosition).get(childPosition), 0);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
