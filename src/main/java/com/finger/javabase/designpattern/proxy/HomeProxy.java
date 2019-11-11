package com.finger.javabase.designpattern.proxy;

/**
 * @Author: hushuai
 * @Date: 19-7-11 下午11:25
 * @Description
 */
class HomeProxy implements HomeService{

    private HomeService homeService;

    public HomeProxy(HomeService homeService){
        this.homeService = homeService;
    }
    @Override
    public void LeaseHouse(Home home) {
        System.out.println("装修房子");
        home.color="red";
        System.out.println("提升价格");
        home.price=home.price+1000;
        homeService.LeaseHouse(home);
    }
    // 因为代理上面没有代理就返回自己
    @Override
    public HomeService getProxy() {
        return this;
    }

    public static void main(String[] args) {
        RealHomeowner realHomeowner=new RealHomeowner();
        Home home=new Home(1000, "red");
        realHomeowner.LeaseHouse(home);
        HomeProxy homeProxy = new HomeProxy(realHomeowner);
        homeProxy.LeaseHouse(home);
    }
}
