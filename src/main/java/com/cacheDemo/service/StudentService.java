package com.cacheDemo.service;
import com.cacheDemo.model.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@Service
public class StudentService {
	@Cacheable(value = "ten-second-cache", key = "'studentCache'")
	public Student getStudents() throws InterruptedException {
		Student student = new Student();
		student.setId(1);
		student.setName("Sree");
		Thread.sleep(4000);
		return student;
	}
}
