package com.laptrinhjavaweb.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class CsvService {
    public Map<String, String> readCsvFile(String filePath) {
        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
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
            // Handle the exception as needed
        }

        return dataMap;
    }
}

