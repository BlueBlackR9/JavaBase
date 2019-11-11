package com.finger.javabase.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: hushuai
 * @Date: 19-11-10 下午4:09
 * @Description 闭锁Demo
 * 场景：公司组织要去春游，小伙伴到了后都必须签到，所有人员签到完毕后才可以出发，否则不能出发。
 */
public class CountDownLatchDemo {

    private void arrive(int people) {
        CountDownLatch countDownLatch = new CountDownLatch(people);
        for (int i = 0; i < people; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(5000L);
                    System.out.println("签到成功！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        try {
            // 等所有人员签到成功则出发
            System.out.println("等待中.......");
            countDownLatch.await();
            System.out.println("人员全部签到完毕，出发！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CountDownLatchDemo().arrive(5);
    }
}
