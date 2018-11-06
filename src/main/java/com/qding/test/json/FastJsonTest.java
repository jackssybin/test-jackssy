package com.qding.test.json;

import com.alibaba.fastjson.JSON;
import com.qding.hk.rest.common.base.QdingBaseRequest;
import com.qding.test.regex.ApiVersionMethodDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastJsonTest {


    public static Map<String, List<ApiVersionMethodDetail>> versionMethodNameMap = new HashMap<String, List<ApiVersionMethodDetail>>();

    public static  void main(String[] args){
//        testjson();
        List<ApiVersionMethodDetail> list = new ArrayList<>();
        ApiVersionMethodDetail detail = new ApiVersionMethodDetail();
        detail.setMethodName("1");
        list.add(detail);
        versionMethodNameMap.put("ates",list);
        String jsonStr=JSON.toJSONString(versionMethodNameMap);
        System.out.println(jsonStr);
    }

    private static void testjson() {
        String str="{\n" +
                "  \"mid\" : \"ff8080815c8c1e97015cc63249ca5892\",\n" +
                "  \"puserId\" : \"ff8080815c9b4eea015cc63249b900b5\",\n" +
                "  \"appUser\" : {\n" +
                "    \"userId\" : \"ff8080815c8c1e97015cc63249ca5891\"\n" +
                "  },\n" +
                "  \"appDevice\" : {\n" +
                "    \"qdAppName\" : \"guanjia\",\n" +
                "    \"deviceId\" : \"c363d5c93a2a435e8c06a5db4d8e29d6\",\n" +
                "    \"qdPlatform\" : \"iOS\",\n" +
                "    \"OSVersion\" : \"11.3\",\n" +
                "    \"qdDevice\" : \"Simulator\",\n" +
                "    \"qdVersion\" : \"4.4.3\"\n" +
                "  }\n" +
                "}";

        Map map  = new HashMap();
        map.put("body[appDevice][qdPlatform]","test");
        map.put("body[appDevice][qdDevice]","sss");

//        JSON.parseObject(map., QdingBaseRequest.class)
        String str222= JSON.toJSONString(map);
        System.out.println(str222);
    }
}
