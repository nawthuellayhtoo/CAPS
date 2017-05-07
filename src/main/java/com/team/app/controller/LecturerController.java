package com.team.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.app.model.Course;
import com.team.app.model.Enrolment;
import com.team.app.model.Student;
import com.team.app.service.EnrolmentService;
import com.team.app.service.LecturerService;
import com.team.app.service.StudentService;
import com.team.app.util.Pagination;

@Controller
@RequestMapping(value = "/lecturer")
public class LecturerController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private EnrolmentService enrolmentService;

	@RequestMapping(value = { "/courselist/{type}", "/courselist" }, method = RequestMethod.GET)
	public ModelAndView showCourseList(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		String type = pathVariablesMap.get("type");

		if (loginSession != null && loginSession.getLogin().getRole().equals("lecturer")) {
			List<Course> courseList = lecturerService.findCoursesByLecturer(loginSession.getLogin().getLoginid());
			Pagination p = new Pagination();
			p.setPaginationCourseList(courseList, type, req);
			mav = new ModelAndView("showLecturerCourses");
		} else {
			mav.setViewName("redirect:/home/login");

		}
		return mav;
	}

	@RequestMapping(value = { "/course/enrol/{id}/{type}", "/course/enrol/{id}" }, method = RequestMethod.GET)
	public ModelAndView showStudentByCourse(@PathVariable String id, ModelMap map,
			@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("redirect:/home/login");
		if (loginSession != null  && loginSession.getLogin().getRole().equals("lecturer")) {
			List<String> studentList = lecturerService.findStudentsByCourse(id);
			Course course = lecturerService.findCourse(id);
			map.addAttribute("studentList", studentList);
			map.addAttribute("course", course);
			mav.setViewName("showStudentList");
			return mav;
		}
		return mav;

	}

	@RequestMapping(value = "/student/edit/{sid}/{cid}", method = RequestMethod.GET)
	public String editDepartmentPage(@PathVariable String sid, @PathVariable String cid, ModelMap map,
			HttpSession session) {

		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		List<String> studentList = studentService.findStudent(sid, cid);
		Enrolment enrolment = lecturerService.findEnrolmentByCourseAndStudent(sid, cid);

		if (loginSession != null && loginSession.getLogin().getRole().equals("lecturer")) {
			List<String> gradeList = new ArrayList<String>();
			gradeList.add("1");
			gradeList.add("2");
			gradeList.add("3");
			gradeList.add("4");
			gradeList.add("5");
			map.addAttribute("gradeList", gradeList);

			map.addAttribute("studentList", studentList);
			map.addAttribute("enrolment", enrolment);
			return "editStudentGrade";
		} else {
			return ("redirect:/home/login");

		}

	}

	@RequestMapping(value = "/student/gradeupdate/{eid}", method = RequestMethod.POST)
	public ModelAndView editDepartment(@ModelAttribute @Valid Enrolment enrolment, BindingResult result,
			@PathVariable String eid, final RedirectAttributes redirectAttributes, HttpSession session) {

		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		if (result.hasErrors()) {
			return new ModelAndView("editStudentGrade");
		}

		ModelAndView mav = new ModelAndView("redirect:/lecturer/courselist");

		if (loginSession != null && loginSession.getLogin().getRole().equals("lecturer")) {
			int enrolId = Integer.parseInt(eid);
			Enrolment updatedEnrol = lecturerService.findEnrolmentByEnrolId(enrolId);

			String sid = updatedEnrol.getStudentid().getStudentid();

			updatedEnrol.setGrade(enrolment.getGrade());
			enrolmentService.changeGrade(updatedEnrol);

			Student student = studentService.findStudentById(sid);

			Double gpa = studentService.calculateGPA(sid);
			String strGPA = String.format("%.2f", gpa);
			gpa = Double.parseDouble(strGPA);

			student.setGpa(gpa);
			studentService.updateGPA(student);
		} else {
			mav.setViewName("redirect:/home/login");

		}

		return mav;

	}
}
