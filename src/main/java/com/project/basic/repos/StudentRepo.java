package com.project.basic.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.basic.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
