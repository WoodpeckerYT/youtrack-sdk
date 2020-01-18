package io.github.woodpeckeryt.youtracksdk.service;

import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.issue.dto.IssueCreateCustomFieldDTO;
import io.github.woodpeckeryt.youtracksdk.issue.dto.IssueCreateDTO;
import io.github.woodpeckeryt.youtracksdk.issue.dto.IssueCreateProjectDTO;
import io.github.woodpeckeryt.youtracksdk.transport.ApacheTransport;
import io.github.woodpeckeryt.youtracksdk.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public class Tracker {


    public static void main(String[] args){

        Transport transport = new ApacheTransport("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");

        YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");

        youTrack.getIssueService().getIssuesInProject("WOODPECKER");
        System.out.println(youTrack.getIssueService().getIssuesInProject("WOODPECKER"));

        IssueCreateProjectDTO issueCreateProjectDTO = new IssueCreateProjectDTO("1234");
        Object object = new Object();
        IssueCreateCustomFieldDTO issueCreateCustomFieldDTO = new IssueCreateCustomFieldDTO("TestType","TestName",object );

        List<IssueCreateCustomFieldDTO> customFields = new ArrayList<IssueCreateCustomFieldDTO>();
        customFields.add(issueCreateCustomFieldDTO);
        IssueCreateDTO issueCreateDTO = new IssueCreateDTO("TestSummary","TestDescription",issueCreateProjectDTO,customFields);
        youTrack.getIssueService().createIssue(issueCreateDTO);


    }

}
