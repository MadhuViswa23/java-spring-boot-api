package com.demo.hellospring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hellospring.model.User;





public interface UserRepository  extends JpaRepository<User, Integer>{

	 List<User> findByName(String name);
	 List<User>findByMail(String mail);
	 List<User>findByPhone(String phone);
	 List<User>findByPassword(String passsord);
	 List<User>findByNameOrPhoneOrMail(String name,String phone,String mail);
	// List<User>findByPassword(String passsord);
	 List<User> findByIsActive(boolean isActive);

	    List<User> findByIsDeleteFalse();
	
	//void save(userDto usd);
	//List<User> findByNameOrPhoneOrMail(String name,String phone,String  mail);
	
	    List<User> findByIsActiveTrue();

}