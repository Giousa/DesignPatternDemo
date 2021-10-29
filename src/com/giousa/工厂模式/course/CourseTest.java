package com.giousa.工厂模式.course;

/**
 * 简单工厂模式：3种方式
 */
public class CourseTest {

    public static void main(String[] args) {
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.CourseTest();
        courseInfo.CourseTest2();
        courseInfo.CourseTest3();

        String name = courseInfo.getClass().getName();
        System.out.println(name);

        String name1 = CourseInfo.class.getName();
        System.out.println(name1);

        Class<CourseInfo> courseInfoClass = CourseInfo.class;
        System.out.println(courseInfoClass);
    }
}
