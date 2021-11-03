package com.giousa.享元模式.ticket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketFlyweightFactory {

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
