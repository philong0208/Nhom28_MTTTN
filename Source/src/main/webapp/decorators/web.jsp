<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="categoryUrl" value="/api/category"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:choose>
        <c:when test="${meta== null || empty meta}">
    <title><dec:title default="Light novel" /></title>
        </c:when>
        <c:otherwise>
     <title>${meta.ogTitle}</title>
     <meta name="description" content="${meta.ogDescription}">

     <meta property="og:title" content="${meta.ogTitle}" />
     <meta property="og:description" content="${meta.ogDescription}" />
     <meta property="og:url" content="${meta.ogURL}" />
        </c:otherwise>
    </c:choose>

    <link rel="apple-touch-icon" sizes="180x180" href="/repository/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/repository/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/repository/favicon-16x16.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!--    bootstrap-->
    <link rel="stylesheet" href="<c:url value="/template/web/lib/boostrap/css/bootstrap.css"/>">

    <!--    font-awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%--    <link rel="stylesheet" href="<c:url value="/template/web/lib/fontawesome-free-5.15.1-web/css/all.css"/>">--%>

    <!-- UIkit CSS -->
    <link rel="stylesheet" href="<c:url value="/template/web/lib/uikit-3.5.8/css/uikit.css"/>" />

    <!--    css-->
    <link rel="stylesheet" href="<c:url value="/template/web/css/home.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/news-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/news-detail.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/product-list.css"/>">
    <link rel="stylesheet" href="<c:url value="/template/web/css/product.css"/>">
    <link href="<c:url value="/template/web/css/introduce.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/introduction-component.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/distribution.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/recruitment.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/search-catalogue.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/contact.css"/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/template/web/css/button-footer.css"/>">
    <link href="<c:url value="/template/web/css/breadcrumb.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/web/css/pagination.css"/>" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<c:url value="/template/web/css/custom-footer.css"/>">

    <!--  jquery-->
    <script type='text/javascript' src='<c:url value="/template/web/lib/jquery-3.5.1/jquery-3.5.1.min.js" />'></script>

    <!--  simplelightbox-->
    <link href="<c:url value="/template/web/lib/simplelightbox/simple-lightbox.css"/>" rel="stylesheet" type="text/css" />
    <script type='text/javascript' src='<c:url value="/template/web/lib/simplelightbox/simple-lightbox.min.js" />'></script>
    <!-- slick-carousel -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css" rel="stylesheet" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css" rel="stylesheet" />

</head>
<body>

    <!-- Header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- Header -->

    <dec:body/>
    <a href="https://chat.zalo.me/?phone=0903197896" id="linkzalo" target="_blank" rel="noopener noreferrer">
        <div id="fcta-zalo-tracking" class="fcta-zalo-mess">
            <span id="fcta-zalo-tracking">Chat hỗ trợ</span>
        </div>
        <div class="fcta-zalo-vi-tri-nut">
            <div id="fcta-zalo-tracking" class="fcta-zalo-nen-nut">
                <div id="fcta-zalo-tracking" class="fcta-zalo-ben-trong-nut">
                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 460.1 436.6">
                        <path fill="currentColor" class="st0" d="M82.6 380.9c-1.8-.8-3.1-1.7-1-3.5 1.3-1 2.7-1.9 4.1-2.8 13.1-8.5 25.4-17.8 33.5-31.5 6.8-11.4 5.7-18.1-2.8-26.5C69 269.2 48.2 212.5 58.6 145.5 64.5 107.7 81.8 75 107 46.6c15.2-17.2 33.3-31.1 53.1-42.7 1.2-.7 2.9-.9 3.1-2.7-.4-1-1.1-.7-1.7-.7-33.7 0-67.4-.7-101 .2C28.3 1.7.5 26.6.6 62.3c.2 104.3 0 208.6 0 313 0 32.4 24.7 59.5 57 60.7 27.3 1.1 54.6.2 82 .1 2 .1 4 .2 6 .2H290c36 0 72 .2 108 0 33.4 0 60.5-27 60.5-60.3v-.6-58.5c0-1.4.5-2.9-.4-4.4-1.8.1-2.5 1.6-3.5 2.6-19.4 19.5-42.3 35.2-67.4 46.3-61.5 27.1-124.1 29-187.6 7.2-5.5-2-11.5-2.2-17.2-.8-8.4 2.1-16.7 4.6-25 7.1-24.4 7.6-49.3 11-74.8 6zm72.5-168.5c1.7-2.2 2.6-3.5 3.6-4.8 13.1-16.6 26.2-33.2 39.3-49.9 3.8-4.8 7.6-9.7 10-15.5 2.8-6.6-.2-12.8-7-15.2-3-.9-6.2-1.3-9.4-1.1-17.8-.1-35.7-.1-53.5 0-2.5 0-5 .3-7.4.9-5.6 1.4-9 7.1-7.6 12.8 1 3.8 4 6.8 7.8 7.7 2.4.6 4.9.9 7.4.8 10.8.1 21.7 0 32.5.1 1.2 0 2.7-.8 3.6 1-.9 1.2-1.8 2.4-2.7 3.5-15.5 19.6-30.9 39.3-46.4 58.9-3.8 4.9-5.8 10.3-3 16.3s8.5 7.1 14.3 7.5c4.6.3 9.3.1 14 .1 16.2 0 32.3.1 48.5-.1 8.6-.1 13.2-5.3 12.3-13.3-.7-6.3-5-9.6-13-9.7-14.1-.1-28.2 0-43.3 0zm116-52.6c-12.5-10.9-26.3-11.6-39.8-3.6-16.4 9.6-22.4 25.3-20.4 43.5 1.9 17 9.3 30.9 27.1 36.6 11.1 3.6 21.4 2.3 30.5-5.1 2.4-1.9 3.1-1.5 4.8.6 3.3 4.2 9 5.8 14 3.9 5-1.5 8.3-6.1 8.3-11.3.1-20 .2-40 0-60-.1-8-7.6-13.1-15.4-11.5-4.3.9-6.7 3.8-9.1 6.9zm69.3 37.1c-.4 25 20.3 43.9 46.3 41.3 23.9-2.4 39.4-20.3 38.6-45.6-.8-25-19.4-42.1-44.9-41.3-23.9.7-40.8 19.9-40 45.6zm-8.8-19.9c0-15.7.1-31.3 0-47 0-8-5.1-13-12.7-12.9-7.4.1-12.3 5.1-12.4 12.8-.1 4.7 0 9.3 0 14v79.5c0 6.2 3.8 11.6 8.8 12.9 6.9 1.9 14-2.2 15.8-9.1.3-1.2.5-2.4.4-3.7.2-15.5.1-31 .1-46.5z"></path>
                    </svg>
                </div>
                <div id="fcta-zalo-tracking" class="fcta-zalo-text">
                    Chat ngay
                </div>
            </div>
        </div>
    </a>
    <%--footer--%>
    <%@ include file="/common/web/footer.jsp" %>
    <%--footer--%>

    <!-- Load Facebook SDK for JavaScript -->
<%--    <div style="float:left; margin:10px 10px 0 0;">
        <div id="fb-root"></div>
    </div>
    <script>
        window.fbAsyncInit = function() {
            FB.init({
                xfbml            : true,
                version          : 'v8.0'
            });
        };
        (function(d, s, id) {
            var js, fjs = d.getElementsByTagName(s)[0];
            if (d.getElementById(id)) return;
            js = d.createElement(s); js.id = id;
            js.src = 'https://connect.facebook.net/en_US/sdk/xfbml.customerchat.js';
            fjs.parentNode.insertBefore(js, fjs);
        }(document, 'script', 'facebook-jssdk'));
    </script>
    <!-- Your Chat Plugin code -->
    <div class="fb-customerchat"
         attribution=setup_tool
         page_id="101711481709504">
    </div>
    --%>
    <!--    popper-->
    <script type='text/javascript' src='<c:url value="/template/web/lib/popper/popper.min.js" />'></script>
    <script type='text/javascript' src='<c:url value="/template/web/lib/boostrap/js/bootstrap.js" />'></script>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>

    <!-- UIkit js -->
    <script type="text/javascript" src="<c:url value="/template/web/lib/uikit-3.5.8/js/uikit.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/template/web/lib/uikit-3.5.8/js/uikit-icons.js"/>"></script>

    <script src="<c:url value='/template/web/paging/jquery.twbsPagination.js' />"></script>

    <script type="text/javascript">
        // hide and show arrow up button
        $(document).ready(function(){
            $(document).scroll(function(){
                    if (window.scrollY < 50){
                        $("#arrowUp").hide();
                    }
                    else{
                        $("#arrowUp").show();
                    }
                }
            );
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })
        });

        // function scroll top
        function scrolltop(){
            var c = document.documentElement.scrollTop || document.body.scrollTop;
            if (c > 0) {
                window.requestAnimationFrame(scrolltop);
                window.scrollTo(0, c - c / 5);
            }
        };
        $(function(){
            var current = location.pathname;
            $('#nav li a').each(function(){
                var $this = $(this);
                ref = $this.attr('href')
                if (ref === "/"){
                    ref = "/trang-chu"
                }
                // if the current path is like this link, make it active
                if(ref.indexOf(current) !== -1){
                    $this.addClass('active');
                }
            })
        })

        // nav action
        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("backdrop").style.display = "block";
            document.getElementsByTagName("body")[0].style.overflow = "hidden";
        }

        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("backdrop").style.display = "none";
            document.getElementsByTagName("body")[0].style.overflow = "auto";
        }
        // show sub menu
        $('#collapseOne').on('show.bs.collapse', function () {
            document.getElementById('icon-collapseOne').className ="fas fa-minus"
        })
        $('#collapseOne').on('hidden.bs.collapse', function () {
            document.getElementById('icon-collapseOne').className ="fas fa-plus"
        })
        // zalo
        if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) )
        {document.getElementById("linkzalo").href="https://zalo.me/0903197896";}

      loadCategories = function (){
          $.ajax({
              url: '${categoryUrl}',
              type: 'GET',
              dataType: 'json',
              contentType: 'application/json',
              success: function (response) {
                  const categoriesComponent = $('.categories')
                  categoriesComponent.html("")
                  const categories= response?.categories ? response.categories : [];
                  for (let i = 0; i < categories.length; i++) {
                      const category = categories[i]
                      categoriesComponent.append(`<a href="/san-pham?productCategoryCode=`+ category.code+`">`+category.name+`</a>`)
                  }
              },
              error: function (res) {
               console.error(res)
              }
          });
      }
      loadCategories()
    </script>
    <!-- zalo -->
    <style>
        @keyframes zoom{0%{transform:scale(.5);opacity:0}50%{opacity:1}to{opacity:0;transform:scale(1)}}@keyframes lucidgenzalo{0% to{transform:rotate(-25deg)}50%{transform:rotate(25deg)}}.jscroll-to-top{bottom:100px}.fcta-zalo-ben-trong-nut svg path{fill:#fff}.fcta-zalo-vi-tri-nut{position:fixed;bottom:120px;right:45px;z-index:999}.fcta-zalo-nen-nut,div.fcta-zalo-mess{box-shadow:0 1px 6px rgba(0,0,0,.06),0 2px 32px rgba(0,0,0,.16)}.fcta-zalo-nen-nut{width:50px;height:50px;text-align:center;color:#fff;background:#0068ff;border-radius:50%;position:relative}.fcta-zalo-nen-nut::after,.fcta-zalo-nen-nut::before{content:"";position:absolute;border:1px solid #0068ff;background:#0068ff80;z-index:-1;left:-20px;right:-20px;top:-20px;bottom:-20px;border-radius:50%;animation:zoom 1.9s linear infinite}.fcta-zalo-nen-nut::after{animation-delay:.4s}.fcta-zalo-ben-trong-nut,.fcta-zalo-ben-trong-nut i{transition:all 1s}.fcta-zalo-ben-trong-nut{position:absolute;text-align:center;width:60%;height:60%;left:10px;bottom:10px;line-height:70px;font-size:25px;opacity:1}.fcta-zalo-ben-trong-nut i{animation:lucidgenzalo 1s linear infinite}.fcta-zalo-nen-nut:hover .fcta-zalo-ben-trong-nut,.fcta-zalo-text{opacity:0}.fcta-zalo-nen-nut:hover i{transform:scale(.5);transition:all .5s ease-in}.fcta-zalo-text a{text-decoration:none;color:#fff}.fcta-zalo-text{position:absolute;top:6px;text-transform:uppercase;font-size:12px;font-weight:700;transform:scaleX(-1);transition:all .5s;line-height:1.5}.fcta-zalo-nen-nut:hover .fcta-zalo-text{transform:scaleX(1);opacity:1}div.fcta-zalo-mess{position:fixed;bottom:129px;right:83px;z-index:99;background:#fff;padding:7px 25px 7px 15px;color:#0068ff;border-radius:50px 0 0 50px;font-weight:700;font-size:15px}.fcta-zalo-mess span{color:#0068ff!important}
        span#fcta-zalo-tracking{font-family:Roboto;line-height:1.5}.fcta-zalo-text{font-family:Roboto}
    </style>
</body>
</html>
