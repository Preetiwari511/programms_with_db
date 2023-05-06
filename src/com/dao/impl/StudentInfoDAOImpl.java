package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.config.DatabaseConfig;
import com.dao.StudentInfoDAO;
import com.dto.StudentInfo;

public class StudentInfoDAOImpl implements StudentInfoDAO {

	@Override
	public List<StudentInfo> getStudentInfo() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet r = null;
		// TODO create list of StudentInfo
		List<StudentInfo> students = new ArrayList<>();
		try {
			con = DatabaseConfig.getConnection();
			st = con.createStatement();
			r = st.executeQuery("select * from Studentinfo");

			while (r.next()) {
				// TODO create new StudentInfo object , add values from result set and add
				// object to list
				StudentInfo studentInfo = new StudentInfo();
				int studentID = r.getInt("studentID");
				String fname = r.getString("firstName");
				String lname = r.getString("lastName");
				int age = r.getInt("age");
				String address = r.getString("address");
				int rollNo = r.getInt("rollNo");
				String className = r.getString("class");
				Date dateOfBirth = r.getDate("date_of_birth");
				LocalDateTime dateTime = (LocalDateTime) r.getObject("punch_time");
				Timestamp createdOn = r.getTimestamp("created_on");
				studentInfo.setStudentID(studentID);
				studentInfo.setFirstName(fname);
				studentInfo.setLastName(lname);
				studentInfo.setAge(age);
				studentInfo.setAddress(address);
				studentInfo.setRollNo(rollNo);
				studentInfo.setClassNo(className);
				studentInfo.setDateOfBirth(dateOfBirth);
				studentInfo.setDateTime(dateTime);
				studentInfo.setCreatedOn(createdOn);
				students.add(studentInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (r != null)
				try {
					r.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		// return student info list
		return students;
	}

	@Override
	public StudentInfo getStudentInfoById(int id) throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet r = null;
		String query = "SELECT * FROM `students`.`studentinfo` where studentID = " + id;
		StudentInfo studentInfo = new StudentInfo();
		try {
			con = DatabaseConfig.getConnection();
			st = con.createStatement();
			r = st.executeQuery(query);

			while (r.next()) {
				int studentID = r.getInt("studentID");
				String fname = r.getString("firstName");
				String lname = r.getString("lastName");
				int age = r.getInt("age");
				String address = r.getString("address");
				int rollNo = r.getInt("rollNo");
				String className = r.getString("class");
				Date dateOfBirth = r.getDate("date_of_birth");
				LocalDateTime dateTime = (LocalDateTime) r.getObject("punch_time");
				Timestamp createdOn = r.getTimestamp("created_on");
				studentInfo.setStudentID(studentID);
				studentInfo.setFirstName(fname);
				studentInfo.setLastName(lname);
				studentInfo.setAge(age);
				studentInfo.setAddress(address);
				studentInfo.setRollNo(rollNo);
				studentInfo.setClassNo(className);
				studentInfo.setDateOfBirth(dateOfBirth);
				studentInfo.setDateTime(dateTime);
				studentInfo.setCreatedOn(createdOn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (r != null)
				try {
					r.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return studentInfo;
	}

	@Override
	public boolean addStudentInfo(StudentInfo studentInfo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "INSERT INTO `students`.`studentinfo` (`firstName`, `lastName`, `age`, `address`, `rollNo`, `class`, `date_of_birth`)" +
				 "VALUES (?,?,?,?,?,?,?)";
		try {
			con = DatabaseConfig.getConnection();
			st = con.prepareStatement(query);
			st.setString(1,studentInfo.getFirstName());
			st.setString(2, studentInfo.getLastName());
			st.setInt(3,studentInfo.getAge());
			st.setString(4, studentInfo.getAddress());
			st.setInt(5, studentInfo.getRollNo());
			st.setString(6, studentInfo.getClassNo());
			st.setDate(7, new java.sql.Date(studentInfo.getDateOfBirth().getYear(),studentInfo.getDateOfBirth().getMonth(), studentInfo.getDateOfBirth().getDay()));
			int i = st.executeUpdate();
			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (r != null)
				try {
					r.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public boolean updateStudentInfo(StudentInfo studentInfo) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "UPDATE `students`.`studentinfo` SET `firstName` = ?, `lastName` = ?, `age` = ?, `address` = ?, `rollNo` = ?, `class` = ?, `date_of_birth` = ? WHERE (`studentId` = ?) ";
		try {
			con = DatabaseConfig.getConnection();
			st = con.prepareStatement(query);
			st.setString(1,studentInfo.getFirstName());
			st.setString(2,studentInfo.getLastName());
			st.setInt(3,studentInfo.getAge());
			st.setString(4, studentInfo.getAddress());
			st.setInt(5,studentInfo.getRollNo());
			st.setString(6,studentInfo.getClassNo());
			st.setInt(8, studentInfo.getStudentID());
			int i = st.executeUpdate();
			if (i > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (r != null)
				try {
					r.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
		}
		return false;
	}

	@Override
	public boolean deleteStudentInfo(int id) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet r = null;
		String query = "DELETE FROM `students`.`studentinfo` WHERE studentId = ?";
		try {
			con = DatabaseConfig.getConnection();
			st = con.prepareStatement(query);
			st.setInt(1, id);
			
			int rowsDeleted = st.executeUpdate();
			if(rowsDeleted>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (r != null)
				try {
					r.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
				}
			
		}
		return false;
	}

}
