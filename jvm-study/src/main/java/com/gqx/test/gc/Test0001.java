package com.gqx.test.gc;

/**
 *
 * TLAB和栈上分配
 *
 * 关闭栈上分配和TLAB
 * -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
 */
public class Test0001 {
    class User{
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }
    void testAlloc(int i ){
        // new 出来的这个User对象根本出不去这个方法，就是没有逃逸
        User user = new User(i,"gqx");
    }

    public static void main(String[] args) {
        Test0001 test0001 = new Test0001();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            test0001.testAlloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}
