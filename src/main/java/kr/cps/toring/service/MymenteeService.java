package kr.cps.toring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.cps.toring.dao.FreenoticeDAO;
import kr.cps.toring.dao.MymenteeDAO;
import kr.cps.toring.model.Freenotice;
import kr.cps.toring.model.Menteeapply;
import kr.cps.toring.model.reviewnotice;
import kr.cps.toring.model.reviewnoticefile;

@Service
public class MymenteeService {

	private MymenteeDAO mymenteeDAO;
	private FreenoticeDAO freenoticeDAO;
	
	@Autowired
	public void setMyMenteeDAO(MymenteeDAO mymenteeDAO) {
		this.mymenteeDAO=mymenteeDAO;
	}
	
	@Autowired
	public void setFreenoticeDAO(FreenoticeDAO freenoticeDAO) {
		this.freenoticeDAO=freenoticeDAO;
	}
	
	///////////////////////////////////////////////////////����
	
	//���� ��û���� �ø��� 
	public void insertmymenteeapply(Menteeapply mentee) {
		mymenteeDAO.insertapplymentee(mentee);
	}
	
	//���� ��û���� �ҷ�����
	public List<Menteeapply> selectapplymentee(int postnum){
		return mymenteeDAO.getselectmenteeapply(postnum);
	}
	

	public void applyupdatementeelist(int postnumber, int menteenumber, String applyYesNo) {
	 	mymenteeDAO.applyupdatementee(postnumber, menteenumber, applyYesNo);
	} 
	
	//게시물 등록 번호 가져오기
	public int postnum() {
		List<Integer> postnum= mymenteeDAO.postnum();
		System.out.println(postnum.get(0));
		
		int num = postnum.get(0);
		
		return num;
	}
	
	
	//여기서 부터 후기 게시판 내용
	public void insertreviewnotice(reviewnotice review) {
		mymenteeDAO.insertreviewnotice(review); //등록
	}
	
	public void insertreviewnoticefile(reviewnoticefile reviewfile) {
		mymenteeDAO.insertreviewnoticefile(reviewfile);//등록
	}
	
	public List<reviewnoticefile> selectreview(){
		return mymenteeDAO.getreviewfile(); //이미지만 가져오기
	}
	
	public List<reviewnotice> selecteheanamereivew(){
		return mymenteeDAO.selectereview(); //후기 전체 가져오기
	}
	
	public List<reviewnotice> rivewnoticelist(){
		return mymenteeDAO.reivewnoticelist(); //후기 글 상위 5개 가져오기
	}
	//후기 파일 가져오기
	public List<reviewnoticefile> filereviewDetail(int postnumber){
		return mymenteeDAO.filereviewDetail(postnumber);
	}
	
	public List<reviewnotice> ReviewList(int postnumber){
		return mymenteeDAO.Reviewnoticpost(postnumber); //후기 전체 가져오기
	}
	
	public List<Integer> postnumber(int menteenubmer){
		return mymenteeDAO.menteepostnumber(menteenubmer);
		
	}
	
	
	//후기 수정 //후기 파일은 파일 목록 삭제후 다시 올리기
	public Boolean updatereviewnotice(reviewnotice reviewnotice) {
		return mymenteeDAO.updatereivewnotice(reviewnotice);
	}
	
	//후기 파일 삭제
	public Boolean deletereviewnoticefiles(int postnumber) {
		return mymenteeDAO.deletereviewnoticefile(postnumber);
	}
	
	//후기 게시판 삭제
	public Boolean deletereviewnotices(int postnum) {
		return mymenteeDAO.deletereviewnotice(postnum);
	}
	
	//////
	//자신의 회뭔 번호로 자신이 신청 멘티 신청 내역 가져오기
	public List<Menteeapply> mymenteeapply(int menteenumber){
		return mymenteeDAO.selctementeenumber(menteenumber);
	}

	//맨티 신청서 게시번호로 삭제
	public Boolean deleteappplymentee(int postnum) {
		return mymenteeDAO.menteeapplydelete(postnum);
	}
	
	//멘티 신청서 수정
	public Boolean updateapplymentee(Menteeapply menteeapply) {
		return mymenteeDAO.updateapplymentee(menteeapply);
	}
	
	
	//////////////////////////////
	//자유게시판
	public Boolean freeinsertnotice(Freenotice free) {
		return freenoticeDAO.freenoticeinsert(free);
	}
	
	//자유게시판 젠체리스트 출력
	public List<Freenotice> freelist(){
		return freenoticeDAO.selectFreenoticelist();
	}
	
	//해당하는 게시물만 수정
	public Boolean freeupdatelist(Freenotice free){
		return freenoticeDAO.updatefreelist(free);
		
	}
	
	//자신의 회원번호에 해당하는 자유 게시글 불러오기
	public List<Freenotice> myfreelist(int menteenumber){
		return freenoticeDAO.myfreelist(menteenumber);
	}
	
	
	//자신이 선택한 게시물 번호로 삭제
	public Boolean myfreedelete(int postnumber) {
		return freenoticeDAO.myfreenoticedelete(postnumber);
	}
	
	
	//자신의 후기 게시물 가져오기
	public List<reviewnotice> myreviewlist(int menteenumber){
		return mymenteeDAO.myreviewlist(menteenumber);
	}
	
	
	/*
	
	//�ı� �Խ��� �� ���� �ҷ�����
	
	public List<reviewnotice> reviewDetail(int postnumber) {
		return mymenteeDAO.reviewDetail(postnumber);
		
	}
	//�ı� �Խ��� �� ���� ���� �ҷ�����
	public List<reviewnoticefile> reviewDetailfile(int postnumber) {
		return mymenteeDAO.reviewfileDetail(postnumber);
	}
	
	//후기 게시판에서 파일 리스트를 가져오는 것
	public List<reviewnoticefile> rewviews(int postnumber){
		
	}
	*/
	
	//멘토 멘티 체트하기
	public List<Integer> usercount(){
		return mymenteeDAO.usercount();
	}
	//멘토 인원 체크
	public List<Integer> usermentor(){
		return mymenteeDAO.usermentor();
	}
	
	
	//멘티 신청 개수
	public List<Integer> menteecount(){
		return mymenteeDAO.menteecount();
	}
	
	//멘토 등록개수
	public List<Integer> mentornoticecount(){
		return mymenteeDAO.mentornoticecount();
	}
	
	//매칭된 그붑스터디 수
	public List<Integer> groupcount(){
		return mymenteeDAO.groupstudy();
	}
	
}
