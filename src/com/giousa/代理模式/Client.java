package com.giousa.代理模式;

/**
 * 代理模式是为被代理类生成一个代理类，由代理类去调用被代理类的方法，并添加一些逻辑。
 * 装饰器是在不改变原有类的情况下，动态的添加原有类的功能，两者作用看似非常相近。
 *
 * 具体区别如下：
 * 1.代理模式对对象实现访问控制而不增强对象本身的功能，装饰器模式是增强对象的功能。
 * 2.代理模式为对象生成一个代理对象，由代理对象访问原对象；装饰器模式更多对原对象的功能进行增强，是继承方案的一个代替。
 * 3.代理模式的重心在于调用对象的某个功能，并做一个和对象本身无关的业务，装饰器模式重心在于扩展自身的功能。
 */
public class Client {


    /**
     * 接口
     */
    interface ISubject {
        void request();
    }

    /**
     * 实现类
     */
    static class RealSubject implements ISubject {

        @Override
        public void request() {
            System.out.println("real request. subject = " + this);
        }
    }

    /**
     * 代理类
     */
    static class Proxy implements ISubject {

        private ISubject subject;

        //代理模式，基本上不需要从外部传入对象，而是内部定义
        public Proxy() {
            this.subject = new RealSubject();
        }

        @Override
        public void request() {
            //代理模式，不需要对接口进行增强，基本上就处理一层逻辑
            //before()  处理前执行   这里屏蔽，只有装饰器模式需要放开
            subject.request();
            //after()   处理后执行
        }
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.request();
    }
}
