package cn.gch.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.gch.dao.BaseDao;
import cn.gch.domain.Customer;

public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;//用于接收运行期泛型类型
	
	public BaseDaoImp() {
		//获得当前类型的带有泛型类型的父类
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得运行期的泛型类型
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}
	@Override
	public void save(T t) {
		System.out.println("ssddsdsd");
		getHibernateTemplate().save(t);
		System.out.println(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getByid(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getByid(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		if(list!=null&&list.size()>0){
			Long t = (Long) list.get(0);
			return t.intValue();
		}else{
			return null;
		}
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, int start, Integer pageSize) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return list;
	}
	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

}
