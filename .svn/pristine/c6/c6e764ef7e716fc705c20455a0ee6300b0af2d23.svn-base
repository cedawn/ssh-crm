package cn.gch.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.gch.dao.UserDao;
import cn.gch.domain.User;

public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

	@Override
	public User getUserByCodePassword(String user_code) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", user_code));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
}
