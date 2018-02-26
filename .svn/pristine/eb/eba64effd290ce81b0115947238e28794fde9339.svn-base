package cn.gch.service;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

import cn.gch.domain.Customer;
import cn.gch.utils.PageBean;

public interface CustomerService {

	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	

	public Customer getById(Long cust_id);

	public void saveOrUpdate(Customer customer);
	public void delete(Serializable id);

	

}
