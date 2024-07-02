package com.shopthethao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
  
   @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
   public ModelAndView homePage() {
      ModelAndView mav = new ModelAndView("home");
      return mav;
   }
   
   
   
   @ResponseBody
   @RequestMapping(value = "/springmvc", produces = "text/html; charset=UTF-8")
   public String springMVCPage(Model model) {
	   String message = "test đổi body";
       model.addAttribute("message", message);
       return message;
   }
}
