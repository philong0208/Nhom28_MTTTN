package com.laptrinhjavaweb.utils;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.service.impl.CsvService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class MessageResponseUtils {

    public static Map<String, String> getMessage(String message) {
        CsvService csvService = new CsvService();
        Map<String, String> results = new HashMap<>();
        Map<String, String> stringStringMap = csvService.readCsvFile("D:\\Nhatminhptithcm\\Repository\\Workspace\\Nhom28_MTTTN\\Source\\src\\main\\resources\\message\\MessageData.csv");
        if (message.contains("success")) {
            results.put(SystemConstant.ALERT, "success");
        } else {
            results.put(SystemConstant.ALERT, "danger");
        }
        results.put(SystemConstant.MESSAGE_RESPONSE, stringStringMap.get(message));
        return results;
    }
}
