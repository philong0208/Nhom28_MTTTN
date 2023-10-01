<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="formUrl" value="/admin/menu-page/list"/>
<c:url var="postAPI" value="/api/admin/menu"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách Menu</title>
</head>
<body>
<div class="main-content">
    <form:form modelAttribute="model" action="${formUrl}" id="listForm" method="GET">
        <div class="main-content-inner">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                    <li class="active">Danh sách menu</li>
                </ul><!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${messageResponse!=null}">
                            <div class="alert alert-block alert-${alert}">
                                <button type="button" class="close" data-dismiss="alert">
                                    <i class="ace-icon fa fa-times"></i>
                                </button>
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-btn-controls">
                                    <div class="pull-right tableTools-container">
                                        <div class="dt-buttons btn-overlap btn-group">
                                            <a flag="info" class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                               data-toggle="tooltip" title="Thêm" href='<c:url value="/admin/menu-page/edit"/>'>
                                                    <span>
                                                    <i class="fa fa-plus-circle bigger-110 purple"></i>
                                                </span>
                                            </a>
                                            <button id="btnDelete" type="button" class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" disabled
                                                    data-toggle="tooltip" title="Xóa bài viết" onclick="warningBeforeDelete()">
                                                    <span>
                                                    <i class="fa fa-trash-o bigger-110 pink"></i>
                                                	</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                                                   requestURI="${formUrl}"
                                                   partialList="true" size="${model.totalItems}" id="tableList"
                                                   pagesize="${model.maxPageItems}" export="false"
                                                   class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                                                   style="margin: 3em 0 1.5em;">
                                        <display:column title="<fieldset class='form-group'>
												        <input type='checkbox' id='checkAll' class='check-box-element'>
												        </fieldset>" class="center select-cell"
                                                        headerClass="center select-cell">
                                            <fieldset>
                                                <input type="checkbox" name="checkList" value="${tableList.id}" id="checkbox_${tableList.id}" class="check-box-element"/>
                                            </fieldset>
                                        </display:column>
                                        <display:column headerClass="text-left" property="id" title="Id"/>
                                        <display:column headerClass="text-left" title="Tiêu đề">
                                            <c:if test = "${tableList.parentId !=null}">
                                                &nbsp; &nbsp; |___
                                            </c:if>
                                           <span>${tableList.name}</span>
                                        </display:column>
                                        <display:column headerClass="text-left" property="url" title="URL"/>
                                        <display:column headerClass="text-left" property="index" title="Thứ tự"/>
                                        <display:column headerClass="text-left" title="Vị trí">
                                            <c:if test = "${tableList.position ==1}">
                                                <span class="badge badge-success">Header</span>
                                            </c:if>
                                            <c:if test = "${tableList.position == 2}">
                                                <span class="badge badge-dark">Footer</span>
                                            </c:if>
                                        </display:column>
                                        <display:column headerClass="col-actions" title="Thao tác">
                                            <c:url var="editPost" value="/admin/menu-page/edit">
                                                <c:param name="id" value="${tableList.id}"/>
                                            </c:url>
                                            <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                               title="Cập nhật bài viết" href='${editPost}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                            </a>
                                        </display:column>
                                    </display:table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form:form>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#btnSearch').click(function (e) {
            e.preventDefault();
            $('#listForm').submit();
        });
    });
    function warningBeforeDelete() {
        showAlertBeforeDelete(function () {
            event.preventDefault();
            var dataArray = $(' tbody input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            deletePost(dataArray);
        });
    }

    function deletePost(data) {
        $.ajax({
            url: '${postAPI}',
            type: 'DELETE',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                window.location.href = "<c:url value='/admin/menu-page/list?message=delete_success'/>";
            },
            error: function(res) {
                window.location.href = "<c:url value='/admin/menu-page/list?message=error_system'/>";
            }
        });
    }
</script>
</body>
</html>
