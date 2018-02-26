package cn.gch.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	void saveOrUpdate(T t);
	void save(T t);
	
	void delete(T t);
	
	void delete(Serializable id);
	
	void update(T t);
	T getByid(Serializable id);
	Integer getTotalCount(DetachedCriteria dc);
	List<T> getPageList(DetachedCriteria dc, int start, Integer pageSize);

}
