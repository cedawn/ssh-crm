package cn.gch.service;

import cn.gch.domain.User;

public interface UserService {
	User getUserByCodePassword(User u);
	void save(User u);
}
