package com.hhy.maven.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {
	
	/**
	 * 系统中异常包括两类
	 * 预期异常
	 * 运行时异常RuntimeException
	 * 前者通过捕获异常从而获取异常信息，后者主要通过规范代码开发、测试通过手段减少运行时异常的发生。
	 * 系统的dao、service、controller出现都通过throws Exception向上抛出，最后由springmvc前端控制器交由异常处理器进行异常处理
	 * @param request
	 * @param response
	 * @param handle
	 * @param ex
	 * @return
	 */
	public ModelAndView resolveException(HttpServletRequest request, 
											HttpServletResponse response,
											Object handle,
											Exception ex) {
		CustomException customException;
		/**
		 * 如果该异常类型是系统自定义异常，则直接取出异常信息，在错误页面展示
		 * 否则构造一个自定义的异常类型，显示错误信息为位置错误
		 */
		if (ex instanceof CustomException) {
			// 自定义异常
			customException = (CustomException)ex;
		} else {
			customException = new CustomException("未知错误");
		}
		
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("message", message);
		return modelAndView;
 	}
}
