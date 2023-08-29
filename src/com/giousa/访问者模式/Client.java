package com.giousa.访问者模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 访问者模式试图解决如下问题： 一个类农场里面包含各种元素，例如有大雁，狗子，鸭子。而每个元素的操作却经常变换，
 * 一会让大雁排成一字，一会让大雁排成人字。当大雁排成一字的时候狗子要排成S形状，鸭子要排成B形状，当大雁排成人字时候狗子要叫两声，鸭子要跳起来...。
 * 但对农场这类有要求，第一：可以迭代这些元素，第二：里面的元素不能频繁变动，你不能一会把鸭子杀了吃了，一会又买回一匹马...，如果是这样的话就不适合使用Visitor模式
 *
 * 定义
 * 封装一些作用于某种数据结构中的各元素的操作，它可以在不改变这个数据结构的前提下定义作用于其内部各个元素的新操作
 *
 * 使用场景
 * 当你有个类，里面的包含各种类型的元素，这个类结构比较稳定，不会经常增删不同类型的元素。而需要经常给这些元素添加新的操作的时候，考虑使用此设计模式。
 *
 * 访问者模式要点总结
 * 准确识别出Visitor实用的场景，如果一个对象结构不稳定决不可使用，不然在增删元素时改动将非常巨大。
 * 对象结构中的元素要可以迭代访问
 * Visitor里一般存在与元素个数相同的visit方法。
 * 元素通过accept方法通过this将自己传递给了Visitor。
 *
 * 优点
 * 使得给结构稳定的对象增加新算法变得容易，提搞了代码的可维护性，可扩展性。
 *
 * 缺点
 * 太复杂，特别是伪动态双分派，不仔细理解很难想清楚。
 *
 * 总结
 * 访问者模式使用频率较低，而且复杂，可酌情掌握
 */
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

    ///////////////////////////////////////////////////////////////////////////
    // 具体被访问元素接口
    ///////////////////////////////////////////////////////////////////////////
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


    ///////////////////////////////////////////////////////////////////////////
    // 具体访问者接口
    ///////////////////////////////////////////////////////////////////////////

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

    ///////////////////////////////////////////////////////////////////////////
    //对象结构
    ///////////////////////////////////////////////////////////////////////////
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


    ///////////////////////////////////////////////////////////////////////////
    // 测试
    ///////////////////////////////////////////////////////////////////////////
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
