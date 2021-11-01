package com.giousa.单例模式;

/**
 * 枚举单例法
 */
public class Client4 {

    public static void main(String[] args) {

        EnumSington instance = EnumSington.getInstance();
        Object obj = new Object();

        instance.setData(obj);
        System.out.println(instance.getData());

        EnumSington instance1 = EnumSington.getInstance();
        instance1.setData(obj);
        System.out.println(instance.getData());

        EnumSington instance2 = EnumSington.getInstance();
        instance2.setData(obj);
        System.out.println(instance.getData());

    }

    public enum EnumSington {
        INSTANCE;

        private Object data;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public static EnumSington getInstance() {
            return INSTANCE;
        }
    }
}
