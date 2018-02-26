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
			throw new RuntimeException("�Ñ���������");
		}else if(!exitU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("�ܴa�e�`");
		}
		return exitU;
	}

	@Override
	public void save(User u) {
		User user = userDao.getUserByCodePassword(u.getUser_code());
		
		if(user!=null){
			throw new RuntimeException("�û����Ѵ���");
		}else{
			userDao.save(u);
	
		}
		}

}
