package com.hhy.maven.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hhy.maven.po.Items;
import com.hhy.maven.service.ItemsService;

@Controller
public class JsonTestController {
	
	@Autowired ItemsService itemsService;
	
	
	@RequestMapping("/json")
	public ModelAndView json() throws Exception {		
		
		return new ModelAndView("jsonTest");
	}
	
	//请求json串(商品信息)，输出json(商品信息)
	//@RequestBody将请求的商品信息的json串转成items对象
	//@ResponseBody将items转成json输出
	@RequestMapping("/requestJson")
	public @ResponseBody List<Items> requestJson(@RequestBody Items items) throws Exception {
		
		List<Items> itemList =itemsService.findItemsList(items);
		

		//@ResponseBody将items转成json输出
		return itemList;
	}
	
	
	 //请求key/value，输出json
	@RequestMapping("/responseJson")
	public @ResponseBody Items responseJson(Items items){

	    //@ResponseBody将items转成json输出
	    return items;
	}
}



