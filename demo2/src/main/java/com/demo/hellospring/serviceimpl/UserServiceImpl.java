package com.demo.hellospring.serviceimpl;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;
import java.security.SecureRandom;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.hellospring.dto.UserDto;
import com.demo.hellospring.model.User;
import com.demo.hellospring.repository.UserRepository;
import com.demo.hellospring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	    private JavaMailSender javaMailSender;
@Autowired
UserRepository userRepository;//objectuserRepository//
	@Override
	public boolean saveorupdate(UserDto userdto) {
		User use=new User();
		use.setId(userdto.getId());
		use.setName(userdto.getName());
		use.setMail(userdto.getMail());
		use.setPassword(userdto.getPassword());
		use.setPhone(userdto.getPhone());
//		use.setAge(userdto.getAge());
		userRepository.save(use);
		return true;
	}
	@Override
	public boolean deleteUserByID(int id) {
		userRepository.deleteById(id);
		return true;
	}
	@Override
	public List<User> getAllUser() {
		List<User> product=userRepository.findAll();
		return product;
	}
	@Override
	public Optional<User> getByID(int id) {
		Optional<User> opro=userRepository.findById(id);
		return opro;
	}
	
	@Override
	public String signUp(UserDto userdto) {
		List<User> name=userRepository.findByName(userdto.getName());
		if(name !=null) {
			List<User> mail=userRepository.findByMail(userdto.getMail());
			if(mail !=null) {
				List<User> phone=userRepository.findByPhone(userdto.getPhone());
				if(phone !=null) {
					List<User> password=userRepository.findByPassword(userdto.getPassword());
					if(password !=null) {
						User user=new User();
						BeanUtils.copyProperties(userdto, user);
						user.setPassword(this.encode(userdto.getPassword()));
						userRepository.save(user);
						return "signup success";
					}
					return "check password";
				}
				return "check phone num";
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
	@Override
	public String signIn(String name, String password) {
		List<User>users=userRepository.findByNameOrPhoneOrMail(name,name,name);
		String status="";
		if(users.size()>0) {
			for(User userss:users) {
				if(this.decode(password, userss.getPassword())) {
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
	@Override
	public int softDeleteById(int id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        user.setIsDelete(true); // Mark the user as deleted
	        userRepository.save(user);
	        return 1; // Successful soft delete
	    }
	    return 0; // User not found
	    
	   
	}
	@Override
	
	public String sendEmail(String to, String textBody, String topic) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("ilagowda1105@gmail.com");
			simpleMailMessage.setTo(to);
			simpleMailMessage.setSubject(topic);
			simpleMailMessage.setText(textBody);
			javaMailSender.send(simpleMailMessage);
		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
		return "Successfully Sent";
	}
//	public String sendEmail(String to, String textBody, String topic) {
		// TODO Auto-generated method stub
//		return null;
//	}
	
	
}