package com.hhy.maven.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hhy.maven.mapper.UserMapper;
import com.hhy.maven.po.User;
import com.hhy.maven.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired UserMapper userMapper;
	
	public boolean checkIsLogin(User user) throws Exception {
		
		User loginUser = (User)userMapper.findLoginUser(user);
		if (!StringUtils.isEmpty(loginUser) && loginUser!=null) {
			// 查到用户 
			
			return true;
		}
		return false;
	}

}
