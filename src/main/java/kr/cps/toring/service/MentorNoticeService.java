package kr.cps.toring.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cps.toring.dao.MentorNoticeDAO;
import kr.cps.toring.model.MentorNotice;
import kr.cps.toring.model.User;

@Service
public class MentorNoticeService {

	private MentorNoticeDAO mentorNoticeDAO;
	
	@Autowired
	public void setMentorNoticeDAO(MentorNoticeDAO mentorNoticeDAO) {
		this.mentorNoticeDAO = mentorNoticeDAO;
	}
	
	//게시글 전체 가져오기
	public List<MentorNotice> getAllRecord(){
		return mentorNoticeDAO.getAllRecord();
	}
	//모집 중 게시글 가져오기
	public List<MentorNotice> getRecruitingRecord(){
		return mentorNoticeDAO.getRecruitingRecord();
	}
	//모집 완료 게시글 가져오기
	public List<MentorNotice> getCompletedRecord(){
		return mentorNoticeDAO.getCompletedRecord();
	}
	//해당 멘토 글 가져오기
	public List<MentorNotice> getMentorRecord(String memberName){
		return mentorNoticeDAO.getMentorRecord(memberName);
	}
	//한 게시글 가져오기
	public MentorNotice getRecord(int noticeNumber){
		return mentorNoticeDAO.getRecord(noticeNumber);
	}
	//게시글 추가
	public int insertRecord(MentorNotice mentorNotice){
		return mentorNoticeDAO.insertRecord(mentorNotice);
	}
	//게시글 수정
	public int updateRecord(MentorNotice mentorNotice){
		return mentorNoticeDAO.updateRecord(mentorNotice);
	}
	//게시글 삭제
	public int deleteRecord(int noticeNumber){
		return mentorNoticeDAO.deleteRecord(noticeNumber);
	}
	//사용자 멘토 체크
	public int checkMentor(String userNumber){
		return mentorNoticeDAO.checkMentor(userNumber);
	}
	//작성자 체크
	public int checkPrepares(String userNumber, int noticeNumber){
		return mentorNoticeDAO.checkPrepares(userNumber, noticeNumber);
	}
	//유저 이름 가져오기
	public String getUserName(String userNumber){
		return mentorNoticeDAO.getUserName(userNumber);
	}
	//해당 멘토 글 가져오기
	public List<MentorNotice> getMentorNotice(int number){
		return mentorNoticeDAO.getMentorRecord(number);
	}
	//멀티 스레드 시간 체크
	public void checkTime(String date){
		mentorNoticeDAO.checkTime(Date.valueOf(date));
	}	   
	public List<Integer> getMaxNumber(){
		return mentorNoticeDAO.getMaxNumber();
	}
	//멘토링 참가인원 수 증가
	public boolean addPersonNumber(int noticeNumber){
	    return mentorNoticeDAO.addPersonNumber(noticeNumber);
	}
	//멘토링 인원 수 확인
	public boolean checkPersonNumber(int noticeNumber){
	    return mentorNoticeDAO.checkPersonNumber(noticeNumber);
	}
	//멘토리스트 가져오기
	public List<User> getMentor(){
		return mentorNoticeDAO.getMentor();
	}
	//멘토 정보 가져오기
	public User getUser(int userNumber){
		return mentorNoticeDAO.getUser(userNumber);
	}
}
