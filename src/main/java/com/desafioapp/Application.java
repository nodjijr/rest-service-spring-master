package com.desafioapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.desafioapp.data.CSVToH2;
import com.desafioapp.exception.HandlerMappingFilterBadRequest;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		CSVToH2 file = new CSVToH2();
		System.out.println("H2: " + file.loadCSVToH2());
	}

	@Bean
	@Autowired
	FilterRegistrationBean listHandlers(RequestMappingHandlerMapping requestMappingHandlerMapping) {
		FilterRegistrationBean register = new FilterRegistrationBean();
		register.setFilter(new HandlerMappingFilterBadRequest(requestMappingHandlerMapping));
		register.setName("handlerListFilter");
		register.setUrlPatterns(Arrays.asList(new String[] { "/*" }));
		register.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return register;
	}

}
