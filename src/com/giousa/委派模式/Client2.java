package com.giousa.委派模式;

import java.util.HashMap;

public class Client2 {

    /**
     * 抽象员工类
     */
    public interface Worker {
        public void doWork(String workName);
    }

    /**
     * 委派者角色-工程部
     */
    public static class GongChengBu implements Worker {
        private String name;

        public GongChengBu(String name) {
            this.name = name;
        }

        public void doWork(String workName) {
            System.out.println("工程部：" + name + "完成" + workName + "工作");
        }
    }

    /**
     * 委派者角色-物资部
     */
    public static class WuZiBu implements Worker {
        private String name;

        public WuZiBu(String name) {
            this.name = name;
        }

        public void doWork(String workName) {
            System.out.println("物资部：" + name + "完成" + workName + "工作");
        }
    }

    /**
     * 委派者角色-财务部
     */
    public static class CaiWuBu implements Worker {
        private String name;

        public CaiWuBu(String name) {
            this.name = name;
        }

        public void doWork(String workName) {
            System.out.println("财务部：" + name + "完成" + workName + "工作");
        }
    }

    /**
     * 具体任务角色-项目经理
     */
    public static class XiangMuJingLi implements Worker {

        private String name;
        private HashMap workers = new HashMap();

        public XiangMuJingLi(String name) {
            this.name = name;
        }

        public void add(String workName, Worker worker) {
            workers.put(workName, worker);
        }

        public void remove(String workName) {
            workers.remove(workName);
        }

        public void doWork(String workName) {
            ((Worker) workers.get(workName)).doWork(workName);
        }
    }


    public static void main(String[] args) {
        System.out.println("公司总经理将房地产项目交给项目经理张三来完成");
        XiangMuJingLi xiangMuJingLi = new XiangMuJingLi("张三");
        xiangMuJingLi.add("土建施工", new GongChengBu("李四"));
        xiangMuJingLi.add("物资设备调度", new WuZiBu("王五"));
        xiangMuJingLi.add("验工计价", new CaiWuBu("赵六"));
        System.out.println("项目经理张三完成工作分配");
        System.out.println("=======================");
        xiangMuJingLi.doWork("土建施工");
        xiangMuJingLi.doWork("物资设备调度");
        xiangMuJingLi.doWork("验工计价");
    }
}
