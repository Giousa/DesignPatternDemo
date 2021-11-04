package com.giousa.组合模式.course;

public class Test {

    public static void main(String[] args) {
        System.out.println("================透明组合模式================");

        CourseComponent javaBase = new Course("Java课程", 8880);
        CourseComponent ai = new Course("人工智能",30000);

        CourseComponent packageCourse = new CoursePackage("java架构师课程", 2);
        CourseComponent design = new Course("java设计模式",290);
        CourseComponent source = new Course("源码分享",400);
        CourseComponent softSkill = new Course("软技能",5990);

        packageCourse.addChild(design);
        packageCourse.addChild(source);
        packageCourse.addChild(softSkill);

        CourseComponent catalog = new CoursePackage("课程主目录", 1);
        catalog.addChild(javaBase);
        catalog.addChild(ai);
        catalog.addChild(packageCourse);

        catalog.print();

    }
}
