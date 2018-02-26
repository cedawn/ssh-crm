package cn.gch.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.gch.domain.User;
import cn.gch.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	public User user=new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String login() throws Exception {
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		System.out.println("2222222");
		return "tohome";
	}
	public String regist() throws Exception{
		try{
		userService.save(user);
		}catch(Exception e){
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		return "toLogin";
	}
	@Override
	public User getModel() {
		
		return user;
	}
	
}
