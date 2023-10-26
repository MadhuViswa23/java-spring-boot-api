package com.demo.hellospring.service;

import java.util.List;

import com.demo.hellospring.dto.DoctorDto;

import com.demo.hellospring.model.Doctor;


public interface DoctorService {
	boolean saveorupdate(DoctorDto dto);

	public List<Doctor> getAllDoctor();
	
	public String signUp( DoctorDto dto);
	public String signIn(String name, String password);
	
}
