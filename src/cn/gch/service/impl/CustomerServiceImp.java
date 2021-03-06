package cn.gch.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import cn.gch.dao.CustomerDao;
import cn.gch.domain.Customer;
import cn.gch.service.CustomerService;
import cn.gch.utils.PageBean;

public class CustomerServiceImp implements CustomerService {
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		Integer totalCount=customerDao.getTotalCount(dc);
		
		PageBean pb = new PageBean(currentPage,pageSize,totalCount);
		System.out.println("xzzxc");
		List<Customer> list=customerDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}

	

	@Override
	public Customer getById(Long cust_id) {
		
		return customerDao.getByid(cust_id);
	}

	public void saveOrUpdate(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}

	@Override
	public void delete(Serializable id) {
		customerDao.delete(id);
	}

}
