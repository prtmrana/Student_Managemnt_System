package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Student;
import com.example.managers.StudentManager;

@RestController
@CrossOrigin("*")
public class StudentController {
   
	@Autowired
	StudentManager manager;
	
	@GetMapping(value = "api/student")
	 public List<Student> showList()
	 {
		  return manager.getstudent(); 			
	 }
	 
	 @GetMapping(value = "api/studentbyname/{student_name}")
	 public List<Student> getStudentbyName(@PathVariable String student_name)
	 {
		return manager.getSelected(student_name);
	 }
	 
	 @GetMapping(value = "api/studentbyid/{stid}")
	 public Optional<Student> getStudentbyId(@PathVariable int stid)
	 {
		return manager.getSelectedbyid(stid);
	 }
 
	 @PutMapping(value = "api/student/{student_id}")
	 public void updatestudent(@RequestBody Student stud,@PathVariable int student_id)
	 {
		manager.update(stud,student_id);
	 }
	 
	 @PostMapping(value = "api/students")
	 public void addstudent(@RequestBody Student stud)
	 {
		manager.addstudent(stud);
		
	 }
	 @GetMapping(value= "api/getbyenquiry_id/{enquiry_id}")
	 public 
	 List<Student> getstudentenq(@PathVariable int enquiry_id)
	 {
		return  manager.getstudentenquiry_id(enquiry_id);
	 }
	  
	 @DeleteMapping(value= "api/deletestudbyid/{student_id}")
	 void deletestudent(@PathVariable int student_id) {
		 manager.delstud(student_id);
	 }


}

