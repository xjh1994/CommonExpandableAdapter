# CommonExpandableAdapter
ExpandableListView(可展开的列表组件)通用Adapter

# 截图
<img src="https://github.com/xjh1994/CommonExpandableAdapter/blob/master/screenshot.png" width = "30%" height = "30%" alt="截图" />

# 使用
详细代码见MainActivity.java。
`
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
`
创建ViewHolder
`
class GroupHolder {
    public TextView textView;
}

class ChildHolder {
    public TextView textView;
}
`

