<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- start footer section -->
<c:url var="formUrl" value="/api/web/email"/>
<footer>
    <div class="container" style="padding-bottom: 80px">
        <div id="footer-menu" class="footer-5 footer-style3">
            <div class="row">
                <div class="col-lg-3 col-md-6 sm-margin-25px-bottom mobile-margin-20px-bottom">
                    <div class="sm-padding-50px-right xs-no-padding-right">
                        <p class="no-margin-bottom">Công ty TNHH công nghệ LAPTRINHJAVAWEB</p>
                        <p class="no-margin-bottom">MST/ĐKKD/QĐTL: 0316791735</p>
                    </div>
                </div>
                <div id="f-menu"></div>
                <div class="col-lg-3 col-md-6">
                    <h4 class="mobile-margin-10px-bottom">Liên hệ</h4>
                    <ul class="">
                        <li><i class="ti-location-pin margin-10px-right md-margin-two-right text-theme-color"></i>52/27 Đường số 4, Phường Hiệp Bình Phước, Thành Phố Thủ Đức, Hồ Chí Minh</li>
                        <li><i class="ti-email margin-10px-right md-margin-two-right text-theme-color"></i>cskh@lightnovel.com</li>
                        <li><i class="ti-mobile margin-10px-right md-margin-two-right text-theme-color"></i>Hotline: 0354.502.773 / 0819.423.713/ 0909.804.713</li>
                    </ul>

                    <div class="footer-icon">
                        <ul class="no-margin-bottom">
                            <li>
                                <a href="https://www.facebook.com/laptrinhjavaweb"><i class="fab fa-facebook-f"></i></a>
                            </li>
                            <li>
                                <a href="https://www.youtube.com/laptrinhjavaweb"><i class="fab fa-youtube "></i></a>
                            </li>
                        </ul>
                    </div>
                    <div style="padding-top: 20px">
                        <a href="//www.dmca.com/Protection/Status.aspx?id=726372f3-606a-410c-bcfd-ba23442dd20a&refurl=https://laptrinhjavaweb.com/trang-chu" title="DMCA.com Protection Status" class="dmca-badge" target="_blank"> <img src ="https://images.dmca.com/Badges/dmca_protected_sml_120m.png?ID=726372f3-606a-410c-bcfd-ba23442dd20a"  alt="DMCA.com Protection Status" /></a>  <script src="https://images.dmca.com/Badges/DMCABadgeHelper.min.js"> </script>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<script>

    $('#btnSignMail').click(function (event) {
        event.preventDefault();
        var data = {};
        var formData = $('#formMail').serializeArray();
        var email = '';
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        $.each(formData, function (i,v) {
            if (v.name == 'email') {
                email = v.value;
            }
            data[""+v.name+""] = v.value;
        });
        if (email == '') {
            alert("Email không để trống!");
        } else if(!emailReg.test(email)) {
            alert("Email không hợp lệ!");
        } else if (!email.match(/^[A-Za-z0-9._%+-]+@gmail.com$/)) {
            alert("Email must gmail!");
        } else {
            addMail(data);
        }
    });

    function addMail(data) {
        $.ajax({
            url: '${formUrl}',
            type: 'POST',
            dataType: 'json',
            contentType:'application/json',
            data: JSON.stringify(data),
            success: function(res) {
                alert("Đăng ký thành công");
            },
            error: function(res) {
                alert("Đăng ký thất bại");
            }
        });
    }
</script>
<!-- end footer section -->
