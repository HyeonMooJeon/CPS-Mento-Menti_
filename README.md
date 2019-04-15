# CPS-Mento-Menti_


Web 기반 실시간 스트리밍을 이용한 Mentor-Mentee 매칭 시스템 설계 및 구현

(Design and Implementation of Mentor-Mentee Matching System Using Web-based RealTime Streaming )

전 현 무, 김 현 우, 이 길 우
(Hyeon Moo Jeon, hyeon woo Kim, gill woo Lee)
요약 : 본 시스템은 Web에서 지원하며 본 시스템에 접속한 사용자들의 특정 Needs를 가진 Mentee와 그것을 해결해 줄 수 있는 Mentor가 Matching되며 1 : 多 의 Mnetoring 서비스를 제공한다. Study 장소와 관련 자료를 Upload할 수 있는 그룹 공간을 제공하며, Mentoring을 받지 못하는 사람도 실시간 스트리밍을 통해 온라인 동영상으로 Mentoring을 받을 수 있게 지원하는 시스템이다.

Keywords : Web, App, Mentor, Mentee, Menoring, RealtimeStreaming, Sunmoon university


 1. 서론

 독학은 계획 수립 및 학습 시간 관리가 자유롭지만, 이는 사용자가 직접 계획을 수립 하며 스스로 지키는 것이기 때문에 이는 단점이 되기도 한다. 다른 방안으로 학원에 다니게 된다면 사용자가 부담해야 할 비용이 상승한다. 이를 통해 해당 시스템은 원하는 교과목에 대해 학습중인 비전공자, 전공자를 위한 Mentor-Mentee 매칭 시스템으로 인터넷 강의와 독학으로 한계를 느끼는 사용자를 위한 시스템으로 1:1 매칭과 1 : 多 의 스터디 그룹 매칭 서비스를 제공한다. Mentoring 서비스를 제공하므로 인해 Mentee가 독학으로 이해가 어려운 교과목에 대해 더욱 학업이 수월해질 것이며 학업을 도와주는 계획 및 학습 시간에 대해 Mentor가 관리하므로 학습에 용이하다는 장점이 있다. 즉 시간 관리 측면으로 보면 누군가의 즉각적인 피드백은 학습을 하는데 큰 도움이 된다. 또한 누군가의 지도로 인해 규칙적인 학습이 가능하고, 학습에 대한 이해도 또한 시간적인 측면에서 단축 할 수 있다. 다른 측면인 정보 해석적인 부분에서 보았을 때 독학은 인터넷을 통한 정보의 진위여부에 대하여 확신할 수 있는가? 누구나 확신할 수 없을 것이다. 두 번째 국내에서 찾아볼 수 없는 정보인 경우 또는 국외에서도 아직 연구되지 않은 분야인 경우는 어떻게 학습해 나아갈 것 인지에 대하여 생각해 보아야 한다. 또한 모국어가 아닌 경우는 어떻게 판단할 것 인가? 이와 같은 문제점은 독학이 아닌 누군가 지도를 해준다면 해결이 가능하다. 물론 다른 방법으로는 학원이 있다. 하지만 학원은 경제적으로 어려운 경우 본인, 또는 부모님에게 부담감을 주게 된다. 이를 통한 해결법은 바 로 본 시스템인 실시간 스트리밍을 이용한
 Mentor-Mentee 매칭 시스템으로 해결할 수 있다. 현재 본 시스템을 개발하기 전 사전조사를 통한 타 시스템과의 차별 점에 대해 설명하도록 하겠다. 현재 서비스 중인 모 사이트는 실명 기반 현직자 멘토링 서비스를 제공한다. 하지만 멘토를 직접적으로 만나서 피드백을 받는 것이 아닌 온라인상 매칭 시스템으로 온라인에만 국한되며 질문 답변식인 온라인 멘토링 조언만 서비스를 한다. 이와 차별점을 두어 본 시스템은 온라인에서 매칭하며 본인이 원하는 멘토를 선택해 직접 오프라인 스터디 그룹을 형성, 참여할 수 있는 만남의 시발점을 제공하며 그룹 게시판을 제공한다.
 
<그림  멘토링 사이트 토링의 메인 페이지>


그림 1의 사이트는 현재 개발된 멘토-멘티 매칭 사이트 ToRing의 첫 메인 페이지이다. 어떠한 서비스를 제공하는지에 대해 한눈에 알아볼 수 있도록 디자인 하였으며 사용자들에게 간편한 인터페이스를 제공한다. 

<그림  멘토링 사이트 토링의 메인 페이지2>


그림2는 스크롤을 밑으로 내렸을 시에 사용자에게 보여주는 화면이다. 본 화면은 현재 서비스중이며 활성화가 되어 있는지에 대해 사용자들에게 보여 줄 수 있는 페이지가 된다. 위와 같은 단축 버튼을 제공하며 현재 샘플링으로 멘토 리스트들을 사용자들에게 보여주며 멘토 리스트의 특정 대상을 누를 경우 그림3과 같은 화면이 출력된다.

<그림  카드 형식의 멘토 리스트>

그림3의 멘토 리스트 화면은 특정 멘토의 멘토링이 가능한 과목이 멘토의 사진, 이름과 동시에 보이게 된다. 또한 번호를 통해 페이징 처리를 지원 함과 동시에 검색기능을 지원하므로 멘토 리스트가 많아져도 충분히 찾을 수 있다.

<그림  멘토 상세 정보>

그림 4의 멘토 상세 정보를 출력하므로 인해 멘토의 주 교과목과 이름, 소속, 학과, 전공이 출력된다. 하단에는 멘토가 현재 진행하고 있는 멘토링과  모집이 완료된 멘토링에 대해서 정보를 제공한다.해당 게시글은 다음과 같은 폼 형식을 가진다.

<그림  멘티 모집 게시글>

 그림5와 같이 모집중인 게시글에 대해 멘티는 멘토링을 신청할 수 있다. 멘티는 멘토링을 신청할 때 다음과 같은 폼 형식을 가진다.

<그림  멘티 신청서 폼>

그림6의 멘티 신청서를 작성 후 신청을 누르게 되면 멘티가 신청한 정보는 멘토에게 전달되며 멘토는 본인의 게시글, 또는 마이페이지의 멘토링 신청 현황에서 종합하여 출력하게 된다.


<그림  멘티들이 신청서를 제출한 게시글 하단>

이를 통해 멘토들에 대한 정보를 수집한 후 회원가입을 통해 멘토링 게시판으로 이동하여 현재 모집중인 게시글을 확인할 수 있다.

<그림  멘티 모집중인 게시판> 

그림 5는 현재 멘티를 모집중인 멘토가 작성한 게시 글을 볼 수 있다. 회원가입을 한 멘티는 멘토가 작성한 위와 같은 게시글을 통해 다음 그림과 같은 형식으로 멘티를 신청한다.

< 그림  멘티 신청서 등록 폼>

그림 9와 같은 형식의 신청 폼을 작성한 뒤 신청하기를 누르게 되면 멘토에게 메시지가 도착하여 멘토가 신청한 내용을 확인할 수 있다. 멘토가 볼 수 있는 신청 내용의 도착 형태와 멘티 수락하기(멘토의 그룹에 포함시키기)는 다음 그림10의 형태와 같다.

<그림  멘티 신청 내역>


이와 같이 신청을 수락하게 되면 멘토와 멘티만 이용 할 수 있는 게시판이 만들어 지게 되며 이 게시판을 통해 공지사항과 자료 등을올려 멘토링 그룹간의 소통장소와 정보 공유 장소로 사용하게 된다. 또한 멘토링에 참여하지 못하는 멘티의 경우 이를 지원하기 위해 온라인으로 멘토링을 지원하며, 이를 해결하기 위한 방법으로는 실시간스트리밍 형태로 웹 사이트에서 지원하게 된다. 

<그림  실시간 스트리밍중인 멘토>
또한 위와 같은 스트리밍을 하기 위해서는 가격대가 높은 기기를 사용하야 하므로 본 시스템은 라즈베리파이 와 카메라 모듈을 기반으로 영상을 지원한다.

<그림  라즈베리파이 와 카메라 모듈>

그림 12와 같은 모듈과 기기를 사용하여 웹 사이트에 0.75초 간격으로 촬영한 사진을 지속적으로 보내어 재생시킨다.
Ⅱ. 관련연구

1. 로그인 
 로그인은 개인의 이메일을 통해 회원가입을 진행한다. 이유는 회원가입 후 비밀번호를 잃어버릴시 개인이 입력한 이메일에 비밀번호 정보를 보내줘서 간편하게 개인의 비밀번호를 찾을 수 있게 하기 위해서이다.

2. 멘토-멘티 매칭
 멘토-멘티 매칭은 먼저 멘토인 회원만 멘티 모집글을 등록한다. 멘티 모집글 등록시에는 멘토가 수업할 제목, 모집기간, 멘토링 기간, 멘토링을 할 장소, 멘토링 내용, 첨부파일등을 작성한다. 그리고 모든 사용자는 멘토가 등록한 멘티 모집글을 확인할 수 있고 여기서 회원만 선택한 멘티 모집글에 대해서 상세내용을 확인 후 멘티를 신청할 수 있게 한다. 시스템에서 일정시간마다 날짜를 체크하여 멘토가 정한 모집 기간이 지난 글들을 모집 완료로 바꿔줄 수 있도록 멀티쓰레드를 연구하였다.

3. 멘토링 장소 선정
멘토링 장소를 선택시 도로명 주소 api를 활용하여 멘토가 직접 장소에 대한 내용을 찾아서 적을 필요 없이 장소에 대한 도로명 주소만 입력하여 손쉽게 멘토링 장소를 입력할 수 있게 한다. 그리고 멘티 모집글에 대한 상세내용에서 멘토가 등록한 멘토링 장소에 대한 내용을 지도api와 연결하여 멘토링 장소에 대한 내요을 시작적으로 확인 할 수 있게 한다.

4. 멘티 신청 수락
멘토인 회원은 자신의 등록한 멘티 모집글의 상세내용 하단에서 멘티를 신청한 회원들의 신청 내역을 확인할 수 있다. 그리고 멘토인 회원만 멘티 신청을 확인 하여 사용자들이 멘티 신청 상세 내역, 신청 수락등의 기능을 할 수 없게 한다. 그로 인해 멘토인 회원만 자신의 멘티 모집글에 대해 멘티를 수락할 수 있고 수락할 시 멘티 신청내역의 비고에 수락한 멘티는 신청완료라는 메시지가 뜨게 된다.
5. 그룹 게시판
멘토인 회원이 자신이 등록한 멘티 모집 글의 하단에서 멘티를 신청한 회원을 수락할 시에 그룹게시판이 없을 시 바로 생성될 수 있도록 한다.이미 존재할 시에는 멘티만 그룹에 추가된다. 그룹게시판에는 멘토인 회원이 멘티에게 공지사항, 자료등을 전달하기 위해서 멘토인 회원만 그룹게시판에 글을 등록 할 수 있도록 선택하였다.그룹은 소속회원들만 볼 수 있게 하였고 한눈에 볼 수 있도록 테이블형태가 아닌 카드 형식의 UI를 선택해서 카드 방식의 게시판을 연구하였다.
6.실시간 멘토링
멘티인 회원이 멘토링 시간에 부득이한 사정이나 급한일로 멘토링에 참여 하지 못할시 멘토는 실시간 스트리밍으로 통하여 자신의 멘토링에 부득이하게 참여하지 못하는 회원에게 멘토링 수업을 전달해 줄 수 있도록 하였다.
Ⅲ.사용 방법

 멘토링 사이트 토링의 사용방법으로는 반응형 웹 기반으로 구현했기 때문에 네트워크 통신이 가능하면 어떤 디바이스로든 이용할 수 있다. 이용할 수 있는 서비스는 크게 소개, 멘토링, 커뮤니티, 마이페이지가 있다. 사용자는 로그인을 하지않고 이용할 수 있지만 그룹게시판, 마이페이지는 로그인이 되어있어야만 이용할 수 있다.
먼저 소개는 해당 사이트에 대한 소개를 하는 서비스이다. 사이트가 제공하는 서비스 이용방법이 있는 멘토링 가이드와 현재 사용하는 회원 수, 멘토링 개수를 보여주는 멘토링 현황과 사이트에 대한 소개가 있다.
멘토링에는 현재 사이트에 가입되어 있는 멘토를 카드 형식으로 보여주는 멘토 리스트와 멘토가 등록한 멘티 모집 글을 테이블 형태로 보여주는 멘티 게시판과 멘토가 실시간 멘토링을 해주는 것을 시청할 수 있는 실시간 멘토링이 있다.
커뮤니티에는 멘티나 멘토가 멘토링을 실시한 후에 멘토링 리뷰를 할 수 있는 후기 게시판과 멘토링 할 때 이용할 수 있는 자료들을 올릴 수 있는 자료게시판, 멘토링 매칭 시 소속 사용자들이 해당 멘토링에 대해 공지사항등을 이용할 수 있는 멘토링 그룹 게시판이 있다.
마이페이지에는 해당 사용자의 정보를 변경할 수 있는 회원정보 변경과 사용자의 비밀번호를 변경할 수 있는 비밀번호 변경, 사용자가 어떤 멘토링에 신청했는지 알 수 있는 멘티 신청목록, 사용자가 어떤 멘티 모집 글을 등록했는지 알 수 있는 멘토 등록목록, 사용자가 어떤 자료를 올렸는지 조회할 수 있는 자료 등록목록이 존재한다. 
또한 실시간 멘토링 서비스기기를 제공하여 실시간 스트리밍을 할 수 있으며 멘티는 이를 통해 온라인 웹 사이트내에서 멘토링을 시청할 수 있다. 이와 같같은 서비스를 제공하여 조금더 시간적인 측면에서 수월한 관리가 될 수 있을 것이다.


IV. 실험 및 분석


<그림 9. 멘토링 그룹 데이터베이스 코드>

그림 9는 멘토링 그룹을 가져오는 데이터베이스 연동 코드이다. 현재 접속한 사용자의 회원번호를 통해 현재 DB에 저장되어있는 멘토링 그룹 테이블과 멘토링 그룹 멘티 테이블를 이용해 해당 사용자가 소속되어 있는 그룹들의 정보를 가져온다.

<그림 10. 멘토링 그룹 card 변환코드>
 
그림 10은 멘토링 그룹리스트를 card 방식으로 변환해주는 코드이다. 컨트롤러단에서 model방식으로 넘겨주는 데이터 객체를 JSTL를 이용하여 forEach문으로 테이블에 객체 하나씩 넣어준다. 테이블에 들어가있는 데이터로 테이블 행 하나씩 <li>태그을 생성하여 카드방식으로 변환시켜준다. 



<그림 11. 멀티쓰레드 코드>

그림 11은 현태날짜를 확인하여 데이터베이스에 저장되어있는 정보와 비교하는 멀티쓰레드 코드이다. 이 쓰레드는 서버가 시작할 때 같이 실행되며 1분에 한번 씩 현재 날짜와 시간을 구하고 그 날짜정보를 멘티 모집 글 데이터베이스를 사용하여 현재날짜를 지난 멘티 모집 기간인 멘티 모집 글을 모집 중에서 모집완료로 바꿔준다.


<그림 12. 멘티 모집 글 등록 코드>

그림 12는 멘토인 회원이 작성하여 등록하는 멘티 모집 글 등록코드이다. 멘토가 입력한 멘토링 정보와 회원 정보를 Service단에 넘겨주는 역할을 하며 멘토가 첨부한 파일을 서버에 저장시켜주며 파일 이름이 겹칠 수도 있기 때문에 파일 이름을 getUuid()를 이용하여 암호화하여 실제 파일 이름과 암호화시킨 파일 이름을 넘겨준다.


<그림 13. datePicker 코드>

그림 13은 날짜를 선택할 때 편리하게 사용할 수 있는 달력UI의 datePicker코드이다. jQuery 라이브러리인 JQuery UI중  datePicker를 이용하여 멘토가 멘티 모집 기간과 멘토링 기간을 정할 때 보다 편리하게 선택할 수 있도록 달력UI의 input태그를 사용하였다. 위에 코드는 datePicker의 설정해주는 코드이다.


<그림 14. 멘토링 현황 그래프 코드>

그림 14는 현재 토링홈페이지에 가입한 회원의 멘토/멘티 비율과 멘토인 회원이 멘티 모집글 현황, 멘티인 회원이 멘티 모집글에 멘티 신청을 한 현황, 그리고 멘토링이 매칭 된 현황을 나타내고 있다. 가입한 회원의 멘토/멘티 비율은 pie형태로 나타내고 , 멘토링 신청 현황, 멘토링 모집글 현황, 멘토링 매칭 현황은 막대그래프로 나타낸다.  



<그림 15. 후기게시판 등록 코드>

그림 15은 로그인한 회원이 자신이 멘토링을 받고 난 후에 작성하는 후기게시판 글 등록에 대한 코드이다. 회원이 후기글을 다 작성한뒤 등록 버튼을 눌렀을때 컨트롤러단에서 HttpServletRequset을 통해 후기 글을 작성한 제목,내용,등록날짜등을 전달 받고 전달받은 내용을 Database에 저장한다.
MultipartHttpServletRequest은 회원이 글 작성시 등록한 첨부파일 여러개를 하나로 묶어서 받는다. 묶어서 받은 첨부파일은 Multiparfile을 통해 첨부파일을 List에 담고 for문을 통해 파일을 한개씩 원본파일명 과 UUID을 통해 암호화된 첨부파일명으로 나타낸뒤에 Database에 저장한다. 


<그림 16. 마이페이지 자료 목록 코드>

그림 16는 로그인 한 회원이 마이페이지에서 자신이 등록한 자료글을 테이블 형식으로 보이게 한다. 그리고 테이블에서 제목에 해당하는 곳과 비고 render:function 이벤트를 추가 하여 제목을 클리했을때 해당하는 제목의 상세내용이 modal로 나타나게 하였고 비고에는 버튼추가 하여 버튼을 클릭했을때 클릭한 게시글이 삭제 되게 하였다.



V. 결론

현재 멘토링은 일반적으로 학교 그룹 스터디 등 지인끼리 하는 경우가 다수이다. 만약 아는 사람이 없다면 멘토링을 하지 못하는 경우가 잦다. 해당 서비스는 온라인상에서 멘토링 등록을 신청한 멘티들은 멘토링의 그룹 스터디에 참여할 수 있게 되어 온라인으로 매칭한 멘토와 오프라인으로 직접 만나 계획 및 학습 시간을 관리하고, 공부하는 분야에 대한 방향성을 잡을 수 있게 된다. 또한, 1 : 1 매칭과 1 : 다의 스터디 그룹을 제공함으로 인해 각 사용자는 원하는 방향으로 공부를 할 수 있게 된다.






참고문헌

김춘경(2015, 10) 자바스크립스+jQuery 완전정복 스터디. 1: 기초편 위키북스
김춘경(2015, 10) 자바스크립스+jQuery 완전정복 스터디. 2: jQuery위키북스
김춘경(2015, 10) 자바스크립스+jQuery 완전정복 스터디. 3: 중급고급활용편 위키북스
정재곤(2018.02), “Do it! 안드로이드 앱 프로그래밍” ,이지스퍼블리싱
하울(2018.07.31.), “Firebase로 안드로이드 SNS 앱 만들기”  비제이퍼블릭
