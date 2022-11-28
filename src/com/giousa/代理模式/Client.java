package com.giousa.代理模式;

public class Client {

    public static void main(String[] args) {
//        Proxy proxy = new Proxy(new RealSubject());
        Proxy proxy = new Proxy();
        proxy.request();
    }

    interface ISubject {
        void request();
    }

    /**
     * 这个是装饰器
     */
//    static class Proxy implements ISubject {
//
//        private ISubject subject;
//
//        public Proxy(ISubject subject) {
//            this.subject = subject;
//        }
//
//        @Override
//        public void request() {
//            before();
//            subject.request();
//            after();
//        }
//
//        private void before() {
//            System.out.println("called before request. subject = " + subject);
//        }
//
//        private void after() {
//            System.out.println("called after request. subject = " + subject);
//        }
//    }

    /**
     * 这个才是代理
     */
    static class Proxy implements ISubject {

        private ISubject subject;

        public Proxy() {
            this.subject = new RealSubject();
        }

        @Override
        public void request() {
            before();
            subject.request();
            after();
        }

        private void before() {
            System.out.println("called before request. subject = " + subject);
        }

        private void after() {
            System.out.println("called after request. subject = " + subject);
        }
    }

    static class RealSubject implements ISubject {

        @Override
        public void request() {
            System.out.println("real request. subject = " + this);
        }
    }
}
