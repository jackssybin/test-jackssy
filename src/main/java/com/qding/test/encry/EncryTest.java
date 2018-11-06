package com.qding.test.encry;

import com.qdingnet.auth.service.SecureTransportService;

public class EncryTest {

    public static void main(String[] args){
        String encKey =SecureTransportService.encodeSecretKey("jackssy12jackssy");

        System.out.println("encKey="+encKey);
        String content="";
        String contentOrgin="\n" +
                "\t\"appDevice\":{\n" +
                "      \"qdPlatform\":\"IOS\",\n" +
                "      \"qdDevice\":\"iphone6\",\n" +
                "      \"qdVersion\":\"1.0.0\"\n" +
                "            },\n" +
                "\t\"appUser\":{\n" +
                "      \"projectId\":\"\",\n" +
                "      \"curMemberId\":\"\"\n" +
                "          },\n" +
                "\t\"gcRoomId\":\"3112\",\n" +
                "\t\"gcStatus\":\"01\",\n" +
                "\t\"list\":[],\n" +
                "\t\"test\":null\n" +
                "";
        try {
            content=SecureTransportService.encodeContent(contentOrgin,"jackssy12jackssy");
            System.out.println("content="+content);
            content=SecureTransportService.decodeContent(content,"jackssy12jackssy");
            System.out.println("content after="+content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
