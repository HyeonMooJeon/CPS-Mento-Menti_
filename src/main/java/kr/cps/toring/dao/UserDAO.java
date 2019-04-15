package kr.cps.toring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import kr.cps.toring.model.User;
import kr.cps.toring.service.UserService;

public class UserDAO {
	
	private JdbcTemplate jdbcTemplate;
	public BasicDataSource DataSource;

	public UserDAO() {
		DataSource = new BasicDataSource();
		DataSource.setDriverClassName("com.mysql.jdbc.Driver");
		DataSource.setUsername("hyb");
		DataSource.setUrl("jdbc:mysql://localhost:3306/hyb?serverTimezone=UTC");
		DataSource.setPassword("hyb01");
		this.jdbcTemplate = new JdbcTemplate(DataSource);
	}

	
//	@Autowired
//	public void setDataSource(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//
//	}
	//id 중복값 체크
	public String idoverlapCheck(String userID) {
		
		try {
			return jdbcTemplate.queryForObject("SELECT userID From MEMBER WHERE userID = ?", new Object[] { userID },
					String.class);
		} catch (EmptyResultDataAccessException e) {
		}
		return null;
	}
	//로그인2
	public String sqlLogin(String userID) {
		idoverlapCheck(userID);
		try {
			return jdbcTemplate.queryForObject("SELECT userPassword From MEMBER WHERE userID = ?", new Object[] { userID },
					String.class);
		} catch (EmptyResultDataAccessException e) {
		}
		return null;
	}
	
	//로그인1
	public int login(String userID, String userPassword) {
		System.out.println(userID + userPassword);
		try {
			String memberPassword = sqlLogin(userID);
			if (memberPassword != null) {
				if (memberPassword.equals(userPassword)) {
					return 1; // 로그인 성공
				}
			} else {
				return 0; // 비밀번호 불일치
			}
			return -1; // 아이디 없음
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return -2; // 데이터베이스 오류
	}

	//회원 가입
	public int Register(final User user){
		String check = idoverlapCheck(user.getUserID());
		if(check == null){
////		//MYsql문법으로 바꾸어주어야함
//		String sql = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

			String sqlStament = "insert into member values";
			String query = "(null,'"
					+user.getUserID()+"','"
					+user.getUserPassword()+"','"
					+user.getUserName()+"','"
					+user.getUserDDay()+"','"
					+user.getUserGender()+"','"
					+user.getUserDepartment()+"','"	
					+user.getUserTel()+"','"				
					+user.getUserGrade()+"','"
					+user.getUserPicture()+"','"
					+user.getUserTeaching()+"','"
					+user.getUserDivision()+"','"
					+user.getUsertemper()+"')";
			
			System.out.println("회원가입:"+sqlStament+query);
			jdbcTemplate.execute(sqlStament+query);
			return 1;
		}
		
		
//		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
//
//			@Override
//			public Boolean doInPreparedStatement(PreparedStatement ps)
//					throws SQLException, DataAccessException {
//				
//				  ps.setInt(1, 2);
//				  ps.setString(2, user.getUserPassword());
//				  ps.setString(3, user.getUserName());
//				  ps.setString(4, user.getUserDDay());
//				  ps.setString(5, user.getUserGender());
//				  ps.setString(6, user.getUserDepartment());
//				  ps.setString(7, user.getUserTel());
//				  ps.setString(8, user.getUserGrade());
//				  ps.setString(9, user.getUserDivision());
//				return ps.execute();
//			}
//         });
		
		return 0;
	}
	
	
	//비밀번호찾기
	public String getPw(String e_mail){
		
		String id = e_mail;
		
		String memberPassword = sqlLogin(id);
		
		return memberPassword;
		
	}
	
	//객체 하나 리턴하기 new
	public List<User> getUserMultiRow(String userID) {
		String sqlStatement = "select * from member where userid ='"+userID+"'";

		return jdbcTemplate.query(sqlStatement, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User persion = new User();

				persion.setUserNumber(rs.getInt(1));
				persion.setUserID(rs.getString(2));
				persion.setUserPassword(rs.getString(3));
				persion.setUserName(rs.getString(4));
				persion.setUserDDay(rs.getString(5));
				persion.setUserGender(rs.getString(6));
				persion.setUserDepartment(rs.getString(7));
				persion.setUserTel(rs.getString(8));
				persion.setUserGrade(rs.getString(9));
				persion.setUserDivision(rs.getString(10));
				persion.setUsertemper(rs.getString(11));
				persion.setUserPicture(rs.getString(12));
				persion.setUserTeaching(rs.getString(13));
				
				System.out.println("->"+persion.toString());
				
				return persion;
			}
		});
	}
	
	//이름 이메일주소 생년월일 성별 뺴고 다 바꿀수 있음 내 정보 수정
	public void setUserUpdate(User newuser){
		
		String sqlStament = "Update Member set ";
		
		String query = "UserBDAY = '"+newuser.getUserDDay()+
				"',UserDepartment = '"+newuser.getUserDepartment()+
				"',UserGender = '"+newuser.getUserGender()+
				"',UserTel = '"+newuser.getUserTel()+
				"',UserGrade = '"+newuser.getUserGrade()+
				"',UserTemper = '"+newuser.getUsertemper()+
				"',UserPicture = '"+newuser.getUserPicture()+
				"',UserTeaching = '"+newuser.getUserTeaching()+
				"',UserDivision = '"+newuser.getUserDivision()+"'";
		
		String query2 = " where UserNumber = '"+newuser.getUserNumber()+"'";
		
		jdbcTemplate.update(sqlStament+query+query2);
	}
	  
	//비밀번호 바꾸기
		public void setUserPass(String userID, String password){
			
			String sqlStament = "Update Member set ";
			
			String query = "UserPassword = '"+password+"'";
			String query2 = " where UserID = '"+userID+"'";
			
			jdbcTemplate.update(sqlStament+query+query2);
		}
	
}
