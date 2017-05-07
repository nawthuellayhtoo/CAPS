package com.team.app.controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.team.app.model.Course;
import com.team.app.model.Student;
import com.team.app.service.CourseService;
import com.team.app.service.StudentService;

@Controller
@RequestMapping(value = "/email")
public class SendEmailController {

	@Autowired
	private StudentService sService;
	Properties mailServerProperties;

	@Autowired
	private CourseService cService;

	Session getMailSession;
	MimeMessage generateMailMessage;

	@RequestMapping(value = "/send/{courseid}")
	public ModelAndView generateAndSendEmail(HttpSession session, @PathVariable String courseid)
			throws AddressException, MessagingException {

		ModelAndView mav = new ModelAndView();
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");

		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		Course c = cService.findCourse(courseid);
		Student s = sService.findStudentById(us.getLogin().getLoginid());
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(s.getEmail()));
		generateMailMessage.setSubject("Successful enrolment. ");
		String emailBody = "Dear " + s.getFirstname() + ",<br> You are successfully enrolled for "
				+ c.getCoursename() + " course which is starting on " + c.getStartdate().toString()
				+ "<br><br> Regards, <br>Team 2";
		generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");

		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "sa43team2@gmail.com", "incrediblesuria");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	
		mav.setViewName("redirect:/student/list");
		return mav;

	}

}
