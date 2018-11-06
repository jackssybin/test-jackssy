package com.qding.test.reflect.test;

import com.qding.framework.common.api.struct.AppDevice;
import com.qding.framework.common.api.struct.AppUserInfo;

import java.io.Serializable;

public class QdingBodyRequest extends QdingBodyT implements Serializable {
    private static final long serialVersionUID = -5685807566614870703L;


    public QdingBodyRequest() {
    }

    private AppDevice appDevice;
    private AppUserInfo appUser;



    public AppUserInfo getAppUser() {
        return this.appUser;
    }

    public void setAppUser(AppUserInfo appUser) {
        this.appUser = appUser;
    }

    public AppDevice getAppDevice() {
        return this.appDevice;
    }

    public void setAppDevice(AppDevice appDevice) {
        this.appDevice = appDevice;
    }



    @Override
    public String toString() {
        return "QdingBodyRequest{" +
                "appDevice=" + appDevice +
                ", appUser=" + appUser +
                '}';
    }
}