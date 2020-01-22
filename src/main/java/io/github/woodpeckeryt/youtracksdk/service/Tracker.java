package io.github.woodpeckeryt.youtracksdk.service;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.issue.Issue;

public class Tracker {

    public static void main(String[] args){

//        Transport transport = new ApacheTransport("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");

       // YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNg==.LkAsK2z5GOP1VV774PPoMvPrcHrAX8","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");
        YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNg==.LkAsK2z5GOP1VV774PPoMvPrcHrAX8","https://woodpeckeryt.myjetbrains.com/youtrack");

        youTrack.getIssueService().getAllIssues("0-0");

        Issue[] issues = youTrack.getIssueService().getAllIssues("0-0");

        for (Issue i:issues) {
            System.out.println(i);
        }


    }

}
