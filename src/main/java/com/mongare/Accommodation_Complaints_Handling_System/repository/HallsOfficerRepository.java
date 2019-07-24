package com.mongare.Accommodation_Complaints_Handling_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongare.Accommodation_Complaints_Handling_System.model.HallsOfficer;

public interface HallsOfficerRepository extends JpaRepository<HallsOfficer, Integer> {
	public HallsOfficer findByUnameAndPassword(String uname, String password);
}
