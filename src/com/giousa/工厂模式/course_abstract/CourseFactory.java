package com.giousa.工厂模式.course_abstract;

public abstract class CourseFactory {

    public void init(){
        System.out.println("初始化基础数据信息");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();
}
