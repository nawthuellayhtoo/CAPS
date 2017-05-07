package com.team.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.app.model.Course;
import com.team.app.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource
	private CourseRepository courseRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.team.app.service.CourseService#viewCourses()
	 */
	@Override
	@Transactional
	public ArrayList<Course> viewCourses(String sid) {
		return courseRepository.viewCourses(sid);
	}

	@Override
	@Transactional
	public Course findCourse(String courseId) {
		return courseRepository.findOne(courseId);
	}

	@Override
	@Transactional
	public Course updateCourse(Course course) {
		return courseRepository.saveAndFlush(course);
	}

	@Override
	@Transactional
	public Course findByCourseId(String courseId) {
		return courseRepository.findOne(courseId);
	}

	@Override
	@Transactional
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	@Transactional
	public void deleteCourse(Course course) {
		courseRepository.delete(course);
	}

	@Override
	@Transactional
	public ArrayList<Course> findAllCourses() {
		ArrayList<Course> listCourse = (ArrayList<Course>) courseRepository.findAll();
		return listCourse;
	}
}
