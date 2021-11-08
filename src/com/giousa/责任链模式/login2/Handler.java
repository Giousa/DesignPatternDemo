package com.giousa.责任链模式.login2;

import com.giousa.责任链模式.login.Member;

public abstract class Handler {

    protected Handler chain;

    public void next(Handler handler) {
        this.chain = handler;
    }

    public abstract void doHandler(Member member);
}
