package com.hhy.maven.mapper;

import com.hhy.maven.po.User;

public interface UserMapper {
	
	/**
	 * 根据用户信息查找用户
	 * @param user
	 * @return 用户
	 * @throws Exception
	 */
	public User findLoginUser(User user) throws Exception;
	
}
