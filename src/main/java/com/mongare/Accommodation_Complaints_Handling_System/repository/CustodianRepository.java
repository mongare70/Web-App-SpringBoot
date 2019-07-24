package com.mongare.Accommodation_Complaints_Handling_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mongare.Accommodation_Complaints_Handling_System.model.Custodian;

public interface CustodianRepository extends JpaRepository<Custodian, Integer>{
	public Custodian findByUnameAndPassword(String uname, String password);
}
