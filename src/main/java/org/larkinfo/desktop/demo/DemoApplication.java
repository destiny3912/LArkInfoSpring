package org.larkinfo.desktop.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@SpringBootApplication
public class DemoApplication {
	@Bean
    public ViewResolver viewResolver() {
        //기본 뷰 리졸버에
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //prefix, suffix를 set하고
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        //그 뷰 리졸버를 등록
        return viewResolver;
    }

	info Data = new info();

	@RequestMapping(value="/userName", method = RequestMethod.GET)
	public ModelAndView info(ModelAndView mav, HttpServletRequest req) throws Exception{
		String userName = "init";
		userName = req.getParameter("userName");
		Data.setName(userName);
		String info = Data.getData();
		System.out.println("userName : " + userName);
		mav.setViewName("info");
		mav.addObject("data", info);
		System.out.println("userName : " + info);

		return mav;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
