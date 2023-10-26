package com.demo.hellospring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "patient")
public class Patient {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int ptid;
	    private String ptname;
	    private String ptphone;
	    public String getPtphone() {
			return ptphone;
		}
		public void setPtphone(String ptphone) {
			this.ptphone = ptphone;
		}
	    private String gender;
	    private String medicalcondition;
	    private String age;
	    public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public int getPtid() {
			return ptid;
		}
		public void setPtid(int ptid) {
			this.ptid = ptid;
		}
		public String getPtname() {
			return ptname;
		}
		public void setPtname(String ptname) {
			this.ptname = ptname;
		}
		
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMedicalcondition() {
			return medicalcondition;
		}
		public void setMedicalcondition(String medicalcondition) {
			this.medicalcondition = medicalcondition;
		}
	  
	}

    
    
	
   
