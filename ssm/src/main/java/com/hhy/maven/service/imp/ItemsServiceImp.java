package com.hhy.maven.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhy.maven.mapper.ItemsMapper;
import com.hhy.maven.po.Items;
import com.hhy.maven.service.ItemsService;

@Service("itemsService")
public class ItemsServiceImp implements ItemsService {

	
	@Autowired
	private ItemsMapper itemsMapper;

	
	public List<Items> findItemsList(Items items) throws Exception {
		
		return itemsMapper.findItemsList(items);
	}


	public void insertItem(Items items) throws Exception {

		itemsMapper.insertItem(items);
	}

}
