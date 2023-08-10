package com.giousa.桥接模式;


/**
 * 桥接（Bridge）模式的定义如下：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，
 * 从而降低了抽象和实现这两个可变维度的耦合度。
 *
 * 假如你有一个几何形状（Shape）类， 从它能扩展出两个子类： 圆形（Circle）和方形（Square）。
 * 你希望对这样的类层次结构进行扩展以使其包含颜色， 所以你打算创建名为红色（Red）和蓝色（Blue）的形状子类。
 * 但是，由于你已有两个子类，所以总共需要创建四个类才能覆盖所有组合，例如蓝色圆形（BlueCircle）和红色方形（RedSquare）。
 * 在层次结构中新增形状和颜色将导致代码复杂程度指数增长。例如添加三角形状，你需要新增两个子类，也就是每种颜色一个；
 * 此后新增一种新颜色需要新增三个子类，即每种形状一个。如此以往，情况会越来越糟糕。
 *
 * 解决办法：
 * 问题的根本原因是我们试图在两个独立的维度——形状与颜色——上扩展形状类。这在处理类继承时是很常见的问题。
 * 桥接模式通过将继承改为组合的方式来解决这个问题。具体来说，就是抽取其中一个维度并使之成为独立的类层次，
 * 这样就可以在初始类中引用这个新层次的对象，从而使得一个类不必拥有所有的状态和行为。
 *
 *       -- 红色
 * 颜色  -- 蓝色
 *       -- 绿色
 *
 * 形状  -- 圆形
 *       -- 三角形
 */
public class Client {

    public static void main(String[] args) {

        System.out.println("---------------桥接前-正常方式---------------");
        ConcreteImplementorA concreteImplementorA = new ConcreteImplementorA();
        concreteImplementorA.operationImpl();

        System.out.println("---------------桥接后---------------");
        Abstraction abs = new RefinedAbstraction(new ConcreteImplementorA());
        abs.operation();
    }

    /**
     * 实现化角色
     */
    interface IImplementor {
        void operationImpl();
    }


    /**
     * 具体实现化角色
     */
    static class ConcreteImplementorA implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("我是具体实现化角色A");
        }
    }

    static class ConcreteImplementorB implements IImplementor {

        @Override
        public void operationImpl() {
            System.out.println("我是具体实现化角色B");
        }
    }

    /**
     * 抽象化角色
     */
    static abstract class Abstraction {

        protected IImplementor implementor;

        public Abstraction(IImplementor implementor) {
            this.implementor = implementor;
        }

        public void operation() {
            this.implementor.operationImpl();
        }
    }

    /**
     * 扩展抽象化角色
     */
    static class RefinedAbstraction extends Abstraction {

        public RefinedAbstraction(IImplementor implementor) {
            super(implementor);
        }

        @Override
        public void operation() {
            System.out.println("扩展抽象化角色被访问");
            super.operation();
        }
    }
}
