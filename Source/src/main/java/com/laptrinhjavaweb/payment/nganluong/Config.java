package com.laptrinhjavaweb.payment.nganluong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    // 'Email tài khoản ngân lượng của bạn',
    @Value("${nganluong.config.email}")
    private String email;

    //'Mã merchant bạn vừa đăng ký',
    @Value("${nganluong.config.merchantId}")
    private String merchantId;

    //'Merchant password bạn vừa đăng ký'
    @Value("${nganluong.config.merchantPassword}")
    private String merchantPassword;

    @Value("${nganluong.config.return_url}")
    private String returnUrl;

    @Value("${nganluong.config.cancel_url}")
    private String cancelUrl;

    @Value("${nganluong.config.mode}")
    private boolean mode;

    @Value("${nganluong.config.version}")
    private String version;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public void setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
    }

    public boolean isMode() {
        return mode;
    }

    public void setMode(boolean mode) {
        this.mode = mode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
