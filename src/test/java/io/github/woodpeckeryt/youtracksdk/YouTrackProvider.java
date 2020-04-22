package io.github.woodpeckeryt.youtracksdk;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;

public class YouTrackProvider {

    private final String hostEnvName = "YT_HOST";
    private final String tokenEnvName = "YT_TOKEN";

    public YouTrack get() {
        final String host = System.getenv(hostEnvName);
        final String token = System.getenv(tokenEnvName);

        return new YouTrack(token, host);
    }
}
