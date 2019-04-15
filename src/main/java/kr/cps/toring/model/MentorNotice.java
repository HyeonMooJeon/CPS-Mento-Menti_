package kr.cps.toring.model;

import java.sql.Date;

public class MentorNotice {
	private int noticeNumber;		//게시글 번호
	private int memberNumber;		//작성자 회원번호
	private String memberName;		//작성자 이름
	private String memberBelong;	//작성자 소속
	private String title;			//게시글 제목
	private Date noticeDate;		//게시글 등록날짜
	private Date recruitSdate;		//멘토링 모집 시작 날짜
	private Date recruitFdate;		//멘토링 모집 마감 날짜
	private Date mentoringSdate;	//멘토링 시작 날짜
	private Date mentoringFdate;	//멘토링 종료 날짜
	private String mentoringTime;	//멘토링 시간
	private String category;		//게시글 카테고리
	private int totalNumber;		//멘토링 인원 수
	private String content;			//게시글 내용
	private String filePath;		//게시글 첨부파일 경로
	private String fileName;		//게시글 첨부파일 제목
	private boolean completed;		//게시글 상태
	private int peopleNumber;
	private String mapaddres;	//지도 주소
	private String deteailmap;	
	
	public String getMapaddres() {
		return mapaddres;
	}

	public void setMapaddres(String mapaddres) {
		this.mapaddres = mapaddres;
	}

	public String getDeteailmap() {
		return deteailmap;
	}

	public void setDeteailmap(String deteailmap) {
		this.deteailmap = deteailmap;
	}

	
	
	public MentorNotice(){}

	public MentorNotice(int noticeNumber, int memberNumber, String memberName, String memberBelong, String title, Date noticeDate,
			Date recruitSdate, Date recruitFdate, Date mentoringSdate, Date mentoringFdate, String mentoringTime,
			String category, int totalNumber, String content, String filePath, String fileName, boolean completed,int peopleNumber) {
		this.noticeNumber = noticeNumber;
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberBelong = memberBelong;
		this.title = title;
		this.noticeDate = noticeDate;
		this.recruitSdate = recruitSdate;
		this.recruitFdate = recruitFdate;
		this.mentoringSdate = mentoringSdate;
		this.mentoringFdate = mentoringFdate;
		this.mentoringTime = mentoringTime;
		this.category = category;
		this.totalNumber = totalNumber;
		this.content = content;
		this.filePath = filePath;
		this.fileName = fileName;
		this.completed = completed;
		this.peopleNumber = peopleNumber;
	}

	public int getNoticeNumber() {
		return noticeNumber;
	}

	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBelong() {
		return memberBelong;
	}
	
	public void setMemberBelong(String memberBelong) {
		this.memberBelong = memberBelong;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public void setNoticeDate(String date){
		this.noticeDate = Date.valueOf(date);
	}

	public Date getRecruitSdate() {
		return recruitSdate;
	}

	public void setRecruitSdate(Date recruitSdate) {
		this.recruitSdate = recruitSdate;
	}
	public void setRecruitSdate(String recruitSdate) {
		this.recruitSdate = Date.valueOf(recruitSdate);
	}

	public Date getRecruitFdate() {
		return recruitFdate;
	}

	public void setRecruitFdate(Date recruitFdate) {
		this.recruitFdate = recruitFdate;
	}
	public void setRecruitFdate(String recruitFdate) {
		this.recruitFdate = Date.valueOf(recruitFdate);
	}

	public Date getMentoringSdate() {
		return mentoringSdate;
	}

	public void setMentoringSdate(Date mentoringSdate) {
		this.mentoringSdate = mentoringSdate;
	}
	public void setMentoringSdate(String mentoringSdate) {
		this.mentoringSdate = Date.valueOf(mentoringSdate);
	}

	public Date getMentoringFdate() {
		return mentoringFdate;
	}

	public void setMentoringFdate(Date mentoringFdate) {
		this.mentoringFdate = mentoringFdate;
	}
	public void setMentoringFdate(String mentoringFdate) {
		this.mentoringFdate = Date.valueOf(mentoringFdate);
	}

	public String getMentoringTime() {
		return mentoringTime;
	}

	public void setMentoringTime(String mentoringTime) {
		this.mentoringTime = mentoringTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean getCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
}
