package io.github.woodpeckeryt.youtracksdk.issue;

import io.github.woodpeckeryt.youtracksdk.user.User;

import java.util.List;

public class Issue {
    private Long numberInProject;
    private String summary;
    private String description;
    private String idReadable;
    private Boolean usesMarkdown;
    private String wikifiedDescription;
    private Boolean isDraft;

    private Integer votes;
    private Long commentsCount;

    private Long created;
    private Long updated;
    private Long resolved;

    private Object links; //	Array of IssueLinks
    private Object visibility; //  "visibility" : "Visibility",
    private Object project; // "project" : "Project",
    private Object watchers; //"watchers" : "IssueWatchers",
    private Object voters;//  "voters" : "IssueVoters",
    private Object reporter; //  "reporter" : "User",
    private String draftOwner; // "draftOwner" : "User",
    private Object attachments; //	Array of IssueAttachments
    private Object comments; //MutableCollection
    private Object tags;// "tags" : "MutableCollection",
    private Object subtasks;//"subtasks" : "IssueLink",
    private List customFields;
    private User updater; //"updater" : "User",
    private String C;
    private Object parent; //	IssueLink




    public Long getCreated() {
        return created;
    }

    public Long getNumberInProject() {
        return numberInProject;
    }

    public Object getUpdater() {
        return updater;
    }

    public String getSummary() {
        return summary;
    }

    public String getIdReadable() {
        return idReadable;
    }

    public String getC() {
        return C;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "numberInProject=" + numberInProject +
                ", summary='" + summary + '\'' +
                ", description='" + description + '\'' +
                ", idReadable='" + idReadable + '\'' +
                ", usesMarkdown=" + usesMarkdown +
                ", wikifiedDescription='" + wikifiedDescription + '\'' +
                ", isDraft=" + isDraft +
                ", votes=" + votes +
                ", commentsCount=" + commentsCount +
                ", created=" + created +
                ", updated=" + updated +
                ", resolved=" + resolved +
                ", links=" + links +
                ", visibility=" + visibility +
                ", project=" + project +
                ", watchers=" + watchers +
                ", voters=" + voters +
                ", reporter=" + reporter +
                ", draftOwner='" + draftOwner + '\'' +
                ", attachments=" + attachments +
                ", comments=" + comments +
                ", tags=" + tags +
                ", subtasks=" + subtasks +
                ", customFields=" + customFields +
                ", updater=" + updater +
                ", C='" + C + '\'' +
                ", parent=" + parent +
                '}';
    }
}
