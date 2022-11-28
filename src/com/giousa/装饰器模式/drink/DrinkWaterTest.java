package com.giousa.装饰器模式.drink;

public class DrinkWaterTest {

    public static interface Drink{
        void drink();
    }


    public static class DrinkWater implements Drink{

        @Override
        public void drink() {
            System.out.println("喝水");
        }
    }


    public static class DrinkDecorator implements Drink{

        private Drink drink;

        /**
         * 装饰器和代理模式的区别主要是在这里
         * 装饰器：传入的是接口
         * 代理模式：不需要传值，直接new实现的对象
         * @param drink
         */
        public DrinkDecorator(Drink drink) {
            this.drink = drink;
        }

        @Override
        public void drink() {
            System.out.println("DrinkDecorator 装饰器前");
            drink.drink();
            System.out.println("DrinkDecorator 装饰器后");
        }
    }


    public static void main(String[] args) {
        DrinkDecorator drinkDecorator = new DrinkDecorator(new DrinkWater());
        drinkDecorator.drink();
    }


}
