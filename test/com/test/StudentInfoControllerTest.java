package com.test;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.controller.StudentInfoController;
import com.dto.StudentInfo;

public class StudentInfoControllerTest {
	@Test
	public void getStudentInfoTest() throws Exception {
		StudentInfoController studentInfoController = new StudentInfoController();
		List<StudentInfo> testInfo = studentInfoController.getStudentInfo();
		assertTrue(testInfo.size()>0);
		assertTrue(testInfo.get(1).getFirstName().equalsIgnoreCase("Bhumika"));
		System.out.println(testInfo);
	}
	@Test
	public void addStudentInfoTest() throws Exception{
		StudentInfoController studentInfoController = new StudentInfoController();
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setFirstName("Gunja");
		studentInfo.setLastName("Kalra");
		studentInfo.setAge(14);
		studentInfo.setClassNo("I");
		studentInfo.setAddress("Chittor");
		studentInfo.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1991-12-12"));
		studentInfo.setDateTime(LocalDateTime.of(2023, 04, 26, 22, 59));
		boolean isAdded = studentInfoController.addStudentInfo(studentInfo);
		assertTrue(isAdded);
	}
}
