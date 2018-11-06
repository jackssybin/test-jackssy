package com.qding.test.recyc;

import java.util.HashMap;
import java.util.Map;

public class TestRecyc {


    public static void main(String[] args){
        String[]arr=new String[]{
                "aaa.bbb.ccc.ddd=1",
                "aaa.bbb.ccc.eee=2",
                "aaa.bbb.ccc.fff=3",
                "bbb.ccc=3"};
        //{aaa={bbb={ccc={eee=2, ddd=1, fff=3}}}, bbb={ccc=3}}
        Map map = new HashMap();

        for(String str:arr){
            String[] params=str.split("\\=");
            getFixValMap(params[0].split("\\."),map,0,params[1]);
//            fixMapByParams(params[0].split("\\."), map,params[1]);
        }
        System.out.println("====================");
        System.out.println(map);
    }

    public static void getFixValMap(String[] params,  Map<String, Object> rqMap,int index,String value) {
        int len = params.length;
        String key = params[index];
        Map tmpMap = new HashMap();
        if(index<len){
            if(rqMap.containsKey(key)){
                tmpMap=(Map)rqMap.get(key);
            }else{
                tmpMap=new HashMap<>();
            }
            if(index==len-1){
                tmpMap.put(key,value);
                rqMap.put(key,tmpMap);
            }else{
                index++;
                rqMap.put(key,tmpMap);
                getFixValMap(params,rqMap,index,value);
            }
        }
    }

    public void recycMap(String[] parms,Map map){

    }




    /**
     * 先兼容一下四级嵌套得情况。
     * 这段代码 急需优化,rbs 应急 --todo jackssy
     *
     * @param parmas
     * @param rqMap
     * @param value
     */
    public static void fixMapByParams(String[] parmas, Map rqMap, Object value) {
        int len = parmas.length;
        int i = 0;
        String key1, key2, key3, key4 = "";
        Map valMap1, valMap2, valMap3 = new HashMap();
        if (len == 1) {
            key1 = parmas[i];
            rqMap.put(key1, value);
        } else if (len == 2) {
            key1 = parmas[i];
            if (rqMap.containsKey(key1)) {
                valMap1 = (Map) rqMap.get(key1);
            } else {
                valMap1 = new HashMap();
            }
            key2 = parmas[i + 1];
            valMap1.put(key2, value);
            rqMap.put(key1, valMap1);
        } else if (len == 3) {
            key1 = parmas[i];
            if (rqMap.containsKey(key1)) {
                valMap1 = (Map) rqMap.get(key1);
            } else {
                valMap1 = new HashMap();
            }

            key2 = parmas[i + 1];
            if (valMap1.containsKey(key2)) {
                valMap2 = (Map) valMap1.get(key2);
            } else {
                valMap2 = new HashMap();
            }
            key3 = parmas[i + 2];
            valMap2.put(key3, value);

            valMap1.put(key2, valMap2);

            rqMap.put(key1, valMap1);

        } else if (len == 4) {
            key1 = parmas[i];
            if (rqMap.containsKey(key1)) {
                valMap1 = (Map) rqMap.get(key1);
            } else {
                valMap1 = new HashMap();
            }

            key2 = parmas[i + 1];
            if (valMap1.containsKey(key2)) {
                valMap2 = (Map) valMap1.get(key2);
            } else {
                valMap2 = new HashMap();
            }

            key3 = parmas[i + 2];
            if (valMap2.containsKey(key3)) {
                valMap3 = (Map) valMap2.get(key3);
            } else {
                valMap3 = new HashMap();
            }
            key4 = parmas[i + 3];


            valMap3.put(key4, value);
            valMap2.put(key3, valMap3);

            valMap1.put(key2, valMap2);
            rqMap.put(key1, valMap1);
        }
    }


    public static void getFixMap(String[] params, int index, Map<String, Object> rqMap) {
        int len = params.length;
        String key = "";
        if (index < len) {
            key = params[index];
            System.out.println(" key="+key +" index="+index);
            if(len-1 ==index){
                rqMap.put(params[index-1],key);
            }else{
                index++;
                if (rqMap.containsKey(key)) {
                    getFixMap(params, index, (Map)rqMap.get(key));
                }else{
                    Map childMap = new HashMap();
                    rqMap.put(key,childMap);
                    getFixMap(params, index, childMap);
                }
            }
        }
    }
}
