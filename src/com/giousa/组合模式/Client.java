package com.giousa.组合模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 技术要点总结
 * 1、组合模式有所谓的透明方式与安全方式，是对于使用者而言的
 * 2、透明方式将所有对外操作都放在Component，叶子节点也得提供这些接口，虽然它实际上不支持这些操作。而安全方式只将叶子节点与组合对象同时提供的操作放在Component。
 * 3、为啥叫透明方式呢？因为用户使用的时候根本不管是叶子节点，还是组合对象，反正看到的接口都一样。这样就不安全了，因为万一这个对象是个叶子节点，假设你又使用了一个它不能提供的操作，例如add，就出问题了...
 * 4、通用操作定义在Component中，根据使用方式不同，透明方式与安全方式，有一定的不同
 * 5、组合节点Composite不仅要继承Component，而且要持有一个Component的集合
 * 6、叶子对象只继承Component即可
 *
 * 优点
 * 可以递归组合成任意复杂的对象
 * 可随意增加新类型的Composite与Leaf的类
 * 简化了客户端代码，因为不论对象多么复杂客户端都是以同一套接口操作
 *
 * 缺点
 * 如果需要确定某个组件是特殊组织，然后针对它做特殊的操作，就需要在运行时判断。
 * 类多了
 */
public class Client {

    /**
     * 抽象类，定义统一的处理操作。
     */
    public static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public abstract String operation();

        public abstract boolean addChild(Component component);

        public abstract boolean removeChild(Component component);

        public abstract Component getChild(int index);

        @Override
        public String toString() {
            return "Component{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 树枝节点[组合节点]
     */
    public static class Composite extends Component {

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
     * 叶子节点【单个对象】
     */
    public static class Leaf extends Component {

        public Leaf(String name) {
            super(name);
        }

        @Override
        public String operation() {
            return this.name;
        }

        @Override
        public boolean addChild(Component component) {
            throw new UnsupportedOperationException(this.name+" 已经是基本节点");
        }

        @Override
        public boolean removeChild(Component component) {
            throw new UnsupportedOperationException(this.name+" 无子节点");
        }

        @Override
        public Component getChild(int index) {
            throw new UnsupportedOperationException(this.name+" 无子节点");
        }
    }


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
        System.out.println("===============");
        System.out.println(root.getComponents());
    }
}
