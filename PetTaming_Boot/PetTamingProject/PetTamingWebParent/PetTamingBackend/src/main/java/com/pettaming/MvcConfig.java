package com.pettaming;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		String dirName = "User-photos";
		Path userPhotosDir = Paths.get(dirName);
		
		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/" + dirName + "/**")
		.addResourceLocations("file:/" + userPhotosPath + "/");
		
//		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
//		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
//		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/asserts/");
//		
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
		
	}

}
