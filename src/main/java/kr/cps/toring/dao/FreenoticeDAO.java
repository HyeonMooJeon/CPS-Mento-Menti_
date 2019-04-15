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

import kr.cps.toring.model.Freenotice;




@Repository
public class FreenoticeDAO {

	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSourece(DataSource datasource) {
		this.jdbcTemplate=new JdbcTemplate(datasource);
	}
	
	
	
	 public Boolean freenoticeinsert(final Freenotice free )	 {
			String sql = "insert into freenotice value(?,?,?,?,?,?,?,?)";

			return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, free.getPostnumber());
					ps.setInt(2, free.getMenteenumber());
					ps.setString(3, free.getHeadname());
					ps.setString(4, free.getSubject());
					ps.setString(5, free.getName());
					ps.setString(6, free.getTimedate());
					ps.setString(7, free.getFilematerial());
					ps.setString(8, free.getNewfilematerial());
					
				
					return ps.execute();
				}
			});
		}
	
	 //전체 자유 게시글 내역
	 public List<Freenotice> selectFreenoticelist(){
			String sqlStatment = "select * from freenotice";
			
			return jdbcTemplate.query(sqlStatment, new RowMapper<Freenotice>() {

				@Override
				public Freenotice mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Freenotice free= new Freenotice();
					
					free.setHeadname(rs.getString("headname"));
					free.setSubject(rs.getString("subject"));
					free.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
					free.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
					free.setName(rs.getString("name"));
					free.setTimedate(rs.getString("timedate"));
					free.setFilematerial(rs.getString("filematerial"));
					free.setNewfilematerial(rs.getString("newfilematerial"));
					
					
					return free;
				}
			});
		}
	 
	 //자유 게시글 수정
		 
	 public Boolean updatefreelist(final Freenotice free) {
			String sql = "update freenotice set headname=?,subject=?, name=?,timedate=? where postnumber=? and menteenumber=?";

			return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
					
					
					ps.setString(1, free.getHeadname());
					ps.setString(2, free.getSubject());
					ps.setString(3, free.getName());
					ps.setString(4, free.getTimedate());
					ps.setInt(5, free.getPostnumber());
					ps.setInt(6, free.getMenteenumber());
					return ps.execute();
				}
			});
			
		}
	 
	 
	 //자신의 회원번호로 자유 게시판 불러오기
	 public List<Freenotice> myfreelist(int menteenumber){
			String sqlStatment = "select * from freenotice where menteenumber="+menteenumber;
			
			return jdbcTemplate.query(sqlStatment, new RowMapper<Freenotice>() {

				@Override
				public Freenotice mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					Freenotice free= new Freenotice();
					
					free.setHeadname(rs.getString("headname"));
					free.setSubject(rs.getString("subject"));
					free.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
					free.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
					free.setName(rs.getString("name"));
					free.setTimedate(rs.getString("timedate"));
					
					return free;
				}
			});
		}
	 
	 //자신의 자유 게시판 삭제 
	 public Boolean myfreenoticedelete(final int postnumber) {
			String sql = "delete from freenotice where postnumber=?";

			return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
				
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
					
					ps.setInt(1, postnumber);
					
					return ps.execute();
				}
			}); 
	 }
	 
	
}
