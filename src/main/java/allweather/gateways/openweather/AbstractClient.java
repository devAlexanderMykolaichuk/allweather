package allweather.gateways.openweather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

abstract class AbstractClient {

    private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static JsonFactory JSON_FACTORY = new JacksonFactory();

    private HttpRequestFactory requestFactory;
    private JsonObjectParser jsonObjectParser;

    AbstractClient(){
        this.requestFactory = HTTP_TRANSPORT.createRequestFactory();
        this.jsonObjectParser = new JsonObjectParser(JSON_FACTORY);
    }


    String get(String url) throws IOException {
        GenericUrl genericUrl = new GenericUrl(url);
        HttpRequest request = requestFactory.buildGetRequest(genericUrl);
        request.setParser(jsonObjectParser);
        return request.execute().parseAsString();
    }

    <T> T get(String url, Class<T> responzeClass) throws IOException {
        GenericUrl genericUrl = new GenericUrl(url);
        HttpRequest request = requestFactory.buildGetRequest(genericUrl);
        request.setParser(jsonObjectParser);
        return request.execute().parseAs(responzeClass);
    }

    <T> T get(String url, String param, Class<T> responzeClass) throws IOException {
        GenericUrl genericUrl = new GenericUrl(url);
        HttpRequest request = requestFactory.buildGetRequest(genericUrl);
        request.setParser(jsonObjectParser);
        return request.execute().parseAs(responzeClass);
    }
}
