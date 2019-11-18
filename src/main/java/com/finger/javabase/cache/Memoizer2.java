package com.finger.javabase.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午7:53
 * @Description
 */
public class Memoizer2<A, V> implements IExecutable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final IExecutable<A, V> iExecutable;

    public Memoizer2(IExecutable<A, V> iExecutable) {
        this.iExecutable = iExecutable;
    }

    @Override
    public V execute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = iExecutable.execute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
