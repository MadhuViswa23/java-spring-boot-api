package com.demo.hellospring.service;

import java.util.List;


import com.demo.hellospring.dto.PatientDto;
import com.demo.hellospring.model.Patient;


public interface PatientService {
	



	boolean saveorupdate(PatientDto dto);

	public List<Patient> getAllPatient();

}
