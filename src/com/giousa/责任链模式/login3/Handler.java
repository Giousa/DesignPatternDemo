package com.giousa.责任链模式.login3;

import com.giousa.责任链模式.login.Member;

import java.util.Objects;

public abstract class Handler<T> {

    protected Handler chain;

    public void next(Handler handler) {
        this.chain = handler;
    }

    public abstract void doHandler(Member member);

    public static class Builder<T> {
        private Handler<T> head;

        private Handler<T> tail;

        public Builder<T> addHandler(Handler<T> handler) {
            if (Objects.isNull(this.head)) {
                this.head = this.tail = handler;
                return this;
            }

            this.tail.next(handler);
            this.tail = handler;

            return this;
        }

        public Handler<T> build() {
            return this.head;
        }
    }
}
