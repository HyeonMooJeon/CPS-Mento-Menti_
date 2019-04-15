package kr.cps.toring.model;

public class GroupStudyMentee {
	private int groupNumber;
	private int menteeNumber;
	private String menteeName;
	
	public GroupStudyMentee(int groupNumber, int menteeNumber, String menteeName) {
		this.groupNumber = groupNumber;
		this.menteeNumber = menteeNumber;
		this.menteeName = menteeName;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	public int getMenteeNumber() {
		return menteeNumber;
	}

	public void setMenteeNumber(int menteeNumber) {
		this.menteeNumber = menteeNumber;
	}

	public String getMenteeName() {
		return menteeName;
	}

	public void setMenteeName(String menteeName) {
		this.menteeName = menteeName;
	}
}
