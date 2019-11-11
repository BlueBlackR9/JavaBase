package com.finger.javabase.classloder;

public class Demo1 {

    public static void main(String[] arg){
        ClassLoader c  = Demo1.class.getClassLoader();  //获取Test类的类加载器
        System.out.println(c);
        ClassLoader c1 = c.getParent();  //获取c这个类加载器的父类加载器
        System.out.println(c1);
        ClassLoader c2 = c1.getParent();//获取c1这个类加载器的父类加载器
        System.out.println(c2);
    }
}
