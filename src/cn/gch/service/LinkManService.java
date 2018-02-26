package cn.gch.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.gch.domain.LinkMan;
import cn.gch.utils.PageBean;

public interface LinkManService {

	void saveOrUpdate(LinkMan linkMan);

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage,
			Integer pageSize);

	LinkMan getById(Long lkm_id);

	void delete(Long lkm_id);

	

}
