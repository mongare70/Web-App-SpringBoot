package com.mongare.Accommodation_Complaints_Handling_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongare.Accommodation_Complaints_Handling_System.model.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{

}
