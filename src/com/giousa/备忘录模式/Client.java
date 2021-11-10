package com.giousa.备忘录模式;

public class Client {

    public static void main(String[] args) {
        Originator originator = new Originator();

        Caretaker caretaker = new Caretaker();

        caretaker.storeMemento(originator.createMemento());

        originator.restoreMemento(caretaker.getMemento());
    }

    /**
     * 备忘录角色
     */
    static class Memento {
        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    /**
     * 发起人角色
     */
    static class Originator {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        //创建一个备忘录
        public Memento createMemento() {
            return new Memento(this.state);
        }

        //恢复一个备忘录
        public void restoreMemento(Memento memento) {
            this.setState(memento.getState());
        }
    }

    /**
     * 备忘录管理者角色
     */
    static class Caretaker{

        private Memento memento;

        public Memento getMemento() {
            return memento;
        }

        //存储备忘录
        public void storeMemento(Memento memento){
            this.memento = memento;
        }
    }
}
