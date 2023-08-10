package com.giousa.原型模式;


/**
 * 原型模式(Prototype Pattern)：使用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。原型模式是一种对象创建型模式。
 *
 * 原型模式的工作原理很简单：将一个原型对象传给那个要发动创建的对象，这个要发动创建的对象通过请求原型对象拷贝自己来实现创建过程。
 *
 * 原型模式是一种“另类”的创建型模式，创建克隆对象的工厂就是原型类自身，工厂方法由克隆方法来实现。
 *
 * 需要注意的是通过克隆方法所创建的对象是全新的对象，它们在内存中拥有新的地址，通常对克隆所产生的对象进行修改对原型对象不会造成任何影响，
 * 每一个克隆对象都是相互独立的。通过不同的方式修改可以得到一系列相似但不完全相同的对象。
 */
public class Client {

    /**
     * 抽象原型类
     * @param <T>
     */
    interface IPrototype<T> {
        T clone();
    }

    /**
     * 具体原型类
     */
    static class ConcretePrototypeA implements IPrototype<ConcretePrototypeA> {

        private String desc;

        public ConcretePrototypeA(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeA clone() {
            return new ConcretePrototypeA(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeA{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    /**
     * 具体原型类
     */
    static class ConcretePrototypeB implements IPrototype<ConcretePrototypeB> {

        private String desc;

        public ConcretePrototypeB(String desc) {
            this.desc = desc;
        }

        @Override
        public ConcretePrototypeB clone() {
            return new ConcretePrototypeB(this.desc);
        }

        @Override
        public String toString() {
            return "ConcretePrototypeB{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        ConcretePrototypeA prototypeA = new ConcretePrototypeA("AAA");
        System.out.println(prototypeA);

        ConcretePrototypeA cloneA = prototypeA.clone();
        cloneA.desc = "clone A";
        System.out.println(cloneA);

        ConcretePrototypeB prototypeB = new ConcretePrototypeB("BBBB");
        System.out.println(prototypeB);
        System.out.println(prototypeB.clone());
    }
}
