package com.qding.test.chartsetJudge;

import com.alibaba.fastjson.JSON;
import com.qding.hk.rest.common.util.EncryptUtil;
import junit.framework.TestCase;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainTest extends TestCase{
    public void testToCookie() throws Exception{
        Map<String,String> map = new HashMap<String,String>();

        map.put("test", "t那身");
        map.put("test2", "女神");
//        String sourceStr=JSON.toJSONString(map);
//        String encryStr = new String(GZipUtils.compress(sourceStr.getBytes()),SerializeUtil.CHARSET_ISO88591);
//        System.out.println("encryStr :"+encryStr);
//        System.out.println("解密后"+new String((GZipUtils.decompress(encryStr.getBytes(SerializeUtil.CHARSET_ISO88591)))));
        String souceStr=JSON.toJSONString(map);
        String base64Str= getBase64(souceStr);
        String encryStr=new String(GZipUtils.compress(base64Str.getBytes()),SerializeUtil.CHARSET_ISO88591);
        System.out.println("encryStr=="+encryStr);
        encryStr=getBase64(encryStr);
        System.out.println("encryStr base64=="+encryStr);

        String decryStr= new String(GZipUtils.decompress(getFromBase64(encryStr).getBytes(SerializeUtil.CHARSET_ISO88591)));
        String deBase64Str=getFromBase64(decryStr);
        System.out.println("decryStr="+decryStr);
        System.out.println("deBase64Str="+deBase64Str);



    }

    public static String getBase64(String str){
        byte[] b=null;
        String s=null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if(b!=null){
            s=new BASE64Encoder().encode(b);
        }
        return s;
    }
    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}