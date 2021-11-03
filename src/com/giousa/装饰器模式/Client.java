package com.giousa.装饰器模式;

public class Client {

    public static void main(String[] args) {
        Component component;
        component = new ConcreteComponent();

        component = new ConcreteDecoratorA(component);

        component = new ConcreteDecoratorB(component);

        component = new ConcreteDecoratorA(component);

        component.operation();
    }

    /**
     * 抽象的组件对象
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
            System.out.println("处理业务逻辑");
        }
    }

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
            System.out.println("装饰器A first");
        }

        private void operationLast() {
            System.out.println("装饰器A last");
        }
        public void operation() {
            operationFirst();
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
}
