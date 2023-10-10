<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/api/admin/category"/>
<html>
<head>
    <title>Chỉnh sửa nhóm dịch</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href='<c:url value="/admin/category/list"/>'>Danh sách nhóm dịch</a>
                </li>
                <li class="active">Chỉnh sửa nhóm dịch</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form id="formEdit" modelAttribute="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tên nhóm dịch</label>
                            <div class="col-sm-9">
                                <form:input path="name" id="name" cssClass="form-control"/>
                                <span id="nameVal" class="red" style="display: none;"></span><br/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mã nhóm dịch</label>
                            <div class="col-sm-9">
                                <form:input path="code" id="code" cssClass="form-control"/>
                                <span id="codeVal" class="red" style="display: none;"></span><br/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả</label>
                            <div class="col-sm-9" style="margin-bottom: 10px">
                                <form:textarea path="content" cols="80" rows="10" id="content" cssStyle="width: 943px; height: 72px"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật nhóm dịch" id="btnAddOrUpdateCategory"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới nhóm dịch" id="btnAddOrUpdateCategory"/>
                                </c:if>
                            </div>
                        </div>
                        <form:hidden path="id" id="categoryId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var editor = '';
    $(document).ready(function () {
        editor = CKEDITOR.replace( 'content');
    });

    $('#btnAddOrUpdateCategory').click(function (event) {
        event.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        var hasError = false;
        $('#nameVal').html('');
        $('#codeVal').html('');
        $('#nameVal').css('display', 'none');
        $('#codeVal').css('display', 'none');
        $.each(formData, function (i,v) {
            data[""+v.name+""] = v.value;
            if (v.name === "name" && v.value === "") {
                $('#nameVal').html('Tên không được để trống!');
                $('#nameVal').css('display', 'block');
                hasError = true;
            }
            if (v.name === "code" && !/^[a-zA-Z0-9-]+$/.test(v.value)) {
                $('#codeVal').html('Mã code không hợp lệ. Mã code chỉ bao gồm chữ cái, chữ số và dấu gạch ngang!');
                $('#codeVal').css('display', 'block');
                hasError = true;
            }
        });
        data["content"] = editor.getData();
        var id = $('#categoryId').val();
        if (!hasError) {
            if (id == "") {
                addCategory(data);
            } else {
                updateCategory(data);
            }
        } else {
            setTimeout(function () {
                $('#nameVal').css('display', 'none');
                $('#codeVal').css('display', 'none');
            }, 1500);
        }
    });

    function addCategory(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/admin/category/edit?id="+res.id+"&message=insert_success'/>";
            },
            error: function(res) {
                window.location.href = "<c:url value='/admin/category/edit?message=insert_failed'/>";
            }
        });
    }

    function updateCategory(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'PUT',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/admin/category/edit?id="+res.id+"&message=update_success'/>";
            },
            error: function(res) {
                window.location.href = "<c:url value='/admin/category/list?message=update_failed'/>";
            }
        });
    }

</script>
</body>
</html>
