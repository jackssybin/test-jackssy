package com.qding.test.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class RoomInfo {


    private static final long serialVersionUID = 9029111785897904935L;

    @NotEmpty(message="房间号不能为空")
    private String gcRoomId;

}
