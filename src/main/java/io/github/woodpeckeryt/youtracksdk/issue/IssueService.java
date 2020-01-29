package io.github.woodpeckeryt.youtracksdk.issue;

import com.google.gson.Gson;
import io.github.woodpeckeryt.youtracksdk.issue.dto.IssueCreateDTO;
import io.github.woodpeckeryt.youtracksdk.transport.ApacheTransport;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;
import io.github.woodpeckeryt.youtracksdk.user.User;

import java.lang.reflect.Type;
import java.util.List;

public class IssueService {
    private final Transport gsonTransport;

    public IssueService(Transport gsonTransport) {
        this.gsonTransport = gsonTransport;
    }

    public Issue[] getAllIssues(String projectId){

        String issuePath = "/api/admin/projects/" + projectId
                + "/issues?fields=idReadable,created,updated,resolved,numberInProject,project(name),summary,description,usesMarkdown,wikifiedDescription,reporter,updater,draftOwner,isDraft,visibility,votes,comments,commentsCount,tags,links,externalIssue,customFields,voters,watchers,attachments,subtasks,parent";
        String response = this.gsonTransport.sendGetRequest(issuePath);

        Issue[] issues = new Gson().fromJson(response, Issue[].class);

        return issues;
    }

    public void getIssuesbyUser(String projectId){

        String login = "angron123";
        String project = "Woodpecker";
        String issuePath = "/api/admin/projects/" + projectId + "/issues?fields=id,customFields(value(login)),project(name),created,updated";

        String response = this.gsonTransport.sendGetRequest(issuePath);
        Issue[] issues = new Gson().fromJson(response, Issue[].class);

        for (Issue i:issues) {

            System.out.println(i.getCustomFields().get(3));

           // if(i.getProject().equals(project)) {
               // System.out.println("True");
                System.out.println(i);
                System.out.println(i.getProject());
           // }
////               // User user = i.getUpdater();
////
////               // user.toString();
////              //  System.out.println(user.toString());
////             //   System.out.println("----------------------");
////             //   i.getReporter();
//////                User user1 = i.getReporter();
//////                System.out.println(user1.toString());
////
            }

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

