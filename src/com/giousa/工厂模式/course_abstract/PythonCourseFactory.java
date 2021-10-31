package com.giousa.工厂模式.course_abstract;

public class PythonCourseFactory extends CourseFactory{
    @Override
    protected INote createNote() {
        return new PythonNote();
    }

    @Override
    protected IVideo createVideo() {
        return new PythonVideo();
    }
}
