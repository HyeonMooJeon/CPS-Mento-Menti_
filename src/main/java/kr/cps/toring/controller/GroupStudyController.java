package kr.cps.toring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cps.toring.service.GroupStudyService;

@Controller
public class GroupStudyController {

	private GroupStudyService groupStudyService;
	
	@Autowired
	public void setMentorNoticeService(GroupStudyService groupStudyService){
		this.groupStudyService = groupStudyService;
	}
	
	@RequestMapping(value="/groupStudyBoard")
	public String groupStudyBoard(@RequestParam("memberNumber") int number,Model model){
		model.addAttribute("groupStudy", groupStudyService.getGroupStudy(number));
		return "groupStudyBoard_page";
	}
	@RequestMapping(value="/groupStudy")
	public String groupStudy(@RequestParam("groupNumber") int groupNumber,@RequestParam("mentor") int mentorNumber,Model model){
		model.addAttribute("groupStudyNotice", groupStudyService.getGroupStudyNotice(groupNumber));
		model.addAttribute("mentor",groupStudyService.checkMentor(groupNumber, mentorNumber));
		model.addAttribute("groupNumber", groupNumber);
		return "groupStudy_page";
	}
	@RequestMapping(value="/makeGroupNotice")
	public String makeGroupStudy(@RequestParam("number") int groupNumber,Model model){
		model.addAttribute("groupNumber", groupNumber);
		return "makeGroupNotice_page";
	}
	@RequestMapping(value="/groupStudyNotice")
	public String groupStudyNotice(@RequestParam("postNumber") int noticeNumber, @RequestParam("mentor") boolean prepares,@RequestParam("groupNumber") int groupNumber,Model model){
		model.addAttribute("groupNumber", groupNumber);
		model.addAttribute("mentor", prepares);
		model.addAttribute("notice", groupStudyService.getGroupNotice(noticeNumber));
		return "groupStudyNotice_page";
	}
	@RequestMapping(value="/editGroupNotice")
	public String editGroupNotice(@RequestParam("number") int noticeNumber,@RequestParam("mentor") boolean prepares,Model model){
		model.addAttribute("notice", groupStudyService.getGroupNotice(noticeNumber));
		model.addAttribute("mentor", prepares);
		return "editGroupNotice_page";
	}
}
