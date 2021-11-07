package com.giousa.委派模式.work;

public class Boss {

    public void command(String task, Leader leader) {
        leader.doing(task);
    }
}
