package com.giousa.模板方法.course;

public class JavaCourse extends AbstractCourse {

    private boolean needCheckHome = false;

    public void setNeedCheckHome(boolean needCheckHome) {
        this.needCheckHome = needCheckHome;
    }

    @Override
    protected boolean neeedCheckHomework() {
        return this.needCheckHome;
    }

    @Override
    protected void checkHomework() {
        System.out.println("检查java课后作业");
    }
}
