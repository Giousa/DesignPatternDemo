package com.giousa.工厂模式;

import com.giousa.工厂模式.course.ICourse;
import com.giousa.工厂模式.course.JavaCourse;
import com.giousa.工厂模式.course.PythonCourse;

public class CourseInfo {

    public void CourseTest() {
        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.createCourse("java");
        course.record();
    }

    public void CourseTest2() {
        CourseFactory2 courseFactory = new CourseFactory2();
        ICourse course = courseFactory.createCourse("com.giousa.工厂模式.course.PythonCourse");
        course.record();
    }

    public void CourseTest3() {
        CourseFactory3 courseFactory = new CourseFactory3();
        ICourse course = courseFactory.createCourse(JavaCourse.class);
        course.record();
    }

    public class CourseFactory {

        public ICourse createCourse(String courseName) {
            switch (courseName) {

                case "java":
                    return new JavaCourse();

                case "python":
                    return new PythonCourse();
            }

            return null;
        }
    }

    public class CourseFactory2 {
        public ICourse createCourse(String courseName) {
            if (courseName != null && !"".equals(courseName)) {
                try {
                    return (ICourse) Class.forName(courseName).newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public class CourseFactory3 {
        public ICourse createCourse(Class<? extends ICourse> clazz) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
