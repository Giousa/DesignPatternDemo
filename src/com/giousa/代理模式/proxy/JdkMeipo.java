package com.giousa.代理模式.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkMeipo implements InvocationHandler {

    private IPerson person;

    public IPerson getInstance(IPerson person) {
        this.person = person;
        Class<? extends IPerson> clazz = person.getClass();
        return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.person, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("之前的操作");
    }

    private void after() {
        System.out.println("之后的操作");
    }
}
