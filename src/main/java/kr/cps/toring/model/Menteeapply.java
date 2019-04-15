package kr.cps.toring.model;

public class Menteeapply {

	private String headname; //제목
	private String filename; //파일이름
	private String subject; //내용
	private String newfilename; //암화화한 파일
	private int postnum; //게시물번호
	private int menteenumber; //회원번호
	private String menteename; //멘티 이름
	private String applydate; //가능한 시간
	private String applyYesNo; //y/n
	private String applydatetime; //신청 날짜
	
	
	public String getApplydatetime() {
		return applydatetime;
	}
	public void setApplydatetime(String applydatetime) {
		this.applydatetime = applydatetime;
	}
	public String getApplyYesNo() {
		return applyYesNo;
	}
	public void setApplyYesNo(String applyYesNo) {
		this.applyYesNo = applyYesNo;
	}
	public String getHeadname() {
		return headname;
	}
	public void setHeadname(String headname) {
		this.headname = headname;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getNewfilename() {
		return newfilename;
	}
	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}
	public String getInname() {
		return subject;
	}
	public void setInname(String subject) {
		this.subject = subject;
	}
	
	public Menteeapply() {
		
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public int getMenteenumber() {
		return menteenumber;
	}
	public void setMenteenumber(int menteenumber) {
		this.menteenumber = menteenumber;
	}
	public String getMenteename() {
		return menteename;
	}
	public void setMenteename(String menteename) {
		this.menteename = menteename;
	}
	public String getApplydate() {
		return applydate;
	}
	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}
	
}
