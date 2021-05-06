package com.gqx.test;

/**
 * synchronized
 */
public class Test004 {
    synchronized void m(){

    }
    void n(){
        synchronized (Test004.class){

        }
    }
    void o(){
        synchronized (this){

        }
    }
}
