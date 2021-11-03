package com.giousa.门面模式;

public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }

    static class SubSystemA{
        public void doA(){
            System.out.println("do A");
        }
    }

    static class SubSystemB{
        public void doB(){
            System.out.println("do B");
        }
    }

    static class SubSystemC{
        public void doC(){
            System.out.println("do C");
        }
    }

    static class Facade{

        private SubSystemA subSystemA = new SubSystemA();
        private SubSystemB subSystemB = new SubSystemB();
        private SubSystemC subSystemC = new SubSystemC();

        public void doA(){
            subSystemA.doA();
        }

        public void doB(){
            subSystemB.doB();
        }

        public void doC(){
            subSystemC.doC();
        }
    }
}
