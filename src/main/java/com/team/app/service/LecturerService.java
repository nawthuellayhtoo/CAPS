package com.team.app.service;

import java.util.ArrayList;

import com.team.app.model.Course;
import com.team.app.model.Enrolment;
import com.team.app.model.Lecturer;
import com.team.app.model.Student;

public interface LecturerService {

	ArrayList<Student> findAllStudentByLectuer();

	ArrayList<Course> findCourses();

	ArrayList<Student> findAllStudentByCourse(String cid);

	Course findCourse(String cid);

	ArrayList<Enrolment> findEnrolmentByCourse(String cid);

	ArrayList<String> findStudentsByCourse(String cid);

	Enrolment findEnrolmentByCourseAndStudent(String sid, String cid);

	Enrolment findEnrolmentByEnrolId(int enrolId);

	ArrayList<Course> findCoursesByLecturer(String lecturerid);

	ArrayList<Lecturer> findAllLecturers();

	ArrayList<String> findAllLecturerId();

	ArrayList<String> findAllLecturerFirstName();

	ArrayList<String> findAllLecturerLastName();

	Lecturer findByLecturerId(String lecturerId);

	Lecturer saveLecturer(Lecturer lecturer);

	void deleteLecturer(Lecturer lecturer);
}
