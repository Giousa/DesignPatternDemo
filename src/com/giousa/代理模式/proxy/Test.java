package com.giousa.代理模式.proxy;

public class Test {

    public static void main(String[] args) {
//        ZhangLaosan zhangLaosan = new ZhangLaosan(new Zhangsan());
//        zhangLaosan.findLove();

        JdkMeipo jdkMeipo = new JdkMeipo();
        IPerson person = jdkMeipo.getInstance(new Zhaoliu());
        person.findLove();

        IPerson person2 = jdkMeipo.getInstance(new Zhangsan());
        person2.findLove();
    }
}
