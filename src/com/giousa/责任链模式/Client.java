package com.giousa.责任链模式;

import java.util.Objects;

/**
 * 责任链模式，也叫做职责链，是将请求的发送和接收解耦，让多个接收对象都有机会处理这个请求。
 * 当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 * 职责链模式最常见的应用就是用来开发各种框架的过滤器和拦截器，比如Spring Interceptor和Servlet Filter
 *
 * 使用场景
 * 一个请求需要被多个对象中的某一个处理，但是到底是哪个对象必须在运行时根据条件决定。
 *
 * 优点
 * 是命令发出者与执行者解耦。
 * 一个命令可以被多个处理器执行，例如各种框架中的拦截器
 *
 * 缺点
 * 设计模式通病：类增多了。如果组链时候不合理，可能导致请求得不到执行，还有可能将链变成一个环，请求在里面循环，永远都完不了。
 */
public class Client {

    /**
     * 定义处理器接口，里面持有一个相同的处理器
     */
    static abstract class Handler {

        protected Handler nextHandler;

        public void setNextHandler(Handler nextHandler) {
            this.nextHandler = nextHandler;
        }

        public abstract void handleRequest(String request);
    }

    ///////////////////////////////////////////////////////////////////////////
    // 具体处理器
    ///////////////////////////////////////////////////////////////////////////
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

    /**
     * 测试
     */
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

}
