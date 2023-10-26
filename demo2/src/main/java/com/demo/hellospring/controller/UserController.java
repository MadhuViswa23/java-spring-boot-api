package com.demo.hellospring.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hellospring.dto.UserDto;
import com.demo.hellospring.model.User;
import com.demo.hellospring.service.UserService;

	
@RestController
public class UserController {
	
	@Autowired
	UserService  userService ;
	
	
	@PostMapping("/saveorup")
	 public boolean Savorupdate (@RequestBody UserDto dto) {
		return userService.saveorupdate(dto) ;
		 
	
	 }
	
	@GetMapping("/dele")
	 public boolean deleteUserById(int id) {
		 return userService.deleteUserByID(id);
	 }
	 
	@GetMapping("/getAll") 
	 public List<User>getAllUser(){
		 return userService.getAllUser();
		 
      }
	 
	@GetMapping("/getBy")
	 public Optional<User>getById(int id){
		 return userService.getByID(id);
		 
     }
	
	@PostMapping("/signup")
	public String signUp(@RequestBody UserDto dto) {
		return userService.signUp(dto);
	}
	
	@PostMapping("/signin")
	public String signIn(@RequestParam String password, String mail) {
		return userService.signIn(mail,password);
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam("to") String to, @RequestParam("textBody") String textBody,
			@RequestParam("topic") String topic) {
		return userService.sendEmail(to, textBody, topic);
	}

}
	

