package com.xjh194.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.xjh194.commonexpandableadapter.base.CommonExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private List<String> groupList = new ArrayList<>();
    private List<List<String>> childList = new ArrayList<>();
    private CommonExpandableAdapter commonExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initAdapter();
    }

    private void initView() {
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
    }

    private void initData() {
        groupList.add("目录1");
        groupList.add("目录2");
        groupList.add("目录3");
        groupList.add("目录4");

        List<String> tempStringList = new ArrayList<>();
        tempStringList.add("子目录1");
        tempStringList.add("子目录2");
        tempStringList.add("子目录3");
        tempStringList.add("子目录4");
        childList.add(tempStringList);
        childList.add(tempStringList);
        childList.add(tempStringList);
        childList.add(tempStringList);
    }

    private void initAdapter() {
        commonExpandableAdapter = new CommonExpandableAdapter(this, groupList, childList) {

            @Override
            public int getGroupLayoutResId() {
                return R.layout.item_group;
            }

            @Override
            public int getchildLayoutResId() {
                return R.layout.item_child;
            }

            @Override
            public Object getGroupViewHolder() {
                return new GroupHolder();
            }

            @Override
            public Object getChildViewHolder() {
                return new ChildHolder();
            }

            @Override
            public void initGroupViewHolder(Object holder, View view) {
                ((GroupHolder) holder).textView = (TextView) view.findViewById(R.id.textView);
            }

            @Override
            public void initChildViewHolder(Object holder, View view) {
                ((ChildHolder) holder).textView = (TextView) view.findViewById(R.id.textView);
            }

            @Override
            public void handleGroupData(Object holder, Context context, Object data, int type) {
                ((GroupHolder) holder).textView.setText(((String) data));
            }

            @Override
            public void handleChildData(Object holder, Context context, Object data, int type) {
                ((ChildHolder) holder).textView.setText(((String) data));
            }
        };
        expandableListView.setAdapter(commonExpandableAdapter);

        int size = commonExpandableAdapter.getGroupCount();
        for (int i = 0; i < size; i++) {
            expandableListView.expandGroup(i);
        }
    }

    class GroupHolder {
        public TextView textView;
    }

    class ChildHolder {
        public TextView textView;
    }
}
