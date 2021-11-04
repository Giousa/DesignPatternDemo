package com.giousa.组合模式.file;

public abstract class Direactory {

    protected String name;

    public Direactory(String name) {
        this.name = name;
    }

    public abstract void show();
}
