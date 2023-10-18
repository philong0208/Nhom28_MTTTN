package com.laptrinhjavaweb.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CsvService {
    public static Map<String, String> readCsvFile() {
        Map<String, String> dataMap = new HashMap<>();
        try (InputStream inputStream = CsvService.class.getResourceAsStream("/message/MessageData.csv");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             CSVReader reader = new CSVReader(bufferedReader)) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 2) {
                    String key = nextLine[0];
                    String value = nextLine[1];
                    dataMap.put(key, value);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return dataMap;
    }

}

