package com.ylzInfo.bean;

public class Message {
    private String id;
    private String sendtime;
    private String title;
    private String type;
    private String sutitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSutitle() {
        return sutitle;
    }

    public void setSutitle(String sutitle) {
        this.sutitle = sutitle;
    }
}
