package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false, unique = true)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Double cgpa;

    @Column(nullable = false)
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transcript_id", referencedColumnName = "transcriptId")
    private Transcript transcript;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_courses",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    // Constructors
    public Student() {}

    public Student(String studentNumber, String firstName, String middleName,
                   String lastName, Double cgpa, LocalDate dateOfEnrollment ) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;



    }

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public Transcript getTranscript() {
		return transcript;
	}

	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", dateOfEnrollment="
				+ dateOfEnrollment +"]";
	}

    // Getters and Setters
    // (Auto-generate in your IDE)
}
