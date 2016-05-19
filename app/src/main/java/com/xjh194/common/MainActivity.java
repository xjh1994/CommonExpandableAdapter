package com.xjh194.common;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
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
        initHeaderAdapter();
        commonExpandableAdapter = new CommonExpandableAdapter<String, String, GroupHolder, ChildHolder>(this, groupList, childList) {

            @Override
            public int getGroupLayoutResId() {
                return R.layout.item_group;
            }

            @Override
            public int getchildLayoutResId() {
                return R.layout.item_child;
            }

            @Override
            public GroupHolder getGroupViewHolder() {
                return new GroupHolder();
            }

            @Override
            public ChildHolder getChildViewHolder() {
                return new ChildHolder();
            }

            @Override
            public void initGroupViewHolder(GroupHolder holder, View view) {
                holder.textView = (TextView) view.findViewById(R.id.textView);
            }

            @Override
            public void initChildViewHolder(ChildHolder holder, View view) {
                holder.textView = (TextView) view.findViewById(R.id.textView);
            }

            @Override
            public void handleGroupData(GroupHolder holder, Context context, String data, int type) {
                holder.textView.setText((data));
            }

            @Override
            public void handleChildData(ChildHolder holder, Context context, String data, int type) {
                holder.textView.setText((data));
            }
        };

        expandableListView.setAdapter(commonExpandableAdapter);

        int size = commonExpandableAdapter.getGroupCount();
        for (int i = 0; i < size; i++) {
            expandableListView.expandGroup(i);
        }
    }

    private void initHeaderAdapter() {
        View view = LayoutInflater.from(this).inflate(R.layout.header_expandable, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("头部");
        expandableListView.addHeaderView(view);
    }

    class GroupHolder {
        public TextView textView;
    }

    class ChildHolder {
        public TextView textView;
    }
}
