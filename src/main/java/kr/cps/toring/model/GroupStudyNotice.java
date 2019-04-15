package kr.cps.toring.model;

import java.sql.Date;

public class GroupStudyNotice {
	private int groupNumber;
	private int noticeNumber;
	private String title;
	private String content;
	private Date noticeDate;
	private String filePath;
	private String fileName;
	
	public GroupStudyNotice(){}
	public GroupStudyNotice(int groupNumber, int noticeNumber, String title, String content, Date noticeDate,String filePath,String fileName) {
		this.groupNumber = groupNumber;
		this.noticeNumber = noticeNumber;
		this.title = title;
		this.content = content;
		this.noticeDate = noticeDate;
		this.filePath = filePath;
		this.fileName = fileName;
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = Date.valueOf(noticeDate);
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
}
