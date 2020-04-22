package io.github.woodpeckeryt.youtracksdk.transport;

import java.io.IOException;

public interface Transport {

    String sendGetRequest(String path) throws IOException;

    String sendPostRequest(String path, Object sendObject);
}
