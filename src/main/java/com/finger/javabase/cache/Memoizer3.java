package com.finger.javabase.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午8:59
 * @Description
 */
public class Memoizer3<A, V> implements IExecutable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final IExecutable<A, V> iExecutable;

    public Memoizer3(IExecutable<A, V> iExecutable) {
        this.iExecutable = iExecutable;
    }

    @Override
    public V execute(A arg) throws InterruptedException, ExecutionException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return iExecutable.execute(arg);
                }
            };
            FutureTask<V> futureTask = new FutureTask<>(callable);
            cache.put(arg, futureTask);
            future = futureTask;
            // 这里将调用实际的执行方法运行，即iExecutable.execute
            futureTask.run();
        }
        return future.get();
    }
}