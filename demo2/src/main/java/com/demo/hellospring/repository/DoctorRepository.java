package com.demo.hellospring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.hellospring.model.Doctor;





public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	@Query(nativeQuery = true, value = "SELECT ptid, ptname, age, gender, medicalcondition, ptphone FROM patient " +
	        "UNION " +
	        "SELECT id, name, specialization,email,age,gender, dtphone phone FROM doctor")
	List<Object[]> mergePatientAndDoctorData();

	

	

	

	
	List<Doctor> findByName(String name);
	List<Doctor> findByEmail(String email);

	List<Doctor> findByDtphone(String password);
	 List<Doctor> findByNameOrDtphoneOrEmail(String name,String dtphone,String email);

	

	
}


