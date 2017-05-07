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

import com.team.app.model.Course;
import com.team.app.model.Lecturer;
import com.team.app.service.CourseService;
import com.team.app.service.LecturerService;
import com.team.app.util.Pagination;

@Controller
@RequestMapping(value = "/admin/course")
public class AdminCourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private LecturerService lecturerService;

	@RequestMapping(value = { "/load/{type}", "/load" }, method = RequestMethod.GET)
	public ModelAndView loadCourseDetails(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {

			String type = pathVariablesMap.get("type");
			mav = new ModelAndView("list-courses");

			List<Course> courseList = courseService.findAllCourses();
			Pagination p = new Pagination();
			p.setPaginationCourseList(courseList, type, req);
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/details/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCourseDetails(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Course course = courseService.findByCourseId(id);
			mav = new ModelAndView("edit-courses", "command", course);
			mav.addObject("lidlist", lecturerService.findAllLecturerId());
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/details/editsave", method = RequestMethod.POST)
	public ModelAndView editSaveCourseDetails(@ModelAttribute("course") Course course, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav;
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			mav = new ModelAndView("redirect:/admin/course/load");
			Lecturer lecturer = lecturerService.findByLecturerId(course.getCourseid());
			mav.addObject("lecturer", lecturer);
			mav.addObject("course", course);
			courseService.updateCourse(course);
			return mav;

		} else {
			return new ModelAndView("redirect:/home/login");
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCourse(HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			mav = new ModelAndView("new-course", "command", new Course());
			mav.addObject("lidlist", lecturerService.findAllLecturerId());
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveAddCourse(@ModelAttribute("course") Course course, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");

		ModelAndView mav = new ModelAndView("");
		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			try{
				String cid = course.getCourseid();
				Course cou = courseService.findByCourseId(cid);
				if (cou == null) {
					mav = new ModelAndView("redirect:/admin/course/load");
					Lecturer lecturer = lecturerService.findByLecturerId(course.getCourseid());
					mav.addObject("lecturer", lecturer);
					mav.addObject("course", course);
					courseService.saveCourse(course);
					return mav;
				} else {
					mav.setViewName("error-page");
				}				
				}catch(Exception e){
					mav.setViewName("error-page-empty");
			}
			
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

	@RequestMapping(value = "/details/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCourse(@PathVariable String id, HttpSession session) {
		UserSession loginSession = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("redirect:/admin/course/load");

		if (loginSession != null && loginSession.getLogin().getRole().equals("administrator")) {
			Course course = courseService.findByCourseId(id);
			courseService.deleteCourse(course);
		} else {
			mav.setViewName("redirect:/home/login");
		}
		return mav;
	}

}
