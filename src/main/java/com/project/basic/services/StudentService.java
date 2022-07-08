package com.project.basic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.basic.dao.StudentDao;
import com.project.basic.models.Student;
import com.project.basic.models.StudentRequest;
import com.project.basic.repos.StudentRepo;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private StudentDao dao;
	
	public List<Student> getStudents() {
		
		
		return repo.findAll();//JPA Repo which will contain all the basic crud methods
		
	}
	
	public List<StudentRequest> getStudentsByJdbc() {

		return dao.getStudentDetails();// JPA Repo which will contain all the basic crud methods

	}
	
	
}
