package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Payment;
import com.example.managers.PaymentManager;


@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
	PaymentManager pmng;
	
	@GetMapping(value="api/getallpayment")
	public List<Payment> getall(){
		return pmng.GetAll();
	}
	
	@GetMapping(value="api/getpaymentbyid/{id}")
	public Optional<Payment> findbyid(@PathVariable int id){
		return pmng.FindById(id);
	}
	
	@PostMapping(value="api/addpayment")
	public void addpayment(@RequestBody Payment p){
		 pmng.addpayment(p);
		 
	}
	
	@GetMapping(value="api/getpaybystudentid/{id}")
	public List<Payment> getbystudent(@PathVariable int id){
		 return pmng.GetByStudentId(id);
	}
}
