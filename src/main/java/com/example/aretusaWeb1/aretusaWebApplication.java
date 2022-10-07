package com.example.aretusaWeb1;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class aretusaWebApplication implements ApplicationContextAware {


	public static ApplicationContext context;
	public static void main(String[] args) {

		SpringApplication.run(aretusaWebApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		aretusaWebApplication.context = applicationContext;
	}

	static public ApplicationContext getContext(){
		return aretusaWebApplication.context;
	}
}
