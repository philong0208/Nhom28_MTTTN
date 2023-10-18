package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MessageResponseUtils {
    public static Map<String, String> getMessage(String message) {
        Map<String, String> results = new HashMap<>();
        Map<String, String> stringStringMap = CsvService.readCsvFile();
        results.put(SystemConstant.ALERT, message.contains("success") ? "success" : "danger");
        results.put(SystemConstant.MESSAGE_RESPONSE, stringStringMap.get(message));
        return results;
    }
}