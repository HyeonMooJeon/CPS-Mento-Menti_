package kr.cps.toring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cps.toring.model.Email;
import kr.cps.toring.service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailSender;
	@Autowired
	private Email email;

	@RequestMapping(value = "/sendpwconroller", method = RequestMethod.POST)
	public String sendEmailAction(@RequestParam("inputEmail") String id, ModelMap model,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String e_mail = id;
		String pw = emailSender.getPw(e_mail); // 비버검사필요
		System.out.println(pw);

		if (pw != null) {
			email.setContent("비밀번호는 " + pw + " 입니다.");
			email.setReceiver(e_mail);
			email.setSubject(id + "님 비밀번호 찾기 메일입니다.");
			emailSender.SendEmail(email);
			return "main_page";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력 정보를 다시 확인해주세요!!'); history.go(-1);</script>");
			out.flush();
			return "main_page";
		}
	}
	
//	@RequestMapping(value = "/setUserUpdate", method = RequestMethod.POST)
//	public String setUserUpdate(@RequestParam("inputEmail") String id, ModelMap model) throws Exception {
//		String e_mail = id;
//		String pw = userservice.getPw(e_mail); // 비버검사필요
//		System.out.println(pw);
//
//		if (pw != null) {
//			email.setContent("비밀번호는 " + pw + " 입니다.");
//			email.setReceiver(e_mail);
//			email.setSubject(id + "님 비밀번호 찾기 메일입니다.");
//			userservice.SendEmail(email);
//			return "redirect:resources/index.jsp";
//		} else {
//			return "redirect:resources/index.jsp";
//		}
//	}

}
