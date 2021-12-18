package com.example.androidnewsui.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.NoArgsConstructor;

/**
 * @Description 从api获取用户信息的封装类
 * @author LZH
 */
@NoArgsConstructor
public class User {
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

    @Override
    public String toString() {
        return "User{" +
                "statusCode=" + statusCode +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", data=" + data +
                ", path='" + path + '\'' +
                '}';
    }

    @NoArgsConstructor
    public static class DataDTO {
        @JsonProperty("result")
        private List<ResultDTO> result;

        public List<ResultDTO> getResult() {
            return result;
        }

        public void setResult(List<ResultDTO> result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "DataDTO{" +
                    "result=" + result +
                    '}';
        }

        @NoArgsConstructor
        public static class ResultDTO {
            @JsonProperty("id")
            private String id;
            @JsonProperty("icon")
            private String icon;
            @JsonProperty("password")
            private String password;
            @JsonProperty("simple")
            private String simple;
            @JsonProperty("isDelete")
            private Integer isDelete;
            @JsonProperty("gmtCreate")
            private String gmtCreate;
            @JsonProperty("gmtUpdate")
            private String gmtUpdate;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getSimple() {
                return simple;
            }

            public void setSimple(String simple) {
                this.simple = simple;
            }

            public Integer getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(Integer isDelete) {
                this.isDelete = isDelete;
            }

            public String getGmtCreate() {
                return gmtCreate;
            }

            public void setGmtCreate(String gmtCreate) {
                this.gmtCreate = gmtCreate;
            }

            public String getGmtUpdate() {
                return gmtUpdate;
            }

            public void setGmtUpdate(String gmtUpdate) {
                this.gmtUpdate = gmtUpdate;
            }

            @Override
            public String toString() {
                return "ResultDTO{" +
                        "id='" + id + '\'' +
                        ", icon='" + icon + '\'' +
                        ", password='" + password + '\'' +
                        ", simple='" + simple + '\'' +
                        ", isDelete=" + isDelete +
                        ", gmtCreate='" + gmtCreate + '\'' +
                        ", gmtUpdate='" + gmtUpdate + '\'' +
                        '}';
            }
        }
    }
}
