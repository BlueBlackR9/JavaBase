package com.finger.javabase.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午7:21
 * @Description
 */
public class Memoizer1<A, V> implements IExecutable<A, V> {

    private final Map<A, V> cache = new HashMap<>();

    private final IExecutable<A, V> iExecutable;

    public Memoizer1(IExecutable<A, V> iExecutable) {
        this.iExecutable = iExecutable;
    }

    @Override
    public synchronized V execute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = iExecutable.execute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}