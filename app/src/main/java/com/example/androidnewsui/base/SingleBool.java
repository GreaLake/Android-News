package com.example.androidnewsui.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;

/**
 * @Description 从api获取单个布尔值的封装类
 * @author LZH
 */
@NoArgsConstructor
public class SingleBool {
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

    @NoArgsConstructor
    public static class DataDTO {
        @JsonProperty("result")
        private Boolean result;

        public Boolean getResult() {
            return result;
        }

        public void setResult(Boolean result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "result=" + result +
                    '}';
        }
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

    @Override
    public String toString() {
        return "Register{" +
                "statusCode=" + statusCode +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }
}
