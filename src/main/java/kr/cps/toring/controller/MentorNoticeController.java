package kr.cps.toring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cps.toring.model.MentorNotice;
import kr.cps.toring.service.MentorNoticeService;

@Controller
public class MentorNoticeController {

	private MentorNoticeService mentorNoticeService;
	
	@Autowired
	public void setMentorNoticeService(MentorNoticeService mentorNoticeService){
		this.mentorNoticeService = mentorNoticeService;
	}
	
	//멘토 리스트
	@RequestMapping(value="/mentorBoard")
	public String mentorBoard(Model model){
		model.addAttribute("mentorList", mentorNoticeService.getMentor());
		return "mentorBoard_page";
	}
	//멘토 페이지
	@RequestMapping(value="/mentor")
	public String mentor(@RequestParam("mentorNumber") int memberNumber,Model model){
		model.addAttribute("mentorNotice", mentorNoticeService.getMentorNotice(memberNumber));
		model.addAttribute("mentor", mentorNoticeService.getUser(memberNumber));
		return "mentor_page";
	}
	//멘토링 게시판
	@RequestMapping(value="/mentorNoticeBoard")
	public String mentorNoticeBoard(Model model){
		model.addAttribute("recruitingNotice", mentorNoticeService.getAllRecord());
		return "mentorNoticeBoard_page";
	}
	//게시글상세내용
	@RequestMapping(value="/mentorNotice")
	public String notice(@RequestParam("number") int noticeNumber, @RequestParam("prepares") int prepares,Model model){
		MentorNotice mentorNotice = mentorNoticeService.getRecord(noticeNumber);
		model.addAttribute("notice", mentorNotice);
		model.addAttribute("prepares",prepares);
		return "mentorNotice_page";
	}
	//게시글 입력 폼
	@RequestMapping(value="/makeMentorNotice", method = RequestMethod.GET)
	public String makeMentorNotice(){		
		return "makeMentorNotice_page";
	}
	//게시글 수정 폼
	@RequestMapping(value = "/editMentorNotice", method = RequestMethod.POST)
	public String editMentorNotice(@RequestParam("number") int noticeNumber, Model model){
		model.addAttribute("notice", mentorNoticeService.getRecord(noticeNumber));
		return "editMentorNotice_page";
	}
	@RequestMapping(value="/mentorOnline")
	public String mentorOnline(){
		return "onlineStreaming_page";
	}
	@RequestMapping(value="/mentorOnlineStreaming")
	public String mentorOnlineStreaming(){
		return "mentorOnlineStreaming_page";
	}
	@RequestMapping(value="/myMentorNotice")
	public String myMentorNotice(@RequestParam("number") int memberNumber,Model model){
		model.addAttribute("mentorNotice", mentorNoticeService.getMentorNotice(memberNumber));
		return "MyMentorNotice_page";
	}
}
