package com.giousa.责任链模式;

import java.util.Objects;

public class Client {

    public static void main(String[] args) {
        ConcreteHandlerA concreteHandlerA = new ConcreteHandlerA();
        ConcreteHandlerB concreteHandlerB = new ConcreteHandlerB();

        concreteHandlerA.setNextHandler(concreteHandlerB);

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
