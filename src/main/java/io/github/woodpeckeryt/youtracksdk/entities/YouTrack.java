package io.github.woodpeckeryt.youtracksdk.entities;

import io.github.woodpeckeryt.youtracksdk.issue.IssueService;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

public class YouTrack {
    private final String token;
    private final String host;
    private final String projectId;

    private final Transport transport;

    private final IssueService issueService;

    public YouTrack(String token, String host, String projectId) {
        this.token = token;
        this.host = host;
        this.projectId = projectId;

        this.transport = new Transport(this.token, this.host);
        this.issueService = new IssueService(this.transport, this.projectId);
    }

    public IssueService getIssueService() {
        return issueService;
    }
}
