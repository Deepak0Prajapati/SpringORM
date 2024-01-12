package Com.SpringCore.Orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.FileSystemUtils;

import Com.SpringCore.Orm.Dao.StudentDao;
import Com.SpringCore.Orm.Entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");
        StudentDao student= context.getBean("studentDao",StudentDao.class);
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        
        
        System.out.println("***************************Welcome to Spring Orm Project*******************");
        System.out.println();
        int choice=0;
        while(true) {
        System.out.println("Press 1 to Add new Student");
        System.out.println("press 2 to displey all students");
        System.out.println("press 3 to get details for single student");
        System.out.println("Press 4 to delete student");
        System.out.println("press 5 to update Student");
        System.out.println("Press 6 to Exit program");
        
        try {
			choice =Integer.parseInt(sc.readLine());
			
			switch(choice) {
			case 1:
				System.out.println("enter id for student");
				int sid=Integer.parseInt(sc.readLine());
				System.out.println("enter name for student");
				String name=sc.readLine();
				System.out.println("enter city for student");
				String city=sc.readLine();
				
				Student s=new Student(sid,name,city);				
				int insert = student.insert(s);
				System.out.println(insert+":Student inserted");
				System.out.println("******************************************");
			break;
			case 2: 
				List<Student> allStudents = student.getAllStudents();
				for (Student student2 : allStudents) {
					System.out.println("id:"+student2.getStudentId());
					System.out.println("Name:"+student2.getStudentName());
					System.out.println("City:"+student2.getStudentCity());
					System.out.println("___________________________________________");
					
				}System.out.println("*******************************************");
			
			break;
			case 3: 
				System.out.println("enter id of student you want to view!!");
				int id=Integer.parseInt(sc.readLine());
				Student student2 = student.getStudent(id);
				System.out.println("id:"+student2.getStudentId());
				System.out.println("Name:"+student2.getStudentName());
				System.out.println("City:"+student2.getStudentCity());
				System.out.println("***********************************************");

			break;
			case 4: System.out.println("enter id of the student you want to delete!!");
			int id1=Integer.parseInt(sc.readLine());
		    student.DeleteStudent(id1);
		    System.out.println("Student Deleted!!");
		    
		    System.out.println("*******************************************");
			
			break;
			case 5: 
				System.out.println("eneter id of the student you  want to update!!");
				int Sid=Integer.parseInt(sc.readLine());
				System.out.println("enter details for updation!!");
				System.out.println("enter name for student");
				String name1=sc.readLine();
				System.out.println("enter city for student");
				String city1=sc.readLine();
				Student s2=new Student(Sid,name1,city1);
				student.UpdateStudents(s2);
				System.out.println("student Updated!!");
				System.out.println("*******************************************");
				

			break;
			case 6:
				System.out.println("Thankyou for using The Program!!");
				System.exit(0);
			break;
			default: System.out.println("Incorrect value");
		
			break;
			}
		} catch (Exception e) {
			System.out.println("incorrect value enetered!!!"+ "");
			// TODO Auto-generated catch block
			
		} 
        }
    }
}
