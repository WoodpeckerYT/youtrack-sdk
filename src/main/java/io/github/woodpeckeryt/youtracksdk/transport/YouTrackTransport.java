package io.github.woodpeckeryt.youtracksdk.transport;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class YouTrackTransport {

    public void sendGetRequest() throws IOException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(
                new GenericUrl(
                        "https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues"
                )
        );

        HttpHeaders headers = request.getHeaders();
        headers.setAuthorization("Bearer " + "perm:cm11aGFtZWRnYWxpZXY=.NDctMA==.rj70ZJ7eklBifZPuEJXeO1z9Ul5My0");

        String rawResponse = request.execute().parseAsString();
        System.out.println(rawResponse);
    }
}
