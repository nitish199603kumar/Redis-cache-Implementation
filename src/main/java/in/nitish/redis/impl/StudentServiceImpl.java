package in.nitish.redis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.jdbc.MysqlDataSource;

import in.nitish.redis.entity.Student;
import in.nitish.redis.repository.StudentRepository;
import in.nitish.redis.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RedisServiceImpl redisServiceImpl;

	@Override
	public Student findById1(Long studentId) {
		
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		Student student=studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student id not found !!"));
		studentRepository.delete(student);
	}
	
//	You can call anywhere this method and set the particular data into redis cache
//	public void sendMyData() {
////		create MyData Class into entity or set the data
//		MyData data=new MyData();
//		redisServiceImpl.sendDataWithExpiration(data);
//	}
//	
//	public Object retrieveData() {
//		Object storeData = redisServiceImpl.getStoreData();
//		return storeData;
//	}

}
