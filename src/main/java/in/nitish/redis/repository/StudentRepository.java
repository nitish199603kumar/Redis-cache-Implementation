package in.nitish.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nitish.redis.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
