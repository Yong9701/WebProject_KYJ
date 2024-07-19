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
  <title>명랑핫도그</title>
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
   <header id="header">
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
	            <a href="../vsCode/user-edit.do?id=${ UserId }">회원정보수정</a>
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
              <a href="board-list.do">명랑소식</a>
              <ul class="depth2">
                <li>
                  <a href="../vsCode/board-list.do">언론보도</a>
                </li>
                <li>
                  <a href="#">홍보동영상</a>
                </li>
                <li>
                  <a href="../vsCode/qna-list.do">고객문의</a>
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
   <main id="container">
    <section class="main_slider">
      <h2 class="blind">메인슬라이더</h2>
      <div class="swiper">
        <div class="swiper-wrapper">
          <div class="swiper-slide slide1">
            <a href="#" target="_blank" title="새창 열림">
              <img class="pc_img" src="images/main_slider1.jpg" alt="메인1">
              <img class="m_img" src="images/m_main_slider1.jpg" alt="모바일메인1">
             </a>
          </div>
          <div class="swiper-slide slide2">
            <a href="#" target="_blank" title="새창 열림">
              <img class="pc_img" src="images/main_slider2.jpg" alt="메인2">
              <img class="m_img" src="images/m_main_slider2.jpg" alt="모바일메인2">
            </a>
          </div>
          <div class="swiper-slide slide3">
            <a href="#" target="_blank" title="새창 열림">
              <img class="pc_img" src="images/main_slider3.jpg" alt="메인3">
              <img class="m_img" src="images/m_main_slider3.jpg" alt="모바일메인3">
            </a>
          </div>
        </div>
        <div class="swiper-button-prev arrow_btn"></div>
        <div class="swiper-button-next arrow_btn"></div>
        <div class="swiper-pagination"></div>
        <button class="autoplay_btn" type="button"><span class="blind">일시정지</span></button>
      </div>
    </section>
    <section class="main_cnt">
      <h2 class="blind">핫도그 판매기부 수량</h2>
      <div class="hotdog_wrap">
        <div class="inner">
          <div class="cell_cnt cnt_wrap">
            <div class="txt_wrap">
              <strong>지금까지 판매된</strong>
              <p>핫도그 개수</p>
            </div>
            <div class="cnt">
              <span>307,878,984</span>
              <p>개</p>
            </div>
          </div>
          <div class="give_cnt cnt_wrap">
            <div class="txt_wrap">
              <strong>지금까지 기부된</strong>
              <p>핫도그 개수</p>
            </div>
            <div class="cnt">
              <span>637,098</span>
              <p>개</p>
            </div>
          </div>
        </div>
        <p class="sold_Date">Date : ~23년 12월 31일</p>
      </div>
    </section>
    <section class="main_product">
      <div class="main_tit tit_wrap">
        <h2>OUR PRODUCT</h2>
      </div>
      <div class="swiper">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <div class="img_wrap img1">
              <p class="blind">떡볶이세트</p>
            </div>
            <div class="txt_wrap">
              <em>TTEOKBOKKI SET</em>
              <h3>떡볶이세트</h3>
              <p>매콤달콤 오리지널소스로 맛을 낸 떡볶이와 찰떡궁합 인기 핫도그 3종을 함께 맛볼 수 있는 세트</p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="img_wrap img2">
              <p class="blind">로제떡볶이세트</p>
            </div>
            <div class="txt_wrap">
              <em>ROSE TTEOKBOKKI SET</em>
              <h3>로제 떡볶이세트</h3>
              <p>매콤한 소스와 부드러운 생크림이 잘 어우러진 로제떡볶이와 찰떡궁합 인기 핫도그 3종을 함께 맛볼 수 있는 세트</p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="img_wrap img3">
              <p class="blind">트리플X치즈 핫도그</p>
            </div>
            <div class="txt_wrap">
              <em>TRIPLE X CHEESE HOTDOG</em>
              <h3>트리플X치즈 핫도그</h3>
              <p>체다치즈와 모짜렐라치즈가 듬뿍 들어간 핫도그에 잘 숙성된 짭짤한 고다치즈를 입혀 바삭하게 튀겨낸 핫도그</p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="img_wrap img4">
              <p class="blind">모짜맵구마 핫도그</p>
            </div>
            <div class="txt_wrap">
              <em>SWEET POTATO SPICY HOTDOG</em>
              <h3>모짜맵구마 핫도그</h3>
              <p>달콤한 고구마와 100% 모짜렐라치즈와 매콤한 할라피뇨소시지 세가지 조합의 핫도그</p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="img_wrap img5">
              <p class="blind">감자통모짜 핫도그</p>
            </div>
            <div class="txt_wrap">
              <em>POTATO WHOLE MOZZA HOTDOG</em>
              <h3>감자통모짜 핫도그</h3>
              <p>100% 모짜렐라치즈에 고소하고 바삭한 감자가 어우러져 고급스러움을 더한 핫도그</p>
            </div>
          </div>
          <div class="swiper-slide">
            <div class="img_wrap img6">
              <p class="blind">감자 핫도그</p>
            </div>
            <div class="txt_wrap">
              <em>POTATO HOTDOG</em>
              <h3>감자 핫도그</h3>
              <p>오동통한 점보소시지와 고소하고 담백한 감자가 만나 더욱 고급스러운 핫도그</p>
            </div>
          </div>
        </div>
        <div class="swiper-button-prev arrow_btn"></div>
        <div class="swiper-button-next arrow_btn"></div>
      </div>
      <div class="product_list">
        <nav class="list_wrap">
          <ul class="list">
            <li>
              <a href="#">
                <span class="img1"></span>
                <div class="txt_wrap">
                  <h3>떡볶이세트</h3>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="img2"></span>
                <div class="txt_wrap">
                  <h3>로제 떡볶이세트</h3>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="img3"></span>
                <div class="txt_wrap">
                  <h3>트리플X치즈 핫도그</h3>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="img4"></span>
                <div class="txt_wrap">
                  <h3>모짜맵구마 핫도그</h3>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="img5"></span>
                <div class="txt_wrap">
                  <h3>감자통모짜 핫도그</h3>
                </div>
              </a>
            </li>
            <li>
              <a href="#">
                <span class="img6"></span>
                <div class="txt_wrap">
                  <h3>감자 핫도그</h3>
                </div>
              </a>
            </li>
            <li class="more_btn">
              <a href="#">
                <span class="img7"></span>
                <div class="txt_wrap">
                  <h3>메뉴 더보기</h3>
                </div>
              </a>
            </li>
          </ul>
        </nav>
      </div>
    </section>
    <section class="main_sauce">
      <div class="sauce_wrap">
        <div class="main_tit">
          <h2>OUR SAUCE</h2>
        </div>
        <div class="txt_wrap">
          <p>다양한 시즈닝 &amp; 소스 메뉴</p>
          <a class="move_btn" href="#">바로가기</a>
        </div>
      </div>
    </section>
    <section class="main_story">
      <div class="main_tit">
        <h2>OUR STORY</h2>
      </div>
      <div class="story_tit">
        <strong>건강하고, 정직하고, 행복하게</strong>
        <p>명랑시대 쌀 핫도그는 인류의 건강과 행복을 추구하는 기업으로써<br>
          ‘늘 건강하고, 늘 정직하게, 모두가 행복한’이라는 슬로건을 걸고<br>
          사회적인 기업, 친환경 기업으로의 발전을 향해 나아가고 있습니다.</p>
      </div>
      <div class="story_info">
        <ul class="value">
          <li>
            <em>건강</em>
            <p># 좋은 재료로 늘 건강하게</p>
          </li>
          <li class="value2">
            <em>정직</em>
            <p># 매일 신선한 발효속성 반죽</p>
          </li>
          <li class="value3">
            <em>행복</em>
            <p># 모두를 행복하게 하는 맛</p>
          </li>
        </ul>
        <div class="notice_wrap">
          <div class="notice notice_left">
            <h3>명랑소식</h3>
            <ul class="notice_list">
              <li>
                <a href="#">명랑핫도그, LG유플러스와 '유플WEEK' 이벤트 진행</a>
                <p class="date">2024-04-19</p>
              </li>
              <li>
                <a href="#">명랑핫도그, 만우절 오이냉국 정말로 판매?</a>
                <p class="date">2024-04-01</p>
              </li>
              <li>
                <a href="#">명랑핫도그, MBC 금토드라마 '원더풀 월드' 제작 지원</a>
                <p class="date">2024-03-21</p>
              </li>
              <li>
                <a href="#">명랑핫도그, 일본 국제 프랜차이즈 쇼 참가</a>
                <p class="date">2024-03-14</p>
              </li>
            </ul>
            <a class="more_btn" href="#"><span class="blind">더보기</span></a>
          </div>
          <div class="notice notice_right">
            <h3>명랑비디오</h3>
            <div class="img_wrap">
              <iframe width="600" height="254" src="https://www.youtube.com/embed/PBLQDkkCX-M" title="함께 만들어가는 행복한, 명랑시대외식청년창업협동조합" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
            </div>
            <a class="more_btn" href="#"><span class="blind">더보기</span></a>
          </div>
        </div>
        <div class="donate_wrap">
          <div class="donate donate_left">
            <div class="txt_wrap">
              <h3>푸드트럭 <strong>희망나눔</strong></h3>
              <p>가격도 착한데 하는일도 착한<br>명랑핫도그의 푸드트럭 희망나눔</p>
            </div>
            <a class="move_btn" href="#">바로가기</a>
          </div>
          <div class="donate donate_right">
            <div class="txt_wrap">
              <h3>이달의 우수 가맹점</h3>
              <p>배달 / 매장관리 부문<br>이달의 우수 가맹점을 소개합니다.</p>
            </div>
            <a class="move_btn" href="#">바로가기</a>
          </div>
        </div>
      </div>
    </section>
   </main>
   <footer id="footer">
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