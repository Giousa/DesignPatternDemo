package com.giousa.工厂模式.course_factory;

public class CourseFactoryTest {

    public static void main(String[] args) {
        PythonCourseFactory pythonCourseFactory = new PythonCourseFactory();
        ICourse iCourse = pythonCourseFactory.create();
        iCourse.startCourse();
    }
}
