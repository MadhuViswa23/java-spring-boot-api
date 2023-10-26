package com.demo.hellospring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.hellospring.model.Doctor;
import com.demo.hellospring.model.Patient;



public interface PatientRepository extends JpaRepository<Patient, Integer> {
//	@Query(value = "SELECT id, name,  age, gender, phoneFROM patient " +
//            "UNION " +
//            "SELECT dtid, dtname, specialization,email FROM doctor", nativeQuery = true)
//List<Object[]> mergePatientAndDoctorData();
	@Query(nativeQuery = true, value = "SELECT ptid, ptname, age, gender, medicalcondition, ptphone FROM patient " +
	        "UNION " +
	        "SELECT id, name, specialization,email,age,gender dtphone FROM doctor")
	List<Object[]> mergePatientAndDoctorData();

	List<Doctor> findByPtname(String ptname);


}
