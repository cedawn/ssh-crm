package cn.gch.test;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.gch.dao.UserDao;
import cn.gch.domain.Customer;
import cn.gch.domain.SaleVisit;
import cn.gch.domain.User;
import cn.gch.service.SaleVisitService;
import cn.gch.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory ;
	@Test
	public void fun2(){
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		//-------------------------------------------------
		User u = new User();
		
		u.setUser_code("jack");
		u.setUser_name("杰克");
		u.setUser_password("1234");
		
		session.save(u);
		
		//-------------------------------------------------
		tx.commit();
		
		session.close();
		
	}
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	//测试Dao Hibernate模板
	public void fun3(){
		
		User u = ud.getUserByCodePassword("jack");
		
		System.out.println(u.getUser_name());
	}
	@Resource(name="userService")
	private UserService us;
	@Test
	//测试aop事务
	public void fun4(){
		User u = new User();
		
		u.setUser_code("hqy");
		u.setUser_name("郝强勇");
		u.setUser_password("1234");
		
		
		us.save(u);
	}
	@Resource(name="saleVisitService")
	private SaleVisitService ss;
	@Test
	public void fun5(){
		
		SaleVisit saleVisit = new SaleVisit();
		
		
		saleVisit.setVisit_addr("111");
		Customer cust=new Customer();
		cust.setCust_id(2l);
		saleVisit.setCustomer(cust);
		User user=new User();
		user.setUser_id(1l);
		saleVisit.setUser(user);
		saleVisit.setVisit_time(new Date());
		ss.saveOrUpdate(saleVisit);
		
		//只能到这了，这可以，你看着办
	
	}
}
