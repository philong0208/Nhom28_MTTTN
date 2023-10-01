<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<!-- start blog post section -->
<section class="blogs">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 sm-margin-50px-bottom xs-margin-35px-bottom">
                <div class="posts">
                    <!--  start post-->
                    <div class="post">
                        <div class="content">
                            ${model.content}
                        </div>
                    </div>
                    <!--  end post-->
                </div>
            </div>
        </div>
    </div>
</section>
<%--<script async defer crossorigin="anonymous"
        src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v14.0&appId=495626718735108&autoLogAppEvents=1"
        nonce="UX4xoKmu"></script>
<div class="comment-box">
    <div class="container">
        <div id="facebookComment" class="fb-comments"
             data-width="900" data-numposts="5"></div>
    </div>
</div>
<script type="application/javascript">
    document.getElementById("facebookComment").setAttribute("data-href",window.location.href);
</script>--%>
</body>
</html>
