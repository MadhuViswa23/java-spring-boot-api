package com.demo.hellospring.serviceimpl;



import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.hellospring.dto.DoctorDto;

import com.demo.hellospring.model.Doctor;

import com.demo.hellospring.service.DoctorService;
import com.demo.hellospring.repository.DoctorRepository;



@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public boolean saveorupdate(DoctorDto doctordto) {
		Doctor dt = new Doctor();
	    dt.setId(doctordto.getId());
	    dt.setName(doctordto.getName());
	    dt.setAge(doctordto.getAge());
		dt.setGender(doctordto.getGender());
	    dt.setSpecialization(doctordto.getSpecialization());
	    dt.setEmail(doctordto.getEmail());
	    dt.setPassword(doctordto.getPassword());
	    dt.setDtphone(doctordto.getDtphone());
	    dt.setUsername(doctordto.getUsername());
	   doctorRepository.save(dt);

		
		return true;
		
	}
	@Override
	public List<Doctor> getAllDoctor() {
		List<Doctor> product=doctorRepository.findAll();
		return product;
	}

	@Override
	public String signUp(DoctorDto doctordto) {
		List<Doctor> name=doctorRepository.findByName( doctordto.getName());
		if(name !=null) {
			List<Doctor> email=doctorRepository.findByEmail(doctordto.getEmail());
			if(email !=null) {
				List<Doctor> dtphone=doctorRepository.findByDtphone(doctordto.getDtphone());
				if(dtphone !=null) {
					List<Doctor> password=doctorRepository.findByDtphone(doctordto.getPassword());
					if(password !=null) {
						Doctor doctor=new Doctor();
						BeanUtils.copyProperties(doctordto, doctor);
						doctor.setPassword(this.encode(doctordto.getPassword()));
						doctorRepository.save(doctor);
						return "success";
					}
					return "check password";
				}
				return "check phone number";
			}
			return "check mail";
		}
		
		return "check name";
		}
	public String encode(String encodeedPassword) {
		BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder(10,new SecureRandom());
		return bCryptPasswordEncoder.encode(encodeedPassword);
	}
	
	public boolean decode(String text, String text2) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder.matches(text, text2);

	}

	public String signIn(String name, String password) {
		List<Doctor>doctors=doctorRepository.findByNameOrDtphoneOrEmail(name,name,name);
		String status="";
		if(doctors.size()>0) {
			for(Doctor doctorss:doctors) {
				if(this.decode(password, doctorss.getPassword())) {
					status="Successfully Login";
					
				}else {
					status="Check Password";
				}
			}
		}
		else {
			status="no Data found";
		}
		return status;
	}
}
