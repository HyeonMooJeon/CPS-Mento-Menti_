<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>멘토 - 멘티 매칭 사이트 토링</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="resources/css/bootstrap.css" rel="stylesheet" />
  <link href="resources/css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="resources/css/fancybox/jquery.fancybox.css" rel="stylesheet">
  <link href="resources/css/jcarousel.css" rel="stylesheet" />
  <link href="resources/css/flexslider.css" rel="stylesheet" />
  <link href="resources/css/style.css" rel="stylesheet" />
  <!-- Theme skin -->
  <link href="resources/skins/default.css" rel="stylesheet" />
  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="resources/ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="resources/ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="resources/ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="resources/ico/apple-touch-icon-57-precomposed.png" />
 <link rel="shortcut icon" href="resources/img/KakaoTalk_20181129_215759141.png" />

  <!-- =======================================================
    Theme Name: Flattern
    Theme URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
  <!-- 이길우 링크 추가 -->
<!-- 한이음 테이블 css -->
<link rel="stylesheet" type="text/css" href="https://www.hanium.or.kr/css/board.css">
<!-- 달력 날짜 선택 -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link href="resources/css/test.css" rel="stylesheet" type="text/css"/>
<style>
/*datepicer 버튼 롤오버 시 손가락 모양 표시*/
.ui-datepicker-trigger{cursor: pointer;}
/*datepicer input 롤오버 시 손가락 모양 표시*/
.hasDatepicker{cursor: pointer;}
#content {
 	padding: 0px 0 0 0;
}
.left-sidebar {
    padding: 50px 0 0 0;
}
.bbsWriteA tbody tr td textarea {
    background-color: #fbfbfb !important;
    font-size: 14px;
    overflow: auto;
}
.center {
  position: relative;
  left: 50%;
  transform: translateX(-50%);
}
</style>
<script>
function groupStudy(){
		var number = <%=session.getAttribute("sessionNUMBER")%>;
		if(number == null){
			alert("로그인을 먼저해주세요!");
		}else{
	  	$("#memberNumber").val('<%=session.getAttribute("sessionNUMBER")%>');
	  	$("#groupStudy").submit();
		}  
	}
function send(){
	/* var param = $("form[name=edit]").serialize(); */
	var formData= new FormData($("#edit")[0])
	console.log("update실행")
	$.ajax({
		 url :"/toring/updateMentorNotice"
		 ,type:"post"
		 ,data:formData
         ,dataType:"json"
         ,processData : false
         ,contentType : false
	 	 ,success: function(data){
	 		 if(data.check==1){
	 			alert("게시글을 수정했습니다");
	 			location.href="/toring/mentorNoticeBoard";
	 		 }else{
	 			alert("데이터베이스 에러");
	 		 }	 		 
	 	  },error: function(){
	 		  alert("서버 에러");
	 	  }
	 });
}
</script>
</head>

<body>
<%
        if(!(session.getAttribute("sessionID") == null)) // 로그인이 되었을 때
        { 
	 %>
        <div id="wrapper">
    <!-- toggle top area -->
    <div class="hidden-top">
      <div class="hidden-top-inner container">
        <div class="row">
          <div class="span12">
            <ul>
              <li><strong>멘토 - 멘티의 매칭은 항상 열려 있습니다.</strong></li>
              <li>Main office: 충청남도 아산시 탕정면 선문로221번길 70 선문대학교</li>
              <li>Call us <i class="icon-phone"></i> 010 - 5060 - 6887 </li>
            </ul>
          </div>
        </div>
      </div> 
    </div>
    <!-- end toggle top area -->
    <!-- start header -->
    <header>
      <div class="container">
        <!-- hidden top area toggle link -->
        <div id="header-hidden-link">
          <a href="#" class="toggle-link" title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
        </div>
        <!-- end toggle link -->
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
              <ul>
               <li><a href="/toring/my_page_redata"><i class="icon-user"></i>My Page</a></li>
                <li><a href="#" data-toggle="modal" data-target="#logoutModal">Logout</a></li>
              </ul>
            </div>
		
 	<% 		// 로그인 화면으로 이동
             
        }
        else // 로그인 안되었을 경우
        {
    %>
    <div id="wrapper">
    <!-- toggle top area -->
    <div class="hidden-top">
      <div class="hidden-top-inner container">
        <div class="row">
          <div class="span12">
            <ul>
              <li><strong>멘토 - 멘티의 매칭은 항상 열려 있습니다.</strong></li>
              <li>Main office: 충청남도 아산시 탕정면 선문로221번길 70 선문대학교</li>
              <li>Call us <i class="icon-phone"></i> 010 - 5060 - 6887 </li>
            </ul>
          </div>
        </div>
      </div> 
    </div>
    <!-- end toggle top area -->
    <!-- start header -->
    <header>
      <div class="container ">
        <!-- hidden top area toggle link -->
        <div id="header-hidden-link">
          <a href="#" class="toggle-link" title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
        </div>
        <!-- end toggle link -->
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
              <ul>
                <li><a href="#mySignup" data-toggle="modal"><i class="icon-user"></i> Sign up</a></li>
                <li><a href="#mySignin" data-toggle="modal">Sign in</a></li>
              </ul>
            </div>
    <%} %>   
            <!-- Signup Modal HM 2018/11/30 -->
            <div id="mySignup" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="mySignupModalLabel" aria-hidden="true">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="mySignupModalLabel">회원 <strong>가입</strong></h4>
              </div>
              <div class="modal-body">
              
                <form class="form-horizontal"  action="/toring/registercontroller" method="post">                   
                  <div class="control-group">
                    <label class="control-label" for="inputName">이름</label>
                    <div class="controls">
                      <input type="text" id="inputName" name ="userName" placeholder="Name" required="required">
                    </div>
                  </div> 
                  <div class="control-group">
                    <label class="control-label" for="inputEmail">이메일(ID)</label>
                    <div class="controls">
                      <input type="email" id="inputEmail" name ="userEmail" placeholder="Email" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword">비밀번호</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword" name ="userPassword" placeholder="Password" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword2">비밀번호 확인</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword2" name ="userPassword2" placeholder="Password" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputBDAY">생일</label>
                    <div class="controls">
                      <input type="text" id="inputBDAY" name ="userBDAY" placeholder="BDAY ex)94.10.15" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="sex_M">성별</label>
                    <div class="controls">
                      <input type="radio" id="sex_M" name="sex_MF" value="M" required="required">남자
                      <input type="radio" id="sex_F" name="sex_MF" value="F">여자
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputDepartment">소속 부서</label>
                    <div class="controls">
                      <input type="text" id="inputDepartment" name="userDepartment" placeholder="department" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputTelNum">전화번호</label>
                    <div class="controls">
                      <input type="text" id="inputTelNum" name="userTel" placeholder="telNum" required="required">
                    </div>
                  </div>
          
                   <div class="control-group">
                    <label class="control-label" for="inputGrade">학년</label>
                    <div class="controls">
                      <input type="text" id="inputGrade" name="userGrade" placeholder="grade" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="sex_M">구분</label>
                    <div class="controls">
                      <input type="radio" id="RadioMento" name="RadioMentoMentee" value="멘토" required="required">멘토
                      <input type="radio" id="RadioMentee" name="RadioMentoMentee" value="멘티">멘티
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">Sign up</button>
                    </div>
                    <p class="aligncenter margintop20">
                      	이미 회원 가입이 되어 있습니까? <a href="#mySignin" data-dismiss="modal" aria-hidden="true" data-toggle="modal">Sign in</a>
                    </p>
                  </div>
                </form>
              </div>
            </div>
            <!-- end signup modal -->
            <!-- Sign in Modal -->
            <div id="mySignin" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="mySigninModalLabel" aria-hidden="true">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="mySigninModalLabel">로그<strong> 인</strong></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal" action="/toring/logincontroller" method="post">
                  <div class="control-group">
                    <label class="control-label" for="inputText">이메일(ID)</label>
                    <div class="controls">
                      <input type="text" id="inputEmail" name="userID" placeholder="Username">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSigninPassword">비밀번호</label>
                    <div class="controls">
                      <input type="password" id="inputSigninPassword" name="userPassword" placeholder="Password">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">로그 인</button>
                    </div>
                    <p class="aligncenter margintop20">
                      	비밀번호를 잊으셨습니까? <a href="#myReset" data-dismiss="modal" aria-hidden="true" data-toggle="modal">비밀번호 찾기</a>
                    </p>
                  </div>
                </form>
              </div>
            </div>
            <!-- end signin modal -->
            <!-- Reset Modal -->
            <div id="myReset" class="modal styled hide fade" tabindex="-1" role="dialog" aria-labelledby="myResetModalLabel" aria-hidden="true">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 id="myResetModalLabel">비밀 번호 <strong>찾기</strong></h4>
              </div>
              <div class="modal-body">
                <form class="form-horizontal" action="/toring/sendpwconroller" method="POST">
                  <div class="control-group">
                    <label class="control-label" for="inputResetEmail">이메일 (ID)</label>
                    <div class="controls">
                      <input type="text" id="inputResetEmail" name="inputEmail" placeholder="Email">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">비밀번호 찾기</button>
                    </div>
                    <p class="aligncenter margintop20">
                      We will send instructions on how to reset your password to your inbox
                    </p>
                  </div>
                </form>
              </div>
            </div>
            <!-- end reset modal -->
          </div>
        </div>
        <div class="row">
          <div class="span4">
            <div class="logo">
              <a href="/toring"><img src="resources/img/KakaoTalk_20181209_230049068.png" alt="" class="logo" /></a>
            </div>
          </div>
          <div class="span8">
            <div class="navbar navbar-static-top">
              <div class="navigation">
                <nav>
                  <ul class="nav topnav">
										<li class="dropdown"><a href="/toring/">Home <!-- <i class="icon-angle-down"></i> -->
										</a></li>
										<li class="dropdown"><a href="javascript:void(0);">소개 <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												 <li><a href="/toring/Introduce">소개</a></li>
												<li><a href="/toring/Charttoring">멘토링현황</a></li>
											</ul></li>
										<li class="dropdown active"><a href="javascript:void(0);">멘토링<i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="/toring/mentorBoard">멘토리스트</a></li>
												<li><a href="/toring/mentorNoticeBoard">멘티모집</a></li>
												<li><a href="/toring/mentorOnlineStreaming">실시간멘토링</a></li>
											</ul></li>
										<li class="dropdown"><a href="javascript:void(0);">커뮤니티 <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="/toring/Freenoticelist">자료실</a></li>
												<li><a href="/toring/Reviewlist">후기게시판</a></li>
												<li><a href="javascript:void(0);" onClick="groupStudy();">그룹게시판</a></li>
											</ul></li>
										<li class="dropdown"><a href="/toring/my_page_redata">마이페이지 <i
												class="icon-angle-down"></i></a>
										<!-- 	<ul class="dropdown-menu">
                        <li><a href="/toring/my_page_redata">회원정보</a></li>
                        <li><a href="blog-right-sidebar.html">멘토링 현황</a></li>
											</ul> --></li>
									</ul>
                </nav>
              </div>
              <!-- end navigation -->
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- end header -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>멘티 모집</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="/toring/"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="javascript:void(0);">멘토링</a><i class="icon-angle-right"></i></li>
              <li class="active">멘티 모집</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span3">
             <aside class="left-sidebar">
              <div class="widget">
                <h5 class="widgetheading">멘토링</h5>
                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="/toring/mentorBoard">멘토 리스트</a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/mentorNoticeBoard">멘토링 게시판</a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/mentorOnlineStreaming">실시간게시판</a></li>
                  
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
          	<article>
          		<div class="span8">
          			<label style="margin-top:20px;">글 수정하기</label>
          			<a href="/toring/mentorNoticeBoard" style="margin-top:20px;" class="btn btn-theme pull-right">글 목록으로</a>
          		</div>
          	</article>
            <article>
              <div class="row">
              	<!-- <form action="/toring/updateMentorNotice" method="post" enctype="multipart/form-data"> -->
              	<form id="edit" name="edit" enctype="multipart/form-data">
              	<div class="table-responsive">
				<table class="bbsWriteA" summary="게시물 쓰기">
					<colgroup>
						<col width="23%">
						<col width="77%">
					</colgroup>

					<tbody>
						<tr>
							<th scope="row"><label for="title"><span class="division">멘토링 제목</span></label></th>
							<td><input id="title" name="title" class="inputTxt01" style="width: 95%;" type="text" maxlength="100" value="${notice.title}"></td>
						</tr>
						<tr>
							<th scope="row"><label for="recruitDate"><span class="division">멘토링 모집 기간</span></label></th>
							<td>
								<label for="recruitSdate" style="margin-right: 10px;">				
								<input id="recruitSdate" name="recruitSdate" type="text" style="border: 1px solid #e0e0e0; background-color: #fbfbfb;" value="${notice.recruitSdate}" readonly>	
								</label>
								<label style="margin-right: 10px;">~</label>
								<label for="recruitFdate">
								<input id="recruitFdate" name="recruitFdate" type="text" style="border: 1px solid #e0e0e0; background-color: #fbfbfb;" value="${notice.recruitFdate}">
								</label>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="mentoringDate"><span class="division">멘토링 기간</span></label></th>
							<td>
								<label for="mentoringSdate" style="margin-right: 10px;">
									<input id="mentoringSdate" name="mentoringSdate" type="text" style="border: 1px solid #e0e0e0; background-color: #fbfbfb;" value="${notice.mentoringSdate}">	
								</label>
								<label style="margin-right: 10px;">~</label>
								<label for="mentoringFdate">
									<input id="mentoringFdate" name="mentoringFdate" type="text" style="border: 1px solid #e0e0e0; background-color: #fbfbfb;" value="${notice.mentoringFdate}">	
								</label>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="time"><span class="division">멘토링 시간</span></label>
							<td>
								<input id="time" name="time" class="inputTxt01" style="width: 95%;" type="text" maxlength="100" value="${notice.mentoringTime}">
							</td>
						</tr>
						
						
						<tr>
							<th scope="row"><label for="map"><span class="division">멘토링 장소</span></label>
							<td>
								<input type="button"  value="주소검색" onclick="goPopup();"> 
								<input type="text" id="roadAddrPart1" name="roadAddrPart1" style="width:85%" value="${notice.mapaddres}">
							</td>
						</tr>
						
						<tr>
							<th scope="row"><label for="map"><span class="division">상세 주소</span></label>
							<td>
								<input type="text" id="addrDetail" name="addrDetail" style="width:40%" value="${notice.deteailmap}">
							</td>
						</tr>  
						
						
						<tr>
							<th scope="row"><label for="input0104"><span class="division">카테고리</span></label></th>
							<td>
								<span class="category">
								
									<select id="category" name="category" class="select02" style="width: 250px;" title="카테고리">

										<option value="공대계열">공대계열</option>

										<option value="보건계열">보건계열</option>
										
										<option value="인문계열">인문계열</option>
										
										<option value="자연계열">자연계열</option>

									</select>								
								</span>
							</td>
						</tr>
						<tr>
							<th>
								<label for="peopleNumber"><span class="division">멘토링 인원 수</span></label>
							</th>
							<td>
								<input id="peopleNumber" name="peopleNumber" class="inputTxt01" style="width: 95%;" type="text" maxlength="100" value="${notice.totalNumber}">
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="content"><span class="division">멘토링 세부 내용</span></label></th>
							<td>
								<textarea id="content" name="content" class="textarea" style="width: 95%; height: 120px;">${notice.content}</textarea>
							</td>
						</tr>
						<tr>
							<th scope="row"><label for="file"><span class="division">첨부파일</span></label></th>
							<td>
								<div class="form-group">
   								<input type="file" name="file" style="height: 35px;">
   								</div>
							</td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" id="noticeNumber" name="noticeNumber" value="${notice.noticeNumber}">
				</div>	
				</form>
				<button onClick="send();" class="btn btn-theme btn-large btn-rounded center" style="margin-top: 2em;">수정하기</button>			
              </div>
            </article>
            <!-- author info -->
          </div>
        </div>
      </div>
    </section>
     <!-- Logout Modal-->
				<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
								<button class="close" type="button" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">현재 세션을 종료 할 준비가되면 아래의 "로그 아웃"을 선택하십시오.</div>
							<div class="modal-footer">
								<button class="btn btn-secondary" type="button"
									data-dismiss="modal">취소</button>
								<a class="btn btn-primary" href="/toring/logoutAction">로그아웃</a>
							</div>
						</div>
					</div>
				</div>
    <footer>
      <div class="container">
        <div class="row">
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Browse pages</h5>
              <ul class="link-list">
                <li><a href="#">About our company</a></li>
                <li><a href="#">Our services</a></li>
                <li><a href="#">Meet our team</a></li>
                <li><a href="#">Explore our portfolio</a></li>
                <li><a href="#">Get in touch with us</a></li>
              </ul>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">Important stuff</h5>
              <ul class="link-list">
                <li><a href="#">전 현무</a></li>
                <li><a href="#">김 현우</a></li>
                <li><a href="#">이 길우</a></li>
                <li><a href="#">백 승한</a></li>
                <li><a href="#">정 병철</a></li>
              </ul>
            </div>
          </div> 
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">광고</h5>
              <div class="flickr_badge">
                <script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
              </div>
              <div class="clear">
              </div>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading">사이트 관리 정보</h5>
              <address>
                        <strong>선문대학교 컴퓨터공학과</strong><br>
                            충청남도 아산시 탕정면 선문로221번길 70 선문대학교
                      </address>
              <p>
                <i class="icon-phone"></i> 010 - 5060 - 6887  <br>
                <i class="icon-envelope-alt"></i> Lee Gill Woo@gmail.com
              </p>
            </div>
          </div>
        </div>
      </div>
      <div id="sub-footer">
        <div class="container">
          <div class="row">
            <div class="span6">
              <div class="copyright">
                <p>
                  <span>&copy; Flattern - All right reserved.</span>
                </p> 
                <div class="credits">
               
                  Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
              </div>
            </div>
            <div class="span6">
              <ul class="social-network">
                <li><a href="#" data-placement="bottom" title="Facebook"><i class="icon-facebook icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Twitter"><i class="icon-twitter icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Linkedin"><i class="icon-linkedin icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Pinterest"><i class="icon-pinterest icon-square"></i></a></li>
                <li><a href="#" data-placement="bottom" title="Google plus"><i class="icon-google-plus icon-square"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </footer>
  </div>
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
  <!-- javascript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
<!--   <script src="resources/js/jquery.js"></script>  -->
  <script src="resources/js/jquery.easing.1.3.js"></script>
  <script src="resources/js/bootstrap.js"></script>
  <script src="resources/js/jcarousel/jquery.jcarousel.min.js"></script>
  <script src="resources/js/jquery.fancybox.pack.js"></script>
  <script src="resources/js/jquery.fancybox-media.js"></script>
  <script src="resources/js/google-code-prettify/prettify.js"></script>
  <script src="resources/js/portfolio/jquery.quicksand.js"></script>
  <script src="resources/js/portfolio/setting.js"></script>
  <script src="resources/js/jquery.flexslider.js"></script>
  <script src="resources/js/jquery.nivo.slider.js"></script>
  <script src="resources/js/modernizr.custom.js"></script>
  <script src="resources/js/jquery.ba-cond.min.js"></script>
  <script src="resources/js/jquery.slitslider.js"></script>
  <script src="resources/js/animate.js"></script> 

  <!-- Template Custom JavaScript File -->
  <script src="resources/js/custom.js"></script>
  <script>
        $(function() {
            //모든 datepicker에 대한 공통 옵션 설정
            $.datepicker.setDefaults({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                ,minDate: "-1Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+1Y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
            });
 
            //input을 datepicker로 선언 
           /*  $("#recruitSdate").datepicker(); */
            $("#recruitFdate").datepicker();
            $("#mentoringSdate").datepicker();  
            $("#mentoringFdate").datepicker();
            
            //From의 초기값을 오늘 날짜로 설정
            $('#recruitSdate').datepicker('setDate', '${notice.recruitSdate}'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후) 
            //To의 초기값을 내일로 설정
            $('#recruitFdate').datepicker('setDate', '${notice.recruitFdate}'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
          	//From의 초기값을 오늘 날짜로 설정
            $('#mentoringSdate').datepicker('setDate', '${notice.mentoringSdate}'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
            //To의 초기값을 내일로 설정
            $('#mentoringFdate').datepicker('setDate', '${notice.mentoringFdate}'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
        });
        
        
        function goPopup(){
        	// 주소검색을 수행할 팝업 페이지를 호출합니다.
        	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrCoordUrl.do)를 호출하게 됩니다.
        	var pop = window.open("/toring/JusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
        }  
          

        function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo,entX,entY){

        	document.edit.roadAddrPart1.value = roadAddrPart1+roadAddrPart2;
        	//document.make.roadAddrPart2.value = ;  
        	document.edit.addrDetail.value = addrDetail;
  
        		
        }
        
        
    </script>
      <form action="/toring/groupStudyBoard" method="post" id="groupStudy">
  <input type="hidden" id="memberNumber" name="memberNumber">
  </form>
</body>
</html>