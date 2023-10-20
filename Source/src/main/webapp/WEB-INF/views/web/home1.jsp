<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<div id="grapesjs-wrapper-content">
</div>
<script type="application/javascript">
    const grapContent = ${content};
    $('#grapesjs-wrapper-content').html(grapContent.html)
    $('#grapesjs-wrapper-content').append(`<style>${grapContent.css}</style>`)
</script>
</body>
</html>
