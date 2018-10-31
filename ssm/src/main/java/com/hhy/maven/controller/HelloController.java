package com.hhy.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HelloController {
	@RequestMapping("/hello")
	public ModelAndView hello() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "张三");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}