package com.finger.javabase.suanfa;

/**
 * @Author: hushuai
 * @Date: 19-8-25 下午5:23
 * @Description
 */
public class ArrayTest {

    int[] arrayInit = new int[]{1, 2, 3, 4};

    public void xxx(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(j);
            }
        }
    }
}