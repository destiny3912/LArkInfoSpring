package org.larkinfo.desktop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class DemoApplication {
	@Bean
    public ViewResolver viewResolver() {
        //기본 뷰 리졸버에
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //prefix, suffix를 set하고
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".html");
        //그 뷰 리졸버를 등록
        return viewResolver;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
