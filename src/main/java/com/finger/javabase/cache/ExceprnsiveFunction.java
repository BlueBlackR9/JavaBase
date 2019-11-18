package com.finger.javabase.cache;

/**
 * @Author: hushuai
 * @Date: 19-11-17 下午7:18
 * @Description
 */
public class ExceprnsiveFunction implements IExecutable<String, Object> {

    /**
     * 一个耗时的方法
     * @param arg A
     * @return Object
     */
    @Override
    public Object execute(String arg) {
        return new Object();
    }
}
