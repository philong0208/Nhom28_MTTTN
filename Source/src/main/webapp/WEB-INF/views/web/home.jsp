<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div class="row banner-bg mx-0">
    <!-- left -->
    <div class="col-md-4 col-sm-12 row-left">
        <div class="d-flex justify-content-center align-items-center h-100">
            <div class="text-center">
                <%--<h1 class="text-white">${leftBanner.name}</h1>--%>
                <h1 class="text-white">Tiểu thuyết mới nhất</h1>
                <%--<a href="<c:url value="/san-pham/?productCategoryCode=${leftBanner.code}"/>"--%>
                <a href="<c:url value="#"/>"
                   class="gl-cta gl-cta--primary gl-cta--primary-light"
                   title="Chi tiết">Chi tiết
                    <span class="gl-icon__wrapper" role="img">
                             <i class="fa fa-thin fa-arrow-right"></i>
                        </span>
                </a>
            </div>
        </div>
    </div>
    <!-- left -->
    <!-- right -->
    <div class="col-md-8 col-sm-12 w-100 row-right">
        <div class="cover">
            <div class="cover-carousel" id="drag-container">
                <div id="spin-container">
                    <c:forEach var="item" items="${latest}">
                        <c:if test="${not empty item.thumbnail}">
                            <c:set var="image" value="/repository${item.thumbnail}"/>
                            <img src="${image}" style="cursor: pointer;" onclick="window.open('<c:url
                                    value="/tieu-thuyet/${item.shortTitle}-${item.id}"/>', '_blank');">
                            <%--<img src="${image}" style="cursor: pointer;" onclick="window.open('<c:url
                                    value="#"/>', '_blank');">--%>
                        </c:if>
                        <c:if test="${empty item.thumbnail}">
                            <img src="<c:url value='/template/image/default.png'/>">
                        </c:if>
                    </c:forEach>
                </div>
                <div id="ground"></div>
            </div>

            <div id="music-container"></div>
        </div>
    </div>
    <!-- right -->
</div>
<!--discover-->
<div class="discover">
    <div class="container py-3  shadow p-3  rounded">
        <div class="discover-header container">
            <div class="row">
                <div class="col-md-6 pull-left">
                    <h2 style="font-weight: bold">Tiểu thuyết xem nhiều</h2>
                </div>
                <div class="col-md-6">
                    <a href="/san-pham-gach-moi" class="float-right" style="color: black">Xem thêm <i class="fas fa-arrow-right"></i></a>
                </div>
            </div>
        </div>

        <div class="new-collection">
            <!-- collection item -->
            <c:forEach var="item" items="${mostView}">
                <div>
                    <div class="item w-100 position-relative" id="${item.shortTitle}">
                        <a href="<c:url value="/tieu-thuyet/${item.shortTitle}-${item.id}"/>"
                           class="image-container w-100 h-100">
                            <c:if test="${not empty item.thumbnail}">
                                <c:set var="image" value="/repository${item.thumbnail}"/>
                            </c:if>
                            <c:if test="${empty item.thumbnail}">
                                <c:set var="image" value="/template/image/default.png"/>
                            </c:if>
                            <img class="card-img-top h-100 img-target" src="${image}" alt="">
                        </a>
                        <div>
                            <p class="mb-0"><strong>${item.shortTitle}</strong></p>
                            <%--<p class="mb-0"><small>${item.shortTitle}</small></p>--%>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <!-- collection item -->
        </div>
    </div>
</div>
<c:if test="${not empty mostRate}">
    <!-- best seller -->
    <div class="discover">
        <div class="container py-3  shadow p-3  rounded">
            <div class="discover-header container">
                <div class="row">
                    <div class="col-md-6 pull-left">
                        <h2 style="font-weight: bold">Tiểu thuyết hay nhất</h2>
                    </div>
                    <div class="col-md-6">
                        <a href="/san-pham-gach-moi" class="float-right" style="color: black">Xem thêm <i class="fas fa-arrow-right"></i></a>
                    </div>
                </div>
            </div>

            <div class="new-collection">
                <!-- collection item -->
                <c:forEach var="item" items="${mostRate}">
                    <div>
                        <div class="item w-100 position-relative" id="${item.shortTitle}">
                            <a href="<c:url value="/tieu-thuyet/${item.shortTitle}-${item.id}"/>"
                               class="image-container w-100 h-100">
                                <c:if test="${not empty item.thumbnail}">
                                    <c:set var="image" value="/repository${item.thumbnail}"/>
                                </c:if>
                                <c:if test="${empty item.thumbnail}">
                                    <c:set var="image" value="/template/image/default.png"/>
                                </c:if>
                                <img class="card-img-top h-100 img-target" src="${image}" alt="">
                            </a>
                            <div>
                                <p class="mb-0"><strong>${item.shortTitle}</strong></p>
                                    <%--<p class="mb-0"><small>${item.shortTitle}</small></p>--%>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- collection item -->
            </div>
        </div>
    </div>
    <!-- best seller -->
</c:if>


<!-- home-detail-new-technology-left-to-right-->
1
<%--
<div class="home-detail">
    <div class="container h-100">
        <div class="row h-100">
            <c:if test="${(not empty news) && (not empty news[0])}">
                <div class="col-md-6 col-sm-12 row-left">
                    <p class="title-first">${news[0].name}</p>
                    <p>${news[0].shortDescription}</p>
                    <a href="<c:url value='/tin-tuc/${news[0].newCategoryCode}/${news[0].seoUrl}-${news[0].id}'/>">
                        Xem thêm <i class="fas fa-arrow-right"></i></a>
                </div>
            </c:if>
            <c:if test="${(not empty news) && (not empty news[1])}">
                <div class="col-md-6 col-sm-12 w-100 row-right">
                    <c:if test="${not empty news[1].image}">
                        <c:set var="image" value="/repository/blog/${news[1].image}"/>
                    </c:if>
                    <c:if test="${empty news[1].image}">
                        <c:set var="image" value="/template/img/default.png"/>
                    </c:if>
                    <div style="background-image: url(<c:url value="${image}"/>);" class="w-100 h-100 row-right-div">
                        <div class="caption d-flex align-items-center col-md-4">
                            <a href="<c:url value='/tin-tuc/${news[1].newCategoryCode}/${news[1].seoUrl}-${news[1].id}'/>">${news[1].name}</a>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
2
<!--highlights-project-left-to-right-->
<div class="highlights-project">
    <div class="container">
        <div class="row">
            <c:if test="${not empty news && news.size() >= 5}">
                <c:forEach items="${news}" var="item" begin="2" end="4">
                    <div class="col-md-2 col-sm-6 p-0 item">
                        <c:if test="${not empty item.image}">
                            <c:set var="image" value="/repository/blog/${item.image}"/>
                        </c:if>
                        <c:if test="${empty item.image}">
                            <c:set var="image" value="/template/img/default.png"/>
                        </c:if>
                        <img src="${image}" class="w-100 h-100">
                    </div>
                    <div class="col-md-2 col-sm-6 p-0 item">
                        <div class="text d-flex align-items-center">
                            <a href="<c:url value='/tin-tuc/${item.newCategoryCode}/${item.seoUrl}-${item.id}'/>">${item.name}</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
3
<!-- home-detail-new-technology-right-to-left -->
<div class="home-detail">
    <div class="container h-100">
        <div class="row h-100">
            <c:if test="${(not empty news) && (not empty news[5])}">
                <div class="col-md-6 col-sm-12 w-100 row-right">
                    <c:if test="${not empty news[5].image}">
                        <c:set var="image" value="/repository/blog/${news[5].image}"/>
                    </c:if>
                    <c:if test="${empty news[5].image}">
                        <c:set var="image" value="/template/img/default.png"/>
                    </c:if>
                    <div style="background-image: url(<c:url value="${image}"/>);" class="w-100 h-100 row-right-div">
                        <div class="caption d-flex align-items-center col-md-4">
                            <a href="<c:url value='/tin-tuc/${news[5].newCategoryCode}/${news[5].seoUrl}-${news[5].id}'/>">${news[5].name}</a>
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${(not empty news) && (not empty news[6])}">
                <div class="col-md-6 col-sm-12 row-left">
                    <p class="title-first">${news[6].name}</p>
                    <p>${news[6].shortDescription}</p>
                    <a href="<c:url value='/tin-tuc/${news[6].newCategoryCode}/${news[6].seoUrl}-${news[6].id}'/>">Xem
                        thêm <i class="fas fa-arrow-right"></i></a>
                </div>
            </c:if>
        </div>
    </div>
</div>
4
<!--highlights-project-right-to-left-->
<div class="highlights-project">
    <div class="container">
        <div class="row">
            <c:if test="${not empty news && news.size() >= 9}">
                <c:forEach items="${news}" var="item" begin="7" end="9">
                    <div class="col-md-2 col-sm-6 p-0 item">
                        <c:if test="${not empty item.image}">
                            <c:set var="image" value="/repository/blog/${item.image}"/>
                        </c:if>
                        <c:if test="${empty item.image}">
                            <c:set var="image" value="/template/img/default.png"/>
                        </c:if>
                        <img src="${image}" class="w-100 h-100">
                    </div>
                    <div class="col-md-2 col-sm-6 p-0 item">
                        <div class="text d-flex align-items-center">
                            <a href="<c:url value='/tin-tuc/${item.newCategoryCode}/${item.seoUrl}-${item.id}'/>">${item.name}</a>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>
<div class="mt-5"></div>
--%>

<%--<div class="support-bg">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <div class="icon-wrapper">
                    <i class="fa fa-phone-square fa-5x" style="color: #C0504E" aria-hidden="true"></i>
                </div>
                <div>
                    ${supportCenter.content}
                </div>
            </div>
        </div>
    </div>
</div>--%>
<script type="text/javascript">
    // You can change global variables here:
    var radius = 290; // how big of the radius
    var autoRotate = true; // auto rotate or not
    var rotateSpeed = -60; // unit: seconds/360 degrees
    var imgWidth = 200; // width of images (unit: px)
    var imgHeight = 250; // height of images (unit: px)

    // Link of background music - set 'null' if you dont want to play background music
    var bgMusicURL = null;
    var bgMusicControls = null; // Show UI music control

    /*
        NOTE:
        + imgWidth, imgHeight will work for video
        + if imgWidth, imgHeight too small, play/pause button in <video> will be hidden
        + Music link are taken from: https://hoangtran0410.github.io/Visualyze-design-your-own-/?theme=HauMaster&playlist=1&song=1&background=28
        + Custom from code in tiktok video  https://www.facebook.com/J2TEAM.ManhTuan/videos/1353367338135935/
    */


    // ===================== start =======================
    // animation start after 1000 miliseconds
    setTimeout(init, 1000);

    var odrag = document.getElementById('drag-container');
    var ospin = document.getElementById('spin-container');
    var aImg = ospin.getElementsByTagName('img');
    var aVid = ospin.getElementsByTagName('video');
    var aEle = [...aImg, ...aVid]; // combine 2 arrays

    // Size of images
    ospin.style.width = imgWidth + "px";
    ospin.style.height = imgHeight + "px";

    // Size of ground - depend on radius
    var ground = document.getElementById('ground');
    ground.style.width = radius * 3 + "px";
    ground.style.height = radius * 3 + "px";

    function init(delayTime) {
        for (var i = 0; i < aEle.length; i++) {
            aEle[i].style.transform = "rotateY(" + (i * (360 / aEle.length)) + "deg) translateZ(" + radius + "px)";
            aEle[i].style.transition = "transform 1s";
            aEle[i].style.transitionDelay = delayTime || (aEle.length - i) / 4 + "s";
        }
    }

    function applyTranform(obj) {
        // Constrain the angle of camera (between 0 and 180)
        if (tY > 180) tY = 180;
        if (tY < 0) tY = 0;
        var cover = document.getElementsByClassName("cover")
        // Apply the angle
        obj.style.transform = "rotateX(" + (-tY) + "deg) rotateY(" + (tX) + "deg)";
    }

    function playSpin(yes) {
        ospin.style.animationPlayState = (yes ? 'running' : 'paused');
    }

    var sX, sY, nX, nY, desX = 0,
        desY = 0,
        tX = 0,
        tY = 10;

    // auto spin
    if (autoRotate) {
        ospin.style.animation = `spin 60s infinite linear`;
    }

    // setup events
    /*document.onpointerdown = function (e) {
        clearInterval(odrag.timer);
        e = e || window.event;
        var sX = e.clientX,
            sY = e.clientY;

        this.onpointermove = function (e) {
            e = e || window.event;
            var nX = e.clientX,
                nY = e.clientY;
            desX = nX - sX;
            desY = nY - sY;
            tX += desX * 0.1;
            tY += desY * 0.1;
            applyTranform(odrag);
            sX = nX;
            sY = nY;
        };

        this.onpointerup = function (e) {
            odrag.timer = setInterval(function () {
                desX *= 0.95;
                desY *= 0.95;
                tX += desX * 0.1;
                tY += desY * 0.1;
                applyTranform(odrag);
                playSpin(false);
                if (Math.abs(desX) < 0.5 && Math.abs(desY) < 0.5) {
                    clearInterval(odrag.timer);
                    playSpin(true);
                }
            }, 17);
            this.onpointermove = this.onpointerup = null;
        };

        return false;
    };

    document.onmousewheel = function(e) {
        e = e || window.event;
        var d = e.wheelDelta / 20 || -e.detail;
        radius += d;
        init(1);
    };*/

    $('.new-collection').slick({
        dots: true,
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        responsive: [
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            },
        ]
    });

    $('.new-collection-selling').slick({
        dots: true,
        infinite: true,
        speed: 300,
        slidesToShow: 4,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 2000,
        responsive: [
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 600,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            },
        ]
    });

    $('.img-lv2').hide()
    $(document).ready(function () {
        $('.img-target').mouseover(function () {
            if ($(this).next('.img-lv2').length != 0) {
                $(this).next('.img-lv2').show();
                $(this).hide();
            }
        });
        $('.img-lv2').mouseout(function () {
            $('.img-lv2').hide();
            $(this).prev('.img-target').show();
        });
    });

</script>
</body>
</html>
