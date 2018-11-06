package com.qding.test.chartsetJudge;

import java.text.DecimalFormat;

public class ByteToKbSize {
    public static void main(String[] args){
        byte[] bytes=new byte[1024 *100 ];
//        bytes.length
        System.out.println(fileSizeConver(bytes.length));

    }

    public static String fileSizeConver(long fileS)
    {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize="0B";
        if(fileS==0){
            return wrongSize;
        }
        if (fileS < 1024){
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576){
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else if (fileS < 1073741824){
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
        else{
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }
}
