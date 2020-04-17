package com.cacheDemo.controller;
import com.cacheDemo.model.Student;
import com.cacheDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/student")
public class ControllerStudent {
	@Autowired
	StudentService service;
	@GetMapping()
	public Student getStudents() throws InterruptedException {
		return service.getStudents();
	}
}
