package com.hhy.maven.service;

import com.hhy.maven.po.User;

public interface UserService {
	
	/**
	 * 查看用户是否登录
	 * @param user
	 * @return true/登录  false/未登录
	 * @throws Exception
	 */
	public boolean checkIsLogin(User user) throws Exception;
}
