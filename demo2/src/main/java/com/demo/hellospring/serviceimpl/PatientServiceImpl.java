package com.demo.hellospring.serviceimpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.demo.hellospring.dto.PatientDto;

import com.demo.hellospring.model.Patient;

import com.demo.hellospring.repository.PatientRepository;
import com.demo.hellospring.service.PatientService;



@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepository patientRepository;
	@Override
	public boolean saveorupdate(PatientDto patientdto) {
	
		Patient pt = new Patient();
		pt.setPtid(patientdto.getPtid());
		pt.setPtname(patientdto.getPtname());
		pt.setPtphone(patientdto.getPtphone());
		pt.setAge(patientdto.getAge());
		pt.setGender(patientdto.getGender());
		pt.setMedicalcondition(patientdto.getMedicalcondition());
		patientRepository.save(pt);
		return true;
	}
	@Override
	public List<Patient> getAllPatient() {
		List<Patient> product=patientRepository.findAll();
		return product;
	}
	
}

