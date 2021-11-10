package com.giousa.观察者模式.question;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("==================");
        System.out.println(name + "老师，您好！\n您收到了一个在课堂:" + gper.getName() + "，学生：" + question.getUsername() + "的提问，问题是：" + question.getContent());
    }
}
