package com.example.managers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.entities.Student;


@Service
public interface  StudentManager {


	List<Student> getstudent();	
	void update(Student std,int id);
	List<Student> getSelected(String name);
	Optional<Student> getSelectedbyid(int id);
	void addstudent(Student student);
	List<Student> getstudentenquiry_id(int getbyenquiry_id);
	void delstud(int student_id);
}