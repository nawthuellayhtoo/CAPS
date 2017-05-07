package com.team.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.app.model.Login;
import com.team.app.service.LoginService;
import com.team.app.util.Pagination;

@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = { "/load/{type}", "/load" }, method = RequestMethod.GET)
	public ModelAndView loadLoginDetails(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		mav.setViewName("redirect:/home/login");
		if (loginSession != null) {
			String type = pathVariablesMap.get("type");
			List<Login> loginList = loginService.findAllLogin();
			Pagination p = new Pagination();
			p.setPaginationLoginList(loginList, type, req);
			return new ModelAndView("list-login");
		}
		return mav;

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addLogin(HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("new-login", "command", new Login());

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			ArrayList<String> lrole = loginService.findAllLoginRole();
			mav.addObject("lrole", lrole);
		} else {
			mav.setViewName("redirect:/home/login");
		}

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveAddLogin(@ModelAttribute("login") Login login, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			try{
				Login lin = loginService.findByLoginId(login.getLoginid());
				if (lin == null) {
					loginService.saveLogin(login);
					return new ModelAndView("redirect:/admin/login/load", "login", login);
				} else {
					return new ModelAndView("error-page");
				}
			}catch(Exception e){
				return new ModelAndView("error-page-empty");
			}		
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLecturerDetails(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		Login login = loginService.findByLoginId(id);
		ModelAndView mav = new ModelAndView("edit-login", "command", login);

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			ArrayList<String> lrole = loginService.findAllLoginRole();
			mav.addObject("lrole", lrole);
		} else {
			mav.setViewName("redirect:/home/login");
		}

		return mav;
	}

	@RequestMapping(value = "/details/editsave", method = RequestMethod.POST)
	public ModelAndView editSaveLecturerDetails(@ModelAttribute("lecturer") Login login, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			loginService.saveLogin(login);
			return new ModelAndView("redirect:/admin/login/load", "login", login);
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteLogin(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("redirect:/admin/login/load");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Login login = loginService.findByLoginId(id);
			loginService.deleteLogin(login);
		} else {
			mav.setViewName("redirect:/home/login");
		}
		
		return mav;
		
	}
}
