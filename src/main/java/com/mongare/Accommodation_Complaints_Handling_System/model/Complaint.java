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
@Table(name="Complaints")
@EntityListeners(AuditingEntityListener.class)

public class Complaint {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	
	@NotBlank
	private String complaintTitle;
	
	@NotBlank
	private String complaintDescription;
	
	@NotBlank
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotBlank
	private String uname;
	
	@NotBlank
	private String regNo;
	
	@NotBlank
	private String hostel;
	
	@NotBlank
	private String block;
	
	@NotBlank
	private String roomNumber;

	public String getComplaintTitle() {
		return complaintTitle;
	}

	public void setComplaintTitle(String complaintTitle) {
		this.complaintTitle = complaintTitle;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Complaint [cid=" + cid + ", complaintTitle=" + complaintTitle + ", complaintDescription="
				+ complaintDescription + ", fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", regNo="
				+ regNo + ", hostel=" + hostel + ", block=" + block + ", roomNumber=" + roomNumber + "]";
	}
	
	
	
	
	
}
