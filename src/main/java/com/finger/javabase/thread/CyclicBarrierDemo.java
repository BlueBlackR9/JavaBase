package com.finger.javabase.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: hushuai
 * @Date: 19-11-11 下午9:44
 * @Description 参加1000米赛跑，跑完后大家一起去吃饭
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        Running running = new Running(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(running);
            thread.start();
        }
    }
}

class Running implements Runnable {

    private CyclicBarrier cyclicBarrier;

    Running(int peopleCount) {
        cyclicBarrier = new CyclicBarrier(peopleCount);
    }

    public void run() {
        try {
            System.out.println("运动员：" + Thread.currentThread().getName() + "跑步中...");
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println("运动员：" + Thread.currentThread().getName() + "到达终点,等待其他小伙伴！!");
            cyclicBarrier.await();
            System.out.println("全部到达终点，去吃饭！");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}