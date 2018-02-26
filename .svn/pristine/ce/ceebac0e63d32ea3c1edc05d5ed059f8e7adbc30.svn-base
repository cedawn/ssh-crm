package cn.gch.web.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.gch.domain.SaleVisit;
import cn.gch.domain.User;
import cn.gch.service.SaleVisitService;
import cn.gch.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit=new SaleVisit();
	private SaleVisitService saleVisitService;
	public String delete() throws Exception{
		saleVisitService.delete(saleVisit.getVisit_id());
		return "delete";
	}
	public String toEdit() throws Exception{
		SaleVisit sv = saleVisitService.getById(saleVisit.getVisit_id());
		ActionContext.getContext().put("saleVisit", sv);
		return "edit";
	}
	public String add() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVisit.setUser(u);
		saleVisitService.save(saleVisit);
		return "toList";
	}
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception{
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		if(saleVisit.getCustomer()!=null&&saleVisit.getCustomer().getCust_id()!=null){
			dc.add(Restrictions.eq("customer.cust_id", saleVisit.getCustomer().getCust_id()));
		}
		PageBean pb = saleVisitService.getPageBean(dc,currentPage,pageSize);
		//2 将PageBean放入request域,转发到列表页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
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
	public SaleVisit getModel() {
		
		return saleVisit;
	}
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
	
	

}
