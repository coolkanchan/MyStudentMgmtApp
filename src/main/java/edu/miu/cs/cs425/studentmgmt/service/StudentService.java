package edu.miu.cs.cs425.studentmgmt.service;

import java.util.List;

import edu.miu.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    
    List<Student> getStudent();
}
