package com.example.repositories;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Staff;


@Repository
@Transactional
public interface StaffRepository extends JpaRepository<Staff,Integer>{

	@Modifying
	@Query("update Staff s set s.staff_name = :name, s.photo_url= :photo, s.staff_mobile = :mobile, s.staff_email = :email, s.staff_username = :uname, s.staff_password = :pass, s.staff_role = :role, s.staff_isactive = :status where s.staff_id = :id" )
	void updateStaff(@Param("name") String name, @Param("photo") String photo,@Param("mobile") String mobile, @Param("email") String email, @Param("uname") String uname, @Param("pass") String pass, @Param("role") String role, @Param("status") boolean staus,@Param("id") int id);
	
//	@Modifying
//	@Query(value="update Staff s set s.staff_username = :uname, s.staff_password = :pass, s.staff_role = :role, s.staff_isactive = :status where s.staff_name = :name",nativeQuery=true )
//	void getbyname(@Param("uname") String uname, @Param("pass") String pass, @Param("role") String role, @Param("status") boolean status, @Param("name") String name);

	
	@Query(value="SELECT * FROM Staff s WHERE s.staff_username = :username",nativeQuery=true)
    Optional<Staff> findByUsername(@Param("username") String username);
	
//	@Modifying
//	@Query("update Staff s set s.staff_isactive = :status where s.staff_id = :id")
//	void setActive (@Param("status")boolean status, @Param("id") int id );
	
//	@Query("update Course c set c.course_name = :name, c.course_description=:description,c.course_duration = :duration, c.course_syllabus=:syllabus where c.course_id = :id")
//	void update2(@Param("name") String name,@Param("description")String description,@Param("duration") int duration,@Param("syllabus") String syllabus,@Param("id")int id);
	
}
