package cn.gch.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.gch.dao.LinkManDao;
import cn.gch.domain.Customer;
import cn.gch.domain.LinkMan;
import cn.gch.service.LinkManService;
import cn.gch.utils.PageBean;

public class LinkManServiceImp implements LinkManService {
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	@Override
	public void saveOrUpdate(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);
		System.out.println("xxxxxx");
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize) {
		Integer totalCount = linkManDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage,pageSize,totalCount);
		
		List<LinkMan> list=linkManDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	@Override
	public LinkMan getById(Long lkm_id) {
		
		return linkManDao.getByid(lkm_id);
	}
	@Override
	public void delete(Long lkm_id) {
		linkManDao.delete(lkm_id);
	}
	
	
}
