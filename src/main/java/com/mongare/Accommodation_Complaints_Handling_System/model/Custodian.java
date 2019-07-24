package com.mongare.Accommodation_Complaints_Handling_System.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Custodians")
@EntityListeners(AuditingEntityListener.class)
public class Custodian {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@NotBlank
	private String staffNo;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	private String uname;
	
	@NotBlank
	private String hostel;
	
	@NotBlank
	private String password;

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	@Override
	public String toString() {
		return "Custodian [cid=" + cid + ", staffNo=" + staffNo + ", fname=" + fname + ", lname=" + lname + ", uname="
				+ uname + ", hostel=" + hostel + ", password=" + password + "]";
	}
	
	
}
