<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title><dec:title default="${model.title}"/></title>
    <meta name="description" content="${model.metaDescription}"/>

    <meta property="og:locale" content="vi_VN" />
    <meta property="og:title" content="${model.title}" />
    <meta property="og:description" content="${model.ogDescription}" />
    <meta property="og:url" content="https://laptrinhjavaweb.com/${model.ogUrl}" />
    <meta property="og:image" content="https://laptrinhjavaweb.com/repository${model.ogImage}" />

    <!-- favicon -->
    <link rel="shortcut icon" href="<c:url value='/template/web/image/logo/favicon-light-novel.png' />" />

    <!-- plugins -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/plugins.css' />" />

    <!-- revolution slider css -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/rev_slider/settings.css' />">
    <link rel="stylesheet" href="<c:url value='/template/web/css/rev_slider/layers.css' />">
    <link rel="stylesheet" href="<c:url value='/template/web/css/rev_slider/navigation.css' />">

    <!-- core style css -->
    <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" />
    <link href="<c:url value='/template/web/css/home-page.css' />" rel="stylesheet" />

    <%--grt youtube css--%>
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/grt-youtube/grt-youtube-popup.css' />">

    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />

    <%--fix infor footer--%>
    <link rel="stylesheet" href="<c:url value='/template/web/css/fix-infor-footer.css' />" />

    <%--jquery 2.1.4--%>
    <script type='text/javascript' src='<c:url value="/template/web/js/jquery-2.1.4/jquery.min.js" />'></script>

    <%--live chat pavietnam--%>
    <%--<script type="text/javascript" src="https://livechat.pavietnam.vn/js/script.js" id="live_chat_30s" data-lang="vi"></script>--%>
    <style type="text/css">
        .fb_iframe_widget {
            position: relative !important;
            display: flex !important;
            justify-content: center;
        }
    </style>

    <!-- Messenger Chat Plugin Code -->
    <div id="fb-root"></div>

    <!-- Your Chat Plugin code -->
    <div id="fb-customer-chat" class="fb-customerchat">
    </div>

    <script>
        var chatbox = document.getElementById('fb-customer-chat');
        chatbox.setAttribute("page_id", "2106944296001356");
        chatbox.setAttribute("attribution", "biz_inbox");
    </script>

    <!-- Your SDK code -->
    <script>
        window.fbAsyncInit = function() {
            FB.init({
                xfbml            : true,
                version          : 'v12.0'
            });
        };

        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
    </script>

    <!-- Script Popup -->
    <script src="https://salekit.io/embed/js/0b750217" async="async"></script>

    <%--Script Form--%>
    <script src="https://salekit.io/assets/js/embed/sk.js"></script>

    <decorator:getProperty property="page.local_header"></decorator:getProperty>
    <decorator:getProperty property="page.local_css"></decorator:getProperty>
    <%--<meta name="copyright" content="lập trình java web cung cấp khóa học java web online lập trình web với java jsp servlet spring mvc spring boot tại tphcm" />
    <meta name="robots" content="INDEX,FOLLOW" />
    <meta name="generator" content="lập trình java web cung cấp khóa học java web online lập trình web với java jsp servlet spring mvc spring boot tại tphcm" />
    <link rel="canonical" href="https://laptrinhjavaweb.com/${model.canonicalUrl}" />--%>
    <%--<meta property="og:site_name" content="Lập trình java web" />--%>
</head>
<body>
    <%--<script id="__bs_script__1">//<![CDATA[
    document.write("<script async src='/browser-sync/browser-sync-client.js?v=2.26.7'><\/script>".replace("HOST", location.hostname));
    //]]></script>--%>

    <div id="preloader">
        <div class="row loader">
            <div class="loader-icon"></div>
        </div>
    </div>

    <!-- Header -->
    <%@ include file="/common/web/header.jsp" %>

    <!-- start main-wrapper section -->
    <div class="main-wrapper">

        <dec:body/>
        <div id="email-register"></div>
        <!-- start extra section -->
        <section class="parallax" data-overlay-dark="75" data-background="">
            <div class="container">
                <div class="text-center">
                    <h4 class="text-white font-weight-500 font-size50 md-font-size44 sm-font-size40 xs-font-size34">Nhận Ebook phỏng vấn lập trình <br> <span class="text-theme-color"> Java và Spring Framework </span></h4>
                    <p class="text-white width-50 md-width-60 sm-width-80 xs-width-auto center-col font-size16 margin-30px-bottom">Hy vọng tài liệu phỏng vấn này sẽ giúp cho anh/chị/em tốt hơn trong quá trình phỏng vấn</p>
                    <a href='http://ebookjavaandspringframework.laptrinhjavaweb.com' target="_blank" class="butn white text-capitalize"><span>Đăng ký nhận ebook ngay</span></a>
                </div>
            </div>
        </section>
        <!-- end extra section -->
        <%--footer--%>
        <%@ include file="/common/web/footer.jsp" %>
    </div>
    <!-- end main-wrapper section -->

    <%--fix infor footer--%>
    <%@ include file="/common/web/fix-infor-footer.jsp" %>

    <!-- popper -->
    <script src="<c:url value='/template/web/js/abc/popper.min.js' />"></script>

    <!-- start scroll to top -->
    <a href="javascript:void(0)" class="scroll-to-top"><i class="fas fa-angle-up" aria-hidden="true"></i></a>
    <!-- end scroll to top -->

    <a class="phone-icon"
       data-html="true"
       data-toggle="modal" data-target="#hotline-modal">
        <img src="<c:url value='/template/web/image/abc/icons8-phone.svg' />" alt="phone">
    </a>

    <!-- Modal -->
    <div class="modal fade" id="hotline-modal" tabindex="-1" role="dialog" aria-labelledby="hotline-modal" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6>Hotline tư vấn dịch vụ</h6>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <ul class="hotline-list-static">
                        <li>
                            <a href="tel:0354502773">
                                <label>Tư vấn viên 1: </label><span>0354.502.773</span>
                            </a>
                        </li>
                        <li>
                            <a href="tel:0819423713">
                                <label>Tư vấn viên 2: </label><span>0819.423.713</span>
                            </a>
                        </li>
                        <li>
                            <a href="tel:0819423713">
                                <label>Tư vấn viên 3: </label><span>0909.804.713</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

    <a href="https://zalo.me/4588194011921423842" class="zalo-icon" data-toggle="tooltip" data-placement="left" title="Chat với Light Novel trên zalo" target="_blank">
        <img src="<c:url value='/template/web/image/abc/icons8-zalo.svg' />" alt="zalo">
    </a>

    <%--<a href="https://m.me/lamrangho" class="fb-icon" data-toggle="tooltip" data-placement="left" title="Chat với laptrinhjavaweb trên facebook cá nhân" target="_blank">
        <img src="<c:url value='/template/web/image/abc/icons8-icon-messenger.svg' />" alt="facebook">
    </a>--%>

    <!-- all js include start -->

    <!-- modernizr js -->
    <script src="<c:url value='/template/web/js/modernizr.js' />"></script>

    <!-- bootstrap -->
    <script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
    <!-- navigation -->
    <script src="<c:url value='/template/web/js/nav-menu.js' />"></script>

    <!-- tab -->
    <script src="<c:url value='/template/web/js/easy.responsive.tabs.js' />"></script>

    <!-- owl carousel -->
    <script src="<c:url value='/template/web/js/owl.carousel.js' />"></script>

    <!-- jquery.counterup.min -->
    <script src="<c:url value='/template/web/js/jquery.counterup.min.js' />"></script>

    <!-- stellar js -->
    <script src="<c:url value='/template/web/js/jquery.stellar.min.js' />"></script>

    <!-- waypoints js -->
    <script src="<c:url value='/template/web/js/waypoints.min.js' />"></script>

    <!-- jquery.magnific-popup js -->
    <script src="<c:url value='/template/web/js/jquery.magnific-popup.min.js' />"></script>

    <!-- isotope.pkgd.min js -->
    <script src="<c:url value='/template/web/js/isotope.pkgd.min.js' />"></script>

    <!-- revolution slider js files start -->
    <script src="<c:url value='/template/web/js/rev_slider/jquery.themepunch.tools.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/jquery.themepunch.revolution.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.actions.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.carousel.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.kenburn.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.layeranimation.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.migration.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.navigation.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.parallax.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.slideanims.min.js' />"></script>
    <script src="<c:url value='/template/web/js/rev_slider/extensions/revolution.extension.video.min.js' />"></script>
    <!-- revolution slider js files end -->

    <!-- custom scripts -->
    <script src="<c:url value='/template/web/js/main.js' />"></script>

    <!-- all js include end -->

    <script src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>

    <%--start grt youtube js--%>
    <script src="<c:url value='/template/web/grt-youtube/grt-youtube-popup.js' />"></script>
    <script src="<c:url value='/template/web/js/youtube-popup.js' />"></script>
    <%--end grt youtube js--%>

    <decorator:getProperty property="page.local_script"></decorator:getProperty>
</body>
</html>
