package com.team.app.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.app.model.Login;
import com.team.app.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginRepository loginRepository;

	@Override
	@Transactional
	public Login authenticate(String loginId, String password) {
		Login loginUser = loginRepository.findUserByNamePwd(loginId, password);
		return loginUser;
	}

	@Override
	@Transactional
	public Login saveLogin(Login login) {
		return loginRepository.save(login);
	}

	@Override
	@Transactional
	public ArrayList<Login> findAllLogin() {
		return (ArrayList<Login>) loginRepository.findAll();
	}

	@Override
	@Transactional
	public Login findByLoginId(String loginId) {
		return loginRepository.findOne(loginId);
	}

	@Override
	@Transactional
	public void deleteLogin(Login login) {
		loginRepository.delete(login);
	}

	@Override
	@Transactional
	public ArrayList<String> findAllLoginRole() {
		ArrayList<String> listLogin = loginRepository.findAllLoginRole();
		return listLogin;
	}
}
