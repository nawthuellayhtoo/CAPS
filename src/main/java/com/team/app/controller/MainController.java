package com.team.app.controller;

import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team.app.model.Login;
import com.team.app.service.LoginService;
import com.team.app.validator.LoginValidator;

@Controller
@RequestMapping(value = "/home")
public class MainController {

	@Autowired
	private LoginValidator loginValidator;

	@Autowired
	private LoginService loginService;

	@InitBinder("login")
	private void initLoginBinder(WebDataBinder binder) {
		binder.addValidators(loginValidator);
	}

	@RequestMapping(value = "/app/home/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("login", new Login());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute Login login, HttpSession session,
			final RedirectAttributes redirectAttributes, BindingResult result) {
		loginValidator.validate(login, result);
		ModelAndView mav = new ModelAndView("");
		if (result.hasErrors()) {
			return new ModelAndView("login");
		}
		UserSession userSession = new UserSession();
		if (login.getLoginid() != null && login.getPassword() != null) {
			Login loginUser = null;

			loginUser = loginService.authenticate(login.getLoginid(), login.getPassword());
			if (loginUser == null) {
				mav = new ModelAndView("redirect:/home/login");
				JFrame frame = new JFrame("JoptionPane showMessageDialog example");
				JOptionPane.showMessageDialog(frame, "LoginId or Password is wrong", "Error Box",
						JOptionPane.INFORMATION_MESSAGE);
			  frame.setAlwaysOnTop(true);
			  
			} else {
				userSession.setLogin(loginUser);
				userSession.setSessionId(session.getId());

				if (loginUser.getRole().equalsIgnoreCase("administrator")) {

					mav = new ModelAndView("redirect:/admin/student/load");

				} else if (loginUser.getRole().equalsIgnoreCase("lecturer")) {

					mav = new ModelAndView("redirect:/lecturer/courselist");

				} else if (loginUser.getRole().equalsIgnoreCase("student")) {

					mav = new ModelAndView("redirect:/student/list");
				} else {

					return mav;
				}

			}
			session.setAttribute("USERSESSION", userSession);
		}
		return mav;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}

}
