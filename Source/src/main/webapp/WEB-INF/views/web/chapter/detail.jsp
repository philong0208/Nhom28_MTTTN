<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- breadcrumb -->
<div class=" bread-link">
    <div class='container'>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="text-uppercase breadcrumb-item"><a href="/">TRANG CHỦ</a></li>
                <li class="text-uppercase breadcrumb-item active" aria-current="page">TIN TỨC</li>
            </ol>
        </nav>
    </div>
</div>
<!--news-->
<div class="news">

    <!--news-body-->
    <div class="container py-4">
        <div class="row">
            <div class="col-md-3">
                <h2 class="text-center">Danh sách chương</h2>
                <div class="list-group">
                    <c:forEach var="item" items="${chapterList}">
                        <c:if test="${thisChapter == item.shortTitle}">
                            <a href="<c:url value='/tin-tuc/${item.shortTitle}'/>"
                               class="list-group-item list-group-item-action list-group-item-light active">
                                    <%--                                <i class="fas fa-home"></i>--%>
                                    ${item.shortTitle}
                                    <%--                                <span class="badge badge-primary badge-pill"></span>--%>
                            </a>
                        </c:if>
                        <c:if test="${thisChapter != item.shortTitle}">
                            <a href="<c:url value='/tin-tuc/${item.shortTitle}'/>"
                               class="list-group-item list-group-item-action list-group-item-light">
                                    <%--                                <i class="fas fa-home"></i>--%>
                                    ${item.shortTitle}
                                    <%--                                <span class="badge badge-primary badge-pill"></span>--%>
                            </a>
                        </c:if>

                    </c:forEach>
                </div>
                <iframe class="w-100 mt-3" src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fcongtygachmennhay&tabs=timeline&width=300&height=250&small_header=true&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"  style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
                <iframe class="w-100 mt-3" src="https://www.youtube.com/embed/LagT0M5CbZE">
                </iframe>
            </div>
            <div class="col-md-9">
                <!--post-item-->
                <div class="post-item my-3">
                    <div class="info d-flex align-items-center">
                        <p class="mr-1 name">${model.postShortTitle}</p>
                        <p class="day"> - ${model.createdDate}</p>
                    </div>
                    <h2> ${model.shortTitle}</h2>
                    <div class="content">
                        ${model.content}
                    </div>
                    <div class="share d-flex align-items-center py-4">
                        <p class="text mb-0 mx-2">Chia sẻ</p>
                        <i class="fab fa-facebook-f mx-2"></i>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${comments}" var="comment">
                <div class="comment">
                    <p><strong>${comment.userFullName}</strong> - ${comment.createdDate}</p>
                    <p>${comment.content}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>

</html>
