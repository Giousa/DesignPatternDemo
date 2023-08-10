package com.giousa.命令模式;


/**
 * 命令(Command)模式又叫作动作(Action)模式或事务(Transaction)模式，是一种对象的行为模式。将一个请求封装为一个对象，
 * 从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的操作。
 * <p>
 * 命令模式的本质：封装请求
 * <p>
 * 设计意图：命令模式通过将请求封装到一个命令(Command)对象中，实现了请求调用者和具体实现者之间的解耦。
 * <p>
 * 在以下条件下可以考虑使用命令模式：
 * • 如果需要抽象出需要执行的动作，并参数化这些对象，可以选用命令模式。将这些需要执行的动作抽象成为命令，然后实现命令的参数化配置。
 * • 如果需要在不同的时刻指定、排列和执行请求，可以选用命令模式。将这些请求封装成为命令对象，然后实现将请求队列化。
 * • 如果需要支持取消操作，可以选用命令模式，通过管理命令对象，能很容易地实现命令的恢复和重做功能。
 * • 如果需要支持当系统崩溃时，能将系统的操作功能重新执行一遍，可以选用命令模式。将这些操作功能的请求封装成命令对象，
 * 然后实现日志命令，就可以在系统恢复以后，通过日志获取命令列表，从而重新执行一遍功能。
 * • 在需要事务的系统中，可以选用命令模式。命令模式提供了对事务进行建模的方法。命令模式有一个
 */
public class Client {

    /**
     * 命令的接收者
     * 一般来说，这个类有几个方法，就可以创建几条命令
     */
    public static class Receiver {
        /**
         * 示意方法，真正执行命令相应的操作
         */
        public void action() {
            System.out.println("执行具体操作");
        }
    }

    /**
     * 命令接口
     */
    interface ICommand {
        void execute();
    }

    /**
     * 命令具体实现
     */
    public static class ConcreteCommand implements ICommand {

        /**
         * 持有相应的接收者对象
         */
        private Receiver receiver;

        public ConcreteCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        /**
         * 执行命令
         */
        @Override
        public void execute() {
            //通常会转调接收者对象的相应方法，让接收者来真正执行功能
            receiver.action();
        }
    }

    /**
     * 命令的调用者
     */
    public static class Invoker {

        /**
         * 持有命令对象
         */
        private ICommand command;

        /**
         * 设置调用者持有的命令对象
         */
        public void setCommand(ICommand command) {
            this.command = command;
        }

        /**
         * 示意方法，调用命令执行请求
         */
        public void invoke() {
            command.execute();
        }
    }

    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        // 创建命令对象，设定它的接收者
        ICommand command = new ConcreteCommand(receiver);
        // 创建调用者，把命令对象设置进去
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        // 调用者调用命令
        invoker.invoke();
    }
}
