package com.hhy.maven.service;

import java.util.List;

import com.hhy.maven.po.Items;

public interface ItemsService {
	
	// 查询列表
	public List<Items> findItemsList(Items items) throws Exception;
	
	// 插入数据
	public void insertItem(Items items) throws Exception;

}
