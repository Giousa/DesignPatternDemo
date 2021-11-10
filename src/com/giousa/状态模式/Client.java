package com.giousa.状态模式;

public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setCurrentState(new ConcreteStateA());
        context.handle();
    }

    static abstract class State {
        protected Context context;

        public void setContext(Context context) {
            this.context = context;
        }

        public abstract void handle();
    }

    static class ConcreteStateA extends State {

        @Override
        public void handle() {
            System.out.println("StateA do it");
            //切换B状态
            this.context.setCurrentState(Context.STATE_B);
            this.context.getCurrentState().handle();
        }
    }

    static class ConcreteStateB extends State {

        @Override
        public void handle() {
            System.out.println("StateB do it");
        }
    }

    static class Context {
        private static final State STATE_A = new ConcreteStateA();
        private static final State STATE_B = new ConcreteStateB();

        private State currentState = STATE_A;

        {
            STATE_A.setContext(this);
            STATE_B.setContext(this);
        }

        public void setCurrentState(State state) {
            this.currentState = state;
            this.currentState.setContext(this);
        }

        public State getCurrentState() {
            return currentState;
        }

        public void handle() {
            this.currentState.handle();
        }
    }
}
