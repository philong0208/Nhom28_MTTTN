package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;

import java.util.HashMap;
import java.util.Map;

public class MessageResponseUtils {

    public static Map<String, String> getMessage(String message) {
        Map<String, String> results = new HashMap<>();
        if (message.equals(SystemConstant.INSERT_SUCCESS)) {
            results.put(SystemConstant.ALERT, "success");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Thêm dữ liệu thành công");
        } else if (message.equals(SystemConstant.UPDATE_SUCCESS)) {
            results.put(SystemConstant.ALERT, "success");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Cập nhật dữ liệu thành công");
        } else if (message.equals(SystemConstant.DELETE_SUCCESS)) {
            results.put(SystemConstant.ALERT, "success");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Xóa dữ liệu thành công");
        } else if (message.equals(SystemConstant.ERROR_SYSTEM)) {
            results.put(SystemConstant.ALERT, "danger");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Đã có lỗi xảy ra, vui lòng thử lại sau");
        } else if (message.equals(SystemConstant.INSERT_FAILED)) {
            results.put(SystemConstant.ALERT, "danger");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Dữ liệu này đã tồn tại, vui lòng nhập lại");
        } else if (message.equals(SystemConstant.UPDATE_FAILED)) {
            results.put(SystemConstant.ALERT, "danger");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Dữ liệu này đã tồn tại, cập nhật thất bại");
        } else if (message.equals(SystemConstant.DELETE_FAILED)) {
            results.put(SystemConstant.ALERT, "danger");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Xóa thất bại, đảm bảo rằng dữ liệu bạn xóa không được sử dụng ở bất kỳ đâu");
        } else if (message.equals(SystemConstant.DATA_ACCESS_DENIED)) {
            results.put(SystemConstant.ALERT, "danger");
            results.put(SystemConstant.MESSAGE_RESPONSE, "Bạn không có quyền truy cập vào dữ liệu này");
        }
        return results;
    }
}
