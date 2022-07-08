package com.project.basic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.basic.dao.StudentDao;
import com.project.basic.models.Student;
import com.project.basic.models.StudentRequest;
import com.project.basic.repos.StudentRepo;
import com.project.basic.services.StudentService;

@RestController
@RequestMapping("/StudentBackend")
public class StudentController {

	
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private StudentDao dao;
	
	@GetMapping("/getStudents")
	List<Student> getStudents() {
		
		return this.studentService.getStudents();
		
	}
	
	@GetMapping("/getStudents/2.0")
	List<StudentRequest> getStudentsByJdbc() {
		
		return this.studentService.getStudentsByJdbc();
		
	}
	
	@PostMapping("/saveStudent")
	int saveStudent(@RequestBody StudentRequest student) {
		//return repo.save(student);
		return dao.saveStudent(student);
		
	}
	
}
