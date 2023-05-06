package com.service.impl;

import java.util.List;

import com.dao.StudentInfoDAO;
import com.dao.impl.StudentInfoDAOImpl;
import com.dto.StudentInfo;
import com.service.StudentInfoService;

public class StudentInfoServiceImpl  implements StudentInfoService{
	
	private StudentInfoDAO studentInfoDAO = new StudentInfoDAOImpl();
	@Override
	public List<StudentInfo> getStudentInfo() throws Exception {
		return studentInfoDAO.getStudentInfo();
	}
	@Override
	public StudentInfo getStudentInfoById(int id) throws Exception {
		return studentInfoDAO.getStudentInfoById(id);
	}
	@Override
	public boolean addStudentInfo(StudentInfo studentInfo) throws Exception {
		return studentInfoDAO.addStudentInfo(studentInfo);
	}
	@Override
	public boolean updateStudentInfo(StudentInfo studentInfo) throws Exception {
		return studentInfoDAO.updateStudentInfo(studentInfo);
	}
	@Override
	public boolean deleteStudentInfo(int id) throws Exception {
		return studentInfoDAO.deleteStudentInfo(id);
	}

}
