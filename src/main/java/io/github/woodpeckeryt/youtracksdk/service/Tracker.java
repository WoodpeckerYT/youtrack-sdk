package io.github.woodpeckeryt.youtracksdk.service;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.transport.ApacheTransport;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

public class Tracker {




    public static void main(String[] args){

        Transport transport = new ApacheTransport("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");
        System.out.println("Test");
        //transport.sendGetRequest();

        YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");

        System.out.println(youTrack.getUserService().getMeInformation());
        IssueC
        youTrack.getIssueService().createIssue()
        System.out.println(youTrack.getIssueService().getIssuesInProject("WOODPECKER"));


    }

}
