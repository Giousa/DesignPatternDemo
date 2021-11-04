package com.giousa.组合模式.file;

public class File extends Direactory{
    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
