package com.qding.test.thread.waitnotify;

import java.util.*;

public class MyList {

    private List list = new ArrayList();

    public void add() {
        list.add("我是元素");
    }

    public int size() {
        return list.size();
    }

}
