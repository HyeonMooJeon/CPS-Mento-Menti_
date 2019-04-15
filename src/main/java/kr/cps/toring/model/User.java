package kr.cps.toring.model;

public class User {

	private int userNumber;
	private String userID;
	private String userPassword;
	private String userName;
	private String userDDay;
	private String userGender;
	private String usertemper;
	private String userDepartment;
	private String userTel;
	private String userGrade;
	private String userDivision;
	private String userTeaching;
	private String userPicture;
	
	
	public String getUserTeaching() {
		return userTeaching;
	}

	public void setUserTeaching(String userTeaching) {
		this.userTeaching = userTeaching;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	public String getUsertemper() {
		return usertemper;
	}

	public void setUsertemper(String usertemper) {
		this.usertemper = usertemper;
	}

	@Override
	public String toString() {
		return "User [userNumber=" + userNumber + ", userID=" + userID + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userDDay=" + userDDay + ", userGender=" + userGender
				+ ", userDepartment=" + userDepartment + ", userTel=" + userTel + ", userGrade=" + userGrade
				+ ", userDivision=" + userDivision + "]";
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDDay() {
		return userDDay;
	}

	public void setUserDDay(String userDDay) {
		this.userDDay = userDDay;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserDivision() {
		return userDivision;
	}

	public void setUserDivision(String userDivision) {
		this.userDivision = userDivision;
	}

}
