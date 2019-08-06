package com.mongare.Accommodation_Complaints_Handling_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongare.Accommodation_Complaints_Handling_System.model.AcceptedComplaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.Complaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.Custodian;
import com.mongare.Accommodation_Complaints_Handling_System.model.DoneComplaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.HallsOfficer;
import com.mongare.Accommodation_Complaints_Handling_System.model.Student;
import com.mongare.Accommodation_Complaints_Handling_System.repository.AcceptedComplaintRepository;
import com.mongare.Accommodation_Complaints_Handling_System.repository.ComplaintRepository;
import com.mongare.Accommodation_Complaints_Handling_System.repository.CustodianRepository;
import com.mongare.Accommodation_Complaints_Handling_System.repository.DoneComplaintRepository;
import com.mongare.Accommodation_Complaints_Handling_System.repository.HallsOfficerRepository;
import com.mongare.Accommodation_Complaints_Handling_System.repository.StudentRepository;

@Service
public class ServiceHalls {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	ComplaintRepository crepo;
	
	@Autowired
	HallsOfficerRepository hrepo;
	
	@Autowired
	CustodianRepository curepo;
	
	@Autowired
	AcceptedComplaintRepository acrepo;
	
	@Autowired
	DoneComplaintRepository dcrepo;
	
	public void save(Student student) {
	 	srepo.save(student);
	}
	
	public void saveHallsOfficer(HallsOfficer hallsOfficer) {
	 	hrepo.save(hallsOfficer);
	}
	
	public void saveCustodian(Custodian custodian) {
	 	curepo.save(custodian);
	}
	
	public Student getStudent(String uname, String password) {
		return srepo.findByUnameAndPassword(uname, password);
	}
	
	public HallsOfficer getHallsOfficer(String uname, String password) {
		return hrepo.findByUnameAndPassword(uname, password);
	}
	
	public Custodian getCustodian(String uname, String password) {
		return curepo.findByUnameAndPassword(uname, password);
	}
	
	
	public 	String saveComplaint(Complaint complaint) {
		String message="";
		crepo.save(complaint);
		if(crepo.save(complaint)!=null) {
		message="Complaint Submitted Successfully";	
		}
		else {
			message="Please Try Again!";
		}
		return message;
	}
	
	public String saveAcceptedComplaint(AcceptedComplaint acceptedComplaint) {
		String message="";
		acrepo.save(acceptedComplaint);
		if(acrepo.save(acceptedComplaint)!=null) {
		message="Accepted Successfully";
		}
		else {
		message="Failed to accept complaint";
		}
		return message;
	}
	
	public String saveDoneComplaint(DoneComplaint doneComplaint) {
		String message="";
		dcrepo.save(doneComplaint);
		if(dcrepo.save(doneComplaint)!=null) {
		message="Complaint Done";
		}
		else {
		message="Failed to complete complaint";
		}
		return message;
	}
	public void deleteComplaint(int cid) {
		crepo.deleteById(cid);
		
	}
	public void deleteAcceptedComplaint(int acid) {
		acrepo.deleteById(acid);
		
	}
}
