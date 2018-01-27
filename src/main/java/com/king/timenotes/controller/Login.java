package com.king.timenotes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.king.timenotes.jdbc.entity.Note;
import com.king.timenotes.jdbc.entity.UserInfo;
import com.king.timenotes.jdbc.service.UserInfoService;

@RestController
public class Login {
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	@Autowired
    private UserInfoService userInfoService;
	
	@RequestMapping("/login")
    public List<UserInfo> login(@RequestParam(value="username",required=true) String username,@RequestParam(value="password",required=true) String password){
        return userInfoService.login(username,password);
    }

	@RequestMapping("/queryNotes")
    public List<Note> queryNotes(@RequestParam(value="username",required=true) String username){
        return userInfoService.queryNotes(username);
    }
	
	@RequestMapping("/addNote")
    public String addNote(@RequestParam(value="username",required=true) String username,@RequestParam(value="title") String title,@RequestParam(value="content") String content){
        userInfoService.addNote(username,title,content);
        String result = "success";
        return result;
    }

}
