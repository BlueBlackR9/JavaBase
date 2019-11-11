package com.finger.javabase.datasturts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: hushuai
 * @Date: 19-8-17 下午5:09
 * @Description
 */
public class HashMapRead {

    Map<String, String> map = new HashMap<>();

    public void testPut() {
        Map<String, String> map1 = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            map1.put(UUID.randomUUID().toString(), "xxx");
        }
    }

    public void testPut2() {
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            map2.put(i, "xxx");
        }

        for (int i = 0; i < 17; i++) {
            map2.get(i);
        }
    }

    public static void main(String[] args) {
        new HashMapRead().testPut2();
    }
}
