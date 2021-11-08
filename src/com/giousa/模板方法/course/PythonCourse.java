package com.giousa.模板方法.course;

public class PythonCourse extends AbstractCourse {
    @Override
    protected void checkHomework() {
        System.out.println("检查Python作业");
    }
}
