<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--footer-->
<div class="footer py-4 mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-4">
                <a class="footer-logo" href="/">
                    <img src="<c:url value="/template/image/logo.png"/>" alt="footer logo">
                </a>
                <ul class="list-unstyled text-small">
                    <li class="py-2"><a href="#"><span class="title font-weight-bold">Văn phòng</span>: Số 99 đường 99 Lý Thường Kiệt, Phường 99 - Quận 99</a></li>
                    <li class="py-2"><a href="#"><span class="title font-weight-bold">Nhà máy</span>: Khu Công Nghiệp 99 - Phường Mỹ Xuân - Thị Xã Phú Mỹ - Tỉnh 99</a></li>
                    <li class="py-2"><a href="#"><span class="title font-weight-bold">Tel</span>: 0254-9999 / 99999</a></li>
                    <li class="py-2"><a href="#"><span class="title font-weight-bold">Hotline</span>: 028 3863 9999</a></li>
                </ul>
            </div>
            <div class="col-md-4 col-4">
                <h3 class="py-2 footer-title"><a href="#">Thông tin</a></h3>
                <ul class="list-unstyled text-small">
                    <li class="py-2"><a href="<c:url value="/gioi-thieu"/>">Giới thiệu</a></li>
                    <li class="py-2"><a href="<c:url value="/tin-tuc"/>">Tin tức</a></li>
                    <li class="py-2"><a href="<c:url value="/lien-he"/>">Liên hệ</a></li>
                </ul>
            </div>
            <div class="col-md-4 col-4">
                <h3 class="py-2 footer-title"><a href="#">Tiểu thuyết</a></h3>
                <ul class="list-unstyled text-small">
                    <li class="py-2"><a href="<c:url value="/san-pham?productCategoryCode=gach-lat-nen&page=1"/>">Thể loại 1</a></li>
                    <li class="py-2"><a href="<c:url value="/san-pham?productCategoryCode=gach-men-bong&page=1"/>">Thể loại 2</a></li>
                    <li class="py-2"><a href="<c:url value="/san-pham?productCategoryCode=gach-op-tuong&page=1"/>">Thể loại 3</a></li>
                    <li class="py-2"><a href="<c:url value="/san-pham?productCategoryCode=gach-trang-tri&page=1"/>">Thể loại 4</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="container text-center py-4">
        <div class="copyright">Copyright © <span id="copyright"></span> - Công Ty TNHHg Light Novel</div>
    </div>
</div>
<script>document.getElementById('copyright').appendChild(document.createTextNode(new Date().getFullYear()))</script>
<%--footer--%>
<div class='arrowUp' id="arrowUp" type='button' onclick="scrolltop()"><i class="fa fa-long-arrow-alt-up" style="font-size:20px; color: white"></i></div>
