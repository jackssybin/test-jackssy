package com.qding.test.regex;

import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Map;

public class JSTreeJsonGroupObject {

    private JSONArray data;
    private int methodCount;
    private Map<String, Integer> vMethod;
    private Map<String, List<ApiVersionMethodDetail>> vMethodNameList;

    public JSONArray getData() {
        return data;
    }

    public void setData(JSONArray data) {
        this.data = data;
    }

    public int getMethodCount() {
        return methodCount;
    }

    public void setMethodCount(int methodCount) {
        this.methodCount = methodCount;
    }

    public Map<String, Integer> getvMethod() {
        return vMethod;
    }

    public void setvMethod(Map<String, Integer> vMethod) {
        this.vMethod = vMethod;
    }

    public Map<String, List<ApiVersionMethodDetail>> getvMethodNameList() {
        return vMethodNameList;
    }

    public void setvMethodNameList(Map<String, List<ApiVersionMethodDetail>> vMethodNameList) {
        this.vMethodNameList = vMethodNameList;
    }
}
