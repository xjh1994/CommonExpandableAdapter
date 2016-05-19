package com.xjh194.commonexpandableadapter.inter;

import android.view.View;

public interface IChildViewHolder<C> {
	
	public  C getChildViewHolder();
	
	public  void initChildViewHolder(C holder, View view);
      
}
