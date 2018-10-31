package com.hhy.maven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hhy.maven.po.User;
import com.hhy.maven.service.UserService;

@Controller
public class LoginController {
	
	@Autowired UserService userService;
	
	// 获取登录页
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		if (request.getSession().getAttribute("user") != null) {
			// session有值，登录过 直接跳转页面
			return new ModelAndView("redirect:/queryItems");
		}
		// 否则跳转登陆页
		return new ModelAndView("login");
	}
	
	// 请求登录
	@RequestMapping(value="/loginRequest",method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginRequest(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		if (userService.checkIsLogin(user)==true) {
			// 登录成功
			request.getSession().setAttribute("user", user);
			
			return new ModelAndView("redirect:/queryItems");
		}
		
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("message", "账号密码有误，请重新输入");
		return modelAndView;
	}
	
	// 退出登录
	@RequestMapping(value="/logoutRequest",method={RequestMethod.POST, RequestMethod.GET})
	public String logoutRequest(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {

		// 清除session
		request.getSession().invalidate();

		// 跳转登陆页
		return "redirect:/login";
	}
}
