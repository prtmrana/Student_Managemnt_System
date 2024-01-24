package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Batch;

@Transactional
public interface BatchRepository extends JpaRepository<Batch, Integer>{
	
	@Query(value="select * from Batch  where batch_Id=:batchno",nativeQuery = true)
	Optional<Batch> getBatch(@Param("batchno")int batchno);
	
	@Query(value="SELECT * FROM Batch WHERE batch_start_time > CURDATE();",nativeQuery=true)
	List<Batch> getUpcomingBatch();
	
	@Query(value="SELECT * FROM Batch WHERE CURDATE() >= batch_start_time AND CURDATE() <= batch_end_time;",nativeQuery=true)
	List<Batch> getCurrentBatch();
	
	@Query(value="SELECT * FROM batch WHERE batch_name LIKE %:batchName%",nativeQuery = true)
	List<Batch> getBatchByName(@Param("batchName")String batchName);
	
	
	
	 @Query(value="SELECT * FROM Batch WHERE CURDATE() >= batch_end_time && CURDATE() >= batch_end_time;",nativeQuery=true)
	 List<Batch> getPastBatch();
	
	 
	 @Query(value="SELECT * FROM Batch WHERE course_id= :courseid",nativeQuery=true)
	 List<Batch> getBatchByCourse_Id(@Param("courseid") int cid);
	
	 
	 
}
