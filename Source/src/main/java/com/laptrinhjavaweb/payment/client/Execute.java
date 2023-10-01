package com.laptrinhjavaweb.payment.client;

import com.laptrinhjavaweb.payment.nganluong.ResponseData;
import okhttp3.*;
import okio.Buffer;
import org.w3c.dom.CharacterData;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

public class Execute {

    OkHttpClient client = new OkHttpClient();

    public HttpResponse Post(String endpoint, String payload) {

        try {

            HttpRequest httpRequest = new HttpRequest("POST", endpoint, payload, "application/json");

            Request request = createRequest(httpRequest);

            Response result = client.newCall(request).execute();
            HttpResponse response = new HttpResponse(result.code(), result.body().string(), result.headers());

            return response;
        } catch (Exception e) {
//            LogUtils.error("[Execute] "+ e);
        }
        return null;
    }

    public HttpResponse Get(String endpoint) {

        try {
            HttpRequest httpRequest = new HttpRequest("GET", endpoint, "", "application/json");
            Request request = createRequest(httpRequest);
            Response result = client.newCall(request).execute();
            HttpResponse response = new HttpResponse(result.code(), result.body().string(), result.headers());
            return response;
        } catch (Exception e) {
        }
        return null;
    }

    public ResponseData tranformXML(String result) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(result));

        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("result");

        ResponseData response = new ResponseData();
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);

            NodeList name = element.getElementsByTagName("error_code");
            Element line = (Element) name.item(0);
            response.setError_code(getCharacterDataFromElement(line));

            NodeList title = element.getElementsByTagName("token");
            line = (Element) title.item(0);
            response.setToken(getCharacterDataFromElement(line));

            NodeList description = element.getElementsByTagName("description");
            line = (Element) description.item(0);
            response.setDescription(getCharacterDataFromElement(line));

            NodeList checkout_url = element.getElementsByTagName("checkout_url");
            line = (Element) checkout_url.item(0);
            response.setCheckout_url(getCharacterDataFromElement(line));
        }
        return response;
    }

    public static String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }

    public static Request createRequest(HttpRequest request) {
        RequestBody body = RequestBody.create(request.getPayload(), MediaType.get(request.getContentType()));
        return new Request.Builder()
                .method(request.getMethod(), body)
                .url(request.getEndpoint())
                .build();
    }

    public String getBodyAsString(Request request) throws IOException {
        Buffer buffer = new Buffer();
        RequestBody body = request.body();
        body.writeTo(buffer);
        return buffer.readUtf8();
    }
}
