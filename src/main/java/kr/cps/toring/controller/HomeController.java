package kr.cps.toring.controller;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cps.toring.service.MentorNoticeService;
import kr.cps.toring.service.MymenteeService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private MymenteeService mymenteeService;
	private MentorNoticeService mentorNoticeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	public void setMyFamilyService(MymenteeService mymenteeService,MentorNoticeService mentorNoticeService) {
		this.mymenteeService = mymenteeService;
		this.mentorNoticeService = mentorNoticeService;
	}
	
	
	
	
	//메인 홈페이지 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("mentorList", mentorNoticeService.getMentor());
	
		return "main_page";
	}
	
	 
	//후기 신청서 작성
	@RequestMapping(value="/ReviewEnrollment")
	public String rewviewinsert(Model model)throws Exception {
		 int postnum = mymenteeService.postnum()+1;
		 model.addAttribute("postnum" , postnum);
		return "ReviewEnrollment";
	}
	
	//후기 전체 글 페이지 
	@RequestMapping(value="/Reviewlist")
	public String Reviewlist() {
		
	return "Reviewlist";	
	}
	   
	//후기 상세페이지 
	@RequestMapping(value="/ReviewDetailpage")
	public String ReviewDetailpate(Model model, @RequestParam("postnumber") String postnum) {
		model.addAttribute("postnum",postnum);
		
		return "ReviewDetailpage";
	}
	
	//후기 수정 페이지 
	@RequestMapping(value="/Reviewupdate")
	public String Reviewupdate(HttpServletRequest req,Model model)throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		    
		String postnum = req.getParameter("postnum");
		String applyTitle = req.getParameter("applyTitle");
		String applysubject = req.getParameter("applysubject");
	
		model.addAttribute("postnum", postnum);
		model.addAttribute("headname",applyTitle);
		model.addAttribute("subject", applysubject);
		
		
		return "Reviewupdate";
	}
	
	//멘티 신청서 작성 페이지
	@RequestMapping(value="Menteeapply")
	public String menteeapply(@RequestParam("postnum") String postnum,  Model model) {
		model.addAttribute("postnum", postnum);
		//System.out.println(postnum);
		
		return "Menteeapply";
	}
	
	//마이 페이지에서 자신이 신청한 멘티 신청서를 볼수 있음  신청중일 때만수정, 삭제 가능
	
	@RequestMapping(value="MyMenteeapplylist")
	public String mymenteeapplylist() {
		
		return "MyMenteeapplylist";
	}
	
	
	@RequestMapping(value="/Menteeapplyupdate")
	public String menteeapplyupdate(HttpServletRequest req,Model model)throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		    
		model.addAttribute("postnum", req.getParameter("postnum"));
		model.addAttribute("headname",req.getParameter("inputheadname"));
		model.addAttribute("subject", req.getParameter("applysubject"));
		model.addAttribute("time", req.getParameter("time"));
		

		/*System.out.println(req.getParameter("postnum"));
		System.out.println(req.getParameter("inputheadname"));
		System.out.println(req.getParameter("applysubject"));
		
		System.out.println(req.getParameter("time"));*/
		  
		return "Menteeapplyupdate";
	}
	
	
	
	//자유게시판 
	@RequestMapping(value="/Freenoticelist")
	public String freenoticelist() {
		
		return "Freenoticelist";
	}
	
	//자유게시판 글 등록 페이지
	@RequestMapping(value="/FreenoticeEnrollment")
	public String freenoticeEnrollment() {
		return "FreenoticeEnrollment";
	}
	
	//자유게시판 수정 페이지
	 @RequestMapping(value="/Freenoticeupdate")
	 public String freeupdate(HttpServletRequest req,Model model) throws UnsupportedEncodingException {
		 req.setCharacterEncoding("utf-8");
		 
		 String headname = req.getParameter("inputheadname");
		 String postnum = req.getParameter("postnum");
		 String subject = req.getParameter("applysubject");
		 
		  
		 model.addAttribute("headname", headname);
		 model.addAttribute("postnum", postnum);
		 model.addAttribute("subject", subject);
		 
		 return "Freenoticeupdate";
	 }
	 
	//자신이 올린 자유게시판 수정 삭제 페이지
	 @RequestMapping(value="/Myfreenoticelist")
	public String Myfreenoticelist() {
		 return "Myfreenoticelist";
	 }

	 
	 
	 //자신의 후기 들 가져오기
	 @RequestMapping(value="/MyReviewlist")
	 public String MyReviewlist(){
		 return "MyReviewlist";
	 }
	 
	 
	 //홈페이지 소개
	 @RequestMapping(value="/Introduce")
	 public String  introduce() {
		 return "Introduce";
	 }
	 
	 //홈페이지 가이드
	 @RequestMapping(value="/Guide")
	 public String guide() {
		 return "Guide";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 //예제
	 
	 @RequestMapping(value="/Charttoring")
		public String chart(Model model) {
		 
		 model.addAttribute("usercount", mymenteeService.usercount().get(0));
		 model.addAttribute("usermentor", mymenteeService.usermentor().get(0));
		 model.addAttribute("menteecount", mymenteeService.menteecount().get(0));
		 model.addAttribute("mentorcountnotice", mymenteeService.mentornoticecount().get(0));
		 model.addAttribute("groupstudy", mymenteeService.groupcount().get(0));
		 
			 return "Charttoring";
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 //지도 예제 
	 @RequestMapping(value="/TestingMap")
	 public String mapstest() {
		 return "TestingMap";
	 }
	 
	 
	/* @RequestMapping(value="/JusoPopup")
	 public String maps() {
		 return "JusoPopup";
	 }*/
		@RequestMapping(value = "/JusoPopup", method = { RequestMethod.GET,RequestMethod.POST})
		public String jusoPopup( Model model) {
			logger.info("jusoPopup {}."); //showFamily_page

		
			return "jusoPopup";
		}
			
	 
	 
	 
	 
}
