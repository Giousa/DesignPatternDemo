package com.giousa.原型模式;

public class Client {

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

    interface IPrototype<T>{
        T clone();
    }

    static class ConcretePrototypeA implements IPrototype<ConcretePrototypeA>{

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

    static class ConcretePrototypeB implements IPrototype<ConcretePrototypeB>{

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
}
