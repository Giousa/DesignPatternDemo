package com.giousa.迭代器模式.course;

public interface CourseAggregate {

    void add(Course course);

    void remove(Course course);

    Iterator<Course> iterator();
}
