package com.gqx.test;

import java.lang.reflect.InvocationTargetException;

/**
 * F
 */
public class Test001  {




    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        TestClassLoad testClassLoad = new TestClassLoad();
        Class clazz = testClassLoad.loadClass("com.gox.juc.study.Test001");

        System.out.println(clazz.getClassLoader());
        System.out.println(testClassLoad.getParent());
        testClassLoad = null;
        clazz = null;
        testClassLoad = new TestClassLoad();
        Class clazz2 = testClassLoad.loadClass("com.gox.juc.study.Test001");

        System.out.println(clazz2.getClassLoader());
        System.out.println(testClassLoad.getParent());
        System.out.println(clazz == clazz2);

//        Object test001 =  clazz.newInstance();
//        Method method = clazz.getMethod("test");
//        method.invoke(test001);
//        System.out.println(clazz.getClassLoader());
//        System.out.println(JSON.class.getClassLoader());
    }
}
