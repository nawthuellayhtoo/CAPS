package com.team.app.controller;

import java.util.ArrayList;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.app.model.Course;
import com.team.app.model.Enrolment;
import com.team.app.model.Student;
import com.team.app.service.CourseService;
import com.team.app.service.EnrolmentService;
import com.team.app.service.StudentService;
//import com.team.app.controller.UserSession;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private CourseService cService;

	@Autowired
	private EnrolmentService eService;

	@Autowired
	private StudentService sService;

	@RequestMapping(value = "/view/{courseid}", method = RequestMethod.GET)
	public ModelAndView viewCourseDetails(@PathVariable String courseid, HttpSession session) {
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		if (us != null && us.getLogin().getRole().equals("student")) {
			mav = new ModelAndView("viewCourseDetails");
			Course course = cService.findCourse(courseid);
			mav.addObject("course", course);
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/view/{courseid}", method = RequestMethod.POST)
	public ModelAndView createNewCourse(@PathVariable String courseid, @ModelAttribute Enrolment enrolment,
			final RedirectAttributes redirectAttributes, HttpSession session) {

		ModelAndView mav = new ModelAndView("");

		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (us != null  && us.getLogin().getRole().equals("student")) {
			String s = us.getLogin().getLoginid();
			Course course = cService.findCourse(courseid);
			enrolment.setCourseid(course);

			Student student = sService.findStudentById(s);
			enrolment.setStudentid(student);

			enrolment.setEnrolmentdate(new Date());

			eService.createEnrolment(enrolment);

			String cid = enrolment.getCourseid().getCourseid();
			Course c = cService.findCourse(cid);
			c.setSize(c.getSize() - 1);
			cService.updateCourse(c);
			JFrame frame = new JFrame("JOptinPane showMessageDialog example");
			frame.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(frame, "Enrollment Successful! Confirmation Email has been sent to you!",
					"Meggage Box", JOptionPane.INFORMATION_MESSAGE);
			
			mav.setViewName("redirect:/email/send/{courseid}");
		} else {
			mav.setViewName("redirect:/home/login");
		}

		return mav;
	}

	@RequestMapping(value = "/grade", method = RequestMethod.GET)
	public ModelAndView viewGradesPage(HttpSession session) {
		ModelAndView mav = new ModelAndView("");
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (us != null   && us.getLogin().getRole().equals("student")) {
			String s = us.getLogin().getLoginid();

			mav = new ModelAndView("viewGrades");
			try {
				ArrayList<String> gradesList = sService.viewGrades(s);
				mav.addObject("gradesList", gradesList);
				double gpa = sService.viewGpa(s);
				mav.addObject("gpa", gpa);
			} catch (Exception npe) {
				mav.setViewName("error-page-null");
			}

		} else

		{
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}
}
