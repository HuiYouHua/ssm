package com.hhy.maven.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hhy.maven.po.User;

public class LoginInterceptor implements HandlerInterceptor {

	//进入 Handler方法之前执行
    //用于身份认证、身份授权
    //比如身份认证，如果认证通过表示当前用户没有登陆，需要此方法拦截不再向下执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 获取请求的url
		String url = request.getRequestURI();
		
		// 如果该请求时登录请求则放行
		if (url.indexOf("login") >= 0) {
			return true;
		}
		
		// 其他的请求则判断该用户是否登录，否则跳转登陆页面
		HttpSession session = request.getSession();
		// 从session中取出用户信息
		Object user = (Object)session.getAttribute("user");
		if (!StringUtils.isEmpty(user)) {
			// 登录  放行
			return true;
		}
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		return false;
	}

	//进入Handler方法之后，返回modelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里传到视图，也可以在这里统一指定视图
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//执行Handler完成执行此方法
    //应用场景：统一异常处理，统一日志处理
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
