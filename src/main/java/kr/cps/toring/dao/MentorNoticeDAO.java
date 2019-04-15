package kr.cps.toring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.cps.toring.model.MentorNotice;
import kr.cps.toring.model.User;

@Repository
public class MentorNoticeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	//게시글 전체 가져오기
	public List<MentorNotice> getAllRecord(){
		String sqlStament = "select * from mentor_notice";
		return jdbcTemplate.query(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice mentorNotice = new MentorNotice();
				mentorNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				mentorNotice.setMemberNumber(rs.getInt("memberNumber"));
				mentorNotice.setMemberName(rs.getString("memberName"));
				mentorNotice.setMemberBelong(rs.getString("memberBelong"));
				mentorNotice.setTitle(rs.getString("title"));
				mentorNotice.setNoticeDate(rs.getDate("noticeDate"));
				mentorNotice.setRecruitSdate(rs.getDate("recruitSdate"));
				mentorNotice.setRecruitFdate(rs.getDate("recruitFdate"));
				mentorNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
				mentorNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
				mentorNotice.setMentoringTime(rs.getString("mentoringTime"));
				mentorNotice.setCategory(rs.getString("category"));
				mentorNotice.setTotalNumber(rs.getInt("totalNumber"));
				mentorNotice.setContent(rs.getString("content"));
				mentorNotice.setFilePath(rs.getString("filepath"));
				mentorNotice.setFileName(rs.getString("filename"));
				mentorNotice.setCompleted(rs.getBoolean("completed"));
				mentorNotice.setPeopleNumber(rs.getInt("peopleNumber"));
				return mentorNotice;
			}
		});
	}
	//모집 중 게시글 전체 가져오기
		public List<MentorNotice> getRecruitingRecord(){
			String sqlStament = "select * from mentor_notice where completed=false";
			return jdbcTemplate.query(sqlStament, new RowMapper<MentorNotice>(){
				@Override
				public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
					MentorNotice recruitingNotice = new MentorNotice();
					recruitingNotice.setNoticeNumber(rs.getInt("noticeNumber"));
					recruitingNotice.setMemberNumber(rs.getInt("memberNumber"));
					recruitingNotice.setMemberName(rs.getString("memberName"));
					recruitingNotice.setMemberBelong(rs.getString("memberBelong"));
					recruitingNotice.setTitle(rs.getString("title"));
					recruitingNotice.setNoticeDate(rs.getDate("noticeDate"));
					recruitingNotice.setRecruitSdate(rs.getDate("recruitSdate"));
					recruitingNotice.setRecruitFdate(rs.getDate("recruitFdate"));
					recruitingNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
					recruitingNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
					recruitingNotice.setMentoringTime(rs.getString("mentoringTime"));
					recruitingNotice.setCategory(rs.getString("category"));
					recruitingNotice.setTotalNumber(rs.getInt("totalNumber"));
					recruitingNotice.setContent(rs.getString("content"));
					recruitingNotice.setFilePath(rs.getString("filepath"));
					recruitingNotice.setFileName(rs.getString("filename"));
					recruitingNotice.setCompleted(rs.getBoolean("completed"));
					recruitingNotice.setPeopleNumber(rs.getInt("peopleNumber"));
					return recruitingNotice;
				}
			});
		}
	//모집 완료 게시글 전체 가져오기
	public List<MentorNotice> getCompletedRecord(){
		String sqlStament = "select * from mentor_notice where completed=true";
		return jdbcTemplate.query(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice completedNotice = new MentorNotice();
				completedNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				completedNotice.setMemberNumber(rs.getInt("memberNumber"));
				completedNotice.setMemberName(rs.getString("memberName"));
				completedNotice.setMemberBelong(rs.getString("memberBelong"));
				completedNotice.setTitle(rs.getString("title"));
				completedNotice.setNoticeDate(rs.getDate("noticeDate"));
				completedNotice.setRecruitSdate(rs.getDate("recruitSdate"));
				completedNotice.setRecruitFdate(rs.getDate("recruitFdate"));
				completedNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
				completedNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
				completedNotice.setMentoringTime(rs.getString("mentoringTime"));
				completedNotice.setCategory(rs.getString("category"));
				completedNotice.setTotalNumber(rs.getInt("totalNumber"));
				completedNotice.setContent(rs.getString("content"));
				completedNotice.setFilePath(rs.getString("filepath"));
				completedNotice.setFileName(rs.getString("filename"));
				completedNotice.setCompleted(rs.getBoolean("completed"));
				completedNotice.setPeopleNumber(rs.getInt("peopleNumber")); 
				return completedNotice;
			}
		});
	}
	//해당 멘토 글 가져오기
	public List<MentorNotice> getMentorRecord(String memberName){
		String sqlStament = "select * from mentor_notice where memberName='"+memberName+"'";
		return jdbcTemplate.query(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice mentorNotice = new MentorNotice();
				mentorNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				mentorNotice.setMemberNumber(rs.getInt("memberNumber"));
				mentorNotice.setMemberName(rs.getString("memberName"));
				mentorNotice.setMemberBelong(rs.getString("memberBelong"));
				mentorNotice.setTitle(rs.getString("title"));
				mentorNotice.setNoticeDate(rs.getDate("noticeDate"));
				mentorNotice.setRecruitSdate(rs.getDate("recruitSdate"));
				mentorNotice.setRecruitFdate(rs.getDate("recruitFdate"));
				mentorNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
				mentorNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
				mentorNotice.setMentoringTime(rs.getString("mentoringTime"));
				mentorNotice.setCategory(rs.getString("category"));
				mentorNotice.setTotalNumber(rs.getInt("totalNumber"));
				mentorNotice.setContent(rs.getString("content"));
				mentorNotice.setFilePath(rs.getString("filepath"));
				mentorNotice.setFileName(rs.getString("filename"));
				mentorNotice.setCompleted(rs.getBoolean("completed"));
				mentorNotice.setPeopleNumber(rs.getInt("peopleNumber"));
				return mentorNotice;
			}
		});
	}
	//해당 멘토 글 가져오기
	public List<MentorNotice> getMentorRecord(int number){
		String sqlStament = "select * from mentor_notice where memberNumber="+number;
		return jdbcTemplate.query(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice mentorNotice = new MentorNotice();
				mentorNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				mentorNotice.setMemberNumber(rs.getInt("memberNumber"));
				mentorNotice.setMemberName(rs.getString("memberName"));
				mentorNotice.setMemberBelong(rs.getString("memberBelong"));
				mentorNotice.setTitle(rs.getString("title"));
				mentorNotice.setNoticeDate(rs.getDate("noticeDate"));
				mentorNotice.setRecruitSdate(rs.getDate("recruitSdate"));
				mentorNotice.setRecruitFdate(rs.getDate("recruitFdate"));
				mentorNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
				mentorNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
				mentorNotice.setMentoringTime(rs.getString("mentoringTime"));
				mentorNotice.setCategory(rs.getString("category"));
				mentorNotice.setTotalNumber(rs.getInt("totalNumber"));
				mentorNotice.setContent(rs.getString("content"));
				mentorNotice.setFilePath(rs.getString("filepath"));
				mentorNotice.setFileName(rs.getString("filename"));
				mentorNotice.setCompleted(rs.getBoolean("completed"));
				mentorNotice.setPeopleNumber(rs.getInt("peopleNumber"));
				return mentorNotice;
			}
		});
	}
	//게시글 하나 가져오기
	public MentorNotice getRecord(int noticeNumber){
		String sqlStament = "select * from mentor_notice where noticeNumber ="+noticeNumber;
		return jdbcTemplate.queryForObject(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice mentorNotice = new MentorNotice();
				mentorNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				mentorNotice.setMemberNumber(rs.getInt("memberNumber"));
				mentorNotice.setMemberName(rs.getString("memberName"));
				mentorNotice.setMemberBelong(rs.getString("memberBelong"));
				mentorNotice.setTitle(rs.getString("title"));
				mentorNotice.setNoticeDate(rs.getDate("noticeDate"));
				mentorNotice.setRecruitSdate(rs.getDate("recruitSdate"));
				mentorNotice.setRecruitFdate(rs.getDate("recruitFdate"));
				mentorNotice.setMentoringSdate(rs.getDate("mentoringSdate"));
				mentorNotice.setMentoringFdate(rs.getDate("mentoringFdate"));
				mentorNotice.setMentoringTime(rs.getString("mentoringTime"));
				mentorNotice.setCategory(rs.getString("category"));
				mentorNotice.setTotalNumber(rs.getInt("totalNumber"));
				mentorNotice.setContent(rs.getString("content"));
				mentorNotice.setFilePath(rs.getString("filepath"));
				mentorNotice.setFileName(rs.getString("filename"));
				mentorNotice.setCompleted(rs.getBoolean("completed"));
				mentorNotice.setPeopleNumber(rs.getInt("peopleNumber"));
				mentorNotice.setMapaddres(rs.getString("mapaddres"));
				mentorNotice.setDeteailmap(rs.getString("deteailmap"));
				
				
				return mentorNotice;
			}
		});
	}
	//게시글 추가
	public int insertRecord(final MentorNotice mentorNotice)	 {
		String sql = "insert into mentor_notice values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		try{
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, null);
				ps.setInt(2, mentorNotice.getMemberNumber());
				ps.setString(3, mentorNotice.getMemberName());
				ps.setString(4, mentorNotice.getMemberBelong());
				ps.setString(5, mentorNotice.getTitle());
				ps.setDate(6, mentorNotice.getNoticeDate());
				ps.setDate(7, mentorNotice.getRecruitSdate());
				ps.setDate(8, mentorNotice.getRecruitFdate());
				ps.setDate(9, mentorNotice.getMentoringSdate());
				ps.setDate(10, mentorNotice.getMentoringFdate());
				ps.setString(11, mentorNotice.getMentoringTime());
				ps.setString(12, mentorNotice.getCategory());
				ps.setInt(13, mentorNotice.getTotalNumber());
				ps.setString(14, mentorNotice.getContent());
				ps.setString(15, mentorNotice.getFilePath());
				ps.setString(16, mentorNotice.getFileName());
				ps.setBoolean(17, mentorNotice.getCompleted());
				ps.setInt(18, mentorNotice.getPeopleNumber());
				ps.setString(19, mentorNotice.getMapaddres());
				ps.setString(20, mentorNotice.getDeteailmap());
				return ps.execute();
			}	
		});
		return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	// 게시글 수정
	public int updateRecord(final MentorNotice mentorNotice) {
		String sqlStament = "update mentor_notice set title='"+mentorNotice.getTitle()+"',recruitFdate='"+mentorNotice.getRecruitFdate()+
				"',mentoringSdate='"+mentorNotice.getMentoringSdate()+"',mentoringFdate='"+mentorNotice.getMentoringFdate()+
				"',mentoringTime='"+mentorNotice.getMentoringTime()+"',category='"+mentorNotice.getCategory()+"',totalNumber="+
				mentorNotice.getTotalNumber()+",content='"+mentorNotice.getContent()+"',filePath='"+mentorNotice.getFilePath()+
				"',fileName='"+mentorNotice.getFileName()+"',mapaddres='"+mentorNotice.getMapaddres()+"',deteailmap='"+mentorNotice.getDeteailmap()+"' where noticeNumber="+mentorNotice.getNoticeNumber();
		try{
			jdbcTemplate.update(sqlStament);
		/*jdbcTemplate.update(sqlStament, mentorNotice.getTitle(),mentorNotice.getRecruitFdate(),
				mentorNotice.getMentoringSdate(),mentorNotice.getMentoringFdate(),mentorNotice.getMentoringTime(),
				mentorNotice.getCategory(),mentorNotice.getPeopleNumber(),mentorNotice.getContent(),
				mentorNotice.getFilePath(), mentorNotice.getFileName(),mentorNotice.getNoticeNumber());*/
		return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	//게시글 삭제
	public int deleteRecord(int noticeNumber){
		String sqlStament = "delete from mentor_notice where noticeNumber ="+noticeNumber;
		try{
			jdbcTemplate.update(sqlStament);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	//////////////유저
	//유제멘토체크
	public int checkMentor(String userNumber){
		String sqlStament = "select userDivision from member where userNumber="+userNumber;
		User user = jdbcTemplate.queryForObject(sqlStament, new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException{
					User userSample = new User();
					userSample.setUserDivision(rs.getString("userDivision"));
					return userSample;
				}
			});
		if(user.getUserDivision().equals("멘토")) return 0;
		else return 1;
	}
	//작성자체크
	public int checkPrepares(String userNumber,int noticeNumber){
		String sqlStament = "select memberNumber from mentor_notice where noticeNumber = "+noticeNumber;
		MentorNotice mentorNotice = jdbcTemplate.queryForObject(sqlStament, new RowMapper<MentorNotice>(){
			@Override
			public MentorNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				MentorNotice example = new MentorNotice();
				example.setMemberNumber(rs.getInt("memberNumber"));
				return example;
			}
		});
		if(String.valueOf(mentorNotice.getMemberNumber()).equals(userNumber)) return 1;
		else return 0;
	}
	//유저 이름 가져오기
	public String getUserName(String userNumber){
		String sqlStament = "select userName from member where userNumber="+userNumber;
		System.out.println(sqlStament);
		return jdbcTemplate.queryForObject(sqlStament, new RowMapper<String>(){
			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				return rs.getString("userName");
			}
		});
	}
	// 그룹스터디 추가하기 전에
	public List<Integer> getMaxNumber() {
		String sql = "select MAX(noticeNumber) as noticeNumber from mentor_notice";
		return jdbcTemplate.query(sql, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("noticeNumber");
			}
		});
	}
	// 멘토링 인원 수 증가
	public boolean addPersonNumber(final int noticeNumber) {
		String sql = "update mentor_notice set peopleNumber= peopleNumber+1 where noticeNumber = ?";

		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, noticeNumber);
				return ps.execute();
			}
		});
	}

	// 멘토링 인원 체크
	public boolean checkPersonNumber(final int noticeNumber) {
		String sqlTotal = "select totalNumber from mentor_notice where noticeNumber=" + noticeNumber;
		String sqlPeople = "select peopleNumber from mentor_notice where noticeNumber=" + noticeNumber;
		int total = jdbcTemplate.queryForObject(sqlTotal, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("totalNumber");
			}
		});
		int people = jdbcTemplate.queryForObject(sqlPeople, new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("peopleNumber");
			}
		});
		if (total > people) {
			return true;
		}
		return false;
	}

	public void checkTime(final Date date) {
		String sql = "update mentor_notice set completed = true where recruitFdate < ?";
		jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setDate(1, date);
				return ps.execute();
			}
		});
	}
	public List<User> getMentor(){
		String sqlStament = "select * from MEMBER where userDivision='멘토'";
		return jdbcTemplate.query(sqlStament, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				user.setUserNumber(rs.getInt("userNumber"));
				user.setUserName(rs.getString("userName"));
				user.setUserTeaching(rs.getString("UserTeaching"));
				user.setUserPicture(rs.getString("UserPicture"));
				return user;
			}
		});
	}
	//멘토정보 가져오기
	public User getUser(int userNumber){
		String sql = "select * from MEMBER where userNumber="+userNumber;
		return jdbcTemplate.queryForObject(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User user = new User();
				user.setUserNumber(rs.getInt("userNumber"));
				user.setUserDepartment(rs.getString("userDepartment"));
				user.setUserName(rs.getString("userName"));
				user.setUsertemper(rs.getString("UserTemper"));
				user.setUserTeaching(rs.getString("UserTeaching"));
				user.setUserPicture(rs.getString("UserPicture"));
				return user;
			}
		});
	}
}
