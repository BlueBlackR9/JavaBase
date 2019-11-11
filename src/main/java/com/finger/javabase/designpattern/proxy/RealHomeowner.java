package com.finger.javabase.designpattern.proxy;

/**
 * @Author: hushuai
 * @Date: 19-7-11 下午11:28
 * @Description
 */
public class RealHomeowner implements HomeService{
    private HomeService proxy;
    @Override
    public void LeaseHouse(Home home) {
        if (isProxy()){
            System.out.println("房价是 "+ home.price);
            System.out.println("房子颜色是 "+ home.color);
        }else {
            System.out.println("请找房屋代理");
        }
    }
    // 获得自己的代理
    @Override
    public HomeService getProxy() {
        this.proxy=new HomeProxy(this);
        return this.proxy;
    }
    // 校验是否是代理访问
    private Boolean isProxy(){
        if (this.proxy == null){
            return false;
        }else {
            return true;
        }
    }
}
