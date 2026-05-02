package com.example.conceptAndCodingPlayGround;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ConceptAndCodingPlayGroundApplication implements WebMvcConfigurer {

	public static void main(String[] args) {

		SpringApplication.run(ConceptAndCodingPlayGroundApplication.class, args);
	}

	@Autowired
	MyCustomInterceptor1 myCustomInterceptor1;

	@Autowired
	MyCustomInterceptor2 myCustomInterceptor2;

	@Override
	public void addInterceptors(@NonNull InterceptorRegistry registry){
		registry.addInterceptor(myCustomInterceptor1)
				.addPathPatterns("/*")
				.excludePathPatterns("/api/updateUser");

		registry.addInterceptor(myCustomInterceptor2)
				.addPathPatterns("/*")
				.excludePathPatterns("/api/updateUser");
	}

	@Bean
	public FilterRegistrationBean<MyFilter1> myFilter1(){
		FilterRegistrationBean<MyFilter1> myFilterRegistrationBean = new FilterRegistrationBean<>();
		myFilterRegistrationBean.setFilter(new MyFilter1());
		myFilterRegistrationBean.addUrlPatterns("/*");
		myFilterRegistrationBean.setOrder(2);
		return myFilterRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean<MyFilter2> myFilter2(){
		FilterRegistrationBean<MyFilter2> myFilter2FilterRegistrationBean = new FilterRegistrationBean<>();
		myFilter2FilterRegistrationBean.setFilter(new MyFilter2());
		myFilter2FilterRegistrationBean.addUrlPatterns("/*");
		myFilter2FilterRegistrationBean.setOrder(1);
		return myFilter2FilterRegistrationBean;
	}
}
