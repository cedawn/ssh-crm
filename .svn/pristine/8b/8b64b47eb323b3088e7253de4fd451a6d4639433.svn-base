package cn.gch.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.gch.domain.LinkMan;
import cn.gch.domain.SaleVisit;
import cn.gch.utils.PageBean;

public interface SaleVisitService {
	public void saveOrUpdate(SaleVisit saleVisit);
	public void save(SaleVisit saleVisit);
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);
	public void delete(String visit_id);
	public SaleVisit getById(String visit_id);
}
