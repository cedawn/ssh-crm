package cn.gch.service.impl;

import javax.management.RuntimeErrorException;

import cn.gch.dao.UserDao;
import cn.gch.domain.User;
import cn.gch.service.UserService;

public class UserServiceImp implements UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserByCodePassword(User u) {
		User exitU = userDao.getUserByCodePassword(u.getUser_code());
		if(exitU==null){
			throw new RuntimeException("用戶名不存在");
		}else if(!exitU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密碼錯誤");
		}
		return exitU;
	}

	@Override
	public void save(User u) {
		User user = userDao.getUserByCodePassword(u.getUser_code());
		
		if(user!=null){
			throw new RuntimeException("用户名已存在");
		}else{
			userDao.save(u);
	
		}
		}

}
