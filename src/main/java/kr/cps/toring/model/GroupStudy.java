package kr.cps.toring.model;

public class GroupStudy {
	private int groupNumber;
	private int noticeNumber;
	private int mentorNumber;
	private String mentorName;
	private String groupTitle;
	
	public GroupStudy(){}
	public GroupStudy(int groupNumber, int noticeNumber, int mentorNumber, String mentorName, String groupTitle) {
		this.groupNumber = groupNumber;
		this.noticeNumber = noticeNumber;
		this.mentorNumber = mentorNumber;
		this.mentorName = mentorName;
		this.groupTitle = groupTitle;
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

	public int getMentorNumber() {
		return mentorNumber;
	}

	public void setMentorNumber(int mentorNumber) {
		this.mentorNumber = mentorNumber;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
}
