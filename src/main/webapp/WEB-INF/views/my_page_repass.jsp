<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("utf-8");%>
<!-- 세션 폴스 해제하기 -->

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
     
     function mentorNotice(){
 		var number = "<%=session.getAttribute("sessionNUMBER")%>";
 		$("#number").val(number);
 		$("#notice").submit();
 	}
  </script>
  

  <!-- =======================================================
    Theme Name: Flattern
    Theme URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
  	<style>
    p {
        font-family: "Nanum Gothic", sans-serif;
        font-size: 18px;
      }
      p.a {
        font-weight: 400;
      }
 	</style>
 	
</head>

<body>
 	<%
        if(session.getAttribute("sessionID") == null) // 로그인이 안되었을 때
        { 
	 %>
        <script>
			alert("회원이 아닙니다.");
			history.go(-1) // 이전 페이지로 이동
		</script>
 	<% 		// 로그인 화면으로 이동
            response.sendRedirect("/");
            
        }
        else // 로그인 했을 경우
        {
    %>
    <%} %>   
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
                  </ul>
            </div>
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
                    <li class="dropdown active">
                      <a href="/">Home <!-- <i class="icon-angle-down"></i> --> </a>
                 
                    </li>
                    <li class="dropdown">
                       <a href="javascript:void(0);">소개 <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                         <li><a href="/toring/Introduce">소개</a></li>
                        <li><a href="/toring/Charttoring">멘토링 현황</a></li>
                      
                      </ul> 
                    </li>
                    <li class="dropdown">
                     <a href="javascript:void(0);">멘토링<i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="/toring/mentorBoard">멘토리스트</a></li>
                        <li><a href="/toring/mentorNoticeBoard">멘티모집</a></li>
                        <li><a href="/toring/mentorOnlineStreaming">실시간멘토링</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="javascript:void(0);">커뮤니티 <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="/toring/Freenoticelist">자료실</a></li>
                        <li><a href="/toring/Reviewlist">후기게시판</a></li>
                             <li><a href="javascript:void(0);" onClick="groupStudy();">그룹게시판</a></li>  
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="/toring/my_page_redata">마이페이지 <i class="icon-angle-down"></i></a>
                 
                    </li>
                    <!-- <li>
                      <a href="contact.html">Contact </a>
                    </li> -->
                    
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
              <h2>My Page</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="/toring/"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="/toring/my_page_redata">my_page</a><i class="icon-angle-right"></i></li>
              <li class="active">my_page</li>
            </ul> 
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
           <div class="span4">
            <aside class="right-sidebar">
             <!--  <div class="widget">
                <form class="form-search">
                  <input placeholder="Type something" type="text" class="input-medium search-query">
                  <button type="submit" class="btn btn-square btn-theme">Search</button>
                </form>
              </div> -->
              <div class="widget">
                <h5 class="widgetheading">마이페이지</h5>
                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="/toring/my_page_redata">회원정보 변경</a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/my_page_passCheck">비밀번호 변경 </a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/MyMenteeapplylist">멘티 신청 현황 </a></li>
                  <li><i class="icon-angle-right"></i><a href="javascript:void(0);" onClick="mentorNotice();">멘토 등록 현황 </a></li>
                 <li><i class="icon-angle-right"></i><a href="/toring/Myfreenoticelist">자료 내역 </a></li>
                  <li><i class="icon-angle-right"></i><a href="/toring/MyReviewlist">후기 게시글 내역</a></li>
                 
                </ul>  
              </div>   
              
              <div class="widget">
                <h5 class="widgetheading">광고</h5>
	              <div class="flickr_badge">
	                <script type="text/javascript" src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
	              </div>
	              <div class="clear">
	              </div>
              </div>
              <div class="widget">
                <h5 class="widgetheading">Popular tags</h5>
                 <ul class="tags">
                   <li><a href="/toring/my_page_redata">My Page</a></li>
                  <li><a href="/toring/mentorNoticeBoard">멘티 모집</a></li>
                  <li><a href="/toring/Freenoticelist">자료</a></li>  
                  <li><a href="/toring/Reviewlist">후기</a></li> 
                  <li><a href="/toring/Guide">가이드</a></li>
                  <li><a href="/toring/mentorOnlineStreaming">실시간 멘토링</a></li>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
            <article>
             						<!-- 회원 수정 정보 폼  -->  
             	<h2>본인 인증</h2>
            	<form class="form-horizontal"  action="/toring/rePassAction" method="post">                   
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword">변경할 비밀번호</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword" name ="userPassword" placeholder="Password" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <label class="control-label" for="inputSignupPassword2">변경할 비밀번호 확인</label>
                    <div class="controls">
                      <input type="password" id="inputSignupPassword2" name ="userPassword2" placeholder="Password" required="required">
                    </div>
                  </div>
                  <div class="control-group">
                    <div class="controls">
                      <button type="submit" class="btn">확인</button>
                    </div>
                  </div>
                </form>
           
            </article>
            <!-- author info -->   
          </div>
       
        </div>
      </div>
    </section>
    
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
              <h5 class="widgetheading">자유 게시판</h5>
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
                  <!--
                    All the links in the footer should remain intact.
                    You can delete the links only if you purchased the pro version.
                    Licensing information: https://bootstrapmade.com/license/
                    Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Flattern
                  -->
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
  <script src="resources/js/jquery.js"></script>
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


 <form id="notice" name="notice" action="/toring/myMentorNotice" method="post">
  <input type="hidden" id="number" name="number">
  </form>
  <form action="/toring/groupStudyBoard" method="post" id="groupStudy">
  <input type="hidden" id="memberNumber" name="memberNumber">
  </form>
</body>

</html>
