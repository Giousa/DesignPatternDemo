package com.giousa.模板方法;

/**
 * 模板方法模式
 * 在程序开发中，经常会遇到这种情况：某个方法要实现的算法需要多个步骤，但其中有一些步骤是固定不变的，而另一些步骤则是不固定的。为了提高代码的可扩展性和可维护性，模板方法模式在这种场景下就派上了用场。
 *
 * 模板方法模式的主要优点如下：
 * 在父类中形式化地定义一个算法，而由它的子类来实现细节的处理，在子类实现详细的处理算法时并不会改变算法中步骤的执行次序。
 * 模板方法模式是一种代码复用技术，它在类库设计中尤为重要，它提取了类库中的公共行为，将公共行为放在父类中，而通过其子类来实现不同的行为，它鼓励我们恰当使用继承来实现代码复用。
 * 可实现一种反向控制结构，通过子类覆盖父类的钩子方法来决定某一特定步骤是否需要执行。
 * 在模板方法模式中可以通过子类来覆盖父类的基本方法，不同的子类可以提供基本方法的不同实现，更换和增加新的子类很方便，符合单一职责原则和开闭原则。
 * 模板方法模式的主要缺点如下：
 *
 * 需要为每一个基本方法的不同实现提供一个子类，如果父类中可变的基本方法太多，将会导致类的个数增加，系统更加庞大，设计也更加抽象，此时，可结合桥接模式来进行设计。
 *
 * 适用场景：
 * 对一些复杂的算法进行分割，将其算法中固定不变的部分设计为模板方法和父类具体方法，而一些可以改变的细节由其子类来实现。即：一次性实现一个算法的不变部分，并将可变的行为留给子类来实现。
 * 各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
 * 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制。
 */
public class Client {

    static abstract class AbstractClass{
        protected void step1(){
            System.out.println("AbstractClass 实现：step1");
        }

        protected void step2(){
            System.out.println("AbstractClass 实现：step2");
        }

        protected void step3(){
            System.out.println("AbstractClass 实现：step3");
        }

        /**
         * 避免被子类重写
         */
        public final void templateMethod(){
            this.step1();
            this.step2();
            this.step3();
        }
    }

    static class ConcreteClassA extends AbstractClass{
        @Override
        protected void step1() {
            System.out.println("ConcreteClassA: step1");
        }
    }

    static class ConcreteClassB extends AbstractClass{
        @Override
        protected void step2() {
            System.out.println("ConcreteClassB: step2");
        }
    }

    public static void main(String[] args) {
        AbstractClass abstractClassA = new ConcreteClassA();
        abstractClassA.templateMethod();

        System.out.println("------------");

        AbstractClass abstractClassB = new ConcreteClassB();
        abstractClassB.templateMethod();
    }
}
