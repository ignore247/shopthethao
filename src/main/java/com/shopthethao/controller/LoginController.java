package com.shopthethao.controller;

import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.mail.Session;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopthethao.DAO.loginDAO;
import com.shopthethao.Entity.Accounts;
import com.shopthethao.Entity.Roles;

@Transactional
@Controller

public class LoginController {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	loginDAO loginDAO = new loginDAO();
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String sign_upPage(Model model) {

//		   Session session = factory.getCurrentSession();
//			String hql = "from test_thongtinEntity";
//			Query query = session.createQuery(hql);

		return "../../sign_up";
	}

	@RequestMapping(value = "/user-sign-up", method = RequestMethod.POST)
	public String sign_up(Model model, @RequestParam("email") String email, @RequestParam("password") String password) throws IllegalStateException, SystemException {
		
		System.out.println("đăng ký tài khoản");
		
		System.out.println(email);
		
		System.out.println(password);
		
		Roles role = new Roles("R002", "Customer");
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
        Date created_at = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		Accounts accounts = new Accounts(email,password,created_at,role);
		
		loginDAO.insert_account(accounts);
		
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
