package com.qding.test.reflect.test;

import java.io.Serializable;

public class QdingBodyT<T> implements Serializable {
    private static final long serialVersionUID = -5685807566614870703L;

    private T body;
    private String signCode;
    private String userToken;
    private long timestamp;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getSignCode() {
        return signCode;
    }

    public void setSignCode(String signCode) {
        this.signCode = signCode;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
