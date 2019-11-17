package com.finger.javabase.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: hushuai
 * @Date: 19-11-10 下午4:09
 * @Description 闭锁Demo
 * 场景：100米赛跑，裁判员要等所有运动员准备好后才能鸣枪。
 */
public class CountDownLatchDemo {

    private void demo(int people) {
        CountDownLatch countDownLatch = new CountDownLatch(people);
        for (int i = 0; i < people; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(5000L);
                    System.out.println("准备好了！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
        try {
            // 等所有人员准备好后鸣枪
            System.out.println("裁判员等待中.......");
            countDownLatch.await();
            System.out.println("人员全部准备好了，鸣枪！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CountDownLatchDemo().demo(10);
    }
}
