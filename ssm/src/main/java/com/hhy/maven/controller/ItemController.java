package com.hhy.maven.controller;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hhy.maven.exception.CustomException;
import com.hhy.maven.po.Items;
import com.hhy.maven.service.ItemsService;

@Controller
public class ItemController {
	private static Logger logger = Logger.getLogger(ItemController.class);
	
	@Autowired ItemsService itemsService;
	
	// 查询列表
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(Items items) throws Exception {
		List<Items> itemList =itemsService.findItemsList(items);
		
		// 自定义全局异常处理
		if (StringUtils.isEmpty(itemList)) {
			throw new CustomException("没有更多产品");
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemList", itemList);
		modelAndView.setViewName("itemsList");
		return modelAndView;
	}
	
	// 添加产品页面
	@RequestMapping("/addItemView")
	public ModelAndView addItemView() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addItem");
		return modelAndView;
	}
	
	//  添加产品
	@RequestMapping("/addItem")
	public ModelAndView addItem(HttpServletRequest request, Items items, MultipartFile file) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String res = sdf.format(new Date());
		
		// uploads文件夹位置  这里设置了tomcat的图片虚拟目录在/Library/Java/imgServer，访问地址为http://localhost:8080/img/..
		String rootPath = "/Library/Java/imgServer";
		// 原始名称
		String originalFileName = file.getOriginalFilename();
		// 新文件名
		String newFileName = res + originalFileName.substring(originalFileName.lastIndexOf("."));
		// 创建年月文件夹
		Calendar date = Calendar.getInstance();
		File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

        // 新文件
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // 判断目标文件所在目录是否存在
        if(!newFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        // 将内存中的数据写入磁盘
        file.transferTo(newFile);
        // 完整的url
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
        
        // 设置产品插入时间
		SimpleDateFormat itemInserTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(new Date() + "  " + itemInserTime.format(new Date()));
		String itemInserTimeStr = itemInserTime.format(new Date());
        items.setCreatetime(itemInserTime.parse(itemInserTimeStr));
        
        // 设置图片路径
        items.setPic(fileUrl);
        itemsService.insertItem(items);
        
        return new ModelAndView("redirect:/queryItems");
		
	}
}





















