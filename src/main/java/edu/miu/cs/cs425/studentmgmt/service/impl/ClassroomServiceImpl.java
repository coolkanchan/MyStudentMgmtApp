package edu.miu.cs.cs425.studentmgmt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService{
	
	@Autowired
	private ClassroomRepository classroomRepository;

	@Override
	public Classroom saveClassRoom(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomRepository.saveAndFlush(classroom);
	}

}
