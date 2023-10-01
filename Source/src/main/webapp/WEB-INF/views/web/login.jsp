<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Đăng nhập</title>
    <!-- favicon -->
    <link rel="shortcut icon" href="/template/web/image/logo/favicon-java-web.png" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/home.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/login.css' />">
</head>
<body>
    <form class="login py-4" action="j_spring_security_check" method="POST">

        <div class="wrap w-25 py-4 form-style">
            <c:if test="${param.incorrectAccount != null}">
                <div class="alert alert-danger">
                    Tên đăng nhập hoặc mật khẩu sai!
                </div>
            </c:if>
            <c:if test="${param.accessDenied != null}">
                <div class="alert alert-danger">
                    Bạn không có quyền truy cập!
                </div>
            </c:if>
            <c:if test="${param.sessionTimeout != null}">
                <div class="alert alert-danger">
                    Phiên làm việc hết hạn, yêu cầu đăng nhập lại!
                </div>
            </c:if>
            <img id="logo" src="/template/web/image/logo/logo-java-web.png" alt="logo">
            <h3 class="text-center">Đăng nhập</h3>
            <div class="form-group">
                <label for="username">Tên đăng nhập</label>
                <input type="text" class="form-control" id="username" name="j_username" required>
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="j_password" required>
            </div>
            <button type="submit" class="btn btn-login btn-primary">Đăng nhập <svg aria-hidden="true" focusable="false" data-prefix="far" data-icon="right-to-bracket" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" class="svg-inline--fa fa-right-to-bracket"><path fill="currentColor" d="M192 365.8L302 256 192 146.2l0 53.8c0 13.3-10.7 24-24 24L48 224l0 64 120 0c13.3 0 24 10.7 24 24l0 53.8zM352 256c0 11.5-4.6 22.5-12.7 30.6L223.2 402.4c-8.7 8.7-20.5 13.6-32.8 13.6c-25.6 0-46.4-20.8-46.4-46.4l0-33.6-96 0c-26.5 0-48-21.5-48-48l0-64c0-26.5 21.5-48 48-48l96 0 0-33.6c0-25.6 20.8-46.4 46.4-46.4c12.3 0 24.1 4.9 32.8 13.6L339.3 225.4c8.1 8.1 12.7 19.1 12.7 30.6zm-8 176l80 0c22.1 0 40-17.9 40-40l0-272c0-22.1-17.9-40-40-40l-80 0c-13.3 0-24-10.7-24-24s10.7-24 24-24l80 0c48.6 0 88 39.4 88 88l0 272c0 48.6-39.4 88-88 88l-80 0c-13.3 0-24-10.7-24-24s10.7-24 24-24z" class=""></path></svg></button>
        </div>
    </form>

    <%--jquery 2.1.4--%>
    <script type='text/javascript' src='<c:url value="/template/web/js/jquery-2.1.4/jquery.min.js" />'></script>
    <script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
</body>
</html>
