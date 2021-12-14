package com.example.androidnewsui;

public class NewsData {
    private int imgId;
    private String content;

    public NewsData(int imgId, String content) {
        this.imgId = imgId;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsData() {
    }

    @Override
    public String toString() {
        return "NewsData{" +
                "imgId=" + imgId +
                ", content='" + content + '\'' +
                '}';
    }
}
