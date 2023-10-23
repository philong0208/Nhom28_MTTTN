<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--menu--%>
<div id="backdrop" onclick="closeNav()"></div>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="<c:url value="/trang-chu"/>">Trang chủ</a>
    <a href="<c:url value="/tieu-thuyet"/>">Tiểu thuyết</a>
    <a href="<c:url value="/tieu-thuyet"/>">Giới thiệu</a>
    <div class="d-flex align-items-center justify-content-between pr-3 cursor-pointer item" data-toggle="collapse" data-target="#collapseOne"
         aria-expanded="false" aria-controls="collapseOne"><a href="/san-pham" >Tiểu thuyết </a><i id="icon-collapseOne" class="fas fa-plus"></i></div>
    <div id="collapseOne" class="collapse ml-2 categories">
    </div>
    <a href="<c:url value="/tuyen-dung"/>">Thể loại</a>
    <a href="<c:url value="/tin-tuc"/>">Tác giả</a>
    <a href="<c:url value="/lien-he"/>">Nhóm dịch</a>
</div>
<%--menu--%>
<div class="top-header d-none d-lg-block">
    <div class="container h-100">
        <div class="row justify-content-end h-100">
            <div class="col-4 h-100">
                <div class="row h-100 align-items-center">
                    <a href="tel:02838639377" class="m-0 px-4 px-2 ml-auto text-white"><i class="fa-solid fa-phone"></i> Hotline: 028 - 999999</a>
                </div>
            </div>
            <div class="col-2 h-100">
                <div class="row h-100 align-items-center">
                    <div class="list-icon ml-auto h-100">
                        <a href="https://www.facebook.com/congtygachmennhay/" target="_blank">
                            <img src="<c:url value="/template/web/images/icons8-facebook.svg"/>" alt="facebook" class="h-100 cursor-pointer"/>
                        </a>
                        <a href="https://zalo.me/0903197896" target="_blank">
                            <img src="<c:url value="/template/web/images/icons8-zalo.svg"/>" alt="zalo" class="h-100 cursor-pointer"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--navbar-->
<div class="shadow sticky bg-light">
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <p class="cursor-pointer" onclick="openNav()">
                <i class="fas fa-bars"></i>
                Menu
            </p>
            <a class="navbar-logo m-auto" href="<c:url value="/"/>">
                <c:set var="logo" value="/repository/logo.png"/>
                <img src="${logo}" class="w-100">
                <p class="text-center mb-0 text-dark" style="font-size: 8px;font-weight: bold;">Light novel</p>
            </a>
        </nav>
    </div>
</div>




