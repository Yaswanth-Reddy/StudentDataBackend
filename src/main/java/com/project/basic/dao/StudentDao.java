package com.project.basic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.project.basic.models.StudentRequest;

@Component
public class StudentDao {

	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public static String GET_STUDENTS = "select * from movie_booking_management.student_data";
	
	String INSERT_STUDENT = 
			"INSERT INTO movie_booking_management.student_data (id, student_name, student_gender, student_city) VALUES (:id, :name, :gender, :city)";
	
	 public List<StudentRequest> getStudentDetails() {
		
	//List<Map<String, Object>>	students = this.jdbcTemplate.queryForList(GET_STUDENTS, null);
		
		
		 return jdbcTemplate.query(GET_STUDENTS,
				 new RowMapper<StudentRequest>(){  
			    

				@Override
				public StudentRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					StudentRequest e=new StudentRequest();  
			        e.setId(rs.getInt(1));  
			        e.setName(rs.getString(2)); 
			        e.setGender(rs.getString(3));
			        e.setCity(rs.getString(4));
			        return e;  
				}  
			    }
		 
				 );  
		
	}
	
	 
	 public int saveStudent(StudentRequest request) {
		 
		 MapSqlParameterSource map = new MapSqlParameterSource();
		 map.addValue("id", request.getId());
		 map.addValue("name", request.getName());
		 map.addValue("gender", request.getGender());
		 map.addValue("city", request.getCity());
		 
		 
		 return namedParameterJdbcTemplate.update(INSERT_STUDENT, map);
		 
	 }
	
	
}
