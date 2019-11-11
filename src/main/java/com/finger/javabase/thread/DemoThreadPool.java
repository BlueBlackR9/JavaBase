package com.finger.javabase.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;


/**
 * 线程池练习
 */
public class DemoThreadPool {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("test-pool-%d").build();

    private static ExecutorService demoPool = new ThreadPoolExecutor(5, 10, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(5), threadFactory,
            new ThreadPoolExecutor.DiscardOldestPolicy());

    public void threadPoolTest() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            Thread.sleep(500L);
            demoPool.execute(new DemoTaskRunnable());
            System.out.println("线程池中的线程数目：" + ((ThreadPoolExecutor)demoPool).getPoolSize() + "，队列中等待执行的任务数目：" +
                    ((ThreadPoolExecutor)demoPool).getQueue().size() + "，已执行完的任务数目：" + ((ThreadPoolExecutor)demoPool).getCompletedTaskCount());
        }
    }

    public void completionTest() throws InterruptedException, ExecutionException {
        CompletionService completionService = new ExecutorCompletionService(demoPool);
        for (int i = 0; i < 15; i++) {
            completionService.submit(new DemoTaskCallable());
            System.out.println("线程池中的线程数目：" + ((ThreadPoolExecutor)demoPool).getPoolSize() + "，队列中等待执行的任务数目：" +
                    ((ThreadPoolExecutor)demoPool).getQueue().size() + "，已执行完的任务数目：" + ((ThreadPoolExecutor)demoPool).getCompletedTaskCount());
        }
        for (int j = 0; j < 15; j++) {
            System.out.println(completionService.take().get());
        }
    }
}


class DemoTaskRunnable implements Runnable {

    public DemoTaskRunnable () {
    }

    public void run() {
        System.out.println("任务开始执行，线程名：" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("任务 "+ Thread.currentThread().getName() +"执行完毕");
    }

}

class DemoTaskCallable implements Callable {

    public Object call() {
        System.out.println("任务开始执行，线程名：" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "执行完毕";
    }
}