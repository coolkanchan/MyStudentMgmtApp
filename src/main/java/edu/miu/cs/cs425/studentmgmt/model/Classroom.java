package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;

    @Column(nullable = false)
    private String buildingName;

    @Column(nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    public Classroom() {}

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + classroomId + ", buildingName=" + buildingName + ", roomNumber=" + roomNumber
				+ ", students=" + students + "]";
	}

    // Getters and Setters
}
