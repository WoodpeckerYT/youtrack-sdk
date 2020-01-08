package io.github.woodpeckeryt.youtracksdk.issue;

import com.google.gson.Gson;
import io.github.woodpeckeryt.youtracksdk.issue.dto.IssueCreateDTO;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

public class IssueService {
    private final Transport gsonTransport;

    public IssueService(Transport gsonTransport) {
        this.gsonTransport = gsonTransport;
    }

    public Issue getIssuesInProject(String projectId) {
        String issuePath = "/api/admin/projects/" + projectId
            + "/issues?fields=idReadable,created,updated,resolved,numberInProject,project(name),summary,description,usesMarkdown,wikifiedDescription,reporter,updater,draftOwner,isDraft,visibility,votes,comments,commentsCount,tags,links,externalIssue,customFields,voters,watchers,attachments,subtasks,parent";

        String response = this.gsonTransport.sendGetRequest(issuePath);

        return new Gson().fromJson(response, Issue.class);
    }

    public Issue createIssue(IssueCreateDTO issueCreateDTO) {
        String issuePath = "/api/issues?fields=idReadable,created,updated,resolved,numberInProject,project(name),summary,description,usesMarkdown,wikifiedDescription,reporter,updater,draftOwner,isDraft,visibility,votes,comments,commentsCount,tags,links,externalIssue,customFields,voters,watchers,attachments,subtasks,parent";

        System.out.println(new Gson().toJson(issueCreateDTO));

        String response = this.gsonTransport.sendPostRequest(issuePath, issueCreateDTO);

        return new Gson().fromJson(response, Issue.class);
    }
}
