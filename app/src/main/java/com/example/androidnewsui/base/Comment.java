package com.example.androidnewsui.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Comment {
    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("info")
    private String info;
    @JsonProperty("date")
    private String date;
    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("path")
    private String path;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @NoArgsConstructor
    public static class DataDTO {
        @Override
        public String toString() {
            return "DataDTO{" +
                    "result=" + result +
                    '}';
        }

        public List<?> getResult() {
            return result;
        }

        public void setResult(List<?> result) {
            this.result = result;
        }

        @JsonProperty("result")
        private List<?> result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "statusCode=" + statusCode +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }
}
