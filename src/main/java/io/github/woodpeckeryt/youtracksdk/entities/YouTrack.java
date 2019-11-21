package io.github.woodpeckeryt.youtracksdk.entities;

import io.github.woodpeckeryt.youtracksdk.issue.IssueService;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;
import io.github.woodpeckeryt.youtracksdk.user.UserService;

public class YouTrack {
    private final String token;
    private final String host;
    private final String projectId;

    private final Transport transport;

    private final IssueService issueService;
    private final UserService userService;

    public YouTrack(String token, String host, String projectId) {
        this.token = token;
        this.host = host;
        this.projectId = projectId;

        this.transport = new Transport(this.token, this.host);
        this.issueService = new IssueService(this.transport, this.projectId);
        this.userService = new UserService(this.transport);
    }

    public IssueService getIssueService() {
        return issueService;
    }

    public UserService getUserService() { return userService; }
}
