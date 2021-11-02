package com.giousa.代理模式.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) {
        Order order = new Order();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = sdf.parse("2021/11/02");
            order.setCreateTime(date.getTime());

            IOrderService instance = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderServiceImpl());
            instance.createOrder(order);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
