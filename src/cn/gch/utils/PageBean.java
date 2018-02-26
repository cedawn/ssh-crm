package cn.gch.utils;

import java.util.List;

public class PageBean {
	//当前页数
	private Integer currentPage;
	//总页数
	private Integer totalPage;
	//每页显示条数
	private Integer pageSize;
	//总记录数
	private Integer totalCount;
	//分页列表数据
	private List list;
		
	public PageBean(Integer currentPage, Integer pageSize, Integer totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		if(this.currentPage==null){
			this.currentPage=1;
		}
		if(this.pageSize==null){
			this.pageSize=3;
		}
		
		this.totalPage=(this.totalCount+this.pageSize-1)/this.pageSize;
		if(this.currentPage<1){
			this.currentPage=1;
		}
		if(this.currentPage>this.totalPage){
			this.currentPage=this.totalPage;
		}
	}
	public int getStart(){
		return (this.currentPage-1)*this.pageSize;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
	
}
