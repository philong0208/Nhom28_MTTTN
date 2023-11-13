<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/login/home.css' />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/login/login.css' />">
</head>
<body>
<form class="login py-4" action="j_spring_security_check" method="POST">
    <div class="wrap w-25 py-4 form-style">
        <c:if test="${param.incorrectAccount != null}">
            <div class="alert alert-danger">
                Tên đăng nhập hoặc mật khẩu sai
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
        <div class="form-group">
            <label for="username">Tên đăng nhập</label>
            <input type="text" class="form-control" id="username" name="j_username" required>
        </div>
        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="j_password" required>
        </div>
        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </div>
</form>

<%--jquery 2.1.4--%>
<script type='text/javascript' src='<c:url value="/template/login/jquery.min.js" />'></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
