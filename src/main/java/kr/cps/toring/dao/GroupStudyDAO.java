package kr.cps.toring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.cps.toring.model.GroupStudy;
import kr.cps.toring.model.GroupStudyNotice;

@Repository
public class GroupStudyDAO {

private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public List<GroupStudy> getGroupStudy(int number) {
		String sql ="select * from groupStudy where groupNumber in(select g.groupNumber from groupStudy g, groupStudy_mentee m  where (g.mentorNumber = "+number+" or m.menteeNumber = "+number+") and g.groupNumber = m.groupNumber) ";
		return jdbcTemplate.query(sql, new RowMapper<GroupStudy>(){
			@Override
			public GroupStudy mapRow(ResultSet rs, int rowNum) throws SQLException{
				GroupStudy groupStudy = new GroupStudy();
				groupStudy.setGroupNumber(rs.getInt("groupNumber"));
				groupStudy.setGroupTitle(rs.getString("groupTitle"));
				groupStudy.setMentorName(rs.getString("mentorName"));
				return groupStudy;
			}
		});
	}
	
	public List<GroupStudyNotice> getGroupStudyNotice(int groupNumber){
		String sql = "select * from groupStudy_notice where groupNumber ="+groupNumber;
		return jdbcTemplate.query(sql, new RowMapper<GroupStudyNotice>(){
			@Override
			public GroupStudyNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
				GroupStudyNotice groupStudyNotice = new GroupStudyNotice();
				groupStudyNotice.setGroupNumber(rs.getInt("groupNumber"));
				groupStudyNotice.setNoticeNumber(rs.getInt("noticeNumber"));
				groupStudyNotice.setTitle(rs.getString("title"));
				groupStudyNotice.setContent(rs.getString("content"));
				groupStudyNotice.setNoticeDate(rs.getDate("noticeDate"));
	            groupStudyNotice.setFileName(rs.getString("fileName"));
	            groupStudyNotice.setFilePath(rs.getString("filePath"));
				return groupStudyNotice;
			}
		});
	}
	//////////////////////////////////////////////////////////
	//그룹스터디 번호 가겨오기
	   public List<Integer> checkgroup(int postNum){
		      String sql ="select count(*) as groupNumber from groupStudy where noticeNumber="+postNum;
		      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
		         @Override
		         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
		            return rs.getInt("groupNumber");
		         }
		      });
		   }
	   
	   public List<Integer> getGroupNumber(int postNum){
		      String sql ="select groupNumber from groupStudy where noticeNumber ="+postNum;
		      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
		         @Override
		         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
		            return rs.getInt("groupNumber");
		         }
		      });
		   }
	
	
	   public boolean addMentee(final int groupNumber,final int menteeNumber,final String menteeName){
		      String sql = "insert into groupStudy_mentee value(?,?,?)";
		      try{
		         jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

		            @Override
		            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		               ps.setInt(1, groupNumber);
		               ps.setInt(2, menteeNumber);
		               ps.setString(3, menteeName);
		               return ps.execute();
		            }   
		         });
		         return true;
		         }catch(Exception e){
		            e.printStackTrace();
		         }
		         return false;
		   }
	   
	
	
	//멘토링 글 등록시 바로 그룹게시판 생성
	   public boolean addGroupStudy(final int postNum, final int mentorNumber, final String mentorName, final String title){
		      String sql = "insert into groupStudy value(?,?,?,?,?)";
		      try{
		         jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

		            @Override
		            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		               ps.setString(1, null);
		               ps.setInt(2, postNum);
		               ps.setInt(3, mentorNumber);
		               ps.setString(4, mentorName);
		               ps.setString(5, title);
		               return ps.execute();
		            }   
		         });
		         return true;
		         }catch(Exception e){
		            e.printStackTrace();
		         }
		         return false;
		   }
	   
	   //그룹스터디 멘토 체크
	   public boolean checkMentor(int groupNumber,int mentorNumber){
		   String sqlStament = "select mentorNumber from groupStudy where groupNumber="+groupNumber;
		   GroupStudy groupStudy = jdbcTemplate.queryForObject(sqlStament, new RowMapper<GroupStudy>(){
					@Override
					public GroupStudy mapRow(ResultSet rs, int rowNum) throws SQLException{
						GroupStudy sample = new GroupStudy();
						sample.setMentorNumber(rs.getInt("mentorNumber"));
						return sample;
					}
				});
			if(groupStudy.getMentorNumber() == mentorNumber) return true;
			else return false;
	   }
	   //그룹스터디 공지사항 등록
	   public int addGroupStudy(final GroupStudyNotice groupStudyNotice){
		   String sql = "insert into groupStudy_notice value (?,?,?,?,?,?,?)";
		   try{
		         jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

		            @Override
		            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		               ps.setString(1, null);
		               ps.setInt(2, groupStudyNotice.getGroupNumber());
		               ps.setString(3, groupStudyNotice.getTitle());
		               ps.setString(4, groupStudyNotice.getContent());
		               ps.setDate(5, groupStudyNotice.getNoticeDate());
		               ps.setString(6, groupStudyNotice.getFilePath());
		               ps.setString(7, groupStudyNotice.getFileName());
		               return ps.execute();
		            }   
		         });
		         return 1;
		         }catch(Exception e){
		            e.printStackTrace();
		         }
		         return 0;
	   }
	   //그룹스터디 공지사항 조회
	   public GroupStudyNotice getGroupNotice(int noticeNumber){
		   String sql = "select * from groupStudy_notice where noticeNumber ="+noticeNumber;
		   return jdbcTemplate.queryForObject(sql, new RowMapper<GroupStudyNotice>(){
				@Override
				public GroupStudyNotice mapRow(ResultSet rs, int rowNum) throws SQLException{
					GroupStudyNotice groupStudyNotice = new GroupStudyNotice();
					groupStudyNotice.setGroupNumber(rs.getInt("groupNumber"));
					groupStudyNotice.setNoticeNumber(rs.getInt("noticeNumber"));
					groupStudyNotice.setTitle(rs.getString("title"));
					groupStudyNotice.setContent(rs.getString("content"));
					groupStudyNotice.setNoticeDate(rs.getDate("noticeDate"));
		            groupStudyNotice.setFileName(rs.getString("fileName"));
		            groupStudyNotice.setFilePath(rs.getString("filePath"));
					return groupStudyNotice;
				}
			});
	   }
	   //그룹스터디 공지사항 삭제
	   public int deleteGroupNotice(int noticeNumber){
		   String sqlStament = "delete from groupStudy_notice where noticeNumber ="+noticeNumber;
			try{
				jdbcTemplate.update(sqlStament);
				return 1;
			}catch(Exception e){
				e.printStackTrace();
			}
			return 0;
	   }
	   //그룹스터디 공지사항 수정
	   public int editGroupNotice(GroupStudyNotice groupStudyNotice){
		   String sql = "update groupStudy_notice set title='"+groupStudyNotice.getTitle()+
				   "', content='"+groupStudyNotice.getContent()+"', filePath='"+groupStudyNotice.getFilePath()+
				   "', fileName='"+groupStudyNotice.getFileName()+"' where noticeNumber="+groupStudyNotice.getNoticeNumber();
		   try{
				jdbcTemplate.update(sql);

			return 1;
			}catch(Exception e){
				e.printStackTrace();
			}
			return 0;
	   }
}
