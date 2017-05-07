package com.team.app.service;

import java.util.ArrayList;

import com.team.app.model.Course;

public interface CourseService {

	ArrayList<Course> viewCourses(String studentid);

	Course findCourse(String courseId);

	Course updateCourse(Course course);

	ArrayList<Course> findAllCourses();

	Course findByCourseId(String courseId);

	Course saveCourse(Course course);

	void deleteCourse(Course course);
}