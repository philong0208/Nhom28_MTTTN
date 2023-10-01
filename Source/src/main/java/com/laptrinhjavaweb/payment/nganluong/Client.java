package com.laptrinhjavaweb.payment.nganluong;

import com.laptrinhjavaweb.payment.client.AbstractProcess;
import com.laptrinhjavaweb.payment.client.HttpResponse;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Client extends AbstractProcess<RequestData, ResponseData> {
    @Override
    public ResponseData execute(String url) {
        ResponseData rs = new ResponseData();
        HttpResponse response = execute.Post(url, "");
        if (response == null || response.getStatus() != 200) {
            rs.setError_code("400");
            System.out.println(response);
            return rs;
        }
        try {
            return execute.tranformXML(response.getData());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
