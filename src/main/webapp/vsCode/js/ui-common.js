$(function () {
  // 헤더메뉴바
  $('.gnb>li')
    .on('mouseenter', function () {
      let posX = $(this).offset().left;
      let liWidth = $(this).outerWidth();
      let aWidth = $(this).find('>a').outerWidth();
      let offsetX = posX + (liWidth / 2 - aWidth / 2);

      $('.gnb_wrap .bar').css({
        transform: 'translateX(' + offsetX + 'px)',
        width: aWidth,
        'margin-left': 0,
      });
    })
    .on('mouseleave', function () {
      let aWidth = $(this).find('>a').outerWidth();

      $('.gnb_wrap .bar').css({
        width: 0,
        'margin-left': aWidth / 2,
      });
    });

  // 헤더메뉴 depth2
  $('.gnb_wrap .gnb>li')
    .on('mouseenter', function () {
      $('.gnb_wrap').addClass('on');
    })
    .on('mouseleave', function () {
      $('.gnb_wrap').removeClass('on');
    });

  // 헤더메뉴 fixed
  $(window)
    .on('resize', function () {
      let w = $(this).outerWidth();

      if (w < 1201) {
        $(window)
          .off('scroll')
          .on('scroll', function () {});
      } else {
        if (!!$('.header_bottom').offset()) {
          let gnbTop = $('.header_bottom').offset().top;
          $(window).on('scroll', function () {
            let windowTop = $(window).scrollTop();
            if (gnbTop < windowTop) {
              $('.header_bottom').css({
                position: 'fixed',
                top: 0,
                left: 0,
                'z-index': 9999,
                background: 'white',
                width: '100%',
                'box-shadow': 'rgba(0, 0, 0, 0.5)',
              });
              $('#container').css({
                'padding-top': '67px',
              });
            } else {
              $('.header_bottom').css('position', 'relative');
              $('#container').css({
                'padding-top': '0',
              });
            }
          });
        }
      }
    })
    .trigger('resize');

  // 테블릿메뉴 on
  $('#header .all_btn').on('click', function () {
    $(this).toggleClass('on');

    if ($(this).hasClass('on')) {
      // 테블릿메뉴 버튼을 눌렀을 때 전체스크롤바가 사라지게 함
      $('html, body').css('overflow', 'hidden');
      $('#container').css({
        transform: 'translateX(-25%)',
        transition: 'all 0.2s',
      });
    } else {
      $('html').css('overflow', 'auto');
      $('#container').css({
        transform: 'translateX(0)',
        transition: 'all 0.2s',
      });
    }
    $('#header .m_gnb_wrap').toggleClass('on');
  });

  // 메인슬라이더
  let mainSlider = new Swiper('.main_slider .swiper', {
    loop: true,
    effect: 'fade',
    autoplay: {
      delay: 5000,
    },
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },

    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // autoplay_btn
  $('.main_slider .autoplay_btn').on('click', function () {
    $(this).toggleClass('on');

    if ($(this).hasClass('on')) {
      mainSlider.autoplay.stop();
    } else {
      mainSlider.autoplay.start();
    }
  });

  $('.swiper-pagination, .swiper-button-next, .swiper-button-prev').on(
    'click',
    function () {
      $('.main_slider .autoplay_btn').addClass('on');
    }
  );

  // 핫도그 판매, 기부 개수 카운팅
  function countNum1(cnt, final, amount) {
    const numEl = $('.main_cnt .cell_cnt .cnt span');

    const interval = setInterval(() => {
      cnt += amount;
      // toLocaleString을 통해 천단위마다 쉼표 사용
      numEl.text(cnt.toLocaleString());

      // cnt가 최종숫자 - 증가량보다 크면 최종숫자를 넣어주고 타이머 중지
      if (cnt >= final - amount) {
        numEl.text(final.toLocaleString());
        clearInterval(interval);
      }
    }, 10);
  }
  function countNum2(cnt, final, amount) {
    const numEl = $('.main_cnt .give_cnt .cnt span');

    const interval = setInterval(() => {
      cnt += amount;
      numEl.text(cnt.toLocaleString());

      if (cnt >= final - amount) {
        numEl.text(final.toLocaleString());
        clearInterval(interval);
      }
    }, 10);
  }
  countNum1(0, 307878984, 1876554);
  countNum2(0, 637098, 3734);

  // 메인상품 슬라이더
  let productSlider = new Swiper('.main_product .swiper', {
    loop: true,
    effect: 'fade',
    fadeEffect: { crossFade: true },
    simulateTouch: false,
    allowTouchMove: false,
    autoplay: {
      delay: 2000,
      disableOnInteraction: true,
    },
    on: {
      init: function () {
        $('.main_product .list li').eq(this.realIndex).addClass('on');
      },
      slideChange: function () {
        let idx = this.realIndex;

        $('.main_product .list li')
          .eq(idx)
          .addClass('on')
          .siblings()
          .removeClass('on');
      },
    },
    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // 메인상품 클릭시 인덱스 값으로 슬라이더 연결
  $('.main_product .list li').on('click', function (e) {
    let liIdx = $(this).index();
    if (liIdx < 6) {
      e.preventDefault();

      productSlider.slideToLoop(liIdx);
      productSlider.autoplay.start();
    }
  });

  // 서브페이지 메뉴버튼 토글
  $('.sub_top .sub_home .s_wrap').on('click', function () {
    $(this).toggleClass('on').siblings().removeClass('on');
  });

  // board_write 이메일
  $('.board_write select').on('change', function () {
    let val = $(this).val();

    if (val !== '직접입력') {
      $('.board_write .email2').val(val);
    } else {
      $('.board_write .email2').val('');
    }
  });
});
