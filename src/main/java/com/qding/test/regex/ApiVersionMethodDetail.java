package com.qding.test.regex;

import com.alibaba.fastjson.JSONArray;

public class ApiVersionMethodDetail {

    private String requestHost;
    //请求版本号
    private String versionName;
    //请求地址
    private String requestUri;
    //调用方法
    private String methodName;
    //方法说明
    private String methodNameCn;
    //方法描述
    private String methodDesc;
    //服务号 类名
    private String homeClass;
    //支持HTTP方法
    private String suportHttpMethod;
    //方法request内容
    private JSONArray methodRequest;
    //方法response 内容
    private JSONArray methodResponse ;

    public String getRequestHost() { return requestHost; }

    public void setRequestHost(String requestHost) { this.requestHost = requestHost; }

    public String getHomeClass() {
        return homeClass;
    }

    public void setHomeClass(String homeClass) {
        this.homeClass = homeClass;
    }

    public String getSuportHttpMethod() {
        return suportHttpMethod;
    }

    public void setSuportHttpMethod(String suportHttpMethod) {
        this.suportHttpMethod = suportHttpMethod;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodNameCn() {
        return methodNameCn;
    }

    public void setMethodNameCn(String methodNameCn) {
        this.methodNameCn = methodNameCn;
    }

    public String getMethodDesc() {

        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public JSONArray getMethodRequest() {
        return methodRequest;
    }

    public void setMethodRequest(JSONArray methodRequest) {
        this.methodRequest = methodRequest;
    }

    public JSONArray getMethodResponse() {
        return methodResponse;
    }

    public void setMethodResponse(JSONArray methodResponse) {
        this.methodResponse = methodResponse;
    }

    @Override
    public String toString() {
        return "{"+requestUri+"["+versionName+"]}";
    }
}
