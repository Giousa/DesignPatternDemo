package com.giousa.责任链模式;

import java.util.Objects;

/**
 * 责任链模式，也叫做职责链，是将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 * 职责链模式最常见的应用就是用来开发各种框架的过滤器和拦截器，比如Spring Interceptor和Servlet Filter
 */
public class Client {

    public static void main(String[] args) {
        ConcreteHandlerA concreteHandlerA = new ConcreteHandlerA();
        ConcreteHandlerB concreteHandlerB = new ConcreteHandlerB();

        concreteHandlerA.setNextHandler(concreteHandlerB);

        concreteHandlerA.handleRequest("requestA");
        concreteHandlerA.handleRequest("requestB");
        concreteHandlerA.handleRequest("requestA");
        concreteHandlerA.handleRequest("requestA");
        concreteHandlerA.handleRequest("requestB");
    }


    static abstract class Handler {

        protected Handler nextHandler;

        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void handleRequest(String request);
    }

    static class ConcreteHandlerA extends Handler {

        @Override
        public void handleRequest(String request) {
            if (Objects.equals("requestA", request)) {
                System.out.println("ConcreteHandlerA 实现了请求");
                return;
            }

            if (Objects.nonNull(nextHandler)) {
                nextHandler.handleRequest(request);
            }
        }
    }

    static class ConcreteHandlerB extends Handler {

        @Override
        public void handleRequest(String request) {
            if (Objects.equals("requestB", request)) {
                System.out.println("ConcreteHandlerB 实现了请求");
                return;
            }

            if (Objects.nonNull(nextHandler)) {
                nextHandler.handleRequest(request);
            }
        }
    }
}
