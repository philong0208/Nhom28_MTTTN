package com.laptrinhjavaweb.dto;

import java.util.Map;

public class CsvRecord {
    private Map<String, String> data;

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
