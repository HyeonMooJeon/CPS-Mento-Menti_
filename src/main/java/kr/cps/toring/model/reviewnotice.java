package kr.cps.toring.model;

public class reviewnotice {

	private int postnumber;
	private int menteenumber;
	private String headname;
	private String subject;
	private String name;
	private String timedate;
	
	public reviewnotice() {
		
	}
	
	public reviewnotice(int postnumber, int menteenumber, String headname, String timedate) {
		this.postnumber = postnumber;
		this.menteenumber = menteenumber;
		this.headname = headname;
		this.timedate = timedate;
	}
	
	public int getPostnumber() {
		return postnumber;
	}
	public void setPostnumber(int postnumber) {
		this.postnumber = postnumber;
	}
	public int getMenteenumber() {
		return menteenumber;
	}
	public void setMenteenumber(int menteenumber) {
		this.menteenumber = menteenumber;
	}
	public String getHeadname() {
		return headname;
	}
	public void setHeadname(String headname) {
		this.headname = headname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTimedate() {
		return timedate;
	}
	public void setTimedate(String timedate) {
		this.timedate = timedate;
	}
	
	
}
