<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/admin/menu"/>
<html>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa Menu</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="text-left">
                    <a role="button" onclick="window.history.go(-1); return false;" style="cursor: pointer;">
                        <i class="ace-icon fa fa-angle-double-left"></i>
                        Back
                    </a>
                </div>
            </div>
            </br>
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
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-9">
                                <form:input path="name" id="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Menu Parent</label>
                            <div class="col-sm-9">
                                <form:select path="parentId" id="parentId">
                                    <form:option value="" label="--- Chọn ---"/>
                                    <form:options items="${parents_id}"/>
                                </form:select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Vị trí</label>
                            <div class="col-sm-9">
                                <form:select path="position" id="position">
                                    <form:option value="" label="--- Chọn ---"/>
                                    <form:options items="${positions}"/>
                                </form:select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thứ tự</label>
                            <div class="col-sm-9">
                                <form:input type="number" path="index" id="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">URL</label>
                            <div class="col-sm-9">
                                <form:input path="url" id="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">
                                Open New Tab
                            </label>
                            <div class="col-sm-9">
                                <input id="newTab" checked="${newTab}" name="switch-field-1"
                                       class="ace ace-switch ace-switch-2" type="checkbox">
                                <span class="lbl"></span>
                            </div>

                        </div>
                        <div class="row">
                            <c:if test="${not empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold pull-right" style="margin-right: 3%;"
                                       value="Cập nhật" id="btnAddOrUpdate"/>
                            </c:if>
                            <c:if test="${empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold pull-right" style="margin-right: 3%;"
                                       value="Thêm mới" id="btnAddOrUpdate"/>
                            </c:if>
                        </div>
                        <form:hidden path="id" id="id"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnAddOrUpdate').click(function (event) {
        event.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (i, v) {
            if (v.name == "parentId") {
                data["" + v.name + ""] = parseInt(v.value);
            } else {
                data["" + v.name + ""] = v.value;
            }
        });
        var id = $('#id').val();
        if (id && id.length > 0) {
            updatePost(data);
        } else {
            addPost(data);
        }
    });

    function addPost(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value='/admin/menu-page/list?id="+res.id+"&message=insert_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/menu-page/edit?message=error_system'/>";
            }
        });
    }

    function updatePost(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'PUT',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (res) {
                window.location.href = "<c:url value='/admin/menu-page/list?id="+res.id+"&message=update_success'/>";
            },
            error: function (res) {
            }
        });
    }


</script>
</body>
</html>
