package com.qding.test.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassA<T> {
    private T obj;
    public void setObject(T obj) {      this.obj = obj;  }
    public T getObject() {    return obj;   }

    /**
     * 获取T的实际类型
     */
    public void testClassA() throws NoSuchFieldException, SecurityException {
        System.out.print("getSuperclass::::::::::::");
        System.out.println(this.getClass().getSuperclass().getName());
        System.out.print("getGenericSuperclass::::::::::::");
        Type t = this.getClass().getGenericSuperclass();
        System.out.println(t);
        if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
            System.out.print("getActualTypeArguments::::::::::::");
            for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                System.out.print(t1 + ",");
            }
            System.out.println();
        }
    }
}
