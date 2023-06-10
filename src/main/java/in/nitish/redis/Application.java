package in.nitish.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import in.nitish.redis.entity.Student;
import in.nitish.redis.repository.StudentRepository;

@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main Class");
		Student student1=new Student(1L,"Dilip","Kumar");
		studentRepository.save(student1);
		Student student2=new Student(2L,"Deepak","Kumar");
		studentRepository.save(student2);
		
	}

}
