package io.github.woodpeckeryt.youtracksdk.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import io.github.woodpeckeryt.youtracksdk.entities.YouTrack;
import io.github.woodpeckeryt.youtracksdk.issue.Issue;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Type;
import java.util.List;

import static com.google.gson.reflect.TypeToken.*;

public class Tracker {

    public static void main(String[] args){

//        Transport transport = new ApacheTransport("perm:YW5ncm9uMTIz.NDctNQ==.uLl0ZFOJspRHWbS2ad5vvAOUknmZwp","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");

       // YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNg==.LkAsK2z5GOP1VV774PPoMvPrcHrAX8","https://woodpeckeryt.myjetbrains.com/youtrack/api/admin/projects/72d91e0c-9712-4063-8ad8-1fddbea33a6f/issues");
        YouTrack youTrack = new YouTrack("perm:YW5ncm9uMTIz.NDctNg==.LkAsK2z5GOP1VV774PPoMvPrcHrAX8","https://woodpeckeryt.myjetbrains.com/youtrack");

        youTrack.getIssueService().getAllIssues("0-0");

        Issue[] issues = youTrack.getIssueService().getAllIssues("0-0");

        for (Issue i:issues) {
            String str = "WOODPECKER-37";



            if(i.getIdReadable().equals(str) ){
                System.out.println(i.getUpdater());
                System.out.println(i);
                System.out.println("TRUE ");

                Gson gson = new Gson();

                System.out.println(i.getCreated());
                System.out.println(i.getCreated());
                System.out.println(i.getUpdater());

//                Type type = ParameterizedTypeImpl.make(List.class, new Type[]{childrenClazz}, null);
//                List list = gson.fromJson(json, type);

//                Object read = gson.fromJson((JsonReader) i.getUpdater(), type);
//                System.out.println(read);


            } else{
            System.out.println("TEST ");
            }
        }


    }

}
