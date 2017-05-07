package com.team.app.service;

import java.util.ArrayList;

import com.team.app.model.Student;

public interface StudentService {

	Student findStudentById(String studentid);

	ArrayList<String> viewGrades(String id);

	double viewGpa(String id);

	Student updateGPA(Student student);

	ArrayList<String> findStudent(String sid, String cid);

	Double calculateGPA(String sid);

	ArrayList<Student> findAllStudents();

	Student findByStudentId(String studentId);

	Student saveStudent(Student student);

	void deleteStudent(Student student);

}