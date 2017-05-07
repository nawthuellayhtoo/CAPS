package com.team.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.app.model.Course;
import com.team.app.model.Enrolment;
import com.team.app.model.Lecturer;
import com.team.app.model.Student;
import com.team.app.repository.CourseRepository;
import com.team.app.repository.EnrolmentRepository;
import com.team.app.repository.LecturerRepository;
import com.team.app.repository.StudentRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	private StudentRepository studentRepository;

	@Resource
	private LecturerRepository lecturerRepository;

	@Resource
	private CourseRepository courseRepository;

	@Resource
	private EnrolmentRepository enrolmentRepository;

	@Override
	@Transactional
	public ArrayList<Student> findAllStudentByLectuer() {
		ArrayList<Student> ul = (ArrayList<Student>) studentRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public ArrayList<Course> findCourses() {
		ArrayList<Course> ul = (ArrayList<Course>) courseRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public ArrayList<Student> findAllStudentByCourse(String cid) {
		ArrayList<Student> ul = (ArrayList<Student>) studentRepository.findAllStudentByCourse(cid);
		return ul;
	}

	@Override
	@Transactional
	public Course findCourse(String cid) {

		return courseRepository.findOne(cid);
	}

	@Override
	@Transactional
	public ArrayList<Enrolment> findEnrolmentByCourse(String cid) {
		ArrayList<Enrolment> ul = (ArrayList<Enrolment>) enrolmentRepository.findEnrolmentByCourse(cid);
		return ul;
	}

	@Override
	@Transactional
	public ArrayList<String> findStudentsByCourse(String cid) {
		ArrayList<String> ul = studentRepository.findStudentsByCourse(cid);
		return ul;
	}

	@Override
	public Enrolment findEnrolmentByCourseAndStudent(String sid, String cid) {
		Enrolment e = enrolmentRepository.findEnrolmentByCourseAndStudent(sid, cid);
		return e;
	}

	@Override
	public Enrolment findEnrolmentByEnrolId(int enrolId) {
		return enrolmentRepository.findOne(enrolId);
	}

	@Override
	@Transactional
	public ArrayList<Course> findCoursesByLecturer(String lecturerid) {
		return courseRepository.findCoursesByLecturer(lecturerid);
	}

	@Override
	@Transactional
	public ArrayList<Lecturer> findAllLecturers() {
		ArrayList<Lecturer> listLecturer = (ArrayList<Lecturer>) lecturerRepository.findAll();
		return listLecturer;
	}

	@Override
	@Transactional
	public ArrayList<String> findAllLecturerId() {
		ArrayList<String> listLecturer = lecturerRepository.findAllLecturerId();
		return listLecturer;
	}

	@Override
	@Transactional
	public ArrayList<String> findAllLecturerFirstName() {
		ArrayList<String> listLecturer = lecturerRepository.findAllLecturerFirstName();
		return listLecturer;
	}

	@Override
	@Transactional
	public ArrayList<String> findAllLecturerLastName() {
		ArrayList<String> listLecturer = lecturerRepository.findAllLecturerLastName();
		return listLecturer;
	}

	@Override
	@Transactional
	public Lecturer findByLecturerId(String lecturerId) {
		return lecturerRepository.findOne(lecturerId);
	}

	@Override
	@Transactional
	public Lecturer saveLecturer(Lecturer lecturer) {
		return lecturerRepository.save(lecturer);
	}

	@Override
	@Transactional
	public void deleteLecturer(Lecturer lecturer) {
		lecturerRepository.delete(lecturer);
	}

}
