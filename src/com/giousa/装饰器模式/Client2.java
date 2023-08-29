package com.giousa.装饰器模式;

/**
 * 星巴克要求各种下单功能：大杯原味、大杯加糖、大杯加奶；中杯原味、中杯加糖、中杯加奶；小杯原味、小杯加糖、小杯加奶。
 * 紧接着，提出新需求：
 * 现在用户的口味太刁，好多都要同时加奶，加糖，有的还要加蜂蜜，有些用户要求先加糖再加奶，而一些用户要求先加奶然后再加糖，顺序不能乱！
 */
public class Client2 {

    /**
     * 先声明一个原始对象的接口
     */
    public interface ICoffee {
        void makeCoffee();
    }

    /**
     * 构建我们的原始对象，此处为原味咖啡对象，它实现了ICoffee接口。
     */
    public static class OriginalCoffee implements ICoffee {
        @Override
        public void makeCoffee() {
            System.out.println("原味咖啡 ");
        }
    }

    /**
     * 构建装饰者抽象基类，它要实现与原始对象相同的接口ICoffee，其内部持有一个ICoffee类型的引用，用来接收被装饰的对象
     */
    public static abstract class CoffeeDecorator implements ICoffee {
        private ICoffee coffee;

        public CoffeeDecorator(ICoffee coffee) {
            this.coffee = coffee;
        }

        @Override
        public void makeCoffee() {
            coffee.makeCoffee();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 构建各种装饰者类，他们都继承至装饰者基类 CoffeeDecorator。此处生成了两个，一个是加奶的装饰者,另一个是加糖的装饰者。
    ///////////////////////////////////////////////////////////////////////////
    public static class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(ICoffee coffee) {
            super(coffee);
        }

        @Override
        public void makeCoffee() {
            super.makeCoffee();
            addMilk();
        }

        private void addMilk() {
            System.out.println("加奶 ");
        }
    }

    public static class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(ICoffee coffee) {
            super(coffee);
        }

        @Override
        public void makeCoffee() {
            super.makeCoffee();
            addSugar();
        }

        private void addSugar() {
            System.out.println("加糖");
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 测试
    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //原味咖啡
        ICoffee coffee = new OriginalCoffee();
        coffee.makeCoffee();
        System.out.println("-----------");

        //加奶的咖啡
        coffee = new MilkDecorator(coffee);
        coffee.makeCoffee();
        System.out.println("-----------");

        //先加奶后加糖的咖啡
        coffee = new SugarDecorator(coffee);
        coffee.makeCoffee();
    }
}
