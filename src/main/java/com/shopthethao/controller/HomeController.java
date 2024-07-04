package com.shopthethao.controller;


import java.io.File;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import shopthethao.bean.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private UploadFile basePath;
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
	   
	  System.out.println(basePath.getBasePath());

      ModelAndView mav = new ModelAndView("home");
      return mav;
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
