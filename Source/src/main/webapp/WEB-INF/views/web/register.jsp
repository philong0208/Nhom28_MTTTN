<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/taglib.jsp" %>
<c:url var="formUrl" value="/api/contact/send-email"/>
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
                <li class="text-uppercase breadcrumb-item active" aria-current="page">ĐĂNG KÝ</li>
            </ol>
        </nav>
    </div>
</div>
<!-- contact -->
<div class="pb-5 contact">
<%--    <div class="position-relative banner">
        <div class="container">
            <div class="px-3 py-3 position-absolute ">
                <div class="text-white flex-wrap px-md-5 py-md-5 d-flex align-items-center title-contact">
                    <div class="bolder pl-md-5 mr-5 larger-text">Liên Hệ</div>
                    <div class=" pl-0 small-text">Liên hệ để nhận dịch vụ hổ trợ tốt nhất</div>
                </div>
            </div>
        </div>
    </div>--%>
    <div class="background-form">
        <div class="container">
            <div class="mx-3 px-3 b-5 py-4 my-md-3 mx-xl-5 px-xl-5 form-contact">
                <div class="alert alert-success" id="messageAlert">
                    <div id="messageContent"></div>
                </div>
                <div class="pt-md-5 text-center font-weight-bold inf-contact">Nội quy thành viên Light Novel</div>
                <div class="border my-3 mx-auto border"></div>
                <div class="row">
                    <div class=" col-12 col-md-6">
                        <div class="my-5 px-md-3">
                            <p dir="ltr"><strong><span style="font-size:16px">Về bình luận - đánh giá</span></strong></p>
                            <ul dir="ltr">
                                <li><span style="font-size:16px">Không dùng những lời lẽ...</span></li>
                                <li><span style="font-size:16px">Không tiết lộ nội dung...</span></li>
                            </ul>
                            <p dir="ltr"><strong><span style="font-size:16px">Nội dung truyện</span></strong></p>
                            <ul dir="ltr">
                                <li><span style="font-size:16px">Không đăng truyện có nội dung không phù hợp...</span></li>
                                <li><span style="font-size:16px">Không đăng lại truyện của người khác...</span></li>
                                <li><span style="font-size:16px">Tôn trọng quyền tác giả, xin phép ý kiến...</span></li>
                            </ul>
                            <p dir="ltr"><strong><span style="font-size:16px">Giới hạn quyền</span></strong></p>
                            <ul dir="ltr">
                                <li><span style="font-size:16px">Chỉ được đăng truyện + chương + tác giả</span></li>
                                <li><span style="font-size:16px; color: red; font-weight: bold">Chỉ được đăng truyện thuộc thể loại cho phép</span></li>
                                <li><span style="font-size:16px;">Trường hợp cần thể loại mới, liên hệ trực tiếp admin</span></li>
                            </ul>
                            <p dir="ltr"><strong><span style="font-size:16px">Mọi yêu cầu phê duyệt sớm liên hệ trực tiếp qua</span></strong></p>
                            <ul dir="ltr">
                                <li><span style="font-size:16px">Admin 1: Bùi Phi Minh - 0123.456.789</span></li>
                                <li><span style="font-size:16px">Admin 2: Nguyễn Phạm Nhật Long - 0987.654.321</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-12 col-md-6">
                        <div class="alert alert-success alert-dismissible" id="showMessage" style="display: none">
                            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                            <span id="message"></span>
                        </div>
                        <form:form id="formMail">
                            <div class="mt-md-5 mr-md-4 px-md-3">
                                <label for="fullName">Tên đăng nhập</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="username" placeholder="Tên đăng nhập*" required/>
                            </div>
                            <div class="mt-md-5 mr-md-4 px-md-3">
                                <label for="fullName">Tên hiển thị</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="fullName" placeholder="Tên hiển thị*" required/>
                            </div>
                            <div class="mt-3 mr-md-4 px-md-3">
                                <label for="email">Email</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="email" placeholder="Email*" required/>
                            </div>
                            <div class="mt-3 mr-md-4 px-md-3">
                                <label for="phone">Số điện thoại</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="phone" placeholder="Số điện thoại*" required/>
                            </div>
                            <div class="mt-3 mr-md-4 px-md-3">
                                <label for="phone">Mật khẩu</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="password" placeholder="Mật khẩu*" required/>
                            </div>
                            <div class="mt-3 mr-md-4 px-md-3">
                                <label for="phone">Xác nhận mật khẩu</label>
                                <input type="text" class="w-100 mx-md-4 py-2 px-2 form-text" id="confirmPassword" placeholder="Xác nhận mật khẩu*" required/>
                            </div>
                            <div class="mt-3 pt-4  mr-md-4 px-md-3">
                                <button id="btnSend" type="button"
                                  class='button d-flex mx-md-4 w-100 justify-content-center text-white font-weight-bold ml-auto px-5 py-2 buttonCustomer'>Đăng ký</button>
                            </div>
                        </form:form>
                    </div>
                    <div class=" col-12 col-md-6">
                        <div class="contact-info-map">
                            <iframe
                                    width="900" height="300"
                                    frameborder="0" style="border:0"
                                    src="<c:out value="${contactDTO.infoMap}"/>" allowfullscreen>
                            </iframe>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $( document ).ready(function() {
        $('#messageAlert').hide();
        $('#btnSend').click(function (event) {
            event.preventDefault();
            var formData = {}
            formData['fullName'] =  $("#fullName").val()
            formData['email'] =  $("#email").val()
            formData['phone'] =  $("#phone").val()
            formData['content'] =  $("#content").val()
            addMail(formData);
        });

        function addMail(data) {
            $.ajax({
                url: '${formUrl}',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    $("#messageAlert").show()
                    $('#messageContent').html("Liên hệ thành công")
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
