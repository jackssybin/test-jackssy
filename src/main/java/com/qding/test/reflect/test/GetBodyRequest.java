package com.qding.test.reflect.test;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class GetBodyRequest extends QdingBodyRequest {

    private static final long serialVersionUID = 9029111785897904935L;

    @NotEmpty(message="房间号不能为空")
    @Size(
            min = 1,
            max=4,
            message = "房间号最小{min} 最大{max}"
    )
    private String gcRoomId;

    public String getGcRoomId() {
        return gcRoomId;
    }

    public void setGcRoomId(String gcRoomId) {
        this.gcRoomId = gcRoomId;
    }

    @Override
    public String toString() {
        return "GetGcRoomInfoRequest{" +
                "gcRoomId='" + gcRoomId + '\'' +
                '}';
    }
}