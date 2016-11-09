package com.seasun.myseed.web.vo;

import com.alibaba.fastjson.JSONObject;

public class CommonResponse {
    private String code;
    private String message;
    private JSONObject data;

    public CommonResponse(String code, String message){
        this.code = code;
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
