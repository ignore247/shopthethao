package com.shopthethao.controller;

import javax.mail.Session;
import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Controller

public class LoginController {

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String sign_upPage(Model model) {
		   
//		   Session session = factory.getCurrentSession();
//			String hql = "from test_thongtinEntity";
//			Query query = session.createQuery(hql);
			
		   
	      return "../../sign_up";
	   }
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String sign_up(Model model) {
		   
		   Session session = factory.getCurrentSession();
			String hql = "from test_thongtinEntity";
			Query query = session.createQuery(hql);
			
		   
	      return "../../sign_up";
	   }
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String sign_inPage(Model model) {
		   	
		   
	      return "../../sign_in";
	 }
	
	@RequestMapping(value = "/reset-password", method = RequestMethod.GET)
	public String reset_passwordPage(Model model) {
		   	
		   
	      return "/users/reset_password";
	   }
}
