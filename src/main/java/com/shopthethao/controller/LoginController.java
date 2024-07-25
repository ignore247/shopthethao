package com.shopthethao.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.mail.Session;
import javax.transaction.SystemException;
import javax.transaction.Transactional;

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
		
		Roles role = new Roles("R002", "Customer");
		
		LocalDate localDate = LocalDate.now();
		
        Date created_at = Date.valueOf(localDate);
		
		Accounts accounts = new Accounts(email,password,created_at,role);
		
		loginDAO loginDAO = new loginDAO();
		
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
