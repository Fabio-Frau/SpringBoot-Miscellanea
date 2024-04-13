package com.fabiofrau.Project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.Collections;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		var app = new SpringApplication(Project1Application.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "test"));
		var ctx = app.run(args);

		MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
		System.out.println(myFirstService.tellAStory());
		System.out.println(myFirstService.getJavaVersione());
		System.out.println(myFirstService.getOsName());
		System.out.println(myFirstService.readProp());
		System.out.println(myFirstService.getCustomPropFromAnotherFile());
		System.out.println(myFirstService.getCustomPropFromAnotherFile2());
		System.out.println(myFirstService.getCustomProperty());


	}



}
