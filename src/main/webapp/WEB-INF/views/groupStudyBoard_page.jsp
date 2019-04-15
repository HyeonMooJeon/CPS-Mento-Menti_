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
//그룹 스터디 입장
function admission(number){
	var mentor = <%=session.getAttribute("sessionNUMBER")%>;
	$("#groupNumber").val(number);
	$("#mentor").val(mentor);
	$("#admission").submit();
}
//그룹 스터디 이동
function groupStudy(){
  		var number = <%=session.getAttribute("sessionNUMBER")%>;
  		if(number == null){
  			alert("로그인을 먼저해주세요!");
  		}else{
  	  	$("#memberNumber").val('<%=session.getAttribute("sessionNUMBER")%>');
  	  	$("#groupStudy").submit();
  		}  
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
												<li><a href="/toring/Charttoring">멘토힐 현황</a></li>
											</ul></li>
										<li class="dropdown"><a href="javascript:void(0);">멘토링<i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="/toring/mentorBoard">멘토리스트</a></li>
												<li><a href="/toring/mentorNoticeBoard">멘티모집</a></li>
												<li><a href="/toring/mentorOnlineStreaming">실시간멘토링</a></li>
											</ul></li>
										<li class="dropdown  active"><a href="javascript:void(0);">커뮤니티 <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="/toring/Freenoticelist"">자료실</a></li>
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
              <li><a href="javascript:void(0);">커뮤니티</a><i class="icon-angle-right"></i></li>
              <li class="active">그룹게시판</li>
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
                <h5 class="widgetheading">커뮤니티</h5>
                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="/toring/Freenoticelist">자료실</a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/Reviewlist">후기 게시판</a></li>
                  <li><i class="icon-angle-right"></i><a href="javascript:void(0);" onClick="groupStudy();">그룹게시판</a></li>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
            <article>
              <div class="row">
              	<div class="card-deck box">
              		<c:forEach var="group" items="${groupStudy}">
              			<div class="col-sm-6 box">
              				<div class="card border-danger mb-5 box text-center">
              					<div class="card-body">
              						<h5 class="card-title" style="border-bottom:1px solid rgba(0, 0, 0, 0.125)">${group.groupTitle}</h5>
									<p class="card-text">${group.mentorName}</p>
								</div>
								<div class="card-footer bg-danger text-center text-white">
									<a href="javascript:void(0);" style="color:white; font-size:25px" onClick="admission(${group.groupNumber});">입장하기</a>
								</div>
							</div>
						</div>
              		</c:forEach>
				</div>		
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
  <form id="admission" action="/toring/groupStudy" method="post">
  <input type="hidden" id="mentor" name="mentor">
  <input type="hidden" id="groupNumber" name="groupNumber">
  </form>
   <script src="resources/js/custom.js"></script>
  <form action="/toring/groupStudyBoard" method="post" id="groupStudy">
  <input type="hidden" id="memberNumber" name="memberNumber">
  </form>
</body>
</html>