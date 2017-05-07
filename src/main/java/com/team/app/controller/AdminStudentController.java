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
import com.team.app.model.Login;
import com.team.app.model.Student;
import com.team.app.service.LoginService;
import com.team.app.service.StudentService;
import com.team.app.util.Pagination;

@Controller
@RequestMapping(value = "/admin/student")
public class AdminStudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = { "/load/{type}", "/load" }, method = RequestMethod.GET)
	public ModelAndView loadStudentDetails(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		mav.setViewName("redirect:/home/login");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			String type = pathVariablesMap.get("type");
			List<Student> studentList = studentService.findAllStudents();
			Pagination p = new Pagination();
			p.setPaginationStudentList(studentList, type, req);
			return new ModelAndView("list-students");
		}
		return mav;
	}

	@RequestMapping(value = "/details/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editStudentDetails(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Student student = studentService.findByStudentId(id);
			return new ModelAndView("edit-students", "command", student);
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/editsave", method = RequestMethod.POST)
	public ModelAndView editSaveStudentDetails(@ModelAttribute("student") Student student, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			studentService.saveStudent(student);
			return new ModelAndView("redirect:/admin/student/load", "student", student);
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/details/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Student student = studentService.findByStudentId(id);
			student.setEnrolmentCollection(null);
			studentService.deleteStudent(student);
			return new ModelAndView("redirect:/admin/student/load");
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudent(HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			ModelAndView mav = new ModelAndView("new-student", "command", new Student());
			return mav;
		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveAddStudent(@ModelAttribute("student") Student student, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			try {
				String studentId = student.getStudentid();
				Student stdn = studentService.findByStudentId(studentId);
				if (stdn == null) {
					Login login = new Login();
					login.setLoginid(student.getStudentid());
					login.setPassword(student.getStudentid());
					login.setRole("student");
					loginService.saveLogin(login);
					studentService.saveStudent(student);
					return new ModelAndView("redirect:/admin/student/load", "student", student);
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
