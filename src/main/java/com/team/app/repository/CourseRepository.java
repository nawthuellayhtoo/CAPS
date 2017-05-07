package com.team.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.app.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

	@Query(value = "select * from caps.course c where c.courseid not in (select s.courseid from caps.course s, caps.enrolment e where s.courseid = e.courseid and e.studentid =?1) and c.size > 0 and c.startdate > curdate()", nativeQuery = true)
	ArrayList<Course> viewCourses(String id);

	/*
	 * @Query("Select c.courseid, c.coursename from Course c where c.size>0")
	 * ArrayList<Course> viewCourses();
	 */

	@Query(value = "SELECT * FROM course WHERE lecturerid = ?1", nativeQuery = true)
	ArrayList<Course> findCoursesByLecturer(String lecturerid);
}
