package com.mongare.Accommodation_Complaints_Handling_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mongare.Accommodation_Complaints_Handling_System.dao.ServiceHalls;
import com.mongare.Accommodation_Complaints_Handling_System.model.AcceptedComplaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.Complaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.Custodian;
import com.mongare.Accommodation_Complaints_Handling_System.model.DoneComplaint;
import com.mongare.Accommodation_Complaints_Handling_System.model.HallsOfficer;
import com.mongare.Accommodation_Complaints_Handling_System.model.RejectedComplaint;
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
	
	@PostMapping("/acceptComplaint")
	public String validate(@RequestParam String cid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		AcceptedComplaint acceptedComplaint = new AcceptedComplaint();
		acceptedComplaint.setFname(fname);
		acceptedComplaint.setLname(lname);
		acceptedComplaint.setRegNo(regNo);
		acceptedComplaint.setHostel(hostel);
		acceptedComplaint.setBlock(block);
		acceptedComplaint.setRoomNumber(roomNumber);
		acceptedComplaint.setComplaintTitle(complaintTitle);
		acceptedComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveAcceptedComplaint(acceptedComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("acceptedComplaint", acceptedComplaint);
		
		service.deleteComplaint(Integer.valueOf(cid));
		return "hallsOfficerWelcome.jsp";
	}
	
	@PostMapping("/rejectComplaint")
	public String reject(@RequestParam String cid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		RejectedComplaint rejectedComplaint = new RejectedComplaint();
		rejectedComplaint.setFname(fname);
		rejectedComplaint.setLname(lname);
		rejectedComplaint.setRegNo(regNo);
		rejectedComplaint.setHostel(hostel);
		rejectedComplaint.setBlock(block);
		rejectedComplaint.setRoomNumber(roomNumber);
		rejectedComplaint.setComplaintTitle(complaintTitle);
		rejectedComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveRejectedComplaint(rejectedComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("rejectedComplaint", rejectedComplaint);
		
		
		service.deleteComplaint(Integer.valueOf(cid));
		return "hallsOfficerWelcome.jsp";
	}
	
	@PostMapping("/doneComplaint")
	public String doneComplaint(@RequestParam String acid, @RequestParam String fname,
			@RequestParam String lname,@RequestParam String regNo,
			@RequestParam String hostel,@RequestParam String block,
			@RequestParam String roomNumber, @RequestParam String complaintTitle, @RequestParam String complaintDescription, 
			Model model) {
		
		DoneComplaint doneComplaint = new DoneComplaint();
		doneComplaint.setFname(fname);
		doneComplaint.setLname(lname);
		doneComplaint.setRegNo(regNo);
		doneComplaint.setHostel(hostel);
		doneComplaint.setBlock(block);
		doneComplaint.setRoomNumber(roomNumber);
		doneComplaint.setComplaintTitle(complaintTitle);
		doneComplaint.setComplaintDescription(complaintDescription);
		
		String message=service.saveDoneComplaint(doneComplaint);
		
		model.addAttribute("message",message);
		model.addAttribute("doneComplaint", doneComplaint);
		
		service.deleteAcceptedComplaint(Integer.valueOf(acid));
		return "custodianWelcome.jsp";
	}
}
