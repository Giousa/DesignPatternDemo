package com.giousa.命令模式;

public class Client {

    public static void main(String[] args) {
        ConcreteCommand concreteCommand = new ConcreteCommand();
        Invoker invoker = new Invoker(concreteCommand);
        invoker.action();
    }

    static class Receiver{
        public void action(){
            System.out.println("执行具体操作");
        }
    }

    interface ICommand{
        void execute();
    }

    static class ConcreteCommand implements ICommand{

        private Receiver receiver = new Receiver();

        @Override
        public void execute() {
            this.receiver.action();
        }
    }

    static class Invoker{
        private ICommand cmd;

        public Invoker(ICommand cmd) {
            this.cmd = cmd;
        }

        public void action(){
            this.cmd.execute();
        }
    }
}
