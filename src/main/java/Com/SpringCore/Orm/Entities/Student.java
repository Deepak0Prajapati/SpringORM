package Com.SpringCore.Orm.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	private int StudentId;
	private String StudentName;
	private String StudentCity;
	
	public Student(int studentId, String studentName, String studentCity) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		StudentCity = studentCity;
	}

	public Student() {
		
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentCity() {
		return StudentCity;
	}

	public void setStudentCity(String studentCity) {
		StudentCity = studentCity;
	}
	
	
	

}
