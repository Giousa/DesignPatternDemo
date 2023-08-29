package com.giousa.状态模式;

import java.util.Objects;

/**
 * 优点：
 * 1、增强了程序的可扩展性，因为我们很容易添加一个State
 * 2、增强了程序的封装性，每个状态的操作都被封装到了一个状态类中
 * 缺点：类变多了
 *
 * 状态模式与策略模式
 * 状态模式与策略模式的UML类图都是一样的，从表面上看他们非常相似。特别是将状态切换任务放在Context中做的时候就更像了，但是其背后的思想却非常不同。
 *
 * 策略模式定义了一组可互相代替的算法，这一组算法对象完成的是同一个任务，只是使用的方式不同，例如同样是亿万富翁，马云通过卖东西实现，而王思聪通过继承实现。
 * 状态模式不同的状态完成的任务完全不一样。
 *
 * 也可以这样简单理解：
 * 策略模式，是可以选择不同的方式，完成目的；
 * 状态模式，需要全部走完，才能完成目的。
 */
public class Client2 {

    ///////////////////////////////////////////////////////////////////////////
    // 状态接口
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 此接口定义各个状态的统一操作接口
     */
    public interface LogisticsState {
        void doAction(JdLogistics context);
    }


    ///////////////////////////////////////////////////////////////////////////
    // 物流Context类
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 此类持有一个LogisticsState 的引用，负责在流程中保持并切换状态
     */
    public static class JdLogistics {
        private LogisticsState logisticsState;

        public void setLogisticsState(LogisticsState logisticsState) {
            this.logisticsState = logisticsState;
        }

        public void doAction(){
            //此方法主要用于在方法中进行参数验证。遇到要判断对象是否为空，空的时候报空指针异常的时候就可以使用这个方法。
            Objects.requireNonNull(logisticsState);
            //执行
            logisticsState.doAction(this);
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // 实现各种状态类
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 接单状态类，其需要实现LogisticsState接口
     */
    public static class OrderState implements LogisticsState {
        @Override
        public void doAction(JdLogistics context) {
            System.out.println("商家已经接单，正在处理中...");
        }
    }

    /**
     * 出库状态类
     */
    public static class ProductOutState implements LogisticsState {
        @Override
        public void doAction(JdLogistics context) {
            System.out.println("商品已经出库...");
        }
    }

    /**
     * 运输状态类
     */
    public static class TransportState implements LogisticsState {
        @Override
        public void doAction(JdLogistics context) {
            System.out.println("商品正在运往天津分发中心");
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // 测试
    ///////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        //状态的保持与切换者
        JdLogistics jdLogistics = new JdLogistics();

        //接单状态
        jdLogistics.setLogisticsState(new OrderState());
        jdLogistics.doAction();

        //出库状态
        jdLogistics.setLogisticsState(new ProductOutState());
        jdLogistics.doAction();

        //运输状态
        jdLogistics.setLogisticsState(new TransportState());
        jdLogistics.doAction();
    }
}
