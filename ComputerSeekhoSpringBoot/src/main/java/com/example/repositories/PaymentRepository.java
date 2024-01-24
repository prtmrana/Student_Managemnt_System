package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	
	@Modifying
	@Query(value="select * from payment where student_id= :id",nativeQuery=true)
	public List<Payment> getPayDetail(@Param("id")  int id);
}
