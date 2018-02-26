package cn.gch.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.gch.domain.Customer;
import cn.gch.domain.LinkMan;
import cn.gch.service.LinkManService;
import cn.gch.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan=new LinkMan();
	private LinkManService linkManService;
	
	private Integer currentPage;
	private Integer pageSize;
	public String delete() throws Exception{
		linkManService.delete(linkMan.getLkm_id());
		return "delete";
	}
	public String list() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		
		if(StringUtils.isNotBlank(linkMan.getLkm_name())){
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		PageBean pb=linkManService.getPageBean(dc,currentPage,pageSize);
		ActionContext.getContext().put("pageBean", pb);
		
		return "list";		
	}

	public String add() throws Exception{
		linkManService.saveOrUpdate(linkMan);
		System.out.println("xxxxxxxxx");
		return "toList";
	}
	public String toEdit() throws Exception{
		LinkMan lkm=linkManService.getById(linkMan.getLkm_id());
		ActionContext.getContext().put("linkMan", lkm);
		return "edit";
	}
	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	
	
	
	
	@Override
	public LinkMan getModel() {
		
		return linkMan;
	}
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
}
