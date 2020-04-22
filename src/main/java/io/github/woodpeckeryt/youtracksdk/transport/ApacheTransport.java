package io.github.woodpeckeryt.youtracksdk.transport;

import com.google.gson.Gson;
import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ApacheTransport implements Transport {
    private final static Logger logger = LoggerFactory.getLogger(ApacheTransport.class);

    private final String token;
    private final String host;

    public ApacheTransport(String token, String host) {
        this.token = token;
        this.host = host;
    }

    @Override
    public String sendGetRequest(String path) throws IOException {
        HttpGet request = new HttpGet(this.host + path);
        logger.debug("Start new HTTP Request to {}", request.getURI());

        request.addHeader("Authorization", "Bearer " + this.token);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String result = null;
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }

            return result;
        } else {
            throw new IOException(response.getStatusLine().toString());
        }
    }

    @Override
    public String sendPostRequest(String path, Object sendObject) {
        String result = "";

        try(
            CloseableHttpClient client = HttpClients.createDefault();
            ) {
            HttpPost httpPost = new HttpPost(this.host + path);
            String requestData = new Gson().toJson(sendObject);
            StringEntity entity = new StringEntity(requestData);
            httpPost.setHeader("Authorization", "Bearer " + this.token);
            entity.setContentType("application/json");
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            CloseableHttpResponse response = client.execute(httpPost);

            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
