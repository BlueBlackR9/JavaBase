package com.finger.javabase.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;


/**
 * @Author: hushuai
 * @Date: 19-11-7 下午6:12
 * @Description
 */
public class DemoThreadPoolTest {

    @Test
    public void threadPoolTest() throws InterruptedException {
        DemoThreadPool threadPool = new DemoThreadPool();
        threadPool.threadPoolTest();
    }

    @Test
    public void completionTest() throws InterruptedException, ExecutionException {
        DemoThreadPool threadPool = new DemoThreadPool();
        threadPool.completionTest();
    }

}