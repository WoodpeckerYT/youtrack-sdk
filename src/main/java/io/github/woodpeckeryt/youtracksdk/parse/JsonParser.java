package io.github.woodpeckeryt.youtracksdk.parse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.issue.Issue;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParser {

    public static void main(String[] args) {

    String token = "perm:cm11aGFtZWRnYWxpZXY=.NDctMA==.rj70ZJ7eklBifZPuEJXeO1z9Ul5My0";
    String host = "https://woodpeckeryt.myjetbrains.com/youtrack";
    String projectId = "72d91e0c-9712-4063-8ad8-1fddbea33a6f";

    YouTrack youTrack = new YouTrack(token, host, projectId);
    String issues = youTrack.getIssueService().getIssuesInProject();

    Gson gson = new Gson();

    Type itemsListType = new TypeToken<List<Issue>>() {
    }.getType();


    List<Issue> issue = gson.fromJson(issues, itemsListType);
        JsonObject jsonObject = new JsonObject();



        System.out.println(issues);
        System.out.println("-------------------------------------------------------------");
        System.out.println(issue.toString());
    }
}
