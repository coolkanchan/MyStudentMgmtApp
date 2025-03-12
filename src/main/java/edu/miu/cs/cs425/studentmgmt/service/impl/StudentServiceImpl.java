package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.repository.CourseRepository;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TranscriptRepository transcriptRepository;
    
    @Autowired
    private ClassroomRepository classroomRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public Student saveStudent(Student student) {
    	
    	 Transcript transcript = new Transcript("BS Computer Science");
    	 transcript = transcriptRepository.save(transcript);
    	 student.setTranscript(transcript);
    	 
    	 Classroom classroom = new Classroom("McLaughlin building", "M105");
    	 classroom = classroomRepository.save(classroom);
    	 
    	 student.setClassroom(classroom);
    	 
    	 List<Course> courses = new ArrayList<>();
    	 courses.add(new Course("CS401", "Modern Prog Practices"));
    	 courses.add(new Course("CS435", "Software Engineer"));
    	 
    	 courses = courseRepository.saveAll(courses);
    	 
    	 student.setCourses(courses);
    	
        return studentRepository.save(student);
    }
    
    @Transactional(readOnly = true)
	@Override
	public List<Student> getStudent() {
		List<Student> students = studentRepository.findAll();
		
		students.forEach(student -> {
            System.out.println("Student: " + student.getFirstName());
            System.out.println("Transcript: " + student.getTranscript());
            System.out.println("Classroom: " + student.getClassroom());
            System.out.println("Courses: " + student.getCourses());
        });
        return students;
	}
}
