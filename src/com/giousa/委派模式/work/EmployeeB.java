package com.giousa.委派模式.work;

public class EmployeeB implements IEmployee {

    protected String name = "B";

    protected String goodAt = "平面设计";

    @Override
    public void doing(String task) {
        System.out.printf("我是员工%s,擅长%s,正在执行任务：%s\n", name, goodAt, task);
    }
}
