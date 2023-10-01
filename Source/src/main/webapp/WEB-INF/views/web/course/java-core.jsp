<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@include file="/common/taglib.jsp" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- favicon -->
    <link rel="shortcut icon" href="<c:url value='/template/web/image/logo/favicon-java-web.png' />" />

    <title>${model.title}</title>

    <meta name="description" content="${model.metaDescription}"/>

    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/fonts.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/bootstrap.weber.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/fx.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/magnific-popup.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/custom.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/index.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/course/javacore/css/index1666690930.css' />" />
    <link rel="stylesheet" href="https://slimweb.vn/shop/mycart_builder.css" />
    <!--add to head-->
    <!--vthieu lazy-->
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var userAgent = navigator.userAgent || navigator.vendor || window.opera;
            if (/iPad|iPhone|iPod/.test(userAgent) && !window.MSStream) {
                var image_style = document.querySelectorAll("*[data-style]");
                image_style.forEach(function(img) {
                    $(img).attr("style",img.dataset.style);
                });
            }else{
                var css = '.bg.lazy { background-image: none !important; }',
                    head = document.head || document.getElementsByTagName('head')[0],
                    style = document.createElement('style');

                style.type = 'text/css';
                if (style.styleSheet){
                    style.styleSheet.cssText = css;
                } else {
                    style.appendChild(document.createTextNode(css));
                }
                head.appendChild(style);
            }
        });
    </script>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var userAgent = navigator.userAgent || navigator.vendor || window.opera;
            if (/iPad|iPhone|iPod/.test(userAgent) && !window.MSStream) {
                console.log('ios');
            }else{
                var css = '.bg.lazy { background-image: none !important; }',
                    head = document.head || document.getElementsByTagName('head')[0],
                    style = document.createElement('style');

                style.type = 'text/css';
                if (style.styleSheet){
                    style.styleSheet.cssText = css;
                } else {
                    style.appendChild(document.createTextNode(css));
                }
                head.appendChild(style);
            }
        });
    </script>
    <script>
        var form_pay='<div class="row" id="form_pay_div"><div class="col-md-5"><h4>Hướng dẫn thanh toán</h4></div><div class="col-md-7"><h4>Thông tin liên hệ</h4><form class="contact_form form-vertical mb-30" id="form_pay" novalidate="novalidate" _lpchecked="1"><div class="form-group text-field-group"><input type="text" class="form-control" placeholder="Họ tên*" name="name" size="10"></div><div class="form-group email-field-group"><input type="email" class="form-control" placeholder="Email*" name="email" size="10"></div><div class="form-group text-field-group"><input type="text" class="form-control" placeholder="Số điện thoại*" name="phone" size="10"></div><div class="form-group text-field-group"><input type="text" class="form-control" placeholder="Địa chỉ giao hàng*" name="address" size="10"></div><div class="form-group textarea-group"><textarea class="form-control" placeholder="Ghi chú" rows="3" name="text"></textarea></div><input type="hidden" class="form-control" name="shop_email" value="" size="10"></form></div></div>';
    </script>
    <!--end-->

    <!-- Script Popup -->
    <script src="https://salekit.io/embed/js/0b3d020e" async="async"></script>

    <%--Script Form--%>
    <script src="https://salekit.io/assets/js/embed/sk.js"></script>

</head>
<body nid='' uid='' class="light-page">
<div id="wrap">
    <nav id="nav-logo-menu-btn-1" class="navbar navbar-expand-lg pt-10 pb-10 light shadow show-menu">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col-auto col-lg-2">
                    <img src="https://slimweb.vn/builder/images/modal-loader.gif" data-src="/template/course/javacore/images/user/22607/logoawebsite.png" class="lazy mw-100" alt="" style="max-height: 50px;">
                </div>
                <div class="col-auto ml-auto hidden-lg">
                    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target=".main-menu-collapse" aria-controls="navbarMenuContent" aria-expanded="false" aria-label="Toggle navigation"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                </div>
                <div class="col-lg-10 collapse navbar-collapse main-menu-collapse">
                    <ul class="navbar-nav ml-auto mr-auto" style="">
                        <li class="nav-item active">
                            <a class="nav-link smooth" href="https://laptrinhjavawebacademy.com" target="_self" contenteditable="true">Trang chủ</a>
                        </li>
                        <li class="nav-item" style="">
                            <a class="nav-link smooth" href="#desc-text-img-8" target="_self" contenteditable="true">Giá trị cốt lõi</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link smooth" href="#desc-img-text-9" target="_self" contenteditable="true">Thời gian và cách học</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link smooth" href="#price-3col-3" contenteditable="true" target="_self">Bảng giá</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link smooth" href="#text-1col-center--0" contenteditable="true" target="_self">Chi tiết khóa học</a>
                        </li><li class="nav-item">
                        <a class="nav-link smooth" href="#desc-text" contenteditable="true" target="_self">Lộ trình học</a>
                    </li><li class="nav-item">
                        <a class="nav-link smooth" href="#benefits-3col-15" contenteditable="true" target="_self">Khách hàng đánh giá</a>
                    </li><li class="nav-item">
                        <a class="nav-link smooth" href="#desc-text-2" contenteditable="true" target="_self">Câu hỏi thường gặp</a>
                    </li><li class="nav-item">
                        <a class="nav-link smooth" href="#desc-text--0" contenteditable="true" target="_self">Cộng tác viên</a>
                    </li>
                    </ul>
                </div>
                <div class="col-lg-3 collapse navbar-collapse main-menu-collapse justify-content-lg-end">
                    <div class="">

                    </div>
                </div>
            </div>
        </div>
        <div class="bg-wrap">
            <div class="bg lazy"></div>
        </div>
    </nav>
    <%--Title and introduction--%>
    ${model.content4}
    ${model.content1}
<section id="media-text-img-2" class="text-center pt-75 pb-50 light">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 ml-auto mr-auto" style="">
                <h2 style="color: rgb(1, 60, 92); font-size: 2em;" class="mb-30 text-center slim_relative"><b class="">Video giới thiệu nội dung khoá học java core cơ bản nâng cao tại Laptrinhjavaweb</b></h2>
                <a href="https://www.youtube.com/watch?v=IRZrqX_hlcY" target="_self" class="smooth video-popup mfp-iframe"><img class="lazy shadow mw-100 mb-30" width="800" alt="image" src="https://slimweb.vn/builder/images/modal-loader.gif" data-src="/template/course/javacore/images/user/22607/khoaahocajavaacore.jpg" style="box-shadow: rgb(162, 170, 177) 0px 0px 10px;"></a>


            </div>
        </div>
    </div>
    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section><section id="sep-bottom-3" class="section-sep sep-bottom light">
    <div class="container-fluid">
        <div class="row no-gutters">
            <div class="col-12">

            </div>
        </div>
    </div>
    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section><section id="action-text-btn-5" class="dark text-center pb-50 pt-50">
    <div class="container">
        <div class="row">
            <div class="col-md-8 ml-auto mr-auto" style="">
                <h4 class="mb-20" style="">Nếu xem video vẫn chưa đã</h4>
                <h4 style="" class="mb-30"><span style="text-transform: uppercase;" class=""><b class="">hãy đọc tiếp các nội dung phía dưới</b></span></h4>
                <div class="w-100" style=""><a href="#desc-text-img-8" class="btn fx-btn-pill btn-lg btn-primary smooth" style="padding: 15px 60px;" target="_self">CHI TIẾT</a></div>

            </div>
        </div>
    </div>
    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section>
    ${model.content5}
    ${model.content6}
    <section id="sep-bottom-3--0" class="section-sep sep-bottom light">
    <div class="container-fluid">
        <div class="row no-gutters">
            <div class="col-12">

            </div>
        </div>
    </div>
    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section><header id="header-img" class="dark">
    <div class="">
        <img class="lazy w-100" src="https://slimweb.vn/builder/images/modal-loader.gif" data-src="/template/course/javacore/images/user/22607/mucadichasaukhoahocajavacoreasqla01.jpg" alt="header img">
    </div>
</header>
    ${model.content2}
    ${model.content3}
    ${model.content7}
    ${model.content8}
    ${model.content9}
    ${model.content10}
    ${model.content11}
    ${model.content12}
    <section id="tool-back-to-top" class="text-center light" style="display: block;">
    <div class="content-box d-inline-block bg-default shadow padding" style="position: fixed; right: 0px; bottom: 50px;">
        <a href="#wrap" target="_self" class="smooth"> <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 64 64" height="40" viewBox="0 0 64 64" width="40" class="icon"><path d="m33 64v-60.586l7.293 7.293 1.414-1.561-9-9.146h-1.414l-9 9.146 1.414 1.488 7.293-7.22v60.586z"></path></svg></a>
    </div>
    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section><section id="tool-social-right" class="tool-social-right text-center light">
    <div class="morestats collapse show" style="position: fixed; right: 0px; bottom: 110px;">



        <div class="content-box bg-default shadow padding rounded-circle mb-150" style="background-color: rgb(255, 156, 0);">
            <a href="tel:0819423713" class="smooth" target="_self"> <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 512 512" enable-background="new 0 0 64 64" class="icon" style="fill: rgb(255, 255, 255);"><path d="M493.397 24.615l-104-23.997c-11.314-2.611-22.879 3.252-27.456 13.931l-48 111.997a24 24 0 0 0 6.862 28.029l60.617 49.596c-35.973 76.675-98.938 140.508-177.249 177.248l-49.596-60.616a24 24 0 0 0-28.029-6.862l-111.997 48C3.873 366.516-1.994 378.08.618 389.397l23.997 104C27.109 504.204 36.748 512 48 512c256.087 0 464-207.532 464-464 0-11.176-7.714-20.873-18.603-23.385z" class=""></path></svg></a>

        </div>

    </div>

    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section>
  ${model.content13}
    <section id="tool-social-right--0" class="tool-social-right text-center light">
    <div class="morestats collapse show" style="position: fixed; right: 0px; bottom: 110px;">

        <div class="content-box bg-default shadow padding rounded-circle mb-10" style="background-color: rgb(0, 192, 255);">
            <a href="https://zalo.me/4588194011921423842" target="_blank" class="smooth"><img src="https://slimweb.vn/builder/images/modal-loader.gif" data-src="/template/course/javacore/images/user/887/imagezaloicon.png" height="30" width="30" class="lazy icon" alt="icon" style="fill: rgb(255, 255, 255);"></a>

        </div>
        <div class="content-box bg-default shadow padding rounded-circle mb-10" style="background-color: rgb(33, 115, 243);">
            <a href="https://m.me/laptrinhjavaweb" class="smooth" target="_blank"> <svg xmlns="http://www.w3.org/2000/svg" height="30" viewBox="0 0 448 512" width="30" enable-background="new 0 0 64 64" class="icon" style="fill: rgb(255, 255, 255);"><path d="m224 32c-208.1 0-301.5 246-139.4 368.6v79.4l75.7-42c142.2 39.8 285.4-59.9 285.4-198.7.1-114.5-99.2-207.3-221.7-207.3zm23.4 278.1-57.4-59.6-110.4 61.1 121.1-128.5 57.4 59.6 110.4-61.1z" class=""></path></svg></a>

        </div>
        <div class="content-box bg-default shadow padding rounded-circle mb-10" style="background-color: rgb(255, 156, 0);">
            <a href="tel:0354502773" class="smooth" target="_self"> <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" viewBox="0 0 512 512" enable-background="new 0 0 64 64" class="icon" style="fill: rgb(255, 255, 255);"><path d="M493.397 24.615l-104-23.997c-11.314-2.611-22.879 3.252-27.456 13.931l-48 111.997a24 24 0 0 0 6.862 28.029l60.617 49.596c-35.973 76.675-98.938 140.508-177.249 177.248l-49.596-60.616a24 24 0 0 0-28.029-6.862l-111.997 48C3.873 366.516-1.994 378.08.618 389.397l23.997 104C27.109 504.204 36.748 512 48 512c256.087 0 464-207.532 464-464 0-11.176-7.714-20.873-18.603-23.385z" class=""></path></svg></a>

        </div>

    </div>

    <div class="bg-wrap">
        <div class="bg lazy"></div>
    </div>
</section>
</div>
<footer></footer>
<div class="modal-container"></div>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        lazyload();
        lazyloadUrl();
        if ("IntersectionObserver" in window) {
            var lazyloadImagesBg = document.querySelectorAll(".bg.lazy");
            var imageObserver = new IntersectionObserver(function(entries, observer) {
                entries.forEach(function(entry) {
                    if (entry.isIntersecting) {
                        var image = entry.target;
                        image.classList.remove("lazy");
                        imageObserver.unobserve(image);
                    }
                });
            });

            lazyloadImagesBg.forEach(function(image) {
                imageObserver.observe(image);
            });
        }
        var lazyloadThrottleTimeout;
        var lazyloadThrottleTimeoutUrl;
        lazyloadImages = document.querySelectorAll("img.lazy");
        lazyloadImagesUrl = document.querySelectorAll("*[data-style]");
        function lazyloadUrl(){
            if(lazyloadThrottleTimeoutUrl) {
                clearTimeout(lazyloadThrottleTimeoutUrl);
            }
            lazyloadThrottleTimeoutUrl = setTimeout(function() {
                var scrollTop = window.pageYOffset;
                lazyloadImagesUrl.forEach(function(img) {
                    if($(img).offset().top < (window.innerHeight + scrollTop)) {
                        img.style = img.dataset.style;
                    }
                });
                if(lazyloadImagesUrl.length == 0) {
                    document.removeEventListener("scroll", lazyloadUrl);
                    window.removeEventListener("resize", lazyloadUrl);
                    window.removeEventListener("orientationChange", lazyloadUrl);
                }
            }, 100);
        }

        function lazyload () {
            if(lazyloadThrottleTimeout) {
                clearTimeout(lazyloadThrottleTimeout);
            }
            lazyloadThrottleTimeout = setTimeout(function() {
                var scrollTop = window.pageYOffset;
                lazyloadImages.forEach(function(img) {
                    if($(img).offset().top < (window.innerHeight + scrollTop + 10)) {
                        img.src = img.dataset.src;
                        img.classList.remove('lazy');
                    }
                });
                if(lazyloadImages.length == 0) {
                    document.removeEventListener("scroll", lazyload);
                    window.removeEventListener("resize", lazyload);
                    window.removeEventListener("orientationChange", lazyload);
                }
            }, 0);
        }
        function fix(){
            window.dispatchEvent(new Event('resize'));
        }
        document.addEventListener("scroll",() => {lazyload();lazyloadUrl();fix();});
        window.addEventListener("resize",() => {lazyload();lazyloadUrl();});
        window.addEventListener("orientationChange",() => {lazyload();lazyloadUrl();});
    });
</script>
<script type="text/plain" data-cookiescript="accepted" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCByts0vn5uAYat3aXEeK0yWL7txqfSMX8"></script>
<script src="https://slimweb.vn/builder/js/lib/popper.min.js"></script>
<script src="<c:url value='/template/course/javacore/js/jquery-2.1.4.min.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/vinno1.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/jquery.magnific-popup.min.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/jquery.smooth-scroll.min.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/custom.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/index1666690930.js' />"></script>
<script src="<c:url value='/template/course/javacore/js/index.js' />"></script><script type='text/javascript' src='https://slimweb.vn/shop/include/jquery.mycart2.js'></script>

</body>
</html>
