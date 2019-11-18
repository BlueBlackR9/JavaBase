package com.finger.javabase.cache;

import java.util.concurrent.ExecutionException;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午7:00
 * @Description
 */
public interface IExecutable<A, V> {

    /**
     * 执行实际的计算
     * @param arg A
     * @return V
     * @throws InterruptedException
     */
    V execute(A arg) throws InterruptedException, ExecutionException;
}
