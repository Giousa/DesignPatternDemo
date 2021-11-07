package com.giousa.委派模式.work;

public class EmployeeA implements IEmployee {

    protected String name = "A";

    protected String goodAt = "编程";

    @Override
    public void doing(String task) {
        System.out.printf("我是员工%s,擅长%s,正在执行任务：%s\n", name, goodAt, task);
    }
}
