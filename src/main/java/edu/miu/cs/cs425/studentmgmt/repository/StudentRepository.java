package edu.miu.cs.cs425.studentmgmt.repository;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
    @EntityGraph(attributePaths = {"transcript", "classroom", "courses"})
    List<Student> findAll();
}
