package cn.gch.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.gch.dao.SaleVisitDao;
import cn.gch.domain.Customer;
import cn.gch.domain.SaleVisit;
import cn.gch.service.SaleVisitService;
import cn.gch.utils.PageBean;

public class SaleVisitServiceImp implements SaleVisitService {
	private  SaleVisitDao saleVisitDao;
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	@Override
	public void saveOrUpdate(SaleVisit saleVisit) {
		saleVisitDao.saveOrUpdate(saleVisit);
	}
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		Integer totalCount = saleVisitDao.getTotalCount(dc);
		//2 ����PageBean����
		
		PageBean pb = new PageBean(currentPage,pageSize,totalCount);
		//3 ����Dao��ѯ��ҳ�б�����
		
		List<SaleVisit> list=saleVisitDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		//4 �б����ݷ���pageBean��.������
		pb.setList(list);
		return pb;
	}
	@Override
	public void delete(String visit_id) {
		saleVisitDao.delete(visit_id);
	}
	@Override
	public SaleVisit getById(String visit_id) {
		return saleVisitDao.getByid(visit_id);
	}
	

}
