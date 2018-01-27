package com.king.timenotes;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.king.timenotes.jdbc.entity.UserInfo;
import com.king.timenotes.jdbc.service.UserInfoService;


@SpringBootApplication
@RestController
public class TimeNotesApplication {
	
	@Value("${helloWorld}")
	private String helloWorld;
	
	private static final Logger logger = LoggerFactory.getLogger(TimeNotesApplication.class);
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@Autowired
    private UserInfoService userInfoService;

	@RequestMapping("/hello")
	public String hello() {
		return helloWorld;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(TimeNotesApplication.class, args);
	}
}
