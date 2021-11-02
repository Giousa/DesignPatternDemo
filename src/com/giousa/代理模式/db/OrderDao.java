package com.giousa.代理模式.db;

public class OrderDao {

    public int insert(Order order){
        System.out.println("OrderDao 创建 order 成功");
        return 1;
    }
}
