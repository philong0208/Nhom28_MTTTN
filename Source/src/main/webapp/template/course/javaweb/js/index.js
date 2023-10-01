"use strict";

document.addEventListener('DOMContentLoaded', function() {

setTimeout(function(){//------------------------------------------------------------------------
//						NAVBAR SLIDE SCRIPT
//------------------------------------------------------------------------
$(window).scroll(function () {
    if ($(window).scrollTop() > $("nav").height()) {
        $("nav.navbar").addClass("show-menu");
    } else {
        $("nav.navbar").removeClass("show-menu");
        $("nav.navbar .navMenuCollapse").collapse({
            toggle: false
        });
        $("nav.navbar .navMenuCollapse").collapse("hide");
    }
});

//------------------------------------------------------------------------
//						NAVBAR HIDE ON CLICK (COLLAPSED) SCRIPT
//------------------------------------------------------------------------
//$('.navbar li a').on('click', function() {
//    $('.collapse.in').collapse('hide');
//});
}, 2);



















$(document).scroll(function() {
  var y = $(this).scrollTop();
  if (y > 800) {
    $('#tool-back-to-top').fadeIn();
  } else {
    $('#tool-back-to-top').fadeOut();
  }
});

$(document).on('click', '.btbg', function() {
    $(this).find('.social_chat').toggleClass('hidden');
});



$(document).on('click', '.btbg', function() {
    $(this).find('.social_chat').toggleClass('hidden');
});

});
