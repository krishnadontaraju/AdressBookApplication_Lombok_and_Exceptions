package com.addressbook.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.employee.employeeapplication.EmployeeApplication;

import lombok.extern.slf4j.Slf4j;
import sun.util.logging.resources.logging;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		org.springframework.context.ApplicationContext context = SpringApplication.run(Application.class, args);
	       
		log.info("AddressBook Application Started in {} Environment" , ((ConfigurableApplicationContext) context).getEnvironment().getProperty("environment"));
	}

}
