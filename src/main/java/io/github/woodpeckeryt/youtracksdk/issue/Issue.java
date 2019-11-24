package io.github.woodpeckeryt.youtracksdk.issue;

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


    public Long getNumberInProject() {
        return numberInProject;
    }

    public String getSummary() {
        return summary;
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
                '}';
    }
}
