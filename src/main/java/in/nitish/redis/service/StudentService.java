package in.nitish.redis.service;

import in.nitish.redis.entity.Student;

public interface StudentService {

	
	Student findById1(Long studentId);

	Student updateStudent(Student student);

	void deleteStudent(Long id);
	
	
}
