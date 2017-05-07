package com.team.app.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.support.PagedListHolder;

import com.team.app.model.Course;
import com.team.app.model.Lecturer;
import com.team.app.model.Login;
import com.team.app.model.Student;

public class Pagination {

	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPaginationCourseList(List<Course> courseList, String type, HttpServletRequest req) {

		PagedListHolder<Course> cList = null;
		if (null == type) {
			cList = new PagedListHolder<Course>();
			cList.setSource(courseList);
			cList.setPageSize(5);
			req.getSession().setAttribute("courseList", cList);

		} else if ("next".equals(type)) {
			cList = (PagedListHolder<Course>) req.getSession().getAttribute("courseList");
			cList.nextPage();
		} else if ("prev".equals(type)) {
			cList = (PagedListHolder<Course>) req.getSession().getAttribute("courseList");
			cList.previousPage();
		} else {
			cList = (PagedListHolder<Course>) req.getSession().getAttribute("courseList");

			int pageNum = Integer.parseInt(type);

			cList.setPage(pageNum);
		}
	}

	public void setPaginationStudentStrList(List<String> studentList, String type, HttpServletRequest req) {
		PagedListHolder<String> cList = null;
		if (null == type) {
			cList = new PagedListHolder<String>();
			cList.setSource(studentList);
			cList.setPageSize(5);
			req.getSession().setAttribute("studentList", cList);

		} else if ("next".equals(type)) {
			cList = (PagedListHolder<String>) req.getSession().getAttribute("studentList");
			cList.nextPage();
		} else if ("prev".equals(type)) {
			cList = (PagedListHolder<String>) req.getSession().getAttribute("studentList");
			cList.previousPage();
		} else {
			cList = (PagedListHolder<String>) req.getSession().getAttribute("studentList");

			int pageNum = Integer.parseInt(type);

			cList.setPage(pageNum);
		}

	}
	public void setPaginationLecturerList(List<Lecturer> lecturerList, String type, HttpServletRequest req) {

		PagedListHolder<Lecturer> lList = null;
		if (null == type) {
			lList = new PagedListHolder<Lecturer>();
			lList.setSource(lecturerList);
			lList.setPageSize(5);
			req.getSession().setAttribute("lecturerList", lList);

		} else if ("next".equals(type)) {
			lList = (PagedListHolder<Lecturer>) req.getSession().getAttribute("lecturerList");
			lList.nextPage();
		} else if ("prev".equals(type)) {
			lList = (PagedListHolder<Lecturer>) req.getSession().getAttribute("lecturerList");
			lList.previousPage();
		} else {
			lList = (PagedListHolder<Lecturer>) req.getSession().getAttribute("lecturerList");

			int pageNum = Integer.parseInt(type);

			lList.setPage(pageNum);
		}
	}
	
	public void setPaginationStudentList(List<Student> studentList, String type, HttpServletRequest req) {

		PagedListHolder<Student> sList = null;
		if (null == type) {
			sList = new PagedListHolder<Student>();
			sList.setSource(studentList);
			sList.setPageSize(5);
			req.getSession().setAttribute("studentList", sList);

		} else if ("next".equals(type)) {
			sList = (PagedListHolder<Student>) req.getSession().getAttribute("studentList");
			sList.nextPage();
		} else if ("prev".equals(type)) {
			sList = (PagedListHolder<Student>) req.getSession().getAttribute("studentList");
			sList.previousPage();
		} else {
			sList = (PagedListHolder<Student>) req.getSession().getAttribute("studentList");

			int pageNum = Integer.parseInt(type);

			sList.setPage(pageNum);
		}
	}
	
	public void setPaginationLoginList(List<Login> loginList, String type, HttpServletRequest req) {

		PagedListHolder<Login> lList = null;
		if (null == type) {
			lList = new PagedListHolder<Login>();
			lList.setSource(loginList);
			lList.setPageSize(5);
			req.getSession().setAttribute("loginList", lList);

		} else if ("next".equals(type)) {
			lList = (PagedListHolder<Login>) req.getSession().getAttribute("loginList");
			lList.nextPage();
		} else if ("prev".equals(type)) {
			lList = (PagedListHolder<Login>) req.getSession().getAttribute("loginList");
			lList.previousPage();
		} else {
			lList = (PagedListHolder<Login>) req.getSession().getAttribute("loginList");

			int pageNum = Integer.parseInt(type);

			lList.setPage(pageNum);
		}
	}

}
