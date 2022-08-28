package com.in28minutes.springboot.learnspringboot;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CourseController {
	//http:8080/course
	@RequestMapping("/course")
	@ResponseBody
	
public List<Course> retrieveAllCourse(){
	

	return Arrays.asList(
			new Course(1,"Learn AWS","in28minutes"),
			new Course(2,"Learn DevOps","in28minutes"));
			
}
}
