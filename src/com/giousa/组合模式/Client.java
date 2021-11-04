package com.giousa.组合模式;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        //创建一个根节点
        Composite root = new Composite("root");

        //创建一个树枝节点A
        Composite branchA = new Composite("---branchA");
        //创建一个树枝节点B
        Composite branchB = new Composite("---branchB");

        //创建一个叶子节点
        Component leafA = new Leaf("---leafA");
        Component leafB = new Leaf("---leafB");
        Component leafC = new Leaf("---leafC");

        root.addChild(branchA);
        root.addChild(leafC);

        branchA.addChild(leafA);
        branchA.addChild(branchB);

        branchB.addChild(leafB);

        String operation = root.operation();
        System.out.println(operation);

        System.out.println(root.getComponents());

    }

    static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract String operation();

//        public boolean addChild(Component component){
//            throw new UnsupportedOperationException("addChild not support");
//        }
//
//        public boolean removeChild(Component component){
//            throw new UnsupportedOperationException("removeChild not support");
//        }
//
//        public boolean getChild(int index){
//            throw new UnsupportedOperationException("getChild not support");
//        }


        @Override
        public String toString() {
            return "Component{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 树枝节点
     */
    static class Composite extends Component {

        private List<Component> components;

        public Composite(String name) {
            super(name);
            this.components = new ArrayList<>();
        }

        @Override
        public String operation() {
            StringBuilder builder = new StringBuilder();
            for (Component component : this.components) {
                builder.append("\n");
                builder.append(component.operation());
            }
            return builder.toString();
        }

        public boolean addChild(Component component) {
            return this.components.add(component);
        }

        public boolean removeChild(Component component) {
            return this.components.remove(component);
        }

        public Component getChild(int index) {
            return this.components.get(index);
        }

        public List<Component> getComponents() {
            return components;
        }
    }


    /**
     * 叶子节点
     */
    static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public String operation() {
            return this.name;
        }
    }
}
