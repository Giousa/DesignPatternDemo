package com.giousa.代理模式.db;

public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl() {
        //如果是Spring，自动注入，这里我们直接new一个
        this.orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderServiceImpl 调用OrderDao 创建Order");
        return orderDao.insert(order);
    }
}
