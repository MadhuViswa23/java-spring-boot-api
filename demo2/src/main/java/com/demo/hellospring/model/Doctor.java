package com.demo.hellospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "doctor")
public class Doctor {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	    private String name;
	    private String age;
	    private String dtphone;
	
	    public String getDtphone() {
			return dtphone;
		}
		public void setDtphone(String dtphone) {
			this.dtphone = dtphone;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		private String gender;
	    
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		private String specialization;
	    private String password;
	    private String email;
	    @SuppressWarnings("unused")
			private String Username;
		   
			
			public String getUsername() {
				return specialization;
			}
			public void setUsername(String username) {
				Username = username;
			}
//	    @OneToMany(targetEntity = Patient.)
		
}
   