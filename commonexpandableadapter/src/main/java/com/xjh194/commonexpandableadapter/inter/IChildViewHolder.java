package com.xjh194.commonexpandableadapter.inter;

import android.view.View;

public interface IChildViewHolder<T> {
	
	public  T getChildViewHolder();
	
	public  void initChildViewHolder(T holder, View view);
      
}
