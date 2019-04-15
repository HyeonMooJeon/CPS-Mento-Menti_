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

import kr.cps.toring.model.Menteeapply;
import kr.cps.toring.model.reviewnotice;
import kr.cps.toring.model.reviewnoticefile;


@Repository
public class MymenteeDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSourece(DataSource datasource) {
		this.jdbcTemplate=new JdbcTemplate(datasource);
	}
  
/////////////////////////////���⼭ ����  
 			////// mymentee ���⿡ insert
 
 //멘토링 모집게시글에 멘티 신청
 public Boolean insertapplymentee(final Menteeapply menteeapply )	 {
		String sql = "insert into menteeapply values(?,?,?,?,?,?,?,?,?,?)";
		
		
		return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setInt(1, menteeapply.getPostnum());
				ps.setInt(2, menteeapply.getMenteenumber());
				ps.setString(3, menteeapply.getMenteename());
				ps.setString(4, menteeapply.getHeadname());
				ps.setString(5, menteeapply.getInname());
				ps.setString(6, menteeapply.getFilename());
				ps.setString(7, menteeapply.getNewfilename());
				ps.setString(8, menteeapply.getApplydate());
				ps.setString(9, menteeapply.getApplydatetime());
				ps.setString(10, menteeapply.getApplyYesNo());
				
				return ps.execute();
			}
		});
		
	}

 
 //멘티 신청 내역 가져오기
	public List<Menteeapply> getselectmenteeapply(int postnum){
		String sqlStatment = "select * from menteeapply where postnum="+postnum;
		
		return jdbcTemplate.query(sqlStatment, new RowMapper<Menteeapply>() {

			@Override
			public Menteeapply mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Menteeapply mm = new Menteeapply();
				
				mm.setHeadname(rs.getString("headname"));
				mm.setFilename(rs.getString("filename"));
				mm.setInname(rs.getString("subject"));
				mm.setNewfilename(rs.getString("newfilname"));
				mm.setPostnum(Integer.parseInt(rs.getString("postnum")));
				mm.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
				mm.setMenteename(rs.getString("menteename"));
				mm.setApplydate(rs.getString("applydate"));
				mm.setApplyYesNo(rs.getString("applyYesNo"));
			    mm.setApplydatetime(rs.getString("applydatetime"));
				
				return mm;
			}
		});
	}
	 
	
	   
	//신청완료로 업데이트
	 public Boolean applyupdatementee(final int postnumber, final int menteenumber, final String applyYesNo )	 {
			String sql = "update menteeapply set applyYesNo=? where postnum=? and menteenumber=?";
			 
		
			return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public  Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				
					ps.setString(1, applyYesNo);
					ps.setInt(2, postnumber);
					ps.setInt(3, menteenumber);
					
					
					return ps.execute();
				}
			
			
			});
			
		}
	
	 //여기서 부터 후기 게시판 내뇽
	 
		public List<Integer> postnum(){
			String sqlStatment = "select MAX(postnumber) as postnumber from reviewnotice";
			
			return jdbcTemplate.query(sqlStatment, new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					reviewnotice review = new reviewnotice();
					String postnumber = rs.getString("postnumber");
					if(postnumber==null) {
						int postnum=0;
						review.setPostnumber(postnum);
					}else {
						review.setPostnumber(Integer.parseInt(postnumber));
					}
				return review.getPostnumber();
				}
			});
		}
		
		//후기 파일 등록시 먼저 입력된 후기 게시글 번호를 가져온다.
		public List<Integer> menteepostnumber(int menteenumber){
				String sqlStatment = "select postnumber from reviewnotice  where menteenumber ="+menteenumber+" ORDER BY postnumber DESC limit 1";
			
			return jdbcTemplate.query(sqlStatment, new RowMapper<Integer>() {

				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					reviewnotice review = new reviewnotice();
				
					review.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
					
					
				return review.getPostnumber();
				}
			});
		}
		
		
		 public Boolean insertreviewnotice(final reviewnotice review )	 {
				String sql = "insert into reviewnotice value(?,?,?,?,?,?)";
	
				return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						ps.setInt(1, review.getPostnumber());
						ps.setInt(2, review.getMenteenumber());
						ps.setString(3, review.getHeadname());
						ps.setString(4, review.getSubject());
						ps.setString(5, review.getName());
						ps.setString(6, review.getTimedate());
					
						return ps.execute();
					}
				});
			}
		 
		 public Boolean insertreviewnoticefile(final reviewnoticefile reviewfile )	 {
				String sql = "insert into reviewfile value(?,?,?,?)";
			
				return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						ps.setInt(1, reviewfile.getPostnumber());
						ps.setInt(2, reviewfile.getMenteenumber());
						ps.setString(3, reviewfile.getFilename());
						ps.setString(4, reviewfile.getNewfilename());
						
						return ps.execute();
					}
				});
			}
		 
		 
		 //후기 이미지만 가져오기
		 public List<reviewnoticefile> getreviewfile(){
				String sqlStatment = "select * from reviewfile";
				
				return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnoticefile>() {

					@Override
					public reviewnoticefile mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						reviewnoticefile reviewfileimg = new reviewnoticefile();
				
						String imgcheck = rs.getString("filename");
						String ext=imgcheck.substring(imgcheck.lastIndexOf(".")+1);
					
						if(ext.equals("png") || ext.equals("PNG") || ext.equals("jpg") || ext.equals("JPEG") ) {
							reviewfileimg.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
							reviewfileimg.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
							reviewfileimg.setFilename(imgcheck);
							reviewfileimg.setNewfilename(rs.getString("newfilename"));	
							return reviewfileimg;
						}
							
						return null;
					}
				});
			}
		 
		 //상위 다섯개의 게시물 가져오기 
		 public List<reviewnotice> selectereview(){
			 String sqlStatment = "select * from reviewnotice ORDER BY postnumber DESC limit 5";
			 
					 return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnotice>() {

							@Override
							public reviewnotice mapRow(ResultSet rs, int rowNum) throws SQLException {
								// TODO Auto-generated method stub
								reviewnotice review = new reviewnotice();
						
							review.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
							review.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
							review.setHeadname(rs.getString("headna"));
							review.setTimedate(rs.getString("timedate"));
								return review;
							}
						});
		 }
		 
		 //후기 전체 리스트 출력
		 public List<reviewnotice> reivewnoticelist(){
			 String sqlStatment = "select * from reviewnotice";
			 return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnotice>() {

					@Override
					public reviewnotice mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						reviewnotice review = new reviewnotice();
				
					review.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
					review.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
					review.setHeadname(rs.getString("headna"));
					review.setSubject(rs.getString("subject"));  
					review.setName(rs.getString("name"));
					review.setTimedate(rs.getString("timedate"));

					return review;
					}
				});
		 }
		 
		 //후기 전체 리스트 출력
		 public List<reviewnotice> Reviewnoticpost(int postnumber){
			 String sqlStatment = "select * from reviewnotice where postnumber="+postnumber;
			 return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnotice>() {  

					@Override
					public reviewnotice mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						reviewnotice review = new reviewnotice();
				
					review.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
					review.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
					review.setHeadname(rs.getString("headna"));
					review.setSubject(rs.getString("subject"));  
					review.setName(rs.getString("name"));
					review.setTimedate(rs.getString("timedate"));

					return review;
					}
				});
		 }
		 
		 //상세 파일 리스트 출력
		 public List<reviewnoticefile> filereviewDetail(int postnumber){
			 String sqlStatment = "select * from reviewfile where postnumber="+postnumber;
				return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnoticefile>() {

					@Override
					public reviewnoticefile mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						reviewnoticefile reviewfileimg = new reviewnoticefile();
				
							reviewfileimg.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
							reviewfileimg.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
							reviewfileimg.setFilename(rs.getString("filename"));
							reviewfileimg.setNewfilename(rs.getString("newfilename"));	
							
							return reviewfileimg;
					}
				});
		 }
		 
		 
	 //후기 게시판 수정
		 public Boolean updatereivewnotice(final reviewnotice reviewnotice) {
				String sql = "update reviewnotice set postnumber=?,headna=?,subject=?, name=?,timedate=? where postnumber=? and menteenumber=?";

				return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
					
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
						
						ps.setInt(1, reviewnotice.getPostnumber());
						ps.setString(2, reviewnotice.getHeadname());
						ps.setString(3, reviewnotice.getSubject());
						ps.setString(4, reviewnotice.getName());
						ps.setString(5, reviewnotice.getTimedate());
						ps.setInt(6, reviewnotice.getPostnumber());
						ps.setInt(7, reviewnotice.getMenteenumber());
						return ps.execute();
					}
				});
				
			}
		 
		/* public Boolean updatereivewnotice(reviewnotice reviewnotice) {
			 
				String sql = "update reviewnotice set postnumber=?,headna=?,subject=? name=?,timedate=? where postnumber=? and menteenumber=?";
				jdbcTemplate.update(sql,reviewnotice.getPostnumber(),reviewnotice.getHeadname(),reviewnotice.getSubject(),reviewnotice.getName(),reviewnotice.getTimedate(),
						reviewnotice.getPostnumber(),reviewnotice.getMenteenumber());
				return true; 
		 } 
		 */
		 //후기파일 게시판 삭제
		 public Boolean deletereviewnotice(final int postnumber) {
				String sql = "delete from reviewnotice where postnumber=?";

				return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
					
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
						
						ps.setInt(1, postnumber);
						
						return ps.execute();
					}
				}); 
		 }

		 //후기파일 게시판파일 삭제
		 public Boolean deletereviewnoticefile(final int postnumber) {
				String sql = "delete from reviewfile where postnumber=?";

				return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
					
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
						
						ps.setInt(1, postnumber);
						return ps.execute();
					}
				});
		 }
		 
		 
		
		 //멘티 회원번호로 신청 내역 가져오기
			public List<Menteeapply> selctementeenumber(int menteenumber){
				String sqlStatment = "select * from menteeapply where menteenumber="+menteenumber;
				
				return jdbcTemplate.query(sqlStatment, new RowMapper<Menteeapply>() {

					@Override
					public Menteeapply mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						Menteeapply mm = new Menteeapply();
						
						mm.setHeadname(rs.getString("headname"));
						mm.setFilename(rs.getString("filename"));
						mm.setInname(rs.getString("subject"));
						mm.setNewfilename(rs.getString("newfilname"));
						mm.setPostnum(Integer.parseInt(rs.getString("postnum")));
						mm.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
						mm.setMenteename(rs.getString("menteename"));
						mm.setApplydate(rs.getString("applydate"));
						mm.setApplyYesNo(rs.getString("applyYesNo"));
					    mm.setApplydatetime(rs.getString("applydatetime"));
						
						return mm;
					}
				});
			}
		 
			//멘티 신청내역 삭제
			 public Boolean menteeapplydelete(final int postnumber) {
					String sql = "delete from menteeapply where postnum=? and applyYesNo=?";

					return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
						
						@Override
						public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
							
							ps.setInt(1, postnumber);
							ps.setString(2, null);
							return ps.execute();
						}
					});
			 }
			 
			
			 //멘티 수정
			 public Boolean updateapplymentee(final Menteeapply apply) {
					String sql = "update menteeapply set headname=?,subject=?, menteename=?,applydate=?,applydatetime=?,filename=?,newfilname=? where postnum=? and menteenumber=?";

					return jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
						 
						@Override
						public Boolean doInPreparedStatement(PreparedStatement ps)throws SQLException, DataAccessException{
							
							
							ps.setString(1, apply.getHeadname());
							ps.setString(2, apply.getInname());
							ps.setString(3, apply.getMenteename());
							ps.setString(4, apply.getApplydate());
							ps.setString(5, apply.getApplydatetime());
							ps.setString(6, apply.getFilename());
							ps.setString(7, apply.getNewfilename());
							
							ps.setInt(8, apply.getPostnum());
							ps.setInt(9, apply.getMenteenumber());
							return ps.execute();
						}
					});
					
				}
			 
			 public List<reviewnotice> myreviewlist(int menteenumber){
					String sqlStatment = "select * from reviewnotice where menteenumber="+menteenumber;
					
					return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnotice>() {

						@Override
						public reviewnotice mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							reviewnotice review = new reviewnotice();
							
							review.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
							review.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
							review.setHeadname(rs.getString("headna"));
							review.setSubject(rs.getString("subject"));  
							review.setName(rs.getString("name"));
							review.setTimedate(rs.getString("timedate"));
							
							return review;
						}
					});
				}
			 
			 
			 
			 
		 
		 
	/* //�ı� �Խ��� ���
	 //�ı� �Խ��� ��� ��������
	

		 //���ǿ� �����ϴ� �ı� �Խ��� ���� ��� ��������
		 
	 public List<reviewnoticefile> reviewfileDetail(int postnumber){ //, int menteenum){
			 
			 String sqlStatment = "select * from reviewfile where postnumber="+postnumber; //+", and menteenumber="+menteenum;
			
				return jdbcTemplate.query(sqlStatment, new RowMapper<reviewnoticefile>() {

					@Override
					public reviewnoticefile mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						reviewnoticefile reviewfile = new reviewnoticefile();
						
						reviewfile.setPostnumber(Integer.parseInt(rs.getString("postnumber")));
						reviewfile.setMenteenumber(Integer.parseInt(rs.getString("menteenumber")));
						reviewfile.setFilename(rs.getString("filename"));
						reviewfile.setNewfilename(rs.getString("newfilename"));
		
						
						return reviewfile;
					}
				});
		 }*/
		
			 //차트에 해당하는 유저 전체 회원수 
			  public List<Integer> usercount(){
			      String sql = "select count(*) as usercount from member";
			      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
			         @Override
			         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			            return rs.getInt("usercount");
			         }
			      }); 
			   }
			  //멘토 인원 체크
			  public List<Integer> usermentor(){
			      String sql = "select count(userDivision) as userDivision from member where userDivision = '멘토'";
			      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
			         @Override
			         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			            return rs.getInt("userDivision");
			         }
			      }); 
			   }
			  
			  /*멘티 신청 개수 */
			  public List<Integer> menteecount(){
			      String sql = "select count(*) as menteeapply from menteeapply";
			      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
			         @Override
			         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			            return rs.getInt("menteeapply");
			         }
			      }); 
			   }
			  
			  /*멘토 등록 개수*/
			  public List<Integer> mentornoticecount(){
			      String sql = "select count(*) as mentor_notice from mentor_notice";
			      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
			         @Override
			         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			            return rs.getInt("mentor_notice");
			         }
			      }); 
			   }
			  
			  
			  //매칭이된 그룹게시판 수
			  public List<Integer> groupstudy(){
			      String sql = "select count(*) as groupStudy from groupStudy";
			      return jdbcTemplate.query(sql, new RowMapper<Integer>(){
			         @Override
			         public Integer mapRow(ResultSet rs, int rowNum) throws SQLException{
			            return rs.getInt("groupStudy");
			         }
			      }); 
			   }
			  
			  
		
}
