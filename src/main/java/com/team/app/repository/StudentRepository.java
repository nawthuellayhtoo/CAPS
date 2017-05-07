package com.team.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	@Query(value = "Select e.studentid,c.courseid, c.coursename,e.grade from Enrolment e, Course c where c.courseid=e.courseid and e.studentid=?1", nativeQuery = true)
	ArrayList<String> viewGrades(String sid);

	@Query(value = "select s.gpa from Student s where s.studentid=?1", nativeQuery = true)
	double viewGpa(String sid);

	@Query(value = "Select * from student s, course c, enrolment e where e.courseid = c.courseid and e.studentid = s.studentid and c.courseid=?1", nativeQuery = true)
	ArrayList<Student> findAllStudentByCourse(String cid);

	@Query(value = "Select s.studentid, s.firstname, s.lastname, s.gpa, e.grade from caps.enrolment e,caps.student s where s.studentid=e.studentid and e.courseid = ?1", nativeQuery = true)
	ArrayList<String> findStudentsByCourse(String cid);

	@Query(value = "Select s.studentid, s.firstname, s.lastname, s.gpa, e.grade from caps.enrolment e,caps.student s where s.studentid=e.studentid and s.studentid= ?1 and e.courseid = ?2", nativeQuery = true)
	ArrayList<String> findStudent(String sid, String cid);

	@Query(value = "SELECT SUM(c.credit * e.grade) / SUM(c.credit) FROM student s, enrolment e, course c WHERE s.studentid = e.studentid AND e.courseid = c.courseid AND s.studentid=?1", nativeQuery = true)
	Double calculateGPA(String sid);
}
