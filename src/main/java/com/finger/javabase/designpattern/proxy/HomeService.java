package com.finger.javabase.designpattern.proxy;

/**
 * @Author: hushuai
 * @Date: 19-7-11 下午11:22
 * @Description
 */
public interface HomeService{
    void LeaseHouse(Home home);
    HomeService getProxy();
}
