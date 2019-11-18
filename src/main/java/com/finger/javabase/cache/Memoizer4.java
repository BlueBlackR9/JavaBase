package com.finger.javabase.cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午9:38
 * @Description
 */
public class Memoizer4<A, V> implements IExecutable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final IExecutable<A, V> iExecutable;

    public Memoizer4(IExecutable<A, V> iExecutable) {
        this.iExecutable = iExecutable;
    }

    @Override
    public V execute(A arg) throws InterruptedException, ExecutionException {
        Future<V> future = cache.get(arg);
        if (future == null) {
            Callable<V> callable = () -> iExecutable.execute(arg);
            FutureTask<V> futureTask = new FutureTask<>(callable);
            future = cache.putIfAbsent(arg, futureTask);
            if (future == null) {
                future = futureTask;
                // 这里将调用实际的执行方法运行，即iExecutable.execute
                futureTask.run();
            }
        }
        try {
            return future.get();
        } catch (CancellationException e) {
            cache.remove(arg, future);
            throw new ExecutionException(e);
        }
    }
}