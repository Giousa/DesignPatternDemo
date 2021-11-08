package com.giousa.模板方法.course;

public class Test {

    public static void main(String[] args) {
        System.out.println("===java===");
        JavaCourse javaCourse = new JavaCourse();
        javaCourse.setNeedCheckHome(true);
        javaCourse.createCourse();


        System.out.println("===python===");
        PythonCourse pythonCourse = new PythonCourse();
        pythonCourse.createCourse();
    }
}
