package kr.cps.toring.controller.mentee;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.cps.toring.model.Freenotice;
import kr.cps.toring.service.MymenteeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@RestController
public class FreenoticeController {
	private static final Logger logger = LoggerFactory.getLogger(MymenteeController.class); 
	private MymenteeService mymenteeService;
	
	@Autowired
	public void setMyFamilyService(MymenteeService mymenteeService) {
		this.mymenteeService = mymenteeService;
	}
	
	
	//자유 게시판 등록
	 @RequestMapping(value="/insertfree")
	 public void Test(HttpServletRequest req, MultipartHttpServletRequest request) throws Exception {
		 logger.info("자유게시판 등록");
		 		
			req.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
		Freenotice free = new Freenotice();
			
	  	String applyTitle = req.getParameter("applyTitle");
		String applysubject = req.getParameter("applysubject");
		int menteenumber = Integer.parseInt(req.getParameter("menteenumber"));
		String applydate= req.getParameter("applydate");
		String name=req.getParameter("menteename");
		
		String file1 = request.getSession().getServletContext().getRealPath("/");
		String path = file1+"resources/material/";
		
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
        
		free.setHeadname(applyTitle);
		free.setMenteenumber(menteenumber);
		free.setName(name);
		free.setSubject(applysubject);
		free.setTimedate(applydate);
		free.setFilematerial(fileName);
		free.setNewfilematerial(newFileName);
		
		
		mymenteeService.freeinsertnotice(free);

	 }
	
	//자유게시판 전체 리스트 출력
	 @RequestMapping(value="/freelistall")
	 public JSONObject freelistall(){
		 List<Freenotice> free = mymenteeService.freelist();
		 JSONArray jsonarray = JSONArray.fromObject(free);
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("data",jsonarray);
		 
		 JSONObject jsonobject = JSONObject.fromObject(map);
		 
		 return jsonobject;
	 }
	 
	
	 @RequestMapping(value="/freeupdatelist")
	 public void freeupdatelist(HttpServletRequest req, MultipartHttpServletRequest request) throws Exception {
		 logger.info("자유게시판 수정");
		 		
			req.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			
		Freenotice free = new Freenotice();
			
	  	String applyTitle = req.getParameter("applyTitle");
		String applysubject = req.getParameter("applysubject");
		int menteenumber = Integer.parseInt(req.getParameter("menteenumber"));
		String applydate= req.getParameter("applydate");
		String name=req.getParameter("menteename");
		System.out.println(req.getParameter("applysubject"));
		
		
		String file1 = request.getSession().getServletContext().getRealPath("/");
		String path = file1+"resources/material/";
		
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
        
        
        
		free.setPostnumber(Integer.parseInt(req.getParameter("postnum")));
		free.setHeadname(applyTitle);
		free.setMenteenumber(menteenumber);
		free.setName(name);
		free.setSubject(applysubject);
		free.setTimedate(applydate);
		free.setFilematerial(fileName);
		free.setNewfilematerial(newFileName);
		
		
		mymenteeService.freeupdatelist(free);

	 }
	
		 
	 
	 @RequestMapping(value="/myfreeapplylist")
	 public JSONObject myfreelist(@RequestParam("menteenumber") int menteenumber){
		 List<Freenotice> free = mymenteeService.myfreelist(menteenumber);
		 JSONArray jsonarray = JSONArray.fromObject(free);
		 
		 Map<String, Object> map = new HashMap<String, Object>();
		 map.put("data",jsonarray);
		 
		 JSONObject jsonobject = JSONObject.fromObject(map);
		 //System.out.println(jsonobject);
		 return jsonobject;
	 }
	 

	 @RequestMapping(value="/myfreedelete")
		public void menteedelete (HttpServletRequest req) {
			
			mymenteeService.myfreedelete(Integer.parseInt(req.getParameter("postnumber")));
			
		}
}
