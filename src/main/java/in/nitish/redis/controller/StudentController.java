package in.nitish.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nitish.redis.entity.Student;
import in.nitish.redis.service.StudentService;


@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Cacheable(value="student",key="#studentId" )
	@GetMapping("/student/{studentId}")
	public Student findStudentById(@PathVariable Long studentId) {
		
		return studentService.findById1(studentId);
	}
	
	@CachePut(value="student", key="#student.id")
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		
		return studentService.updateStudent(student);
	}
	
	@CacheEvict(value="student",key="#id")
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		
	}
}
