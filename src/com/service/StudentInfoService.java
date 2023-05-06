package com.service;

import java.util.List;

import com.dto.StudentInfo;

public interface StudentInfoService {
	public List<StudentInfo> getStudentInfo() throws Exception;
	public StudentInfo getStudentInfoById(int id) throws Exception;
	public boolean addStudentInfo(StudentInfo studentInfo) throws Exception;
	public boolean updateStudentInfo(StudentInfo studentInfo) throws Exception;
	public boolean deleteStudentInfo(int id) throws Exception;
}
