package com.team.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.app.model.Enrolment;
import com.team.app.repository.EnrolmentRepository;

@Service
public class EnrolmentServiceImpl implements EnrolmentService {

	@Resource
	EnrolmentRepository enrolmentRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.team.app.service.EnrolmentService#createEnrolment(com.team.app.model.
	 * Enrolment)
	 */
	@Override
	@Transactional
	public Enrolment createEnrolment(Enrolment enrolment) {
		return enrolmentRepository.saveAndFlush(enrolment);
	}

	@Override
	@Transactional
	public Enrolment changeGrade(Enrolment enrolment) {
		return enrolmentRepository.saveAndFlush(enrolment);
	}

	@Override
	@Transactional
	public void deleteEnrolment(Enrolment erol) {
		enrolmentRepository.delete(erol);
	}

	@Override
	@Transactional
	public ArrayList<String> findEnrolmentAll() {
		ArrayList<String> eList = enrolmentRepository.findEnrolmentAll();
		return eList;
	}

	@Override
	@Transactional
	public ArrayList<Enrolment> findEnrolmentAllByCourseId(String cid) {
		ArrayList<Enrolment> eList = enrolmentRepository.findEnrolmentAllByCourseId(cid);
		return eList;
	}

	@Override
	@Transactional
	public Enrolment findOneByInteger(Integer enrolId) {
		return enrolmentRepository.findOneByInteger(enrolId);
	}

}
