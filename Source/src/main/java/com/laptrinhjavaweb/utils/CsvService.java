package com.laptrinhjavaweb.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CsvService {
    public static String getMessageData(String keyMessage) {
        try (InputStream inputStream = CsvService.class.getResourceAsStream("/message/MessageData.csv")) {
            assert inputStream != null;
            try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                 CSVReader reader = new CSVReader(bufferedReader)) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine.length >= 2) {
                        String key = nextLine[0];
                        String value = nextLine[1];
                        if (key.equals(keyMessage)) {
                            return value;
                        }
                    }
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return "";
    }
}

