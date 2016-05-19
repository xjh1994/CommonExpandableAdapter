package com.xjh194.commonexpandableadapter.inter;

import android.content.Context;
import android.support.annotation.LayoutRes;

/**
 * Created by Administrator on 2016/5/18.
 */
public interface IExpandableListItem<G, C, T, E> {
    @LayoutRes
    int getGroupLayoutResId();

    @LayoutRes
    int getchildLayoutResId();

    void handleGroupData(G holder, Context context, T data, int type);

    void handleChildData(C holder, Context context, E data, int type);
}
