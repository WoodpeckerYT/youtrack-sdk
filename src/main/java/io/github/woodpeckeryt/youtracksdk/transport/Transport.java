package io.github.woodpeckeryt.youtracksdk.transport;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class Transport {
    private final String token;
    private final String host;

    private final HttpRequestFactory requestFactory;

    public Transport(String token, String host) {
        this.token = token;
        this.host = host;

        this.requestFactory = new NetHttpTransport().createRequestFactory();
    }

    public String sendGetRequest(String path) {
        String response = "";

        try {
            HttpRequest request = requestFactory.buildGetRequest(
                new GenericUrl(
                    this.host + path
                )
            );

            HttpHeaders headers = request.getHeaders();
            headers.setAuthorization("Bearer " + this.token);

            response = request.execute().parseAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
