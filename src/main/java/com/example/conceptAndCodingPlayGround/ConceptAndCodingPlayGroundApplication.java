package com.example.conceptAndCodingPlayGround;

import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
}
