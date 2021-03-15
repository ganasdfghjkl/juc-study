package com.gox.juc.study;

import org.openjdk.jol.info.ClassLayout;

import java.util.Objects;

public class Test006 {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }
}
