package com.demo.hellospring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hellospring.dto.PatientDto;
import com.demo.hellospring.model.Patient;

import com.demo.hellospring.service.PatientService;



@RestController
public class PatientController {
	@Autowired
	PatientService  patientService ;
	@PostMapping("/register")
	 public boolean Savorupdate (@RequestBody PatientDto dto) {
		return patientService.saveorupdate(dto) ;
		 
	
	 }
	@GetMapping("/getAllpatient") 
	 public List<Patient> getAllPatient(){
		 return patientService.getAllPatient();
		 
     }
}



	
	
	

	 
