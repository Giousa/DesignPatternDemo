package com.giousa.工厂模式.course_abstract;

public class CourseAbstractTest {

    public static void main(String[] args) {
        JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.createNote().edit();
        javaCourseFactory.createVideo().record();

        System.out.println("----------------");
        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        pythonCourseFactory.createNote().edit();
        pythonCourseFactory.createVideo().record();
    }
}
