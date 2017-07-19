package com.orangeandbronze.enlistment.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import com.orangeandbronze.enlistment.dao.DataAccessException;
import com.orangeandbronze.enlistment.dao.StudentDAO;
import com.orangeandbronze.enlistment.domain.Student;

public class StudentDaoJdbc implements StudentDAO {
	private final DataSource dataSource;
	
	public StudentDaoJdbc(DataSource dataSource){
		this.dataSource = dataSource;
	}
	@Override
	public Map<String, String> findUserInfobById(int id) {
		throw new UnsupportedOperationException("method not yet implemented");

	}

	@Override
	public Student findWithSectionsBy(int studentNumber) {
		throw new UnsupportedOperationException("method not yet implemented");

	}

	@Override
	public Student findWithoutSectionsBy(int studentNumber) {
		try (Connection conn = dataSource.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(
	                    "SELECT * " +
	                    "FROM students WHERE student_number = ?")) {
	        stmt.setInt(1, studentNumber);
	        stmt.setInt(1, studentNumber);
	        Student student = Student.NONE;
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                String firstName = rs.getString("firstname");
	                String lastName = rs.getString("lastname");
	                student = new Student(studentNumber, firstName, lastName);
	            }
	        }
	        return student;
	    } catch (SQLException e) {
	        throw new DataAccessException(
	                "Problem retrieving student data for student " + 
	                        "with student number " + studentNumber, e);
	    }
	}

}
