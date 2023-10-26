package com.demo.hellospring.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PatientDto {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int ptid;
	    private String ptname;
	    private String age;
	    public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		private String ptphone;
	    public String getPtphone() {
			return ptphone;
		}
		public void setPtphone(String ptphone) {
			this.ptphone = ptphone;
		}
		private String gender;
	    private String medicalcondition;
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
