package com.team.app.controller;

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

import com.team.app.model.Lecturer;
import com.team.app.model.Login;
import com.team.app.service.LecturerService;
import com.team.app.service.LoginService;
import com.team.app.util.Pagination;

@Controller
@RequestMapping(value = "/admin/lecturer")
public class AdminLecturerController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = { "/load/{type}", "/load" }, method = RequestMethod.GET)
	public ModelAndView loadLecturerDetails(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home/login");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			String type = pathVariablesMap.get("type");
			List<Lecturer> lecturerList = lecturerService.findAllLecturers();
			Pagination p = new Pagination();
			p.setPaginationLecturerList(lecturerList, type, req);
			return new ModelAndView("list-lecturers");
		}

		return mav;

	}

	@RequestMapping(value = "/details/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editLecturerDetails(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Lecturer lecturer = lecturerService.findByLecturerId(id);
			return new ModelAndView("edit-lecturers", "command", lecturer);
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/editsave", method = RequestMethod.POST)
	public ModelAndView editSaveLecturerDetails(@ModelAttribute("lecturer") Lecturer lecturer, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			lecturerService.saveLecturer(lecturer);
			return new ModelAndView("redirect:/admin/lecturer/load", "lecturer", lecturer);
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("redirect:/admin/lecturer/load");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Lecturer lecturer = lecturerService.findByLecturerId(id);
			lecturerService.deleteLecturer(lecturer);
		} else {
			mav.setViewName("redirect:/home/login");
		}

		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addLecturer(HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			ModelAndView mav = new ModelAndView("new-lecturer", "command", new Lecturer());
			return mav;
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveAddLecturer(@ModelAttribute("lecturer") Lecturer lecturer, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		if (loginSession != null  && loginSession.getLogin().getRole().equals("administrator")) {
			try {
				String lecturerId = lecturer.getLecturerid();
				Lecturer lec = lecturerService.findByLecturerId(lecturerId);
				if (lec == null) {
					Login login = new Login();
					login.setLoginid(lecturer.getLecturerid());
					login.setRole("lecturer");
					login.setPassword(lecturer.getLecturerid());
					loginService.saveLogin(login);
					lecturerService.saveLecturer(lecturer);
					return new ModelAndView("redirect:/admin/lecturer/load", "lecturer", lecturer);
				} else {
					return new ModelAndView("error-page");
				}
			} catch (Exception e) {
				return new ModelAndView("error-page-empty");
			}
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

}
