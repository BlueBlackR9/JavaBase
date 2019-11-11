package com.finger.javabase.designpattern.proxy;

import org.junit.Test;

/**
 * @Author: hushuai
 * @Date: 19-7-11 下午11:32
 * @Description 强制代理测试类
 */
public class ForceProxyTest {

    /**
     * 此种方式租房会被拒绝，因为目标使用了强制代理
     */
    @Test
    public void test() {
        RealHomeowner realHomeowner=new RealHomeowner();
        Home home=new Home(1000, "red");
        realHomeowner.LeaseHouse(home);
        HomeProxy homeProxy = new HomeProxy(realHomeowner);
        homeProxy.LeaseHouse(home);
    }

    /**
     * 使用下面这种方式可以成功
     */
    @Test
    public void test2() {
        RealHomeowner realHomeowner=new RealHomeowner();
        Home home=new Home(1000,"red");
        HomeService homeProxy = realHomeowner.getProxy();
        homeProxy.LeaseHouse(home);
    }
}
