package com.giousa.建造者模式.builder;

public class CourseBuilderTest {

    public static void main(String[] args) {
        Course course = CourseBuilder
                .build()
                .addName("java课程")
                .addPPT("ppt课件")
                .addVideo("视频文件")
                .builder();

        System.out.println(course);
    }
}
