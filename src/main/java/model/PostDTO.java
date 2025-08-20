package model;

public class PostDTO {
    private String userName;
    private String postId;
    private String title;
    private String content;
    private String suggest;
    private String report;
    
    public PostDTO() {}

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostId() {
        return postId;
    }
    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getSuggest() {
        return suggest;
    }
    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getReport() {
        return report;
    }
    public void setReport(String report) {
        this.report = report;
    }
}
