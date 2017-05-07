package com.team.app.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team.app.model.Course;
import com.team.app.service.CourseService;

@Controller
@RequestMapping(value = "/student")
public class WebPaginationController {

	@Autowired
	private CourseService cService;

	@RequestMapping(value = { "/list/{type}", "/list" }, method = RequestMethod.GET)
	public ModelAndView all(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req,
			HttpSession session) {

		ModelAndView mav = new ModelAndView("");
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		
		if (us != null  && us.getLogin().getRole().equals("student")) {

			PagedListHolder<Course> courseList = null;

			String type = pathVariablesMap.get("type");		

			mav = new ModelAndView("viewCourse");

			if (null == type) {
				// First Request, Return first set of list
				ArrayList<Course> coursesList = cService.viewCourses(us.getLogin().getLoginid());

				courseList = new PagedListHolder<Course>();
				courseList.setSource(coursesList);
				courseList.setPageSize(5);

				req.getSession().setAttribute("coursesLists", courseList);

				printPageDetails(courseList);

			} else if ("next".equals(type)) {
				// Return next set of list
				courseList = (PagedListHolder<Course>) req.getSession().getAttribute("coursesLists");

				courseList.nextPage();

				printPageDetails(courseList);

			} else if ("prev".equals(type)) {
				// Return previous set of list
				courseList = (PagedListHolder<Course>) req.getSession().getAttribute("coursesLists");

				courseList.previousPage();

				printPageDetails(courseList);

			} else {
				// Return specific index set of list
				System.out.println("type:" + type);

				courseList = (PagedListHolder<Course>) req.getSession().getAttribute("coursesLists");

				int pageNum = Integer.parseInt(type);

				courseList.setPage(pageNum);

				printPageDetails(courseList);
			}
		}
		 
		else {
			mav.setViewName("redirect:/home/login");
		
		}

		return mav;
	}

	private void printPageDetails(PagedListHolder courseList) {

		System.out.println("curent page - productList.getPage() :" + courseList.getPage());

		System.out.println("Total Num of pages - productList.getPageCount :" + courseList.getPageCount());

		System.out.println("is First page - productList.isFirstPage :" + courseList.isFirstPage());

		System.out.println("is Last page - productList.isLastPage :" + courseList.isLastPage());
	}
}