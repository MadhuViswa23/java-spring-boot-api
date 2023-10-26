package com.demo.hellospring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hellospring.dto.DoctorDto;

import com.demo.hellospring.model.Doctor;

import com.demo.hellospring.service.DoctorService;

@RestController

public class DoctorController {
	@Autowired
	DoctorService  doctorService ;
	@PostMapping("/registerdoctor")
	 public boolean Savorupdate (@RequestBody DoctorDto dto) {
		return doctorService.saveorupdate(dto) ;
		 
	
	}
	@GetMapping("/getAlldoctor") 
	 public List<Doctor> getAllPatient(){
		 return doctorService.getAllDoctor();
		 
    }
	@PostMapping("/signupdoctor")
	public String  signUp (@RequestBody DoctorDto dto) {
		return doctorService.signUp(dto) ;
	}
	@PostMapping("/signindoctor")
	public String signIn(@RequestParam String password, String email) {
		return doctorService.signIn(email,password);
	}
}
