package com.giousa.代理模式.proxy;

public class ZhangLaosan implements IPerson{

    private Zhangsan zhangsan;

    public ZhangLaosan(Zhangsan zhangsan) {
        this.zhangsan = zhangsan;
    }

    @Override
    public void findLove() {
        before();
        zhangsan.findLove();
        after();
    }

    private void before() {
        System.out.println("之前的操作");
    }

    private void after() {
        System.out.println("之后的收尾");
    }
}
