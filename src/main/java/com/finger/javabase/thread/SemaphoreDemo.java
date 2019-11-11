package com.finger.javabase.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: hushuai
 * @Date: 19-11-10 下午7:03
 * @Description 信号量Demo
 * 场景：有50人排队买票，由于售票窗口有限，最多同时允许3人进行购买，其余排队。
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 每次只能最多有3个人同时买
        BuyTicket buyTicket = new BuyTicket(3);
        // 50个人买票
        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(buyTicket);
            thread.start();
        }
    }
}

class BuyTicket implements Runnable {

    private Semaphore semaphore;

    BuyTicket(int limitCount) {
        semaphore = new Semaphore(limitCount);
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("线程：" + Thread.currentThread().getName() + "买票中...");
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "买票结束！！！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
