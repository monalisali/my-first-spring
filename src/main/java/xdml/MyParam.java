package xdml;

import java.util.List;

public class MyParam {

    /**
     * title : Found a bug
     * body : I'm having a problem with this.
     * assignees : ["octocat"]
     * milestone : 1
     * labels : ["bug"]
     */

    private String title;
    private String body;
    private int milestone;
    private List<String> assignees;
    private List<String> labels;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = milestone;
    }

    public List<String> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<String> assignees) {
        this.assignees = assignees;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }
}
