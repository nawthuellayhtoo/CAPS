package com.team.app.service;

import java.util.ArrayList;

import com.team.app.model.Enrolment;

public interface EnrolmentService {

	Enrolment createEnrolment(Enrolment enrolment);

	Enrolment changeGrade(Enrolment enrolment);

	void deleteEnrolment(Enrolment erol);

	ArrayList<String> findEnrolmentAll();

	ArrayList<Enrolment> findEnrolmentAllByCourseId(String cid);

	Enrolment findOneByInteger(Integer enrolId);
}