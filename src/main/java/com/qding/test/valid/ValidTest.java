package com.qding.test.valid;


import com.qding.hk.rest.common.vaidator.ValidatorUtil;

public class ValidTest {

    public static void main(String[] args){
        System.out.println("1111");
            try{
                RoomInfo obj= new RoomInfo();
                ValidatorUtil.validate(obj);
            }catch (Exception e){
                System.out.println(e.getStackTrace());
                e.getStackTrace();
            }
    }
}


