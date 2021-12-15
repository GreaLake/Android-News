package com.example.androidnewsui.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Login {

    @JsonProperty("statusCode")
    private Integer statusCode;
    @JsonProperty("info")
    private String info;

    @Override
    public String toString() {
        return "Login{" +
                "statusCode=" + statusCode +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }

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

    @JsonProperty("date")
    private String date;
    @JsonProperty("data")
    private DataDTO data;
    @JsonProperty("path")
    private String path;

    @NoArgsConstructor
    public static class DataDTO {
        @Override
        public String toString() {
            return "DataDTO{" +
                    "result=" + result +
                    ", token='" + token + '\'' +
                    '}';
        }

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        @JsonProperty("result")
        private Boolean result;
        @JsonProperty("token")
        private String token;
    }
}
