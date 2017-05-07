package com.team.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.app.model.Student;
import com.team.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentRepository studentRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.team.app.service.StudentService#findStudentById(java.lang.String)
	 */
	@Override
	public Student findStudentById(String studentid) {
		return studentRepository.findOne(studentid);
	}

	public ArrayList<String> viewGrades(String id) {
		return studentRepository.viewGrades(id);
	}

	public double viewGpa(String id) {
		return studentRepository.viewGpa(id);
	}

	@Override
	@Transactional
	public ArrayList<String> findStudent(String sid, String cid) {
		ArrayList<String> ul = studentRepository.findStudent(sid, cid);
		return ul;
	}

	@Override
	public Double calculateGPA(String sid) {
		Double gpa = studentRepository.calculateGPA(sid);
		return gpa;
	}

	@Override
	@Transactional
	public Student updateGPA(Student student) {
		return studentRepository.saveAndFlush(student);
	}

	@Override
	@Transactional
	public ArrayList<Student> findAllStudents() {
		ArrayList<Student> listStudent = (ArrayList<Student>) studentRepository.findAll();
		return listStudent;
	}

	@Override
	@Transactional
	public Student findByStudentId(String studentId) {
		return studentRepository.findOne(studentId);
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

}
