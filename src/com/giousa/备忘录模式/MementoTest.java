package com.giousa.备忘录模式;

public class MementoTest {

    /**
     * 组织者类
     */
    public static class Originator {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        //创建一个备忘录对象
        public Memento createMemento() {
            return new Memento(this);
        }

        //根据备忘录对象，恢复之前组织者的状态
        public void restoreMemento(Memento m) {
            state = m.getState();
        }
    }


    /**
     * 备忘录类
     */
    public static class Memento {

        private String state;

        public Memento(Originator o) {
            this.state = o.state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    /**
     * 管理者类-对Memento包装一下
     * 在这里需要考虑备忘录的封装性，除了Originator类外，其他类不能调用备忘录的内部的相关方法。
     * 因为外界类的调用可能会引起备忘录内的状态发生变化，这样备忘录的设置就没有了意义。
     * 在实际操作中，可以将Memento和Originator类定义在同一个包中来实现封装；也可以将Memento类作为Originator的内部类。
     */
    public static class Caretaker {

        private Memento memento;


        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }


    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        //在originator和caretaker中保存memento对象
        originator.setState("1");
        System.out.println("当前的状态是：" + originator.getState());
        //备忘录，记录状态
        caretaker.setMemento(originator.createMemento());

        originator.setState("2");
        System.out.println("当前的状态是：" + originator.getState());
        //从Caretaker取出Memento对象
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("执行状态恢复，当前的状态是：" + originator.getState());
    }

}
