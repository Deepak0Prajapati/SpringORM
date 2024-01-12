package Com.SpringCore.Orm.Dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import Com.SpringCore.Orm.Entities.Student;

public class StudentDao {
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		
		Integer save =(Integer)this.hibernateTemplate.save(student);
		return save;
		
	}
	
	
	public Student getStudent(int studentId){
		
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;	
		
	}
	
	
	public List<Student> getAllStudents(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
		
	}
	
	@Transactional
	public void DeleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
		
	}
	@Transactional
	public void UpdateStudents(Student student) {
		hibernateTemplate.update(student);
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	

}
