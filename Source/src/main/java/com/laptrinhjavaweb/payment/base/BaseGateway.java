package com.laptrinhjavaweb.payment.base;

import com.laptrinhjavaweb.payment.model.PaymentResponse;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseGateway<T> {
    public T purchase(Map<String, String> fields) {
        return this.executeFromRequest(fields);
    }

    public void appendQueryFields(StringBuffer buf, Map fields) {
        try {
            List fieldNames = new ArrayList(fields.keySet());
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) fields.get(fieldName);

                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    buf.append(URLEncoder.encode(fieldName, "UTF-8"));
                    buf.append('=');
                    buf.append(fieldValue);
                }
                if (itr.hasNext()) {
                    buf.append('&');
                }
            }
        } catch (Exception e) {
        }
    }

    protected abstract T executeFromRequest(Map attr);
    protected abstract PaymentResponse buildUrlFromRequestConfirm(Map attr) throws Exception;
}
