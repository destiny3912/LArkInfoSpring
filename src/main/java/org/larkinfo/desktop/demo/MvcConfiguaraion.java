package org.larkinfo.desktop.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguaraion implements WebMvcConfigurer{
    
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry){

        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/templates")
            .setCacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS));
    }
}
