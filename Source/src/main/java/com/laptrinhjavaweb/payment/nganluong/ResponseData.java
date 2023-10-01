package com.laptrinhjavaweb.payment.nganluong;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResponseData {

    private String checkout_url;
    private String token;
    private String error_code;
    private String description;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    /**
     * Mảng tổng hợp các message mà Ngân Lượng sẽ trả về.
     *
     * @var array
     */
    Map<String, String> responseMessages = Stream.of(new String[][]{
            {"Hello", "World"},
            {"00", "Thành công"},
            {"99", "Lỗi chưa xác minh"},
            {"06", "Mã merchant không tồn tại hoặc bị khóa"},
            {"02", "Địa chỉ IP truy cập bị từ chối"},
            {"03", "Mã checksum không chính xác, truy cập bị từ chối"},
            {"04", "Tên hàm API do merchant gọi tới không hợp lệ (không tồn tại)"},
            {"05", "Sai version của API"},
            {"07", "Sai mật khẩu của merchant"},
            {"08", "Địa chỉ email tài khoản nhận tiền không tồn tại"},
            {"09", "Tài khoản nhận tiền đang bị phong tỏa giao dịch"},
            {"10", "Mã đơn hàng không hợp lệ"},
            {"11", "Số tiền giao dịch lớn hơn hoặc nhỏ hơn quy định"},
            {"12", "Loại tiền tệ không hợp lệ"},
            {"29", "Token không tồn tại"},
            {"80", "Không thêm được đơn hàng"},
            {"81", "Đơn hàng chưa được thanh toán"},
            {"110", "Địa chỉ email tài khoản nhận tiền không phải email chính"},
            {"111", "Tài khoản nhận tiền đang bị khóa"},
            {"113", "Tài khoản nhận tiền chưa cấu hình là người bán nội dung số"},
            {"114", "Giao dịch đang thực hiện, chưa kết thúc"},
            {"115", "Giao dịch bị hủy"},
            {"118", "tax_amount không hợp lệ"},
            {"119", "discount_amount không hợp lệ"},
            {"120", "fee_shipping không hợp lệ"},
            {"121", "return_url không hợp lệ"},
            {"122", "cancel_url không hợp lệ"},
            {"123", "items không hợp lệ"},
            {"124", "transaction_info không hợp lệ"},
            {"125", "quantity không hợp lệ"},
            {"126", "order_description không hợp lệ"},
            {"127", "affiliate_code không hợp lệ"},
            {"128", "time_limit không hợp lệ"},
            {"129", "buyer_fullname không hợp lệ"},
            {"130", "buyer_email không hợp lệ"},
            {"131", "buyer_mobile không hợp lệ"},
            {"132", "buyer_address không hợp lệ"},
            {"133", "total_item không hợp lệ"},
            {"134", "payment_method, bank_code không hợp lệ"},
            {"135", "Lỗi kết nối tới hệ thống ngân hàng"},
            {"140", "Đơn hàng không hỗ trợ thanh toán trả góp"}
    }).collect(Collectors.collectingAndThen(
            Collectors.toMap(data -> data[0], data -> data[1]),
            Collections::<String, String>unmodifiableMap));

    /**
     * @inheritdoc
     */
    public boolean getIsOk() {
        if (this.error_code != null) {
            return Constant.TRANSACTION_STATUS_SUCCESS.equals(this.error_code);
        }
        return false;
    }

    /**
     * Phương thức hổ trợ lấy câu thông báo `message` nhận từ Ngân Lượng.
     *
     * @return null|string Trả về NULL nếu như dữ liệu Ngân Lượng gửi về không tồn tại `error_code`,
     * và ngược lại sẽ là câu thông báo dịch từ `error_code`.
     */
    public String getMessage() {
        String message = null;
        if (this.error_code != null) {
            message = this.responseMessages.get(this.error_code);
        }
        return message;
    }

    public String getCheckout_url() {
        return checkout_url;
    }

    public void setCheckout_url(String checkout_url) {
        this.checkout_url = checkout_url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
