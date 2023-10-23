<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- Small modal -->
<div id="preview-product" style="display: none;">
    <div type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="closeModal()">
        <span aria-hidden="true">&times;</span>
    </div>
    <div class="h-100 w-100 d-flex justify-content-center align-items-center">
        <div class="py-2 uk-position-relative uk-visible-toggle"
             uk-slider="center: true; index: 0;"
             id="preview-product-uk">
            <ul class="uk-slider-items uk-child-width-1-1 uk-child-width-1-1@s uk-child-width-1-1@m uk-grid-medium"
            >
                <c:forEach var="img1" items="${images}">
                    <li class="d-flex ustify-content-center align-items-center">
                        <div class="w-100 d-flex justify-content-center ">
                            <img src="${img1}">
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <a class="uk-position-center-left uk-position-small" href="#" uk-slidenav-previous
               uk-slider-item="previous"></a>
            <a class="uk-position-center-right uk-position-small" href="#" uk-slidenav-next uk-slider-item="next"></a>
        </div>
    </div>
</div>

<!-- product -->
<div class='mt-4 container product'>
    <div class="row d-flex align-items-center justify-content-center pl-2">
        <div class=" w-auto text-right col-md-12 col-lg-7 row">
            <div class="col-12 row warpTwoImg">
                <div class="col-lg-3">
                    <c:forEach var="img2" items="${images}">
                        <div class="mr-3 my-2 d-flex align-items-center smallProduct" data-img="'${img2}'">
                            <img src="/repository${img2}" alt="${img2}">
                        </div>
                    </c:forEach>
                </div>
                <div class="col-md-12 w-100 col-lg-9 ">
                    <div class=" zoom-image w-100 d-flex align-items-center contain">
                        <c:if test="${not empty product.thumbnail}">
                            <c:set var="defaultImg" value="/repository${product.thumbnail}"/>
                        </c:if>
                        <c:if test="${empty product.thumbnail}">
                            <c:set var="defaultImg" value="/template/image/default.png"/>
                        </c:if>
                        <div type="button" data-toggle="modal"
                             data-target="#basicExampleModal"
                             class="img-zoom-container w-100 ">
                            <img class="zoom-img w-100" id="zoom_01"
                                 data-zoom-image="${defaultImg}" src="${defaultImg}" alt="${defaultImg}">
                        </div>
                    </div>
                </div>
                <div id="myresult" class="img-zoom-result"></div>
            </div>
            <div class="ml-auto mr-5 font-italic font-weight-bolder py-4 clickPicture" style="font-size: 0.7em;">Nhấp
                chuột để xem ảnh rộng và tải ảnh
            </div>
        </div>
        <div class="col-md-12 col-lg-5">
            <div class='justify-content-between d-flex'>
                <div class="font-weight-bold">Mã sản phẩm</div>
            </div>
            <div class=" code_Number">${product.shortTitle}</div>
            <div class='py-3 justify-content-between d-flex group_value '>
                <div class="font-weight-bold">NHÃN HIỆU</div>
                <div class="">ITALIANHOME</div>
            </div>
            <div class='py-3 justify-content-between d-flex group_value '>
                <div class="font-weight-bold">NHÀ SẢN XUẤT</div>
                <div class="">ITALIANHOME</div>
            </div>
            <div class='py-3 justify-content-between d-flex group_value'>
                <div class="font-weight-bold">KÍCH THƯỚC</div>
                <div class="">${product.shortTitle} cm</div>
            </div>
            <div class='py-3 justify-content-between d-flex group_value'>
                <div class="font-weight-bold">LOẠI</div>
                <div class="">${product.shortTitle}</div>
            </div>
            <div class="py-3 d-flex group_value">
                <div class="col-md-12 text-right">
                    <a target="_blank" class="btn btn-success" href="https://zalo.me/0903197896">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32px" height="32px">
                            <path fill="#2962ff"
                                  d="M15,36V6.827l-1.211-0.811C8.64,8.083,5,13.112,5,19v10c0,7.732,6.268,14,14,14h10	c4.722,0,8.883-2.348,11.417-5.931V36H15z"/>
                            <path fill="#eee"
                                  d="M29,5H19c-1.845,0-3.601,0.366-5.214,1.014C10.453,9.25,8,14.528,8,19	c0,6.771,0.936,10.735,3.712,14.607c0.216,0.301,0.357,0.653,0.376,1.022c0.043,0.835-0.129,2.365-1.634,3.742	c-0.162,0.148-0.059,0.419,0.16,0.428c0.942,0.041,2.843-0.014,4.797-0.877c0.557-0.246,1.191-0.203,1.729,0.083	C20.453,39.764,24.333,40,28,40c4.676,0,9.339-1.04,12.417-2.916C42.038,34.799,43,32.014,43,29V19C43,11.268,36.732,5,29,5z"/>
                            <path fill="#2962ff"
                                  d="M36.75,27C34.683,27,33,25.317,33,23.25s1.683-3.75,3.75-3.75s3.75,1.683,3.75,3.75	S38.817,27,36.75,27z M36.75,21c-1.24,0-2.25,1.01-2.25,2.25s1.01,2.25,2.25,2.25S39,24.49,39,23.25S37.99,21,36.75,21z"/>
                            <path fill="#2962ff" d="M31.5,27h-1c-0.276,0-0.5-0.224-0.5-0.5V18h1.5V27z"/>
                            <path fill="#2962ff"
                                  d="M27,19.75v0.519c-0.629-0.476-1.403-0.769-2.25-0.769c-2.067,0-3.75,1.683-3.75,3.75	S22.683,27,24.75,27c0.847,0,1.621-0.293,2.25-0.769V26.5c0,0.276,0.224,0.5,0.5,0.5h1v-7.25H27z M24.75,25.5	c-1.24,0-2.25-1.01-2.25-2.25S23.51,21,24.75,21S27,22.01,27,23.25S25.99,25.5,24.75,25.5z"/>
                            <path fill="#2962ff"
                                  d="M21.25,18h-8v1.5h5.321L13,26h0.026c-0.163,0.211-0.276,0.463-0.276,0.75V27h7.5	c0.276,0,0.5-0.224,0.5-0.5v-1h-5.321L21,19h-0.026c0.163-0.211,0.276-0.463,0.276-0.75V18z"/>
                        </svg>
                        Liên hệ báo giá zalo </a>
                </div>
            </div>
        </div>

    </div>
</div>
<div class="container py-4">
    <div class="list-group">
        <c:forEach var="item" items="${chapterList}">
            <%--<c:if test="${thisChapter == item.shortTitle}">
                <a href="<c:url value='/tin-tuc/${item.shortTitle}'/>"
                   class="list-group-item list-group-item-action list-group-item-light active">
                        &lt;%&ndash;                                <i class="fas fa-home"></i>&ndash;%&gt;
                        ${item.shortTitle}
                        &lt;%&ndash;                                <span class="badge badge-primary badge-pill"></span>&ndash;%&gt;
                </a>
            </c:if>--%>
            <%--<c:if test="${thisChapter != item.shortTitle}">--%>
                <a href="<c:url value='/tin-tuc/${item.shortTitle}'/>"
                   class="list-group-item list-group-item-action list-group-item-light">
                        <%--                                <i class="fas fa-home"></i>--%>
                        ${item.shortTitle}
                        <%--                                <span class="badge badge-primary badge-pill"></span>--%>
                </a>
            <%--</c:if>--%>

        </c:forEach>
    </div>
</div>
<div class="container py-4">
    <c:forEach items="${comments}" var="comment">
        <div class="comment">
            <p><strong>${comment.userFullName}</strong> - ${comment.createdDate}</p>
            <p>${comment.content}</p>
        </div>
    </c:forEach>
</div>
<div class="container py-4">
    <form action="your_comment_post_url" method="post">
        <div>
            <label for="content">Nội dung bình luận:</label>
        </div>
        <textarea id="content" name="content" rows="4" cols="50"></textarea><br>
    </br>
        <input type="submit" value="Gửi bình luận">
    </form>
</div>
<!-- Related product -->
<div class="py-4 px-1 w-100 seenGroup">
    <div class="container">
        <div class="mx-auto d-flex" id="footer">
            <div class="w-100">
                <div class='w-100 justify-content-center relatedProduct d-flex'><span class="mr-3">Sản Phẩm </span>
                    <div> Liên Quan</div>
                </div>
                <div class="mb-5 w-100 justify-content-center d-flex">
                    <div class="border"></div>
                </div>
            </div>
        </div>
        <div class="py-4 logoPro uk-position-relative uk-visible-toggle" uk-slider>
            <ul class="py-3 uk-slider-items uk-child-width-1-2 uk-child-width-1-4@s uk-child-width-1-6@m uk-grid-small">
                <c:forEach var="item" items="${relatedProducts}">
                    <li class=" position-relative">
                        <div class="seenItem py-2 flex-column justify-content-center  d-flex">
                            <c:if test="${not empty item.thumbnail}">
                                <c:set var="imageProduct" value="/repository${item.thumbnail}"/>
                            </c:if>
                            <c:if test="${empty item.thumbnail}">
                                <c:set var="imageProduct" value="/template/image/default.png"/>
                            </c:if>
                            <img src="${imageProduct}" alt="${imageProduct}"/>
                            <div class="position-absolute mt-2 codeSeen">${item.shortTitle}</div>
                            <div class=" position-absolute hide1">
                                <div class="text-left font-weight-bold" title="123.092121">${item.shortTitle}</div>
                                <div class='d-flex justify-content-between'>
                                    <div class="mr-1">Kích thước</div>
                                    <div class=" font-weight-bold value">${item.shortTitle} cm</div>
                                </div>
                                <%--<div class="detail"><a
                                        href="<c:url value="/san-pham/${item.productCategoryCode}/${item.code}"/>">xem
                                    chi tiết</a><i class="fas fa-long-arrow-alt-right"></i></div>--%>
                            </div>
                        </div>
                    </li>
                </c:forEach>
            </ul>
            <a class="uk-position-center-left uk-position-small" href="#" uk-slidenav-previous
               uk-slider-item="previous"></a>
            <a class="uk-position-center-right uk-position-small" href="#" uk-slidenav-next uk-slider-item="next"></a>
        </div>
    </div>
</div>

<script type="text/javascript">

    // imageZoom
    window.addEventListener('scroll', () => {
        document.documentElement.style.setProperty('--scroll-y', `${window.scrollY}px`);
    });

    function imageZoom(imgID, resultID) {

        var img, lens, result, cx, cy;
        img = document.getElementById(imgID);
        result = document.getElementById(resultID);

        /*create lens:*/
        lens = document.createElement("DIV");
        lens.setAttribute("class", "img-zoom-lens");

        /*insert lens:*/
        img.parentElement.insertBefore(lens, img);

        /*calculate the ratio between result DIV and lens:*/
        cx = result.offsetWidth / lens.offsetWidth;
        cy = result.offsetHeight / lens.offsetHeight;

        /*set background properties for the result DIV:*/
        result.style.backgroundImage = "url('" + img.src + "')";
        result.style.backgroundSize = (img.width * cx) + "px " + (img.height * cy) + "px";

        /*execute a function when someone moves the cursor over the image, or the lens:*/
        lens.addEventListener("mousemove", moveLens);
        img.addEventListener("mousemove", moveLens);

        /*and also for touch screens:*/
        lens.addEventListener("touchmove", moveLens);
        img.addEventListener("touchmove", moveLens);

        function moveLens(e) {
            var pos, x, y;
            /*prevent any other actions that may occur when moving over the image:*/
            e.preventDefault();
            /*get the cursor's x and y positions:*/
            pos = getCursorPos(e);
            /*calculate the position of the lens:*/
            x = pos.x - (lens.offsetWidth / 2);
            y = pos.y - (lens.offsetHeight / 2);
            /*prevent the lens from being positioned outside the image:*/
            if (x > img.width - lens.offsetWidth) {
                x = img.width - lens.offsetWidth;
            }
            if (x < 0) {
                x = 0;
            }
            if (y > img.height - lens.offsetHeight) {
                y = img.height - lens.offsetHeight;
            }
            if (y < 0) {
                y = 0;
            }
            /*set the position of the lens:*/
            lens.style.left = x + "px";
            lens.style.top = y + "px";
            /*display what the lens "sees":*/
            result.style.backgroundPosition = "-" + (x * cx) + "px -" + (y * cy) + "px";
        }

        function getCursorPos(e) {
            var a, x = 0, y = 0;
            e = e || window.event;
            /*get the x and y positions of the image:*/
            a = img.getBoundingClientRect();
            /*calculate the cursor's x and y coordinates, relative to the image:*/
            x = e.pageX - a.left;
            y = e.pageY - a.top;
            /*consider any page scrolling:*/
            x = x - window.pageXOffset;
            y = y - window.pageYOffset;
            return {x: x, y: y};
        }
    }

    const productsImgStr = `${product.thumbnail}`;
    let productsImg = productsImgStr.split(",");
    var activeImage = "/repository${defaultImage}";
    if (productsImg != null) {
        for (let i = 0; i < productsImg.length; i++) {
            productsImg[i] = `/repository${productsImg[i]}`
        }
    }

    function closeModal() {
        document.getElementById('preview-product').style = "display: none";
        document.getElementsByTagName('body')[0].classList.remove('modal-open');
    };

    function showModal() {
        document.getElementById('preview-product').style = `
        position: absolute;
        top:0;
        left:0;
        height:100%;
        width: 100%;
        background: black;
        z-index: 101;
        display: block`;
        document.getElementsByTagName('body')[0].className = 'modal-open';
    }

    function setActiveImage(image) {
        activeImage = image;
        document.getElementById("zoom_01").src = activeImage
    }

</script>
</body>
</html>
