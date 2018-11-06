package com.qding.test.jvm;

import java.util.UUID;

/**
 * http://lovestblog.cn/blog/2016/11/06/string-intern/
 * -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -Xmx2G -Xms2G -Xmn100M
 */
public class StringTableTest {
    public static void main(String args[]) {
        for (int i = 0; i < 10000000; i++) {
            uuid();
        }
    }

    public static void uuid() {
        UUID.randomUUID().toString().intern();
    }
}