package io.github.woodpeckeryt.youtracksdk.entities;

import io.github.woodpeckeryt.youtracksdk.issue.IssueService;
import io.github.woodpeckeryt.youtracksdk.transport.ApacheTransport;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;
import io.github.woodpeckeryt.youtracksdk.user.UserService;

public class YouTrack {
    private final String token;
    private final String host;

    private final Transport apacheTransport;

    private final IssueService issueService;
    private final UserService userService;

    public YouTrack(String token, String host) {
        this.token = token;
        this.host = host;

        this.apacheTransport = new ApacheTransport(this.token, this.host);
        this.issueService = new IssueService(this.apacheTransport);
        this.userService = new UserService(this.apacheTransport);
    }

    public IssueService getIssueService() {
        return issueService;
    }

    public UserService getUserService() { return userService; }
}
