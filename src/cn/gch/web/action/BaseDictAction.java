package cn.gch.web.action;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import cn.gch.domain.BaseDict;
import cn.gch.service.BaseDictService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseDictAction extends ActionSupport{
	private String dict_type_code;
	
	private BaseDictService baseDictService;
	
	

	@Override
	public String execute() throws Exception {
		List<BaseDict> list= baseDictService.getListByTypeCode(dict_type_code);
		//将list转换为json格式
		String json = JSONArray.fromObject(list).toString();
		//将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		
		return null;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	} 
}
