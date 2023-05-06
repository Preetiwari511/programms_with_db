package com.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dto.StudentInfo;
import com.service.StudentInfoService;
import com.service.impl.StudentInfoServiceImpl;

public class StudentInfoController {
	private StudentInfoService studentInfoService = new StudentInfoServiceImpl();

	public List<StudentInfo> getStudentInfo() {

		try {
			return studentInfoService.getStudentInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public StudentInfo getStudentInfoById(int id)  {
		try {
			return studentInfoService.getStudentInfoById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean addStudentInfo(StudentInfo studentInfo) {
		try {
			return studentInfoService.addStudentInfo(studentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStudentInfo(StudentInfo studentInfo) {
		try {
			return studentInfoService.updateStudentInfo(studentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudentInfo(int id)  {
		try {
			return studentInfoService.deleteStudentInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws ParseException {
		StudentInfoController st = new StudentInfoController();
		List<StudentInfo> students = st.getStudentInfo();
		for (StudentInfo s : students) {
			System.out.println("Id-" + s.getStudentID() + "  " + "Name-" + s.getFirstName() + " " + s.getLastName()
					+ "  " + "Age- " + s.getAge() + "  " + " DOB-" + s.getDateOfBirth() + " " + "PunchTime-"
					+ s.getDateTime());

		}
		
		StudentInfo student = new StudentInfo();
		student.setFirstName("Gunja");
		student.setLastName("Kalra");
		student.setAge(14);
		student.setClassNo("I");
		student.setAddress("Chittor");
		student.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1991-12-12"));
	//	student.setDateTime(LocalDateTime.of(2023, 04, 26, 22, 59));
		System.out.println(st.addStudentInfo(student));
		//System.out.println(st.deleteStudentInfo(1004));		
	}

}
