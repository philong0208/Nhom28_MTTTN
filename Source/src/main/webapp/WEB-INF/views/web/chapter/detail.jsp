<%@ page import="com.laptrinhjavaweb.security.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/admin/comment"/>
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
                            <a href="<c:url value='/tieu-thuyet/${postShortTitle}-${postId}/${item.shortTitle}-${item.id}'/>"
                               class="list-group-item list-group-item-action list-group-item-light active">
                                    <%--                                <i class="fas fa-home"></i>--%>
                                    ${item.shortTitle}
                                    <%--                                <span class="badge badge-primary badge-pill"></span>--%>
                            </a>
                        </c:if>
                        <c:if test="${thisChapter != item.shortTitle}">
                            <a href="<c:url value='/tieu-thuyet/${postShortTitle}-${postId}/${item.shortTitle}-${item.id}'/>"
                               class="list-group-item list-group-item-action list-group-item-light">
                                    <%--                                <i class="fas fa-home"></i>--%>
                                    ${item.shortTitle}
                                    <%--                                <span class="badge badge-primary badge-pill"></span>--%>
                            </a>
                        </c:if>

                    </c:forEach>
                </div>
                <%--<iframe class="w-100 mt-3" src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fcongtygachmennhay&tabs=timeline&width=300&height=250&small_header=true&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"  style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
                <iframe class="w-100 mt-3" src="https://www.youtube.com/embed/LagT0M5CbZE">--%>
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
        <c:if test="${alreadyHaveComment}">
            <div class="row">
                <div class="col-md-3">
                    <strong>Đánh giá của bạn:</strong>
                </div>
                <div class="col-md-9">
                        <div class="comment">
                            <p><strong>${yourComment.userFullName}</strong> - ${yourComment.createdDate}</p>
                            <p>${yourComment.content}</p>
                        </div>
                </div>
            </div>
        </c:if>
        <div class="row">
            <div class="col-md-3">
            </div>
            <div class="col-md-9">
                <c:if test="${SecurityUtils.notLoginYet()}">
                    <div class="mt-3 pt-4  mr-md-4 px-md-3">
                        <a href="<c:url value='/loginAdmin'/>">
                            <button id="login" type="button"
                                    class='button d-flex mx-md-4 w-100 justify-content-center text-white font-weight-bold ml-auto px-5 py-2 buttonCustomer'>Để lại đánh giá</button>
                        </a>
                    </div>
                </c:if>
                <c:if test="${not SecurityUtils.notLoginYet()}">
                    <form:form id="formMail">
                        <div class="mt-3 mr-md-4 px-md-3">
                            <label for="content">Nội dung bình luận</label>
                            <textarea class="w-100 mx-md-4 py-2 px-2 form-text" id="content"
                                      placeholder="Nội dung bình luận"></textarea>
                        </div>
                        <div class="mt-3 pt-4  mr-md-4 px-md-3">
                            <button id="btnSend" type="button" class='button d-flex mx-md-4 w-100 justify-content-center
                        text-white font-weight-bold ml-auto px-5 py-2 buttonCustomer'>
                                    ${alreadyHaveComment ? 'Đánh giá lại chương này' : 'Gửi đánh giá'}
                            </button>
                        </div>
                    </form:form>
                    <br/>
                    <div class="alert alert-success" id="messageAlert">
                        <div id="messageContent"></div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $( document ).ready(function() {
        $('#messageAlert').hide();
        $('#btnSend').click(function (event) {
            event.preventDefault();
            var formData = {}
            formData['content'] =  $("#content").val()
            formData['chapterId'] =  ${model.id}
            formData['userId'] =  ${yourUserId}
            comment(formData);
        });
        function comment(data) {
            $.ajax({
                url: '${formUrl}',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    $("#messageAlert").show()
                    $('#messageContent').html("Đánh giá thành công")
                    setTimeout(function() {
                        location.reload();
                    }, 1000);
                },
                error: function (res) {
                    $("#messageAlert").hide()
                    $('#messageContent').html("Liên hệ thất bại")
                }
            });
        }
    });
</script>
</body>
</html>
