package com.mongare.Accommodation_Complaints_Handling_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongare.Accommodation_Complaints_Handling_System.model.AcceptedComplaint;

public interface AcceptedComplaintRepository extends JpaRepository<AcceptedComplaint, Integer> {
}
