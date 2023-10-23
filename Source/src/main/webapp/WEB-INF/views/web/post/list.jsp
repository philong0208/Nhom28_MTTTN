<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/tieu-thuyet"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form:form modelAttribute="model" action="${formUrl}" id="formSearch" method="GET">
<!-- breadcrumb -->
<div class=" bread-link">
    <div class='container'>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="text-uppercase breadcrumb-item"><a href="/">TRANG CHỦ</a></li>
                <li class="text-uppercase breadcrumb-item"><a href="/san-pham">SẢN PHẨM</a></li>
                <%--<li class="text-uppercase breadcrumb-item active" aria-current="page">${category.name}</li>--%>
            </ol>
        </nav>
    </div>
</div>
<!--product-->
<div class="product">

    <!--introduction-->
    <div class="introduction">
        <div class="backdrop h-100 py-5">
            <div class="container h-100">
                <div class="row h-100">
                    <div class="col-md-4 col-sm-12 d-flex align-items-center title pl-md-5">
                        <%--<p class="text-white font-weight-bold ml-md-5">${category.name}</p>--%>
                    </div>
                    <div class="col-md-8 col-sm-12 d-flex align-items-center description text-white">
                        <div>
                            <%--<p>${category.shortDescription}</p>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--filter-->
    <div class="filter p-3">
        <div class="row mw-100 m-auto">
            <div class="col-md col-sm-3 item">
                <div class="form-group">
                    <label for="productCode">Tên tiểu thuyết</label>
                    <form:input path="shortTitle" cssClass="form-control" id="productCode"/>
                </div>
            </div>
            <div class="col-md col-sm-3 item">
                <div class="form-group">
                    <label for="tagNameStr">Thể loại</label>
                    <form:select path="tagNameStr" id="tagNameStr" cssClass="form-control">
                        <form:option value="" label="--- Chọn thể loại ---"/>
                        <form:options items="${tags}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-md col-sm-3 item">
                <div class="form-group">
                    <label for="authorNameStr">Tác giả</label>
                    <form:select path="authorNameStr" id="authorNameStr" cssClass="form-control">
                        <form:option value="" label="--- Chọn kích thước ---"/>
                        <form:options items="${authors}"/>
                    </form:select>
                </div>
            </div>
            <div class="col-md col-sm-3 item d-flex align-items-center">
                <button type="button" class="search btn mt-3 border-radius-20" id="btnSearch">Tìm kiếm</button>
            </div>
        </div>
    </div>

    <!--list-->
    <div class="list container-fluid">
        <div class="row py-3">
            <c:if test="${empty model.listResult}">
                <p class="ml-5">Không tìm thấy sản phẩm...</p>
            </c:if>
            <c:if test="${not empty model.listResult}">
                <c:forEach var="item" items="${model.listResult}">
                    <div class="col-md-3 col-sm-6 py-5">
                        <div class="item w-100 position-relative" id="item-1">
                            <c:if test="${not empty item.thumbnail}">
                                <c:set var="image" value="/repository${item.thumbnail}"/>
                            </c:if>
                            <c:if test="${empty item.thumbnail}">
                                <c:set var="image" value="/template/image/default.png"/>
                            </c:if>
                            <a href="<c:url value="/tieu-thuyet/${item.shortTitle}-${item.id}"/>" class="w-100 h-100">
                                <img src="${image}" class="w-100 h-100  img-target">
                            </a>
                            <div>
                                <p class="mb-0"><strong>${item.shortTitle}</strong></p>
                                <%--<p class="mb-0"><strong>Kích thước</strong> <small>${item.sizeName} cm</small></p>
                                <p class="mb-0"><strong>Nhãn hiệu</strong> <small>ITALIANHOME</small></p>--%>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>

        </div>
    </div>
    <div class="d-flex mt-5 justify-content-center">
        <nav aria-label="...">
            <!--pagination-->
            <ul class="pagination" id="pagination"></ul>
        </nav>
    </div>
    <form:hidden path="page" id="page"/>
    </form:form>

</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnSearch').click(function (e) {
            e.preventDefault();
            $('#page').val(1);
            $('#formSearch').submit();
        });
    });
    var totalPages = ${model.totalPages};
    var currentPage = ${model.page};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 5,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#page').val(page);
                    $('#formSearch').submit();
                }
            },
            // Text labels
            first:'Trang đầu',
            prev:'Trang trước',
            next:'Tiếp theo',
            last:'Trang cuối',
        });
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
