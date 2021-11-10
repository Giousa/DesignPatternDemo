package com.giousa.观察者模式.question;

import java.util.Observable;

public class GPer extends Observable {

    private String name = "Gper生态圈";

    private static GPer gper = null;

    private GPer() {

    }

    public static GPer getInstance() {
        if (gper == null) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
