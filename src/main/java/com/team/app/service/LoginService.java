package com.team.app.service;

import java.util.ArrayList;

import com.team.app.model.Login;

public interface LoginService
{
	Login authenticate(String loginId, String password);

	Login saveLogin(Login login);

	ArrayList<Login> findAllLogin();

	Login findByLoginId(String loginId);

	void deleteLogin(Login login);

	ArrayList<String> findAllLoginRole();
}
