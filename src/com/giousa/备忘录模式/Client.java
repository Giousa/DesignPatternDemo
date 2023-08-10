package com.giousa.备忘录模式;


/**
 * 备忘录模式
 * 备忘录模式经常可以遇到，譬如下面这些场景：
 *
 * 浏览器回退：浏览器一般有浏览记录，当我们在一个网页上点击几次链接之后，可在左上角点击左箭头回退到上一次的页面，然后也可以点击右箭头重新回到当前页面
 *
 * 数据库备份与还原：一般的数据库都支持备份与还原操作，备份即将当前已有的数据或者记录保留，还原即将已经保留的数据恢复到对应的表中
 *
 * 编辑器撤销与重做：在编辑器上编辑文字，写错时可以按快捷键 Ctrl + z 撤销，撤销后可以按 Ctrl + y 重做
 *
 * 虚拟机生成快照与恢复：虚拟机可以生成一个快照，当虚拟机发生错误时可以恢复到快照的样子
 *
 * Git版本管理：Git是最常见的版本管理软件，每提交一个新版本，实际上Git就会把它们自动串成一条时间线，每个版本都有一个版本号，使用 git reset --hard 版本号 即可回到指定的版本，让代码时空穿梭回到过去某个历史时刻
 *
 *
 * 备忘录模式的主要优点如下：
 * 1、它提供了一种状态恢复的实现机制，使得用户可以方便地回到一个特定的历史步骤，当新的状态无效或者存在问题时，可以使用暂时存储起来的备忘录将状态复原。
 * 2、备忘录实现了对信息的封装，一个备忘录对象是一种原发器对象状态的表示，不会被其他代码所改动。备忘录保存了原发器的状态，采用列表、堆栈等集合来存储备忘录对象可以实现多次撤销操作。
 *
 * 备忘录模式的主要缺点如下：
 * 1、资源消耗过大，如果需要保存的原发器类的成员变量太多，就不可避免需要占用大量的存储空间，每保存一次对象的状态都需要消耗一定的系统资源。
 *
 * 适用场景：
 * 1、保存一个对象在某一个时刻的全部状态或部分状态，这样以后需要时它能够恢复到先前的状态，实现撤销操作。
 * 2、防止外界对象破坏一个对象历史状态的封装性，避免将对象历史状态的实现细节暴露给外界对象。
 */
public class Client {

    /**
     * Memento（备忘录)：存储原发器的内部状态，根据原发器来决定保存哪些内部状态。备忘录的设计一般可以参考原发器的设计，
     * 根据实际需要确定备忘录类中的属性。需要注意的是，除了原发器本身与负责人类之外，备忘录对象不能直接供其他类使用，
     * 原发器的设计在不同的编程语言中实现机制会有所不同。
     */
    public static class Memento {

        private String state;

        public Memento(Originator o) {
            this.state = o.state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

    /**
     * Originator（原发器）：它是一个普通类，可以创建一个备忘录，并存储它的当前内部状态，
     * 也可以使用备忘录来恢复其内部状态，一般将需要保存内部状态的类设计为原发器。
     */
    public static class Originator {
        private String state;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        //创建一个备忘录对象
        public Memento createMemento() {
            return new Memento(this);
        }

        //根据备忘录对象，恢复之前组织者的状态
        public void restoreMemento(Memento m) {
            state = m.getState();
        }
    }


    /**
     * Caretaker（负责人）：负责人又称为管理者，它负责保存备忘录，但是不能对备忘录的内容进行操作或检查。
     * 在负责人类中可以存储一个或多个备忘录对象，它只负责存储对象，而不能修改对象，也无须知道对象的实现细节。
     *
     * 备忘录模式的核心是备忘录类以及用于管理备忘录的负责人类的设计。
     */
    public static class Caretaker {

        private Memento memento;


        public Memento getMemento() {
            return memento;
        }

        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    }


    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        //在originator和caretaker中保存memento对象
        originator.setState("1");
        System.out.println("当前的状态是：" + originator.getState());
        //备忘录，记录状态
        caretaker.setMemento(originator.createMemento());

        originator.setState("2");
        System.out.println("当前的状态是：" + originator.getState());
        //从Caretaker取出Memento对象
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("执行状态恢复，当前的状态是：" + originator.getState());
    }

}
