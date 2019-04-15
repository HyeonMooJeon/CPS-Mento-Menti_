package kr.cps.toring.controller.mentee;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.cps.toring.model.Menteeapply;
import kr.cps.toring.service.GroupStudyService;
import kr.cps.toring.service.MentorNoticeService;
import kr.cps.toring.service.MymenteeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class MymenteeController {
	private static final Logger logger = LoggerFactory.getLogger(MymenteeController.class); 
	private MymenteeService mymenteeService;
	private  GroupStudyService groupservice;
	private MentorNoticeService mentor;
	
	@Autowired
	public void setMyFamilyService(MymenteeService mymenteeService, GroupStudyService groupservice, MentorNoticeService mentor) {
		this.mymenteeService = mymenteeService;
		this.groupservice = groupservice;
		this.mentor =mentor;
	}
	
	
	
	/////////////////////////////////////���⼭ ���ʹ� json,ajax,jqure�������̴�.///////////////////
	 
	 
	 
	 //해당 게시물에 신청 한 신청자 목록
		@RequestMapping(value = "/applylist", method=RequestMethod.GET) 
		public JSONObject mymentee(@RequestParam("postnumber") String postnum){
			
		//	List<Mymentee> json= mymenteeService.mymenteelist();
		List<Menteeapply> json = mymenteeService.selectapplymentee(Integer.parseInt(postnum));
		
		
			JSONArray jsonarray = JSONArray.fromObject(json);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", jsonarray);
			
			JSONObject jsonobject = JSONObject.fromObject(map);
			//System.out.println(jsonobject); 
			return jsonobject;
		}	
			
	 
	 //신청 수락 후 인원체크 인원증가
	 @RequestMapping(value="/testing")
	 public void Test(HttpServletRequest req, ModelMap model, HttpServletResponse response) throws Exception {
		 logger.info("신청 수락");
		 
		 req.setCharacterEncoding("utf-8");
		
			
			String menteenumber = req.getParameter("menteenumber");
			String postnumber = req.getParameter("postnum");
			String applydata = req.getParameter("applydata");
			String menteename = req.getParameter("menteename");
			String mentorname=req.getParameter("membername"); 
			int mentornumber = Integer.parseInt(req.getParameter("menmbernumber"));
			String title = req.getParameter("title");
			
		
			
			if(groupservice.checkgroup(Integer.parseInt(postnumber)).get(0) == 0) {
				groupservice.addGroupStudy(Integer.parseInt(postnumber),mentornumber,mentorname,title);
				
			}
			
			mymenteeService.applyupdatementeelist(Integer.parseInt(postnumber),Integer.parseInt(menteenumber),applydata);
			mentor.addPersonNumber(Integer.parseInt(postnumber));
			int groupnumbers=groupservice.getGroupNumber(Integer.parseInt(postnumber)).get(0);
			
			groupservice.addMentee(groupnumbers, Integer.parseInt(menteenumber), mentorname);
			
	 }
	  
	 
	 //��Ƽ ��û�� �ۼ�
	 @RequestMapping(value="/insertapplymentee")
	 public void insertapplyMentee(  HttpServletRequest req, ModelMap model, HttpServletResponse response, MultipartHttpServletRequest request) throws Exception {
		   logger.info("멘티 신청");
			//req.setCharacterEncoding("EUC-KR");
			req.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
			
			Menteeapply mentee=new Menteeapply();
			
			String applyTitle = req.getParameter("applyTitle");//����
			String applysubject = req.getParameter("applysubject");
			int postnum= Integer.parseInt(req.getParameter("postnum"));//�Խù�ȣ
			int menteenumber = Integer.parseInt(req.getParameter("menteenumber")); //ȸ����ȣ
			String menteename= req.getParameter("menteename");
			String applydate=req.getParameter("time");
			String applyYesNo= null;//
			String applydatetime= req.getParameter("applydate");
			
			String file1 = request.getSession().getServletContext().getRealPath("/");
			String path = file1+"resources/mentoring/";
			
			List<MultipartFile> filelist = request.getFiles("file1");

			String newFileName = ""; 
		        String fileName    = "";
		        
		        File dir = new File(path); 
		        if(!dir.isDirectory()){
		            dir.mkdir();
		        }
		        
		        for(MultipartFile mf : filelist) {
		        	
		        	String originFileName = mf.getOriginalFilename();
		        	long fileSize = mf.getSize();
		        	
		        	System.out.println("실제이름 : "+ originFileName);
		        	System.out.println("fileSize: "+ fileSize);
		        	
		        	if(fileSize>0) {
		        		
		        	fileName = originFileName;
		        	fileName = fileName.trim().replaceAll(" +", "_");
		        	 UUID uuid = UUID.randomUUID();
		        	 String ext = fileName.substring(fileName.lastIndexOf('.'));
		        	 newFileName = uuid+ext;
		        	
		        	 try {
			                mf.transferTo(new File(path+newFileName));
			            } catch (Exception e) {
			                e.printStackTrace();
			            }
			            
			            logger.info("file newname : " + path + newFileName);
			          
			            
		        	}else {
		        		break;
		        	}
		        }  
		        
		        mentee.setPostnum(postnum);
		        mentee.setMenteenumber(menteenumber);
		        mentee.setMenteename(menteename);
		        mentee.setHeadname(applyTitle);
		        mentee.setInname(applysubject);
		        mentee.setFilename(fileName);
		        mentee.setNewfilename(newFileName);
		        mentee.setApplydate(applydate);
		        mentee.setApplydatetime(applydatetime);
		        mentee.setApplyYesNo(applyYesNo);
		        
		        mymenteeService.insertmymenteeapply(mentee);
	 }
	 
	 
	 
	 //자신이 회원번호를 가지고 멘토 신청 리스트 조회mymenteeapply
		@RequestMapping(value = "/menteelistapply", method=RequestMethod.GET) 
		public JSONObject mymenteeapplylist(@RequestParam("menteenumber") int menteenumber){
			
		//	List<Mymentee> json= mymenteeService.mymenteelist();
		List<Menteeapply> json = mymenteeService.mymenteeapply(menteenumber);
		
		
			JSONArray jsonarray = JSONArray.fromObject(json);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", jsonarray);
			
			JSONObject jsonobject = JSONObject.fromObject(map);
			//System.out.println(jsonobject); 
			return jsonobject;
		}	
			
	 //게시번호를 가지고 멘티 신청리스트 삭제
		@RequestMapping(value="/menteedelete")
		public void menteedelete (HttpServletRequest req) {
			
			mymenteeService.deleteappplymentee(Integer.parseInt(req.getParameter("postnumber")));
			
		}
	 //멘티 신청서 수정
		  @RequestMapping(value="/updateapplymenteelist")
			 public void updateReivewlist(HttpServletRequest req, MultipartHttpServletRequest request) throws Exception {
				 logger.info("후기 수정");
				 		
					req.setCharacterEncoding("utf-8");
					request.setCharacterEncoding("utf-8");
					

					
					Menteeapply mentee=new Menteeapply();
					
					String applyTitle = req.getParameter("applyTitle");//����
					String applysubject = req.getParameter("applysubject");
					int postnum= Integer.parseInt(req.getParameter("postnum"));//�Խù�ȣ
					int menteenumber = Integer.parseInt(req.getParameter("menteenumber")); //ȸ����ȣ
					String menteename= req.getParameter("menteename");
					String applydate=req.getParameter("timein");
					String applydatetime= req.getParameter("applydate");
				

				String file1 = request.getSession().getServletContext().getRealPath("/");
				String path = file1+"resources/mentoring/";
				
				List<MultipartFile> filelist = request.getFiles("file1");

				String newFileName = ""; 
			        String fileName    = "";
			        
			        File dir = new File(path); 
			        if(!dir.isDirectory()){
			            dir.mkdir();
			        }
			        
			        for(MultipartFile mf : filelist) {
			        	
			        	String originFileName = mf.getOriginalFilename();
			        	long fileSize = mf.getSize();
			        	
			        	System.out.println("실제이름 : "+ originFileName);
			        	System.out.println("fileSize: "+ fileSize);
			        	
			        	if(fileSize>0) {
			        		
			        	fileName = originFileName;
			        	fileName = fileName.trim().replaceAll(" +", "_");
			        	 UUID uuid = UUID.randomUUID();
			        	 String ext = fileName.substring(fileName.lastIndexOf('.'));
			        	 newFileName = uuid+ext;
			        	
			        	 try {
				                mf.transferTo(new File(path+newFileName));
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				            
				            logger.info("file newname : " + path + newFileName);
				       
				            
			        	}else {
			        		break;
			        	}
			        }  
			        
			        
			        mentee.setPostnum(postnum);
			        mentee.setMenteenumber(menteenumber);
			        mentee.setMenteename(menteename);
			        mentee.setHeadname(applyTitle);
			        mentee.setInname(applysubject);
			        mentee.setFilename(fileName);
			        mentee.setNewfilename(newFileName);
			        mentee.setApplydate(applydate);
			        mentee.setApplydatetime(applydatetime);
			      
			        mymenteeService.updateapplymentee(mentee);
			 }
		
	 
	 
}
