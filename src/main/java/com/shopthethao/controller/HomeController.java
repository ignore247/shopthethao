package com.shopthethao.controller;


import java.io.File;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.shopthethao.DAO.testDAO;
import com.shopthethao.Entity.test_thongtinEntity;
import com.shopthethao.bean.UploadFile;

@Transactional
@Controller
public class HomeController {
	
	@Autowired
	private UploadFile basePath;
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	testDAO temp = new testDAO();
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public String homePage(Model model) {
	   
//	   Session session = factory.getCurrentSession();
//		String hql = "from test_thongtinEntity";
//		Query query = session.createQuery(hql);
		
	   
      return "home";
   }
   
   
   @RequestMapping(value = "/phan-trang", method = RequestMethod.GET)
   public String pagination(Model model,HttpServletRequest request) {
	   
	 
	   List<test_thongtinEntity> list = temp.laytt();
	   PagedListHolder pagedListHolder = new PagedListHolder(list);
	   int page = ServletRequestUtils.getIntParameter(request, "p", 0);
	   pagedListHolder.setPage(page);
	   pagedListHolder.setMaxLinkedPages(5);
	   pagedListHolder.setPageSize(5);
	   System.out.println(pagedListHolder);
	   model.addAttribute("pagedListHolder",pagedListHolder);
     
      return "pagination";
   }
   
   
   
   @ResponseBody
   @RequestMapping(value = "/springmvc", produces = "text/html; charset=UTF-8")
   public String springMVCPage(Model model) {
	   String message = "test đổi body";
       model.addAttribute("message", message);
       return "<h1>test đổi body</h1>";
   }
   
   
   @RequestMapping("upload")
   public String upload (Model model, @RequestParam("image") MultipartFile image) {
	   if (image.isEmpty()) {
		   model.addAttribute("message","Vui lòng chọn file!");
	   }
	   else
	   {
		   try {
				
			   		
			    String pathImage = basePath.getBasePath() + File.separator + image.getOriginalFilename();
				
				  String path = "./resources/image/" + image.getOriginalFilename();
				  System.out.println(path); 
				  image.transferTo(new File (pathImage));
				  
				  Thread.sleep(2500);
				  model.addAttribute("path", path);
				 
			} catch (Exception e) {
				 model.addAttribute("message","Lỗi!");
			}
	   }
	   return "home";
   }
}
