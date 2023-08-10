package com.giousa.享元模式;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Client2 {


    /**
     * 抽象享元类
     */
    public interface ITicket {

        void showInfo(String bunk);
    }

    /**
     * 具体享元类
     */
    public static class TrainTicket implements ITicket {

        private String from;

        private String to;

        private int price;

        public TrainTicket(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void showInfo(String bunk) {
            this.price = new Random().nextInt(1000);
            System.out.println(String.format("%s->%s: %s 价格: %s 元", this.from, this.to, bunk, this.price));
        }
    }

    /**
     * 享元工厂类
     */
    public static class TicketFlyweightFactory {

        private static Map<String, ITicket> pool = new ConcurrentHashMap<>();

        public static ITicket queryTicket(String from, String to) {
            String key = from + "->" + to;

            if (pool.containsKey(key)) {
                System.out.println("从缓冲池里面获取对象，key = " + key + ",内容：" + pool.get(key));
                return pool.get(key);
            }

            TrainTicket trainTicket = new TrainTicket(from, to);
            pool.put(key, trainTicket);
            System.out.println("首次查询创建对象，key = " + key + ",内容：" + trainTicket);

            return trainTicket;
        }
    }

    public static void main(String[] args) {
        ITicket ticket1 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket1.showInfo("硬卧");
        ITicket ticket2 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket2.showInfo("硬卧");
        ITicket ticket3 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket3.showInfo("硬卧");
        ITicket ticket4 = TicketFlyweightFactory.queryTicket("阜阳", "上海");
        ticket4.showInfo("硬卧");
    }
}
