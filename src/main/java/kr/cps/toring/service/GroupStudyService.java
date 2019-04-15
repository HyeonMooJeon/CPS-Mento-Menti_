package kr.cps.toring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cps.toring.dao.GroupStudyDAO;
import kr.cps.toring.model.GroupStudy;
import kr.cps.toring.model.GroupStudyNotice;

@Service
public class GroupStudyService {
	private GroupStudyDAO groupStudyDAO;
	
	@Autowired
	public void setMentorNoticeDAO(GroupStudyDAO groupStudyDAO) {
		this.groupStudyDAO = groupStudyDAO;
	}
	
	public List<GroupStudy> getGroupStudy(int number) {
		return groupStudyDAO.getGroupStudy(number);
	}
	public List<GroupStudyNotice> getGroupStudyNotice(int groupNumber) {
		return groupStudyDAO.getGroupStudyNotice(groupNumber);
	}
	// 멘토링글 등록시 멘토링 글의 그룹게시번호를 가져온다.
	public List<Integer> checkgroup(int postNum) {
		return groupStudyDAO.checkgroup(postNum);
	}
	// 그룹멘티 안에 멘티들을 추가한다.
	public boolean addMentee(int groupNumber, int menteeNumber, String menteeName) {
		return groupStudyDAO.addMentee(groupNumber, menteeNumber, menteeName);
	}
	// 멘토링 글을 등록시 그룹게시판 생성
	public boolean addGroupStudy(int postNum, int mentorNumber, String mentorName, String title) {
		return groupStudyDAO.addGroupStudy(postNum, mentorNumber, mentorName, title);
	}
	public List<Integer> getGroupNumber(int postNum) {
		return groupStudyDAO.getGroupNumber(postNum);
	}
	public boolean checkMentor(int groupNumber, int mentorNumber) {
		return groupStudyDAO.checkMentor(groupNumber, mentorNumber);
	}
	//그룹스터디 공지사항 등록
	public int addGroupNotice(GroupStudyNotice groupStudyNotice){
		return groupStudyDAO.addGroupStudy(groupStudyNotice);
	}
	//그룹스터디 공지사항 조회
	public GroupStudyNotice getGroupNotice(int noticeNumber){
		return groupStudyDAO.getGroupNotice(noticeNumber);
	}
	//그룹스터디 공지사항 삭제
	public int deleteGroupNotice(int noticeNumber){
		return groupStudyDAO.deleteGroupNotice(noticeNumber);
	}
	//그룹스터디 공지사항 수정
	public int updateGroupNotice(GroupStudyNotice groupStudyNotice){
		return groupStudyDAO.editGroupNotice(groupStudyNotice);
	}
}
