package org.larkinfo.desktop.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class pageController{
    info Data = new info();
	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping(value="/userName", method = RequestMethod.GET)
	public String info(Model mav, HttpServletRequest req) throws Exception{
		String userName = "init";
		userName = req.getParameter("userName");
		Data.setName(userName);
		String info = Data.getData();
		System.out.println("userName : " + userName);
		mav.addAttribute("data", info);
		System.out.println("userName : " + info);

		return "info";
	}
}