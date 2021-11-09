package com.giousa.迭代器模式.course;

public class Test {

    public static void main(String[] args) {
        Course java = new Course("java课程");
        Course python = new Course("python课程");
        Course c = new Course("c++课程");

        CourseAggregateImpl courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(java);
        courseAggregate.add(python);
        courseAggregate.add(c);

        Iterator<Course> iterator = courseAggregate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
