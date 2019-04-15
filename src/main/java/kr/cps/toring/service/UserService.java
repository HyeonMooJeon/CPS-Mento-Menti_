package kr.cps.toring.service;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import kr.cps.toring.dao.UserDAO;
import kr.cps.toring.model.Email;
import kr.cps.toring.model.User;

@Service
public class UserService {

	UserDAO userDAO = new UserDAO();

	// 회원정보 가져오기
	public List<User> getMulitiRow(String UserID) {

		return userDAO.getUserMultiRow(UserID);
	}

	// 업데이트
	public int setUpdate(User newuser) {

		try {

			userDAO.setUserUpdate(newuser);
			return 0;

		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}

	}

	// 비밀번호찾기
	public String getPw(String e_mail) {

		return userDAO.getPw(e_mail);
	}

	// 비밀번호바꾸기
	public void setUserPassService(String userID, String userPassword) {

		userDAO.setUserPass(userID, userPassword);
	}

	// 회원가입서비스
	public int registerService(User user) {

		return userDAO.Register(user);
	}

	// 로그인 서비스
	public int loginService(String userID, String password) {

		return userDAO.login(userID, password);
	}

	// 유저 리턴
	public List<User> getUserService(String userID) {

		return userDAO.getUserMultiRow(userID);
	}

}
