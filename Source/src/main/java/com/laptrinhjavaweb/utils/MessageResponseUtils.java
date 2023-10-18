package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MessageResponseUtils {
    public static Map<String, String> getMessage(String key) {
        Map<String, String> results = new HashMap<>();
        results.put(SystemConstant.ALERT, key.contains("success") ? "success" : "danger");
        results.put(SystemConstant.MESSAGE_RESPONSE, CsvService.getMessageData(key));
        return results;
    }
}