<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/admin/post"/>
<html>
<head>
    <title>${model.shortTitle}</title>
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
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa tiểu thuyết</li>
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
                            <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                            <div class="col-sm-9">
                                <form:select path="categoryCode" id="categoryCode">
                                    <form:option value="" label="--- Chọn thể loại ---"/>
                                    <form:options items="${categories}"/>
                                </form:select>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề ngắn</label>
                            <div class="col-sm-9">
                                <form:input path="shortTitle" id="title" cssClass="form-control"/>
                            </div>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thumbnail tiểu thuyết:</label>
                            <div class="col-sm-4">
                                <input type="file" id="uploadImage"/>
                            </div>
                            <div class="col-sm-5" style="margin-bottom: 10px">
                                <c:if test="${not empty model.thumbnail}">
                                    <c:set var="image" value="/repository${model.thumbnail}"/>
                                    <img src="${image}" id="viewImage" width="300px" height="300px">
                                </c:if>
                                <c:if test="${empty model.thumbnail}">
                                    <img src="<c:url value='/template/image/default.png'/>" id="viewImage" width="300px"
                                         height="300px">
                                </c:if>
                            </div>
                            <br/>
                        </div>
                        <br/>
                        <br/>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung tiểu thuyết</label>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12" style="margin-bottom: 10px">
                                <form:textarea path="content" cols="80" rows="10" id="content"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Cập nhật tiểu thuyết" id="btnAddOrUpdatePost"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold"
                                           value="Thêm mới tiểu thuyết" id="btnAddOrUpdatePost"/>
                                </c:if>
                                <a href="<c:url value="/format-editor-help-147"/>"
                                   class="btn btn-white btn-warning btn-bold" role="button">Format khi soạn thảo</a>
                            </div>
                        </div>
                        <form:hidden path="id" id="postId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var editor = '';
    var thumbnailBase64 = '';
    var thumbnailImageName = '';
    var ogImageBase64 = '';
    var ogImageName = '';
    var id = $('#postId').val();
    $(document).ready(function () {
        const configCKEditor = {
            allowedContent: true,
            filebrowserBrowseUrl: '/ckfinder/ckfinder.html',
            filebrowserImageBrowseUrl: '/ckfinder/ckfinder.html?type=Images',
            filebrowserFlashBrowseUrl: '/ckfinder/ckfinder.html?type=Flash',
            filebrowserUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
            filebrowserImageUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
            filebrowserFlashUploadUrl: '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
        }
        editor = CKEDITOR.replace('content', configCKEditor);

        if (id == "78" || id == "33" || id == "84") {
            for (let i = 1; i <= 13; i++) {
                const contentId = 'content' + i;
                CKEDITOR.replace(contentId, configCKEditor);
                let content_init = $('#' + contentId).val();
                $("#" + contentId).val(content_init);
            }
        }
    });

    $('#btnAddOrUpdatePost').click(function (event) {
        event.preventDefault();
        var data = {};
        var formData = $('#formEdit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });
        data["content"] = editor.getData();
        if (thumbnailBase64 != '') {
            data['thumbnailBase64'] = thumbnailBase64;
            data['thumbnailImageName'] = thumbnailImageName;
        }
        if (ogImageBase64 != '') {
            data['ogImageBase64'] = ogImageBase64;
            data['ogImageName'] = ogImageName;
        }
        if (id == "78" || id == "33" || id == "84") {
            for (let i = 1; i <= 13; i++) {
                const contentId = 'content' + i;
                data[contentId] = CKEDITOR.instances['content' + i].getData()
            }
        }
        if (id == "") {
            addPost(data);
        } else {
            updatePost(data);
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
                window.location.href = "<c:url value='/admin/post/edit?id="+res.id+"&message=insert_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/post/edit?message=error_system'/>";
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
                window.location.href = "<c:url value='/admin/post/edit?id="+res.id+"&message=update_success'/>";
            },
            error: function (res) {
                window.location.href = "<c:url value='/admin/post/edit?id="+res.id+"&message=error_system'/>";
            }
        });
    }

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function (e) {
            thumbnailBase64 = e.target.result;
            thumbnailImageName = file.name;
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    $('#uploadOgImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function (e) {
            ogImageBase64 = e.target.result;
            ogImageName = file.name;
        };
        reader.readAsDataURL(file);
        openImage(this, "viewOgImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' + imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

</script>
</body>
</html>
