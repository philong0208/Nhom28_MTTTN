package com.laptrinhjavaweb.payment.nganluong;

public class Constant {
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


    public static String VERSION_3_1 = "3.1";

    public static String VERSION_3_2 = "3.2";

    public static String PAYMENT_METHOD_ATM_ONLINE = "ATM_ONLINE";

    public static String PAYMENT_METHOD_NL = "NL";

    public static String RC_AUTHENTICATE = "PAYMENT_METHOD_NL";

    /**
     * Hằng khai báo giúp bạn xác định trạng thái giao dịch thành công,
     * khi khởi tạo lệnh [[VRC_PURCHASE_SUCCESS]] hoặc [[RC_QUERY_DR]] tại phương thức [[request()]] hoặc [[verifyRequest()]].
     */
    public static String TRANSACTION_STATUS_SUCCESS = "00";

    /**
     * Hằng khai báo giúp bạn xác định trạng thái giao dịch thàng công nhưng Ngân Lượng tạm giữ,
     * khi khởi tạo lệnh [[VRC_PURCHASE_SUCCESS]] hoặc [[RC_QUERY_DR]] tại phương thức [[request()]] hoặc [[verifyRequest()]].
     */
    public static String TRANSACTION_STATUS_PENDING = "01";

    /**
     * Hằng khai báo giúp bạn xác định trạng thái giao dịch thất bại khách hàng không thanh toán hoặc lỗi,
     * khi khởi tạo lệnh [[VRC_PURCHASE_SUCCESS]] hoặc [[RC_QUERY_DR]] tại phương thức [[request()]] hoặc [[verifyRequest()]].
     */
    public static String TRANSACTION_STATUS_ERROR = "02";

}
