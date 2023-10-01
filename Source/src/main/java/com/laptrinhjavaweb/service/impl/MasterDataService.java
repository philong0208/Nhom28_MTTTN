package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.service.IMasterDataService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MasterDataService implements IMasterDataService {
    public static HashMap<Integer, String > hashMap = new HashMap<>();
    static {
        hashMap.put(1, "Header");
        hashMap.put(2, "Footer");
    }
    @Override
    public Map<Integer, String> getMenuType() {
        return hashMap;
    }
}
