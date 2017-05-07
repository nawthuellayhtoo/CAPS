package com.team.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.app.model.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, String> {
	@Query("SELECT DISTINCT l.lecturerid FROM Lecturer l")
	ArrayList<String> findAllLecturerId();

	@Query("SELECT DISTINCT l.firstname FROM Lecturer l")
	ArrayList<String> findAllLecturerFirstName();

	@Query("SELECT DISTINCT l.lastname FROM Lecturer l")
	ArrayList<String> findAllLecturerLastName();
}
