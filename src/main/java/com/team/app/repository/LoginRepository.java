package com.team.app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team.app.model.Login;

public interface LoginRepository extends JpaRepository<Login, String> {

	@Query(value = "Select * from caps.login where loginid=?1 and password=?2", nativeQuery = true)
	Login findUserByNamePwd(String loginId, String password);

	@Query("SELECT DISTINCT l.role FROM Login l")
	ArrayList<String> findAllLoginRole();
}
