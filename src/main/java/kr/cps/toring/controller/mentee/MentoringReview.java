package kr.cps.toring.controller.mentee;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.cps.toring.model.Freenotice;
import kr.cps.toring.model.reviewnotice;
import kr.cps.toring.model.reviewnoticefile;
import kr.cps.toring.service.MymenteeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@RestController
public class MentoringReview {
	private static final Logger logger = LoggerFactory.getLogger(MymenteeController.class); 
	private MymenteeService mymenteeService;
	
	@Autowired
	public void setMyFamilyService(MymenteeService mymenteeService) {
		this.mymenteeService = mymenteeService;
	}
	
	
	
	//멀티파일 후기등록
	 @RequestMapping(value="/insertreview")
	 public void Test(HttpServletRequest req, MultipartHttpServletRequest request) throws Exception {
		 logger.info("후기 글 등록");
		 		
			req.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
			reviewnotice review = new reviewnotice();
			reviewnoticefile reviewfile = new reviewnoticefile();
			
	  	String applyTitle = req.getParameter("applyTitle");
		String applysubject = req.getParameter("applysubject");
		int menteenumber = Integer.parseInt(req.getParameter("menteenumber"));
		//int postnum= Integer.parseInt(req.getParameter("postnum"));
		String applydate= req.getParameter("applydate");
		String name=req.getParameter("menteename");
		System.out.println(req.getParameter("applysubject"));
		
		
		review.setHeadname(applyTitle);
		review.setMenteenumber(menteenumber);
		review.setName(name);
		//review.setPostnumber(postnum);
		review.setSubject(applysubject);
		review.setTimedate(applydate);
		
		mymenteeService.insertreviewnotice(review);

		String file1 = request.getSession().getServletContext().getRealPath("/");
		String path = file1+"resources/upload/";
		
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
		          
		            reviewfile.setPostnumber(mymenteeService.postnumber(menteenumber).get(0));
		            reviewfile.setMenteenumber(menteenumber);
		            reviewfile.setFilename(fileName);
		            reviewfile.setNewfilename(newFileName);
		           
		           mymenteeService.insertreviewnoticefile(reviewfile);
		            
	        	}else {
	        		break;
	        	}
	        }  
	 }
	 
	 //후기 이미지 파일
	 	@RequestMapping(value = "/fileimglist")
		public List<reviewnoticefile> home( Model model) {
			
		List<reviewnoticefile> filelistimg=  mymenteeService.selectreview();
		filelistimg.removeAll(Collections.singleton(null));
			return filelistimg; 
		}
		
		//후기 글 상위 5개 
		@RequestMapping(value = "/reviewheadname")
		public List<reviewnotice> reviewheanmae( Model model) {
	
			return mymenteeService.selecteheanamereivew(); 
		}
		
		 //후기 글 전체 리스트 출력
		@RequestMapping(value = "/reviewenrollmentelist")
		public JSONObject reviewenrollmentelist(){
		List<reviewnotice> json = mymenteeService.rivewnoticelist();
			JSONArray jsonarray = JSONArray.fromObject(json);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", jsonarray);
			
			JSONObject jsonobject =JSONObject.fromObject(map);
			//System.out.println("불름");
			  
			return jsonobject;
		}
		
		//후기 파일 목록 가져오기
		@RequestMapping(value="/ReviewDetail", method = RequestMethod.GET )
		public List<reviewnoticefile> reviewDetail(@RequestParam("postnumber") String postnum){
		
			return mymenteeService.filereviewDetail(Integer.parseInt(postnum));
		}  
		
			//후기 목록 json 형태를 ajax에서 받을 수 있도록 변환해준다.
		   @RequestMapping(value="/Reviewjson", method = RequestMethod.GET )
		   public List<reviewnotice> filelist(@RequestParam("postnumber") String postnum ) throws Exception {
		
			   
			   return mymenteeService.ReviewList(Integer.parseInt(postnum));
		    }
		
		
	 
/*		@RequestMapping(value = "/mainhomelist")
		public JSONObject mymentee(){
			
		//	List<Mymentee> json= mymenteeService.mymenteelist();
		List<Menteeapply> json = mymenteeService.selectapplymentee();
		
		
			JSONArray jsonarray = JSONArray.fromObject(json);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", jsonarray);
			
			JSONObject jsonobject = JSONObject.fromObject(map);
			
			return jsonobject;
		}
	*/
	
		   //후기 게시판 수정
		   @RequestMapping(value="/updateReivewlist")
			 public void updateReivewlist(HttpServletRequest req, MultipartHttpServletRequest request) throws Exception {
				 logger.info("후기 수정");
				 		
					req.setCharacterEncoding("utf-8");
					request.setCharacterEncoding("utf-8");
					

					
					reviewnotice review = new reviewnotice();
					reviewnoticefile reviewfile = new reviewnoticefile();
					
			  	String applyTitle = req.getParameter("applyTitle");
				String applysubject = req.getParameter("applysubject");
				int menteenumber = Integer.parseInt(req.getParameter("menteenumber"));
				int postnum= Integer.parseInt(req.getParameter("postnum"));
				String applydate= req.getParameter("applydate");
				String name=req.getParameter("menteename");
				System.out.println(req.getParameter("applysubject"));
				
				mymenteeService.deletereviewnoticefiles(postnum);
				
				review.setHeadname(applyTitle);
				review.setMenteenumber(menteenumber);
				review.setName(name);
				review.setPostnumber(postnum);
				review.setSubject(applysubject);
				review.setTimedate(applydate);
				
				mymenteeService.updatereviewnotice(review);

				String file1 = request.getSession().getServletContext().getRealPath("/");
				String path = file1+"resources/upload/";
				
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
				          
				            reviewfile.setPostnumber(postnum);
				            reviewfile.setMenteenumber(menteenumber);
				            reviewfile.setFilename(fileName);
				            reviewfile.setNewfilename(newFileName);
				           
				           mymenteeService.insertreviewnoticefile(reviewfile);
				            
			        	}else {
			        		break;
			        	}
			        }  
			 }
	
		   
		   @RequestMapping(value="ReviewDelete",  method = RequestMethod.GET)
		   public void Delete(@RequestParam("postnumber") String postnum) {
			    
			   mymenteeService.deletereviewnotices(Integer.parseInt(postnum));
		   }
		   
		   
		   @RequestMapping(value="/myreviewnoticelist")
			 public JSONObject myreviewlist(@RequestParam("menteenumber") int menteenumber){
				 List<reviewnotice> free = mymenteeService.myreviewlist(menteenumber);
				 JSONArray jsonarray = JSONArray.fromObject(free);
				 
				 Map<String, Object> map = new HashMap<String, Object>();
				 map.put("data",jsonarray);
				 
				 JSONObject jsonobject = JSONObject.fromObject(map);
				 //System.out.println(jsonobject);
				 return jsonobject;
			 }
		   
		 
		   
		   
	
}
