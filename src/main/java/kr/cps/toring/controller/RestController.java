package kr.cps.toring.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.cps.toring.model.GroupStudyNotice;
import kr.cps.toring.model.MentorNotice;
import kr.cps.toring.model.User;
import kr.cps.toring.service.GroupStudyService;
import kr.cps.toring.service.MentorNoticeService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	private MentorNoticeService mentorNoticeService;
	private GroupStudyService groupStudyService;
	
	
	@Autowired
	public void setService(MentorNoticeService mentorNoticeService,GroupStudyService groupStudyService){
		this.mentorNoticeService = mentorNoticeService;	
		this.groupStudyService = groupStudyService;
	}
	
	//게시글 등록
	@RequestMapping(value = "/addMentorNotice")
	public Map<String,Integer> addMentorNotice(MultipartHttpServletRequest req) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		MentorNotice mentorNotice = new MentorNotice();
		mentorNotice.setMemberNumber(Integer.parseInt(req.getParameter("memberNumber")));
		mentorNotice.setMemberName(req.getParameter("memberName"));
		mentorNotice.setMemberBelong(req.getParameter("memberBelong"));
		mentorNotice.setTitle(req.getParameter("title"));
		
		if(req.getParameter("roadAddrPart1")!=null) {
		mentorNotice.setMapaddres(req.getParameter("roadAddrPart1"));
		mentorNotice.setDeteailmap(req.getParameter("addrDetail")); 
		}else {
			mentorNotice.setMapaddres(null);
			mentorNotice.setDeteailmap(null);
		}
		
		//오늘 날짜 가져오기
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		mentorNotice.setNoticeDate(sdf.format(today).toString());
		mentorNotice.setRecruitSdate(sdf.format(today).toString());
		mentorNotice.setRecruitFdate(req.getParameter("recruitFdate"));
		mentorNotice.setMentoringSdate(req.getParameter("mentoringSdate"));
		mentorNotice.setMentoringFdate(req.getParameter("mentoringFdate"));
		mentorNotice.setMentoringTime(req.getParameter("time"));
		mentorNotice.setCategory(req.getParameter("category"));
		mentorNotice.setTotalNumber(Integer.parseInt(req.getParameter("peopleNumber")));
		mentorNotice.setContent(req.getParameter("content"));
		mentorNotice.setCompleted(false);
		mentorNotice.setPeopleNumber(0);
		
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";

		try {
		
			Iterator<String> iter = req.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";

			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			while (iter.hasNext()) {
				fieldName = iter.next(); // 내용을 가져와서
				mfile = req.getFile(fieldName);
				String origName;
				origName =mfile.getOriginalFilename(); // 한글꺠짐
																// 방지

				// 파일명이 없다면
				if ("".equals(origName)) {
					continue;
				}
				// 파일 명 변경(uuid로 암호화)
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = getUuid() + ext;
				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);
				mentorNotice.setFileName(origName);
				mentorNotice.setFilePath(saveFileName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int check = mentorNoticeService.insertRecord(mentorNotice);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("check", check);
		return result;
	}
	//멘토 게시글 수정
	@RequestMapping(value="/updateMentorNotice")
	public Map<String,Integer> updateRecord(MultipartHttpServletRequest req) throws Exception{
		req.setCharacterEncoding("utf-8");
		MentorNotice mentorNotice = new MentorNotice();
		mentorNotice.setNoticeNumber(Integer.parseInt(req.getParameter("noticeNumber")));
		mentorNotice.setTitle(req.getParameter("title"));
		mentorNotice.setRecruitFdate(req.getParameter("recruitFdate"));
		mentorNotice.setMentoringSdate(req.getParameter("mentoringSdate"));
		mentorNotice.setMentoringFdate(req.getParameter("mentoringFdate"));
		mentorNotice.setMentoringTime(req.getParameter("time"));
		
		if(req.getParameter("roadAddrPart1")!=null) {
			mentorNotice.setMapaddres(req.getParameter("roadAddrPart1"));
			mentorNotice.setDeteailmap(req.getParameter("addrDetail"));
			}else {
				mentorNotice.setMapaddres(null);
				mentorNotice.setDeteailmap(null);
			}
		mentorNotice.setCategory(req.getParameter("category"));
		mentorNotice.setTotalNumber(Integer.parseInt(req.getParameter("peopleNumber")));
		mentorNotice.setContent(req.getParameter("content"));
		
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";
		
		try {
		
			Iterator<String> iter = req.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";

			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			while (iter.hasNext()) {
				fieldName = iter.next(); // 내용을 가져와서
				mfile = req.getFile(fieldName);
				String origName;
				origName = mfile.getOriginalFilename(); // 한글꺠짐
																// 방지

				// 파일명이 없다면
				if ("".equals(origName)) {
					continue;
				}
				// 파일 명 변경(uuid로 암호화)
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = getUuid() + ext;
				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);
				mentorNotice.setFileName(origName);
				mentorNotice.setFilePath(saveFileName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int check = mentorNoticeService.updateRecord(mentorNotice);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("check", check);
		return result;
	}
	//파일 암호화
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	//유저멘토체크
	@RequestMapping(value="/checkMentor")
	public Map<String,Integer> checkMentor(HttpServletRequest req){
		int number = mentorNoticeService.checkMentor(req.getParameter("userNumber"));
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("number", number);
		return result;
	}
	//작성자체크
	@RequestMapping(value="/checkPrepares")
	public Map<String,Integer> checkPrepares(HttpServletRequest req){
		int check = mentorNoticeService.checkPrepares(req.getParameter("userNumber"), Integer.parseInt(req.getParameter("noticeNumber")));
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("check", check);
		return result;
	}
	//멘토게시글 삭제
	@RequestMapping(value="/delete")
	public Map<String,Integer> deleteNotice(HttpServletRequest req){
		int check = mentorNoticeService.deleteRecord(Integer.parseInt(req.getParameter("noticeNumber")));
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("success", check);
		return result;
	}
	//그룹스터디 공지사항 등록
	@RequestMapping(value = "/addGroupNotice")
	public Map<String,Integer> addGroupNotice(MultipartHttpServletRequest req) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		GroupStudyNotice groupStudyNotice = new GroupStudyNotice();
		groupStudyNotice.setGroupNumber(Integer.parseInt(req.getParameter("groupNumber")));
		groupStudyNotice.setTitle(req.getParameter("title"));
		groupStudyNotice.setContent(req.getParameter("content"));
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		groupStudyNotice.setNoticeDate(sdf.format(today).toString());
		
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";

		try {
		
			Iterator<String> iter = req.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";

			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			while (iter.hasNext()) {
				fieldName = iter.next(); // 내용을 가져와서
				mfile = req.getFile(fieldName);
				String origName;
				origName = mfile.getOriginalFilename(); // 한글꺠짐
																// 방지

				// 파일명이 없다면
				if ("".equals(origName)) {
					continue;
				}
				// 파일 명 변경(uuid로 암호화)
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = getUuid() + ext;
				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);
				groupStudyNotice.setFileName(origName);
				groupStudyNotice.setFilePath(saveFileName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int check = groupStudyService.addGroupNotice(groupStudyNotice);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("check", check);
		return result;
	}
	@RequestMapping(value="/deleteGroupNotice")
	public Map<String,Integer> deleteGroupNotice(@RequestParam("number") int noticeNumber){
		int check = groupStudyService.deleteGroupNotice(noticeNumber);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("success", check);
		return result;
	}
	//그룹스터디 공지사항 등록
	@RequestMapping(value = "/updateGroupNotice")
	public Map<String,Integer> updateGroupNotice(MultipartHttpServletRequest req) throws Exception {
	
		req.setCharacterEncoding("utf-8");
		GroupStudyNotice groupStudyNotice = new GroupStudyNotice();
		groupStudyNotice.setGroupNumber(Integer.parseInt(req.getParameter("groupNumber")));
		groupStudyNotice.setNoticeNumber(Integer.parseInt(req.getParameter("noticeNumber")));
		groupStudyNotice.setTitle(req.getParameter("title"));
		groupStudyNotice.setContent(req.getParameter("content"));
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		groupStudyNotice.setNoticeDate(sdf.format(today).toString());
		
		String root = req.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/upload/";

		try {
		
			Iterator<String> iter = req.getFileNames();
			MultipartFile mfile = null;
			String fieldName = "";

			File dir = new File(path);
			if (!dir.isDirectory()) {
				dir.mkdirs();
			}
			while (iter.hasNext()) {
				fieldName = iter.next(); // 내용을 가져와서
				mfile = req.getFile(fieldName);
				String origName;
				origName = mfile.getOriginalFilename(); // 한글꺠짐
																// 방지

				// 파일명이 없다면
				if ("".equals(origName)) {
					continue;
				}
				// 파일 명 변경(uuid로 암호화)
				String ext = origName.substring(origName.lastIndexOf('.')); // 확장자
				String saveFileName = getUuid() + ext;
				// 설정한 path에 파일저장
				File serverFile = new File(path + File.separator + saveFileName);
				mfile.transferTo(serverFile);
				groupStudyNotice.setFileName(origName);
				groupStudyNotice.setFilePath(saveFileName);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int check = groupStudyService.updateGroupNotice(groupStudyNotice);
		Map<String,Integer> result = new HashMap<String,Integer>();
		result.put("check", check);
		return result;
	}
	@RequestMapping(value="/getMentorList")
	public List<User> getMentorList(){
		return mentorNoticeService.getMentor();
	}
}
