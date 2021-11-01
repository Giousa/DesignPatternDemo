package com.giousa.建造者模式.builder;

public class CourseBuilder {

    private Course course = new Course();

    public static CourseBuilder build() {
        return new CourseBuilder();
    }

    public CourseBuilder addName(String name) {
        course.setName(name);
        return this;
    }

    public CourseBuilder addPPT(String ppt) {
        course.setPpt(ppt);
        return this;
    }

    public CourseBuilder addVideo(String video) {
        course.setVideo(video);
        return this;
    }

    public Course builder() {
        return course;
    }
}
