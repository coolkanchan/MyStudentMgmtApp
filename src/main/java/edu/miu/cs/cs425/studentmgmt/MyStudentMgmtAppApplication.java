package edu.miu.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;

@SpringBootApplication
@ComponentScan(basePackages = "edu.miu.cs.cs425.studentmgmt")
public class MyStudentMgmtAppApplication implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

//    @Autowired
//    private TranscriptService transcriptService;
//    
//    @Autowired
//    private ClassroomService classroomService;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Task 2:

		// moved this logic to service layer

//    	 Classroom classroom = new Classroom("McLaughlin building", "M105");
//    	 
//    	 Classroom cr = classroomService.saveClassRoom(classroom);

		// Task 3:

//    	 List<Course> courses = new ArrayList<>();
//    	 courses.add(new Course("CS401", "Modern Prog Practices"));
//    	 courses.add(new Course("CS435", "Software Engineer"));

		// Task 1:
		Student s1 = new Student("000-61-0002", "vicky", "kumar", "shaw", 4.45, LocalDate.of(2012, 5, 24));

		studentService.saveStudent(s1);

		System.out.println("Student successfully saved!");

		// find all students details

		List<Student> students = studentService.getStudent();

		for (Student student : students) {

			System.out.println(student);

		}

	}
}
