<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- <meta name="viewport" content="width=1280"> -->
  <meta name="format-detection" content="telephone=no">
  <meta name="description" content="늘 건강하고, 늘 정직하게, 늘 한결같이, 청년들의 투명함과 정직함으로 만든 핫도그, 명랑핫도그">
  <meta property="og:type" content="website">
  <meta property="og:url" content="http://yong9701.dothome.co.kr/rwdmyungranghotdog/index.jsp">
  <meta property="og:title" content="명랑핫도그">
  <meta property="og:description" content="늘 건강하고, 늘 정직하게, 늘 한결같이, 청년들의 투명함과 정직함으로 만든 핫도그, 명랑핫도그">
  <meta property="og:image" content="http://myungranghotdog.com/images/site/kor/layout/logo.png">
  <title>고객문의 | 명랑핫도그</title>
  <link rel="icon" href="images/common/favicon.ico">
  <link rel="apple-touch-icon-precomposed" href="images/common/favicon.jpg">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
  <!-- 라이브러리는 먼저 연결하는 것을 원칙으로 함 -->
  <link rel="stylesheet" href="css/jquery-ui.min.css">
  <link rel="stylesheet" href="css/swiper-bundle.min.css">
  <link rel="stylesheet" href="css/common.css?v=<?php echo time(); ?>">
  <link rel="stylesheet" href="css/main.css?v=<?php echo time(); ?>">
  <link rel="stylesheet" href="css/sub.css?v=<?php echo time(); ?>">
  <script src="js/jquery-3.7.1.min.js"></script>
  <script src="js/jquery-ui.min.js"></script>
  <script src="js/swiper-bundle.min.js"></script>
  <script src="js/ui-common.js?v=<?php echo time(); ?>"></script>
</head>
<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <header id="header" class="sub_header">
      <div class="header_top">
        <h1 class="logo"><a href="index.jsp"><span class="blind">명랑쌀핫도그</span></a></h1>
        <div class="inner">
          <a href="#">해외문의</a>
          <div class="txt_wrap">
            <a href="#">HOME</a>
            <a href="#">SITEMAP</a>
            <a href="#">점주공간</a>
            <% if (session.getAttribute("UserId") == null) { %>
	            <a href="../vsCode/login.jsp">로그인</a>
	         <% } else { %>
	            <a href="../vsCode/Logout.jsp">로그아웃</a>
	            <a href="../vsCode/user-edit.jsp">회원정보수정</a>
	         <% } %>
          </div>
        </div>
      </div>
       <div class="header_bottom">
         <nav class="gnb_wrap">
           <ul class="gnb">
             <li>
               <a href="#">명랑시대</a>
               <ul class="depth2">
                 <li>
                   <a href="#">명랑시대협동조합</a>
                 </li>
                 <li>
                   <a href="#">명랑시대쌀핫도그</a>
                 </li>
                 <li>
                   <a href="#">사회공헌</a>
                 </li>
               </ul>
             </li>
             <li>
               <a href="#">메뉴</a>
               <ul class="depth2">
                 <li>
                   <a href="#">핫도그 / 떡볶이 / 꽈배기</a>
                 </li>
                 <li>
                   <a href="#">소스 / 토핑</a>
                 </li>
                 <li>
                   <a href="#">Special Menu</a>
                 </li>
                 <li>
                   <a href="#">알레르기 / 영양성분</a>
                 </li>
               </ul>
             </li>
             <li>
               <a href="#">이벤트</a>
               <ul class="depth2">
                 <li>
                   <a href="#">진행이벤트</a>
                 </li>
                 <li>
                   <a href="#">지난이벤트</a>
                 </li>
                 <li>
                   <a href="#">당첨자발표</a>
                 </li>
                 <li>
                   <a href="#">푸드트럭 신청</a>
                 </li>
               </ul>
             </li>
             <li>
               <a href="#">창업안내</a>
               <ul class="depth2">
                 <li>
                   <a href="#">창업안내</a>
                 </li>
               </ul>
             </li>
             <li>
               <a href="#">매장안내</a>
               <ul class="depth2">
                 <li>
                   <a href="#">신규매장</a>
                 </li>
                 <li>
                   <a href="#">매장찾기</a>
                 </li>
                 <li>
                   <a href="#">해외매장</a>
                 </li>
               </ul>
             </li>
             <li>
               <a class="active" href="board-list.do">명랑소식</a>
               <ul class="depth2">
                 <li>
                   <a class="active" href="board-list.do">언론보도</a>
                 </li>
                 <li>
                   <a href="#">홍보동영상</a>
                 </li>
                 <li>
                   <a href="qna-list.jsp">고객문의</a>
                 </li>
                 <li>
                  <a href="download.jsp">자료실</a>
                 </li>
               </ul>
             </li>
           </ul>
           <span class="bar"></span>
         </nav>
       </div>
     <button type="button" class="all_btn">
       <span class="blind">메뉴열기</span>
       <i></i>
       <i></i>
       <i></i>
     </button>
     <aside class="m_gnb_wrap">
       <div class="m_click_wrap">
         <a class="m_click" href="#">점주공간</a>
         <a class="m_click" href="#">해외문의</a>
       </div>
       <ul class="m_gnb">
         <li>
           <a href="#">명랑시대</a>
           <ul class="depth2">
             <li>
               <a href="#">명랑시대협동조합</a>
             </li>
             <li>
               <a href="#">명랑시대쌀핫도그</a>
             </li>
             <li>
               <a href="#">사회공헌</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="#">메뉴</a>
           <ul class="depth2">
             <li>
               <a href="#">핫도그 / 떡볶이 / 꽈배기</a>
             </li>
             <li>
               <a href="#">소스 / 토핑</a>
             </li>
             <li>
               <a href="#">Special Menu</a>
             </li>
             <li>
               <a href="#">알레르기 / 영양성분</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="#">이벤트</a>
           <ul class="depth2">
             <li>
               <a href="#">진행이벤트</a>
             </li>
             <li>
               <a href="#">지난이벤트</a>
             </li>
             <li>
               <a href="#">당첨자발표</a>
             </li>
             <li>
               <a href="#">푸드트럭 신청</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="#">창업안내</a>
           <ul class="depth2">
             <li>
               <a href="#">창업안내</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="#">매장안내</a>
           <ul class="depth2">
             <li>
               <a href="#">신규매장</a>
             </li>
             <li>
               <a href="#">매장찾기</a>
             </li>
             <li>
               <a href="#">해외매장</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="board-list.do">명랑소식</a>
           <ul class="depth2">
             <li>
               <a href="board-list.do">언론보도</a>
             </li>
             <li>
               <a href="#">홍보동영상</a>
             </li>
             <li>
               <a href="qna-list.jsp">고객문의</a>
             </li>
             <li>
              <a href="download.jsp">자료실</a>
             </li>
           </ul>
         </li>
         <li>
           <a href="#">이용안내</a>
           <ul class="depth2">
             <li>
               <a href="#">개인정보처리방침</a>
             </li>
             <li>
               <a href="#">이메일무단수집거부</a>
             </li>
             <li>
               <a href="#">사이트맵</a>
             </li>
           </ul>
         </li>
       </ul>
     </aside>
    </header>
   <main id="container" class="board_page sub_container">
    <div class="sub_top">
      <div class="inner">
        <h2>고객문의</h2>
        <div class="sub_home">
          <a class="home_btn" href="#"><span class="blind">HOME</span></a>
          <div class="s_wrap">
            <button class="sub_gnb menu_btn" type="button">명랑소식</button>
            <ul class="s_menu">
              <li><a href="#">명랑시대</a></li>
              <li><a href="#">메뉴</a></li>
              <li><a href="#">이벤트</a></li>
              <li><a href="#">창업안내</a></li>
              <li><a href="#">매장안내</a></li>
              <li><a href="board-list.do">명랑소식</a></li>
              <li><a href="#">이용안내</a></li>
            </ul>
          </div>
          <div class="s_wrap">
            <button class="menu_btn" type="button">고객문의</button>
            <ul class="s_menu">
              <li><a href="board-list.do">언론보도</a></li>
              <li><a href="#">홍보동영상</a></li>
              <li><a href="qna-list.do">고객문의</a></li>
              <li><a href="download.jsp">자료실</a></li>
            </ul>
          </div>
          <div class="sns_wrap">
            <a class="facebook" href="#"></a>
            <a class="twitter" href="#"></a>
            <a class="print" href="#"></a>
          </div>
        </div>
      </div>
    </div>
    <div class="contents">
      <div class="inner">
        <div class="board_view">
          <div class="tit_wrap">
            <h2>${ dto.title }</h2>
            <div class="detail">
              <p>작성자 : ${ dto.name }</p>
              <p>작성일 : ${ dto.postdate }</p>
              <p>조회수 : ${ dto.visitcount }</p>
            </div>
          </div>
          <div class="attachment_wrap">
            <span>첨부파일</span>
            <c:if test="${ not empty dto.ofile }">${ dto.ofile }
        	<a href="../vsCode/download.do?ofile=${ dto.ofile }&sfile=${ dto.sfile }&idx=${ dto.idx }">[다운로드]</a>
        	</c:if>  
          </div>
          <div class="board_txt">
          <c:if test="${ not empty dto.ofile }">
            <c:choose>
            <c:when test="${ mimeType eq 'img' }">
                     <img src="../Uploads/${dto.sfile}" style="max-width:600px" />
            </c:when>
            <c:when test="${ mimeType eq 'audio' }">
                     <audio controls>
                               <source src="../Uploads/${dto.sfile}" type="audio/mp3">
                           </audio> 
            </c:when>
            <c:when test="${ mimeType eq 'video' }">
                     <video controls>
                        <source src="../Uploads/${dto.sfile}" controls>
                     </video>
            </c:when>
            <c:otherwise>
                        <a href="../Uploads/${dto.sfile}" download>${dto.ofile}</a>
            </c:otherwise>
            </c:choose>
            </c:if>
            <div class="txt_wrap">
              ${ dto.content }
              </div>
          </div>
        </div>
        <div class="board_list_btn">
        <c:if test="${ UserName eq dto.name }" >
	      <a class="list_btn" href="qna-edit.do?idx=${ dto.idx }">수정</a>
          <a class="list_btn" href="qna-delete.do?idx=${ dto.idx }">삭제</a>
	     </c:if>
          <a class="list_btn" href="qna-list.do">목록</a>
        </div>
        <div class="comment_wrap">
          <div class="comment_ins">
            <h2>댓글</h2>
            <script>
            function loginYn(f) {
            	if (session.getAttribute("UserId") == null) {
            		alert('로그인 후 댓글을 작성해주세요.');
            		return false;
            	}
            	if (f.comment.value == '') {
            		alert('댓글을 입력해주세요.');
            		return false;
            	}
            }
            </script>
            <form style="width:100%;" name="commForm" method="post" action="../vsCode/qna-view.do?idx=${ dto.idx }" onsubmit="return loginYn(this)">
            	<input type="hidden" name="idx" value="${ dto.idx }">
            	<input type="hidden" name="name" value="${ dto.name }">
            	<textarea class="comment" name="comm" placeholder="댓글을 입력하세요." rows="3" cols="30"></textarea>
            	<button class="com_btn" type="submit">등록</button>            
            </form>
          </div>
          <div class="comment_view">
              	<c:choose>
	              	<c:when test="${ empty commLists }">
	              	</c:when>
	              	<c:otherwise>
	              		<c:forEach items="${ commLists }" var="row" varStatus="loop">
            				<div class="com_list">
              					<div class="user">
	              					<h2>${ row.name }</h2>
	              					<span>${ row.postdate }</span>
            					</div>
	              					<p>${ row.comm }</p>
			            		<div class="com_list_btn_wrap">
				              		<button type="button" class="com_list_btn">수정</button>
				              		<button type="button" class="com_list_btn">삭제</button>
				            	</div>
            				</div>
	              		</c:forEach>
	              	</c:otherwise>
	              </c:choose>
          </div>
        </div>
      </div>
    </div>
   </main>
   <footer id="footer" class="sub_footer">
    <div class="inner">
      <div class="footer_top">
        <ul class="footer_menu">
          <li><a class="strong" href="#">개인정보처리방침</a></li>
          <li><a href="#">이메일무단수집거부</a></li>
          <li><a href="#">창업문의</a></li>
          <li><a href="#">매장찾기</a></li>
        </ul>
      </div>
      <div class="footer_bottom">
        <h2 class="footer_logo"><span class="blind">명랑핫도그</span></h2>
        <div class="txt_wrap">
          <p class="address address1">명랑시대외식청년창업협동조합</p>
          <p class="address address2">충청남도 계룡시 두마면 입암길 42-45, 2층 <span class="line"></span>mr@myungranghotdog.com<span class="line"></span> 사업자등록번호 : 601-87-00459</p>
          <p class="copyright">COPYRIGHT © 2020 MH. ALL RIGHT RESERVED.</p>
        </div>
        <div class="link_wrap">
          <a class="instagram" href="#"><span class="blind">인스타그램</span></a>
          <a class="tiktok" href="#"><span class="blind">틱톡</span></a>
          <a class="youtube" href="#"><span class="blind">유튜브</span></a>
        </div>
        <div class="tel_number">
          <p class="title">대표전화 / 창업상담</p>
          <a href="#">1600-0399</a>
          <p class="time">평일 09:00~17:00</p>
        </div>
      </div>
    </div>
    <div class="quick_menu">
      <ul class="quick">
        <li class="quick1"><a href="#">창업상담<br><strong>1600-0399</strong></a></li>
        <li class="quick2"><a href="#">창업안내</a></li>
        <li class="quick3"><a href="#">매장찾기</a></li>
        <li class="quick4"><a href="#" target="_blank" title="새창 열림"><span class="blind">강다짐</span></a></li>
      </ul>
    </div>
   </footer>
  </div>
</body>
</html>