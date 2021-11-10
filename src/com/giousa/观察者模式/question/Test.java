package com.giousa.观察者模式.question;

public class Test {

    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher zhang = new Teacher("张老师");

        gper.addObserver(tom);
        gper.addObserver(zhang);

        Question question = new Question();
        question.setUsername("张三");
        question.setContent("天空为什么是蓝色的");

        gper.publishQuestion(question);
    }
}
