package kr.cps.toring.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cps.toring.model.User;
import kr.cps.toring.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userservice;
	
	private static final Logger Logger = LoggerFactory.getLogger(UserController.class);

	//마이페이지 내 정보 가져오기
	@RequestMapping(value = "/my_page_redata")
	public String my_page_redata(ModelMap model,HttpSession session) throws Exception {

		String id = (String) session.getAttribute("sessionID");
		
		if(id==null || id.equals("")){                            // id가 Null 이거나 없을 경우
			
			
			return "redirect:/";
			}

		model.addAttribute("UserData", userservice.getMulitiRow(id));
		// return "redirect:resources/mypage_retouch.jsp";
		return "my_page_redata";
	}

	@RequestMapping(value = "/getUserData_pass", method = RequestMethod.POST)
	public String getUserData_pass(@RequestParam("userID") String UserID, ModelMap model) throws Exception {

		model.addAttribute("UserData", userservice.getMulitiRow(UserID));

		return "mypage_retouch_pass";
	}

	//마이 페이지 호출
	@RequestMapping(value = "/my_page")
	public String my_page() throws Exception {

		return "my_page";
	}
	
	//마이페이지 비밀번호 재설정 전에 체크 페이지 호출
	@RequestMapping(value = "/my_page_passCheck")
	public String my_page_passCheck(HttpSession session) throws Exception {
		
		return "my_page_passCheck";
	}
	//마이페이지 비밀번호 재설정 전에 체크 액션
		@RequestMapping(value = "/passCheckAction")
		public String passCheckAction(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam("userPassword")String userPassword,@RequestParam("userPassword2")String userPassword2) throws Exception {
			
			if(userPassword.equals(userPassword2)){
				String strID = (String)session.getAttribute("sessionID");
				String userpass = userservice.getPw(strID);
				if(userpass.equals(userPassword)){
					return "my_page_repass";
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 틀립니다..');</script>");
			out.flush();
		
			return "my_page_passCheck";
			
		}
	
	//마이페이지 비밀번호 재설정 페이지 호출
	@RequestMapping(value = "/my_page_repass")
	public String my_page_repass() throws Exception {

		return "my_page_repass";
	}
	
	//마이페이지 비밀번호 재설정 액션
	@RequestMapping(value = "/rePassAction")
	public String rePassAction(HttpServletResponse response, HttpServletRequest request, HttpSession session, @RequestParam("userPassword")String userPassword,@RequestParam("userPassword2")String userPassword2) throws Exception {
		
		if(userPassword.equals(userPassword2)){
			String userID = (String)session.getAttribute("sessionID");
			userservice.setUserPassService(userID, userPassword);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 성공적으로 변경되었습니다.');</script>");
			out.flush();
			
			return "my_page";
		}
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('변경할 비밀번호가 서로 다릅니다.');</script>");
			out.flush();
		
		return "my_page_repass";
	}
	
	//개인정보 수정
	@RequestMapping(value = "/redataAction")
	public String mypage_rePess(
			@RequestParam("userName") String username,
			@RequestParam("userEmail") String useremail, 
			@RequestParam("userPassword") String userpassword,
			@RequestParam("userPassword2") String userpassword2, 
			@RequestParam("userBDAY") String userbday,
			@RequestParam("sex_MF") String usersex, 
			@RequestParam("userTemper") String usertemper,
			@RequestParam("userDepartment") String userdepartment,
			@RequestParam("userTel") String usertel, 
			@RequestParam("userGrade") String usergrade,
			@RequestParam("RadioMentoMentee") String userdivision,
			@RequestParam("userPicture")String userpicture,
			@RequestParam("userTeaching")String userteaching,
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session) throws Exception 
	{
		if (!(userpassword.equals(userpassword2))) {
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('기존 비밀번호가 아니거나 비밀번호가 서로 다릅니다.');</script>");
				out.flush();
				return "my_page";
		}else{
			String getPassword = userservice.getPw(useremail);
			if(getPassword.equals(userpassword)){
				
				User user = new User();
				int usernumber = (Integer)session.getAttribute("sessionNUMBER");
				user.setUserNumber(usernumber);
				user.setUserName(username);
				user.setUserID(useremail);
				user.setUserPassword(userpassword);
				user.setUserDDay(userbday);
				user.setUserGender(usersex);
				user.setUsertemper(usertemper);
				user.setUserDepartment(userdepartment);
				user.setUserTel(usertel);
				user.setUserGrade(usergrade);
				user.setUserDivision(userdivision);
				user.setUserPicture(userpicture);
				user.setUserTeaching(userteaching);
				userservice.setUpdate(user);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('개인 정보가 수정되었습니다!');</script>");
				out.flush();
				return "my_page";
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('기존 비밀번호가 아니거나 비밀번호가 서로 다릅니다.');</script>");
		out.flush();
		
		return "my_page"; 
	}

	//로그인
	@RequestMapping(value = "/logincontroller", method=RequestMethod.POST)
	public String loginController(@RequestParam("userID") String id, @RequestParam("userPassword") String password
			,HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session)
			throws Exception {

		int loginreturn = userservice.loginService(id, password);

		if (loginreturn == 1){
			List<User> newuser = userservice.getUserService(id);
			session.setAttribute("sessionID", newuser.get(0).getUserID());
			session.setAttribute("sessionNAME", newuser.get(0).getUserName());
			session.setAttribute("sessionNUMBER", newuser.get(0).getUserNumber());
			session.setAttribute("sessionTEMPER", newuser.get(0).getUsertemper());
			session.setAttribute("sessionDIVISION", newuser.get(0).getUserDivision());
		}else{
			//스크립트
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력 정보를 다시 확인해주세요!!');</script>");
			out.flush();
		}
			return "main_page";
//			return "redirect:/";
	}
	
	//회원가입
	@RequestMapping(value = "/registercontroller", method=RequestMethod.POST)
	public String registerController(@RequestParam("userName") String username,
			@RequestParam("userEmail") String useremail, 
			@RequestParam("userPassword") String userpassword,
			@RequestParam("userPassword2") String userpassword2, 
			@RequestParam("userBDAY") String userbday,
			@RequestParam("sex_MF") String usersex, 
			@RequestParam("userDepartment") String userdepartment,
			@RequestParam("userTemper") String usertemper,
			@RequestParam("userTel") String usertel, 
			@RequestParam("userGrade") String usergrade,
			@RequestParam("RadioMentoMentee") String userdivision, 
//			@RequestParam("userPicture")String userpicture,
//			@RequestParam("userTeaching")String userteaching,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		User user = new User();
		if (!(userpassword.equals(userpassword2))) {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력 정보를 다시 확인해주세요!!');</script>");
			out.flush();
			return "main_page";
			
		}else{
			
			user.setUserName(username);
			user.setUserID(useremail);
			user.setUserPassword(userpassword);
			user.setUserDDay(userbday);
			user.setUserGender(usersex);
			user.setUsertemper(usertemper);
			user.setUserDepartment(userdepartment);
			user.setUserTel(usertel);
			user.setUserGrade(usergrade);
			user.setUserDivision(userdivision);
//			user.setUserPicture(userpicture);
//			user.setUserTeaching(userteaching);
			
			int signal = userservice.registerService(user);
			if(signal == 1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원가입 성공'); </script>");
				out.flush();
			}else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('회원가입 실패, 동일한 ID가 있습니다.'); </script>");
				out.flush();
			}
			return "main_page";
		}
		
	}
	
	//로그아웃
	@RequestMapping(value = "/logoutAction")
	public String logoutAction(HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		session.invalidate();
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>alert('로그아웃 되었습니다.'); location.href='/toring/';</script>");
//		out.flush();
//		
		return "redirect:/";
	}

	
}
