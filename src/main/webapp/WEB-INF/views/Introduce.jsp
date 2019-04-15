<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="" /> 

<title>멘토 - 멘티 매칭 사이트 토링</title>

<!-- Bootstrap core CSS-->
<link
	href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700"
	rel="stylesheet">
<link href="resources/css/bootstrap.css" rel="stylesheet" />
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet" />
<link href="resources/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="resources/css/jcarousel.css" rel="stylesheet" />
<link href="resources/css/flexslider.css" rel="stylesheet" />
<link href="resources/css/style.css" rel="stylesheet" />
<!-- Theme skin -->
<link href="resources/skins/default.css" rel="stylesheet" />
<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/ico/apple-touch-icon-144-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/ico/apple-touch-icon-114-precomposed.png" />
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/ico/apple-touch-icon-72-precomposed.png" />
<link rel="apple-touch-icon-precomposed"
	href="resources/ico/apple-touch-icon-57-precomposed.png" />
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
    }  </script>
</head>

<body >
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
							<li>Call us <i class="icon-phone"></i> 010 - 5060 - 6887
							</li>
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
					<a href="#" class="toggle-link"
						title="Click me you'll get a surprise" data-target=".hidden-top"><i></i>Open</a>
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
						<!-- Signup Modal -->
						<div id="mySignup" class="modal styled hide fade" tabindex="-1"
							role="dialog" aria-labelledby="mySignupModalLabel"
							aria-hidden="true">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 id="mySignupModalLabel">
									Create an <strong>account</strong>
								</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="control-group">
										<label class="control-label" for="inputEmail">Email</label>
										<div class="controls">
											<input type="text" id="inputEmail" placeholder="Email">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputSignupPassword">Password</label>
										<div class="controls">
											<input type="password" id="inputSignupPassword"
												placeholder="Password">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputSignupPassword2">Confirm
											Password</label>
										<div class="controls">
											<input type="password" id="inputSignupPassword2"
												placeholder="Password">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Sign up</button>
										</div>
										<p class="aligncenter margintop20">
											Already have an account? <a href="#mySignin"
												data-dismiss="modal" aria-hidden="true" data-toggle="modal">Sign
												in</a>
										</p>
									</div>
								</form>
							</div>
						</div>
						<!-- end signup modal -->
						<!-- Sign in Modal -->
						<div id="mySignin" class="modal styled hide fade" tabindex="-1"
							role="dialog" aria-labelledby="mySigninModalLabel"
							aria-hidden="true">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 id="mySigninModalLabel">
									Login to your <strong>account</strong>
								</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="control-group">
										<label class="control-label" for="inputText">Username</label>
										<div class="controls">
											<input type="text" id="inputText" placeholder="Username">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputSigninPassword">Password</label>
										<div class="controls">
											<input type="password" id="inputSigninPassword"
												placeholder="Password">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Sign in</button>
										</div>
										<p class="aligncenter margintop20">
											Forgot password? <a href="#myReset" data-dismiss="modal"
												aria-hidden="true" data-toggle="modal">Reset</a>
										</p>
									</div>
								</form>
							</div>
						</div>
						    <%} %>   
						<!-- end signin modal -->
						<!-- Reset Modal -->
						<div id="myReset" class="modal styled hide fade" tabindex="-1"
							role="dialog" aria-labelledby="myResetModalLabel"
							aria-hidden="true">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 id="myResetModalLabel">
									Reset your <strong>password</strong>
								</h4>
							</div>
							<div class="modal-body">
								<form class="form-horizontal">
									<div class="control-group">
										<label class="control-label" for="inputResetEmail">Email</label>
										<div class="controls">
											<input type="text" id="inputResetEmail" placeholder="Email">
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Reset password</button>
										</div>
										<p class="aligncenter margintop20">We will send
											instructions on how to reset your password to your inbox</p>
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
										<li class="dropdown active"><a href="javascript:void(0);">소개 <i
												class="icon-angle-down"></i></a>
											<ul class="dropdown-menu">
												<li><a href="/toring/Introduce">소개</a></li>
												<li><a href="/toring/Charttoring">멘링 현황</a></li>
											</ul></li>
										<li class="dropdown"><a href="javascript:void(0);">멘토링<i  
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
										</li>
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
							<h2>소개 </h2>
						</div>
					</div>
					<div class="span8">
						<ul class="breadcrumb">
						   <li><a href="/toring/"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
				             <li class="active">소개</li>

						</ul>
					</div>
				</div>
			</div>   
		</section>
		
		<section id="content">
			<div class="container">
			<!-- 	<div class="row">
					<div class="span12">
						<h4>
							<strong>Toring 소개</strong>
						</h4>
					</div>
					<div class="span12">
						<div class="container">
							
							
						
							 
						</div>
					</div>
				</div> -->
				 <div class="row">  
          <div class="span6">
            <h3 style="color: #F03C02;"><strong>Mentor-Mentee</strong></h3>
            <div class="span6">
						<div class="solidline"></div>
					</div>
            <p class="lead">
               	 경험과 지식이 많은 사람이 스승 역할을 하여 지도와 조언으로 그 대상자의 실력과 잠재력을 향상시키는 것 또는 그러한 체계를<strong> ‘멘토링’ </strong>이라고 하는데, 여기서 스승 역할을 하는 사람을<strong> ‘멘토(mentor)’</strong>, 지도 또는 조언을 받는 사람을 <strong>‘멘티(mentee)’</strong>라고 합니다. 
            </p>
            <h3 style="color: #F03C02;"><strong>Mentoring</strong></h3>
             <div class="span6">
						<div class="solidline"></div>
					</div> 
            <p class="lead" >
            	<strong>  멘토링 </strong>은 멘토와 멘티가 상호 신뢰와 존중의 인간관계에 기반하여 지속적인 소통, 격려, 지지, 조언의 사회적 상호작용을 통해 서로의 역량, 가치, 가능성을 개발하고 발전을 추구하는 상호 전인적 성장활동입니다. 
            </p>  
             
             
             
            
          </div> 
          <div class="span6"> 
            <!-- start flexslider -->
            <div class="flexslider">
              <ul class="slides">
                <li>
                  <img src="resources/img/Introduce/77931131-아이콘으로-멘토링-개념.jpg" alt="" />
                </li>
                <li>
                  <img src="resources/img/Introduce/istockphoto-533442516-1024x1024.jpg" alt="" />
                </li>
                <li>
                  <img src="resources/img/Introduce/istockphoto-823767342-1024x1024.jpg" alt="" />
                </li> 
              </ul>
            </div>
            <!-- end flexslider -->
          </div>
        </div>
				
				
				<!-- divider -->
				<div class="row">
					<div class="span12">
						<div class="solidline"></div>
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
							<h5 class="widgetheading">광고</h5>
							<div class="flickr_badge">
								<script type="text/javascript"
									src="http://www.flickr.com/badge_code_v2.gne?count=8&amp;display=random&amp;size=s&amp;layout=x&amp;source=user&amp;user=34178660@N03"></script>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="span3">
						<div class="widget">
							<h5 class="widgetheading">사이트 관리 정보</h5>
							<address>
								<strong>선문대학교 컴퓨터공학과</strong><br> 충청남도 아산시 탕정면 선문로221번길 70
								선문대학교
							</address>
							<p>
								<i class="icon-phone"></i> 010 - 5060 - 6887 <br> <i
									class="icon-envelope-alt"></i> Lee Gill Woo@gmail.com
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
								<li><a href="#" data-placement="bottom" title="Facebook"><i
										class="icon-facebook icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Twitter"><i
										class="icon-twitter icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Linkedin"><i
										class="icon-linkedin icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Pinterest"><i
										class="icon-pinterest icon-square"></i></a></li>
								<li><a href="#" data-placement="bottom" title="Google plus"><i
										class="icon-google-plus icon-square"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
	<a href="#" class="scrollup"><i
		class="icon-chevron-up icon-square icon-32 active"></i></a>
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

	  <script src="resources/contactform/contactform.js"></script>
    
	<!-- Template Custom JavaScript File -->
	<script src="resources/js/custom.js"></script>

	 <form action="/toring/groupStudyBoard" method="post" id="groupStudy">
  <input type="hidden" id="memberNumber" name="memberNumber">
  </form> 
  
   
  
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
	  
	
 
</script>
  
  
</body>

</html>