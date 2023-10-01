package com.laptrinhjavaweb.payment.nganluong;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class RequestData {
    public RequestData() {
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBaseUrl(boolean sandbox) {
        return (sandbox ? "https://sandbox.nganluong.vn:8088/nl30" : "https://www.nganluong.vn") + "/checkout.api.nganluong.post.php";
    }

    Map<String, String> getAttributes(String command, Config config, Map<String, String> attributes) {
        attributes.put("merchant_id", config.getMerchantId());
        attributes.put("merchant_password", getMd5(config.getMerchantPassword()));
        attributes.put("version", config.getVersion());
        attributes.put("return_url", config.getReturnUrl());
        attributes.put("cancel_url", config.getCancelUrl());
        if (command.equals(Constant.RC_PURCHASE)) {
            attributes.put("function", "SetExpressCheckout");
            attributes.put("receiver_email", config.getEmail());
            if (attributes.get("version").equals(Constant.VERSION_3_2)) {
                if (attributes.containsKey("payment_method")) {
                    attributes.put("payment_method", attributes.get("payment_method"));
                } else {
                    attributes.put("payment_method", Constant.PAYMENT_METHOD_ATM_ONLINE);
                }
            } else {
                attributes.put("payment_method", Constant.PAYMENT_METHOD_NL);
            }
        } else if (command.equals(Constant.RC_AUTHENTICATE)) {
            attributes.put("function", "AuthenTransaction");
        } else {
            attributes.put("function", "GetTransactionDetail");
        }
        return attributes;
    }

    public String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
