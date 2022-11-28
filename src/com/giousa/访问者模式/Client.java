package com.giousa.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {

    /**
     * 访问者接口
     */
    public static interface Visitor {
        void visit(ConcreteElementA elementA);
        void visit(ConcreteElementB elementB);
    }


    /**
     * 被访问元素接口
     */
    public static interface Element{
        void accept(Visitor visitor);
    }

    public static class ConcreteElementA implements Element{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public String operationA() {
            return "ConcreteElementA:  操作operationA";
        }
    }
    public static class ConcreteElementB implements Element{

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public String operationB() {
            return "ConcreteElementB: 操作operationB";
        }
    }



    public static class ConcreteVisitor1 implements Visitor{

        @Override
        public void visit(ConcreteElementA elementA) {
            System.out.println("ConcreteVisitor1 访问 ConcreteElementA: " + elementA.operationA());
        }

        @Override
        public void visit(ConcreteElementB elementB) {
            System.out.println("ConcreteVisitor1 访问 ConcreteElementB: " + elementB.operationB());
        }
    }
    public static class ConcreteVisitor2 implements Visitor {

        @Override
        public void visit(ConcreteElementA elementA) {
            System.out.println("ConcreteVisitor2 访问 ConcreteElementA: " + elementA.operationA());
        }

        @Override
        public void visit(ConcreteElementB elementB) {
            System.out.println("ConcreteVisitor2 访问 ConcreteElementB: " + elementB.operationB());
        }
    }

    public static class ObjectStructure {

        private List<Element> elementList = new ArrayList<>();

        public void accept(Visitor visitor) {
            Iterator<Element> it = elementList.iterator();
            while(it.hasNext()) {
                it.next().accept(visitor);
            }
        }

        public void add(Element element) {
            elementList.add(element);
        }

        public void remove(Element element) {
            elementList.remove(element);
        }
    }


    public static void main(String[] args) {
        //将具体元素注入对象结构中
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        //具体访问者访问具体元素
        objectStructure.accept(new ConcreteVisitor1());
        objectStructure.accept(new ConcreteVisitor2());
    }

}
