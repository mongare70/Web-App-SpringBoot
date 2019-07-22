package com.mongare.Accommodation_Complaints_Handling_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.mongare.Accommodation_Complaints_Handling_System.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	public Student findByUnameAndPassword(String uname, String password);
	
}
