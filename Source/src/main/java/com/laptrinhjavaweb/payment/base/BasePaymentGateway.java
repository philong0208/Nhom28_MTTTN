package com.laptrinhjavaweb.payment.base;

import com.laptrinhjavaweb.payment.PaymentGateway;
import com.laptrinhjavaweb.payment.model.PaymentResponse;

import java.util.Map;

public abstract class BasePaymentGateway<T> extends BaseGateway<T> implements PaymentGateway<T> {
    /**
     * Lệnh `purchase` sử dụng cho việc khởi tạo truy vấn thanh toán.
     */
    public static String RC_PURCHASE = "purchase";

    /**
     * Lệnh `queryDR` sử dụng cho việc truy vấn thông tin giao dịch.
     */
    public static String RC_QUERY_DR = "queryDR";

    /**
     * Lệnh `refund` sử dụng cho việc tạo [[request()]] yêu cầu hoàn trả tiền.
     */
    public static String RC_REFUND = "refund";

    /**
     * Lệnh `queryRefund` sử dụng cho việc tạo [[request()]] để kiểm tra trang thái của lệnh `refund` đã tạo.
     */
    public static String RC_QUERY_REFUND = "queryRefund";

    /**
     * Lệnh `purchaseSuccess` sử dụng cho việc yêu cấu xác thực tính hợp lệ
     * của dữ liệu khi khách hàng thanh toán thành công (cổng thanh toán redirect khách hàng về server).
     */
    public static String VRC_PURCHASE_SUCCESS = "purchaseSuccess";

    /**
     * Lệnh `IPN` sử dụng cho việc yêu cấu xác thực tính hợp lệ
     * của dữ liệu khi khách hàng thanh toán thành công (cổng thanh toán bắn request về server).
     */
    public static String VRC_IPN = "IPN";

    /**
     * @event RequestEvent được gọi khi dữ liệu truy vấn đã được xác thực.
     * Lưu ý sự kiện này luôn luôn được gọi khi xác thực dữ liệu truy vấn.
     */
    public static String EVENT_VERIFIED_REQUEST = "verifiedRequest";

    /**
     * @event VerifiedRequestEvent được gọi khi dữ liệu truy vấn sau khi khách hàng thanh toán thành công,
     * được cổng thanh toán dẫn về hệ thống đã xác thực.
     */
    public static String EVENT_VERIFIED_REQUEST_PURCHASE_SUCCESS = "verifiedRequestPurchaseSuccess";

    /**
     * @event VerifiedRequestEvent được gọi khi dữ liệu truy vấn sau khi khách hàng thanh toán thành công,
     * được cổng thanh toán bắn `request` sang hệ thống đã xác thực.
     */
    public static String EVENT_VERIFIED_REQUEST_IPN = "verifiedRequestIPN";
    /**
     * @var bool nếu là môi trường test thì thiết lập là TRUE và ngược lại.
     */
    boolean sandbox = false;

    private String version;

    /**
     * Phương thức khởi tạo môi trường thử nghiệm.
     * Nó chỉ được gọi khi thuộc tính `sandbox` được thiết lập là TRUE.
     */
    abstract protected void initSandboxEnvironment();


    public PaymentResponse queryDR(Map<String, String> data, String clientId) throws Exception {
        return this.buildUrlFromRequestConfirm(data);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
