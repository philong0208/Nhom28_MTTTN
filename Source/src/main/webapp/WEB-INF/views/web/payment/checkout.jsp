<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <title>Thanh toán online</title>
    <meta name="description" content="A Template by Gozha.net">
    <meta name="keywords" content="HTML, CSS, JavaScript">
    <meta name="author" content="Gozha.net">
    <content tag="local_css">
        <link rel="stylesheet" type="text/css" href="/template/web/css/plugins/payment.css">
    </content>
</head>

<body>
<div class="padding-40px-all sm-padding-30px-all xs-padding-20px-all bg-light-gray">
    <h4 class="font-size38 sm-font-size34 xs-font-size28 line-height-45 sm-line-height-40 font-weight-500 margin-10px-bottom text-center">
        Chọn phương thức thanh toán</h4>
    <div class="d-flex justify-content-center">
        <div class="payment d-flex">
            <table style="clear:both;width:500px;padding-left:46px;">
                <tr>
                    <td colspan="2"><p><span
                            style="color:#ff5a00;font-weight:bold;text-decoration:underline;">Lưu ý</span>
                        Bạn nhập đầy đủ thông tin sau</td>
                </tr>
                <tr>
                    <td>Nhập tiền:</td>
                    <td>
                        <input type="text" style="width:270px" id="price" name="price" class="field-check currencyMask"
                               value=""> VND
                    </td>
                </tr>
                <tr>
                    <td>Họ Tên:</td>
                    <td>
                        <input type="text" style="width:270px" id="buyer_fullname" name="buyer_fullname"
                               class="field-check " value="">
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <input type="text" style="width:270px" id="buyer_email" name="buyer_email"
                               class="field-check " value="">
                    </td>
                </tr>
                <tr>
                    <td>Số Điện thoại:</td>
                    <td>
                        <input type="text" style="width:270px" id="buyer_mobile" name="buyer_mobile"
                               class="field-check " value="">
                    </td>
                </tr>
            </table>
            <%@ include file="/WEB-INF/views/web/payment/paymentNganluong.jsp" %>
        </div>
    </div>
     </br>
    <div class="Send pull-right">
        <a id="order" class="butn">Thanh toán</a>
    </div>
    </form>
    </br>
    </br>
</div>

</body>
</html>
