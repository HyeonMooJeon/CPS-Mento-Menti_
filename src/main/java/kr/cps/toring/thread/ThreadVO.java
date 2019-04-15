package kr.cps.toring.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import kr.cps.toring.service.MentorNoticeService;

public class ThreadVO extends Thread{

	private MentorNoticeService mentorNoticeService;
	
	@Autowired
	public void setMentorNoticeService(MentorNoticeService mentorNoticeService){
		this.mentorNoticeService = mentorNoticeService;
	}
	
	public void init() {
		this.start();
	}
	
	@Override
	public void run() {
	while(true) {
			try{
				Thread.sleep(60000);
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				mentorNoticeService.checkTime(sdf.format(date).toString());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
