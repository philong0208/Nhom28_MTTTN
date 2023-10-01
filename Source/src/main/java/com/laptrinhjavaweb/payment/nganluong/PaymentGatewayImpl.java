package com.laptrinhjavaweb.payment.nganluong;

import com.laptrinhjavaweb.payment.base.BasePaymentGateway;
import com.laptrinhjavaweb.payment.client.HttpResponse;
import com.laptrinhjavaweb.payment.model.PaymentResponse;

import java.util.Map;

import static com.laptrinhjavaweb.payment.client.AbstractProcess.getGson;

public class PaymentGatewayImpl<ResponseData> extends BasePaymentGateway<ResponseData> {
    private final Client client;
    private final Config config;
    private String url = "";

    public PaymentGatewayImpl(Config config, Client client) {
        this.client = client;
        this.config = config;
    }


    @Override
    protected void initSandboxEnvironment() {
    }

    @Override
    public ResponseData purchase(Map<String, String> data) {
        return this.executeFromRequest(data);
    }

    @Override
    public String refundOrder(Map<String, String> data, String clientId) {
        return null;
    }

    public String getUrl() {
        return this.url;
    }

    public String setUrl(String url) {
        return url;
    }

    @Override
    protected ResponseData executeFromRequest(Map attr) {
        StringBuffer paramsStr = new StringBuffer();
        RequestData req = new RequestData();
        paramsStr.append(req.getBaseUrl(this.config.isMode())).append('?');
        attr = req.getAttributes(Constant.RC_PURCHASE, config, attr);
        this.appendQueryFields(paramsStr, attr);
        String url = paramsStr.toString();
        this.setUrl(url);
        return (ResponseData) this.client.execute(url);
    }

    @Override
    protected PaymentResponse buildUrlFromRequestConfirm(Map attr) throws Exception {
        StringBuffer buf = new StringBuffer();
        RequestData req = new RequestData();
        String url = req.getBaseUrl(this.config.isMode()) + req.getAttributes(Constant.RC_AUTHENTICATE, config, attr);
        this.setUrl(url);
        HttpResponse response = this.client.getExecute().Post(url, "");
        if (response.getStatus() != 200) {
            throw new Exception("Error");
        }
        return getGson().fromJson(response.getData(), PaymentResponse.class);
    }
}
