package com.team.app.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.app.model.Enrolment;
import com.team.app.service.EnrolmentService;

@Controller
@RequestMapping(value = "/admin/enrolment")
public class AdminEnrolmentController {

	@Autowired
	private EnrolmentService enrolmentService;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public ModelAndView viewEnrolment(HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ArrayList<String> eList = enrolmentService.findEnrolmentAll();
		ModelAndView mav = new ModelAndView("list-enrolments");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			mav.addObject("eList", eList);
		} else {
			mav.setViewName("redirect:/home/login");
		}

		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEnrolment(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Integer i = Integer.parseInt(id);
			Enrolment enrolment = enrolmentService.findOneByInteger(i);
			enrolmentService.deleteEnrolment(enrolment);
			return new ModelAndView("redirect:/admin/enrolment/load");
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

}
