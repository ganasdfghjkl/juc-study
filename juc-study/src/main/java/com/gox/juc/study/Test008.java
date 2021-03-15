package com.gox.juc.study;

import java.util.Objects;
import java.util.Set;

public class Test008 {
    static volatile Boolean r = Boolean.FALSE;

    public static class T{
        String a;
        public static volatile T t = null;
        public T(){
        }
        public static T getInstance(){
            if (Objects.isNull(t)){
                synchronized (T.class){
                    if (Objects.isNull(t)){
                        t = new T();
                    }
                }
            }
            return t;
        }
    }
    public static void main(String[] args) throws InterruptedException {
       T t = new T();
       new Thread(()->{
           synchronized (t){
               while (r){

               }
               System.out.println(t.a);
           }
       }).start();
       Thread.sleep(100L);
       t.a="!23";
       Thread.sleep(100L);
       r = Boolean.FALSE;

    }
}
