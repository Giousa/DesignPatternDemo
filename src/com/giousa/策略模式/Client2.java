package com.giousa.策略模式;

public class Client2 {


    /**
     * 封装不同的实现算法 首先定义一个策略接口，规定算法的统一操作
     */
    public interface CalculateStrategy {
        int calculateTrafficFee(int distance);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 封装各个算法
    ///////////////////////////////////////////////////////////////////////////

    //乘坐公交车算法
    public static class ByBus implements CalculateStrategy {
        @Override
        public int calculateTrafficFee(int distance) {
            return distance < 10 ? 4 : 6;
        }
    }

    //乘坐滴滴快车算法
    public static class ByDiDiExpress implements CalculateStrategy {
        @Override
        public int calculateTrafficFee(int distance) {
            return distance < 3 ? 8 : (8 + (distance - 3) * 3);
        }
    }

    //骑共享单车算法
    public static class BySharedBicycle implements CalculateStrategy {
        @Override
        public int calculateTrafficFee(int distance) {
            return 2;
        }
    }


    /**
     * 使用算法
     */
    public static class TrafficFeeCalculator {
        public int goToTianJinEye(CalculateStrategy strategy, int distance) {
            return strategy.calculateTrafficFee(distance);
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        TrafficFeeCalculator calculator = new TrafficFeeCalculator();
        System.out.println(String.format("乘坐公交车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new ByBus(), 10)));
        System.out.println(String.format("乘坐滴滴快车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new ByDiDiExpress(), 10)));
        System.out.println(String.format("骑共享单车到天津之眼的花费为：%d块人民币",
                calculator.goToTianJinEye(new BySharedBicycle(), 10)));
    }
}
