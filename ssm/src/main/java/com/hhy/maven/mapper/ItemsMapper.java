package com.hhy.maven.mapper;

import java.util.List;

import com.hhy.maven.po.Items;

public interface ItemsMapper {

	/**
	 * 查找产品列表
	 * @param items 查询的产品关键词，封装成po
	 * @return 产品列表
	 * @throws Exception
	 */
	public List<Items> findItemsList(Items items) throws Exception;
	
	public void insertItem(Items items) throws Exception;
}
