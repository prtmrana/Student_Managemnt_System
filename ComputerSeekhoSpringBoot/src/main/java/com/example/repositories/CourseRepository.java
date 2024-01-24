package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Course;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Modifying
	@Query("update Course c set c.course_name = :name, c.course_description=:description,c.course_duration = :duration, c.course_syllabus=:syllabus,c.age_grp_type=:age_grp_type,c.course_is_active=:course_is_active,c.cover_photo=:cover_photo,c.video_link=:video_link where c.course_id = :id")
	void update(@Param("name") String name, @Param("description") String description, @Param("duration") int duration,
			@Param("syllabus") String syllabus, @Param("age_grp_type") String age_grp_type,
			@Param("course_is_active") boolean course_is_active, @Param("cover_photo") String cover_photo,
			@Param("video_link") String video_link, @Param("id") int id);

	@Modifying
	@Query("update Course c set c.course_is_active =:active where c.course_id=:id")
	void updateInactive(@Param("active") boolean active, @Param("id") int id);

}
