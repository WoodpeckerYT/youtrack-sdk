package io.github.woodpeckeryt.youtracksdk.issue;

import io.github.woodpeckeryt.youtracksdk.transport.Transport;

public class IssueService {
    private final Transport transport;
    private final String projectId;

    public IssueService(Transport transport, String projectId) {
        this.transport = transport;
        this.projectId = projectId;
    }

    public String getIssuesInProject() {
        String issuePath = "/api/admin/projects/" + this.projectId
            + "/issues?fields=idReadable,created,updated,resolved,numberInProject,project(name),summary,description,usesMarkdown,wikifiedDescription,reporter,updater,draftOwner,isDraft,visibility,votes,comments,commentsCount,tags,links,externalIssue,customFields,voters,watchers,attachments,subtasks,parent";
        return this.transport.sendGetRequest(issuePath);
    }
}
