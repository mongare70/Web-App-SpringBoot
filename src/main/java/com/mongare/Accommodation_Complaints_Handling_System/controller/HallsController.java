package com.mongare.Accommodation_Complaints_Handling_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongare.Accommodation_Complaints_Handling_System.dao.ServiceHalls;
import com.mongare.Accommodation_Complaints_Handling_System.model.Complaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.Custodian;
import com.mongare.Accommodation_Complaints_Handling_System.model.HallsOfficer;
import com.mongare.Accommodation_Complaints_Handling_System.model.Student;

@Controller
public class HallsController {
	
	@Autowired
	ServiceHalls service;
	
	@RequestMapping("/")
	public String getHalls() {
		return "studentLogin.jsp";
	}
	
	@RequestMapping("/registration")
	public String registration() {
		return "studentRegistration.jsp";
	}
	
	@RequestMapping("/HallsOfficerRegistration")
	public String hallsOfficerRegistration() {
		return "hallsOfficerRegistration.jsp";
	}
	
	@RequestMapping("/custodianRegistration")
	public String custodianRegistration() {
		return "custodianRegistration.jsp";
	}
	
	@PostMapping("/register")
	String addStudent(Student student) {
		
		service.save(student);
		return "welcome.jsp";
	}
	
	@PostMapping("/hallsOfficerRegister")
	String addHallsOfficer(HallsOfficer hallsOfficer) {
		
		service.saveHallsOfficer(hallsOfficer);
		return "hallsOfficerWelcome.jsp";
	}
	
	@PostMapping("/custodianRegister")
	String addCustodian(Custodian custodian) {
		
		service.saveCustodian(custodian);
		return "custodianWelcome.jsp";
	}
	
	@PostMapping("/login")
	public String validate(@RequestParam String uname, @RequestParam String password, Model model){	
		
		Student student=service.getStudent(uname, password);
		
		if(student!=null) {
			model.addAttribute("student", student);
			return "welcome.jsp";
		}
		else {
			return "studentLogin.jsp";
		}
	}
	
	@PostMapping("/HallsOfficerLogin")
	public String validateHallsOfficer(@RequestParam String uname, @RequestParam String password, Model model){	
		
		HallsOfficer hallsOfficer=service.getHallsOfficer(uname, password);
		
		if(hallsOfficer!=null) {
			model.addAttribute("hallsOfficer", hallsOfficer);
			return "hallsOfficerWelcome.jsp";
		}
		else {
			return "hallsOfficerLogin.jsp";
		}
	}
	
	@PostMapping("/custodianLogin")
	public String validateCustodian(@RequestParam String uname, @RequestParam String password, Model model){	
		
		Custodian custodian=service.getCustodian(uname, password);
		
		if(custodian!=null) {
			model.addAttribute("custodian", custodian);
			return "custodianWelcome.jsp";
		}
		else {
			return "custodianLogin.jsp";
		}
	}
	
	@PostMapping("/welcome")
	public String submitComplaint(@RequestParam String complaintTitle,
			@RequestParam String complaintDescription,@RequestParam String fname,
			@RequestParam String lname,@RequestParam String uname,
			@RequestParam String regNo, @RequestParam String hostel, @RequestParam String block, 
			@RequestParam String roomNumber
			,Model model)
	{
		
		Complaint complaint =new Complaint();
		complaint.setComplaintTitle(complaintTitle);
		complaint.setComplaintDescription(complaintDescription);
		complaint.setFname(fname);
		complaint.setLname(lname);
		complaint.setUname(uname);
		complaint.setRegNo(regNo);
		complaint.setHostel(hostel);
		complaint.setBlock(block);
		complaint.setRoomNumber(roomNumber);
		
		String message=service.saveComplaint(complaint);
		model.addAttribute("message", message);
		model.addAttribute("complaint", complaint);
		return "welcome.jsp";
	}
}
