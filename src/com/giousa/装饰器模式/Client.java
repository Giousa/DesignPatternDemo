package com.giousa.装饰器模式;

/**
 * 装饰者模式的精髓在于动态的给对象增减功能。
 *
 * 优点
 * 可以提供比继承更加灵活的方式去扩展对象的功能，通过排列组合，可以对某个类的一些对象做动态的功能扩展，而不需要装饰的对象却可以保持原样。
 *
 * 缺点
 * 仍然是设计模式的通用缺点：类的个数会增加，会产生很多装饰者类，相应的就增加了复杂度。
 *
 * 装饰者模式与代理模式的区别
 * 一般认为代理模式侧重于使用代理类增强被代理对象的访问，而装饰者模式侧重于使用装饰者类来对被装饰对象的功能进行增强。
 * 除了上面的区别，个人实践中还发现，装饰者模式主要是提供一组装饰者类，然后形成一个装饰者栈，来动态的对某一个对象不断加强，而代理一般不会使用多级代理
 */
public class Client {

    /**
     * 抽象的组件对象-被装饰者
     */
    static abstract class Component {
        public abstract void operation();
    }

    /**
     * 组件对象的具体实现
     */
    static class ConcreteComponent extends Component {

        @Override
        public void operation() {
            System.out.println("ConcreteComponent 处理业务逻辑");
        }
    }

    /**
     * 装饰者
     */
    static abstract class Decorator extends Component {

        /**
         * 持有组件对象
         */
        protected Component component;

        /**
         * 传入组件对象
         *
         * @param component
         */
        public Decorator(Component component) {
            this.component = component;
        }

        /**
         * 转发请求给组件对象，可以在转发前后做一些其他操作
         */
        public void operation() {
            System.out.println("Decorator operation: "+component.getClass());
            component.operation();
        }
    }

    /**
     * 具体装饰器A
     */
    static class ConcreteDecoratorA extends Decorator {

        /**
         * 传入组件对象
         *
         * @param component
         */
        public ConcreteDecoratorA(Component component) {
            super(component);
        }

        private void operationFirst() {
            System.out.println("装饰器A first: ");
        }

        private void operationLast() {
            System.out.println("装饰器A last");
        }
        public void operation() {
            operationFirst();
            System.out.println("装饰器A operation: "+component.getClass());
            super.operation();
            operationLast();
        }
    }

    /**
     * 具体装饰器B
     */
    static class ConcreteDecoratorB extends Decorator {

        /**
         * 传入组件对象
         *
         * @param component
         */
        public ConcreteDecoratorB(Component component) {
            super(component);
        }

        private void operationFirst() {
            System.out.println("装饰器B first");
        }

        private void operationLast() {
            System.out.println("装饰器B last");
        }

        public void operation() {
            operationFirst();
            super.operation();
            operationLast();
        }
    }

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);
//        component = new ConcreteDecoratorA(component);
//        component = new ConcreteDecoratorA(component);
        component.operation();
    }
}
