package com.giousa.代理模式;

public class Client {

    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }

    interface ISubject {
        void request();
    }

    static class Proxy implements ISubject {

        private ISubject subject;

        public Proxy(ISubject subject) {
            this.subject = subject;
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
