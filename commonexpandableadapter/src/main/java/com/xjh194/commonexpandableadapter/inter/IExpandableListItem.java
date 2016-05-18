package com.xjh194.commonexpandableadapter.inter;

import android.content.Context;
import android.support.annotation.LayoutRes;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface IExpandableListItem<T, E> {
    @LayoutRes
    int getGroupLayoutResId();

    @LayoutRes
    int getchildLayoutResId();

    void handleGroupData(T holder, Context context, T data, int type);

    void handleChildData(T holder, Context context, E data, int type);
}
