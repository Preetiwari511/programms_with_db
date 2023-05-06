package programms_with_db;

import java.sql.*;

public class ConnectionDemo {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Student s1 = dao.getStudent(2);
		System.out.println(s1.sname);
	}

}


class StudentDAO{
	public Student getStudent(int rollNo) {
		Student s = new Student();
		s.rollNo = rollNo;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students",
	                "root", "root");
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery("select * from Studentinfo");
			
			while (r.next()) 
			{
			String name = r.getString(1);
			//s.sname = name;
			System.out.println(name);
			}
		} catch (Exception e) {
		   e.printStackTrace();
		}
		return s;
	}
}

class Student {
	int rollNo;
	String sname;
	@Override
	public String toString() {
		return super.toString();
	}
}




