package com.team.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.app.model.Enrolment;

public interface EnrolmentRepository extends JpaRepository<Enrolment, Integer> {

	@Query(value = "Select * from caps.enrolment e where e.courseid = ?1", nativeQuery = true)
	ArrayList<Enrolment> findEnrolmentByCourse(String cid);

	@Query(value = "Select e.* from enrolment e,student s where s.studentid=e.studentid and s.studentid= ?1 and e.courseid = ?2", nativeQuery = true)
	Enrolment findEnrolmentByCourseAndStudent(String sid, String cid);

	@Query(value = "Select e.enrolmentid, e.studentid, s.firstname, s.lastname, e.enrolmentdate, e.grade, c.courseid, c.coursename from enrolment e, student s, course c where s.studentid=e.studentid and e.courseid=c.courseid", nativeQuery = true)
	ArrayList<String> findEnrolmentAll();
	
	@Query(value = "Select * from enrolment e, course c where c.courseid = e.courseid and e.courseid =?1", nativeQuery = true)
	ArrayList<Enrolment> findEnrolmentAllByCourseId(String cid);
	
	@Query(value = "Select * from enrolment e where e.enrolmentid =?1", nativeQuery = true)
	Enrolment findOneByInteger(Integer eid);
}
